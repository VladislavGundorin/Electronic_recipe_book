package com.example.segodn;

import com.example.segodn.RecipeDish;
import jakarta.persistence.*;
import table.*;
import java.util.List;
import java.util.Scanner;
import static com.example.segodn.RecipeDish.entityManager;
public class Main {
    public static void main(String[] args) {
        RecipeDish recipeDishDAO = new RecipeDish();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите запрос:");
            System.out.println("1. Получение рецептов блюд по степени готовности");
            System.out.println("2. Получение рецептов блюд по национальности и времени приготовления");
            System.out.println("3. Получение пользователей по типу рецепта и степени прожарки");
            System.out.println("4. Получение компонентов по национальности");
            System.out.println("5. Получение пользователей с указанным блюдом и национальностью");
            System.out.println("6. Изменение рецепта блюда");
            System.out.println("7. Удаление пользователя по ид");
            System.out.println("8. Добавление время приема рецепта блюда");
            System.out.println("0. Выход");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Сбросить символ новой строки из буфера
            switch (choice) {
                case 0:
                    return;

                case 1:
                    System.out.print("Введите степень прожарки: ");
                    String donenessDegree = scanner.nextLine();
                    List<RecipeDishEntity> recipeDishesByDonenessDegree = recipeDishDAO.getRecipeDishesByDonenessDegree(donenessDegree);
                    for (RecipeDishEntity recipeDish : recipeDishesByDonenessDegree) {
                        System.out.println(recipeDish.getNameDish());
                    }
                    break;
                case 2:
                    System.out.print("Введите национальность: ");
                    String nationality = scanner.nextLine();
                    System.out.print("Введите время приготовления: ");
                    String cookingTime = scanner.nextLine();
                    List<RecipeDishEntity> recipeDishesByNationalityAndCookingTime = recipeDishDAO.getRecipeDishesByNationalityAndCookingTime(nationality, cookingTime);
                    for (RecipeDishEntity recipeDish : recipeDishesByNationalityAndCookingTime) {
                        System.out.println(recipeDish.getNameDish());
                    }
                    break;
                case 3:
                    System.out.print("Введите тип рецепта: ");
                    String recipeType = scanner.nextLine();
                    System.out.print("Введите степень готовности: ");
                    String cookingDegree = scanner.nextLine();
                    List<UserDataEntity> usersByRecipeTypeAndCookingDegree = recipeDishDAO.getUsersByRecipeTypeAndCookingDegree(recipeType, cookingDegree);
                    for (UserDataEntity user : usersByRecipeTypeAndCookingDegree) {
                        System.out.println(user.getFio());
                    }
                    break;
                case 4:
                    System.out.print("Введите национальность: ");
                    String nationalityForComponents = scanner.nextLine();
                    List<ComponentsEntity> componentsByNationality = recipeDishDAO.getComponentsByNationality(nationalityForComponents);
                    for (ComponentsEntity component : componentsByNationality) {
                        System.out.println("Component Name: " + component.getNameComponents());

                        // Получаем блюдо, к которому принадлежит компонент
                        RecipeDishEntity recipeDish = component.getRecipeDish();
                        System.out.println("Dish Name: " + recipeDish.getNameDish());
                    }
                    break;
                case 5:
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");
                    EntityManager em = emf.createEntityManager();

                    try {
                        System.out.print("Введите название типа блюда: ");
                        String dishType = scanner.nextLine();

                        String jpql = "SELECT d FROM RecipeDishEntity d JOIN d.typeDishesById t WHERE t.nameTypeDish = :dishType";
                        Query query = em.createQuery(jpql);
                        query.setParameter("dishType", dishType);
                        List<RecipeDishEntity> dishes = query.getResultList();

                        if (dishes.isEmpty()) {
                            System.out.println("Блюда с указанным типом не найдены.");
                        } else {
                            System.out.println("Блюда с типом '" + dishType + "':");
                            for (RecipeDishEntity dish : dishes) {
                                System.out.println(dish.getNameDish());
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        em.close();
                        emf.close();
                    }
                    break;
                case 6:
                    System.out.print("Введите идентификатор рецепта блюда для изменения: ");
                    int recipeDishId = scanner.nextInt();
                    scanner.nextLine();
                    recipeDishDAO.updateRecipeDish(recipeDishId);
                    break;
                case 7:
                    List<UserDataEntity> users = RecipeDish.getAllUsers();

                    System.out.println("Список пользователей:");
                    for (UserDataEntity user : users) {
                        System.out.println("ID: " + user.getId() + ", FIO: " + user.getFio());
                    }
                    System.out.print("Введите идентификатор пользователя для удаления: ");
                    int userIdToDelete = Integer.parseInt(scanner.nextLine());
                    RecipeDish.deleteUser(userIdToDelete);
                    break;
                case 8:
                    System.out.print("Введите время приема: ");
                    String timeOfReceipt = scanner.nextLine();

                    TimeOfReceiptEntity newTimeOfReceipt = new TimeOfReceiptEntity();
                    newTimeOfReceipt.setNameTimeOfReceipt(timeOfReceipt);

                    entityManager.getTransaction().begin();
                    entityManager.persist(newTimeOfReceipt);
                    entityManager.flush();
                    entityManager.getTransaction().commit();
                    System.out.println("Время приема успешно добавлено.");
                    break;
                default:
                    System.out.println("Некорректный выбор. Попробуйте еще раз.");
                    break;
            }
        }
    }
}
