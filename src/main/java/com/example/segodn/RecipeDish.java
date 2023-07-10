package com.example.segodn;

import jakarta.persistence.*;
import table.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RecipeDish {
    private static EntityManagerFactory entityManagerFactory;
    static EntityManager entityManager;
    private ComponentsEntity[] componentsById;
    public RecipeDish() {
        entityManagerFactory = Persistence.createEntityManagerFactory("Persistence");
        entityManager = entityManagerFactory.createEntityManager();
    }
    public List<RecipeDishEntity> getRecipeDishesByDonenessDegree(String donenessDegree) {
        TypedQuery<RecipeDishEntity> query = entityManager.createQuery(
                "SELECT rd FROM RecipeDishEntity rd " +
                        "JOIN rd.donenessDegreesById dd " +
                        "WHERE dd.nameDonenessDegree = :donenessDegree",
                RecipeDishEntity.class);
        query.setParameter("donenessDegree", donenessDegree);
        return query.getResultList();
    }
    public List<RecipeDishEntity> getRecipeDishesByNationalityAndCookingTime(String nationality, String cookingTime) {
        TypedQuery<RecipeDishEntity> query = entityManager.createQuery(
                "SELECT rd FROM RecipeDishEntity rd " +
                        "JOIN rd.nationalityAffiliationsById na " +
                        "JOIN rd.preparationStagesById ps " +
                        "WHERE na.nameNationalityAffiliation = :nationality " +
                        "AND ps.cookingTime = :cookingTime",
                RecipeDishEntity.class);
        query.setParameter("nationality", nationality);
        query.setParameter("cookingTime", cookingTime);
        return query.getResultList();
    }
    public List<UserDataEntity> getUsersByRecipeTypeAndCookingDegree(String recipeType, String donenessDegree) {
        TypedQuery<UserDataEntity> query = entityManager.createQuery(
                "SELECT u FROM UserDataEntity u " +
                        "JOIN u.recipeDishesById r " +
                        "JOIN r.recipeTypesById rt " +
                        "JOIN r.donenessDegreesById cd " +
                        "WHERE rt.nameRecipeType = :recipeType " +
                        "AND cd.nameDonenessDegree = :donenessDegree",
                UserDataEntity.class);
        query.setParameter("recipeType", recipeType);
        query.setParameter("donenessDegree", donenessDegree);
        return query.getResultList();
    }
    public List<ComponentsEntity> getComponentsByNationality(String nationality) {
        TypedQuery<ComponentsEntity> query = entityManager.createQuery("SELECT c FROM ComponentsEntity c " +
                "JOIN c.recipeDishByIdRecipeDish r " +
                "JOIN r.nationalityAffiliationsById n " +
                "WHERE n.nameNationalityAffiliation = :nationality", ComponentsEntity.class);
        query.setParameter("nationality", nationality);
        return query.getResultList();
    }
    public void updateRecipeDish(int recipeDishId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        try {
            RecipeDishEntity recipeDish = entityManager.find(RecipeDishEntity.class, recipeDishId);

            if (recipeDish == null) {
                System.out.println("Рецепт блюда с указанным идентификатором не найден.");
                return;
            }
            System.out.println("Текущий рецепт блюда:");
            System.out.println("Название блюда: " + recipeDish.getNameDish());
            System.out.println("Количество порций: " + recipeDish.getQuantityServings());
            System.out.println("Вес блюда: " + recipeDish.getWeightDish());
            System.out.println("Сложность: " + recipeDish.getComplexity());
            System.out.println();

            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите новое название блюда: ");
            String newNameDish = scanner.nextLine();
            recipeDish.setNameDish(newNameDish);

            System.out.print("Введите новое количество порций: ");
            short newQuantityServings = scanner.nextShort();
            recipeDish.setQuantityServings(newQuantityServings);

            System.out.print("Введите новый вес блюда: ");
            short newWeightDish = scanner.nextShort();
            recipeDish.setWeightDish(newWeightDish);

            System.out.print("Введите новую сложность: ");
            scanner.nextLine(); // Сбросить символ новой строки из буфера
            String newComplexity = scanner.nextLine();
            recipeDish.setComplexity(newComplexity);

            entityManager.merge(recipeDish);
            transaction.commit();

            System.out.println("Рецепт блюда успешно изменен.");
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static void deleteUser(int userId) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        try {
            UserDataEntity user = entityManager.find(UserDataEntity.class, userId);
            if (user != null) {
                entityManager.remove(user);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    public static List<UserDataEntity> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<UserDataEntity> query = entityManager.createQuery("SELECT u FROM UserDataEntity u", UserDataEntity.class);
        List<UserDataEntity> users = query.getResultList();
        entityManager.close();
        return users;
    }
}