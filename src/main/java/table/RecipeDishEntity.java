package table;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "recipe_dish", schema = "public", catalog = "proekt")
public class RecipeDishEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_dish")
    private String nameDish;
    @Basic
    @Column(name = "quantity_servings")
    private Short quantityServings;
    @Basic
    @Column(name = "weight_dish")
    private Short weightDish;
    @Basic
    @Column(name = "complexity")
    private String complexity;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<ComponentsEntity> componentsById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<DonenessDegreeEntity> donenessDegreesById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<HealthAppointmentEntity> healthAppointmentsById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<NationalityAffiliationEntity> nationalityAffiliationsById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<PreparationStageEntity> preparationStagesById;
    @ManyToOne
    @JoinColumn(name = "id_user_data", referencedColumnName = "id")
    private UserDataEntity userDataByIdUserData;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<RecipeTypeEntity> recipeTypesById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<TimeOfReceiptEntity> timeOfReceiptsById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<TypeDishEntity> typeDishesById;
    @OneToMany(mappedBy = "recipeDishByIdRecipeDish")
    private Collection<UserDataEntity> userDataById;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameDish() {
        return nameDish;
    }

    public void setNameDish(String nameDish) {
        this.nameDish = nameDish;
    }

    public Short getQuantityServings() {
        return quantityServings;
    }

    public void setQuantityServings(Short quantityServings) {
        this.quantityServings = quantityServings;
    }

    public Short getWeightDish() {
        return weightDish;
    }

    public void setWeightDish(Short weightDish) {
        this.weightDish = weightDish;
    }

    public String getComplexity() {
        return complexity;
    }

    public void setComplexity(String complexity) {
        this.complexity = complexity;
    }

//    public Integer getIdUserData() {
//        return idUserData;
//    }
//
//    public void setIdUserData(Integer idUserData) {
//        this.idUserData = idUserData;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecipeDishEntity that = (RecipeDishEntity) o;

        if (id != that.id) return false;
        if (nameDish != null ? !nameDish.equals(that.nameDish) : that.nameDish != null) return false;
        if (quantityServings != null ? !quantityServings.equals(that.quantityServings) : that.quantityServings != null)
            return false;
        if (weightDish != null ? !weightDish.equals(that.weightDish) : that.weightDish != null) return false;
        if (complexity != null ? !complexity.equals(that.complexity) : that.complexity != null) return false;
//        if (idUserData != null ? !idUserData.equals(that.idUserData) : that.idUserData != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameDish != null ? nameDish.hashCode() : 0);
        result = 31 * result + (quantityServings != null ? quantityServings.hashCode() : 0);
        result = 31 * result + (weightDish != null ? weightDish.hashCode() : 0);
        result = 31 * result + (complexity != null ? complexity.hashCode() : 0);
//        result = 31 * result + (idUserData != null ? idUserData.hashCode() : 0);
        return result;
    }

    public Collection<ComponentsEntity> getComponentsById() {
        return componentsById;
    }

    public void setComponentsById(Collection<ComponentsEntity> componentsById) {
        this.componentsById = componentsById;
    }

    public Collection<DonenessDegreeEntity> getDonenessDegreesById() {
        return donenessDegreesById;
    }

    public void setDonenessDegreesById(Collection<DonenessDegreeEntity> donenessDegreesById) {
        this.donenessDegreesById = donenessDegreesById;
    }

    public Collection<HealthAppointmentEntity> getHealthAppointmentsById() {
        return healthAppointmentsById;
    }

    public void setHealthAppointmentsById(Collection<HealthAppointmentEntity> healthAppointmentsById) {
        this.healthAppointmentsById = healthAppointmentsById;
    }

    public Collection<NationalityAffiliationEntity> getNationalityAffiliationsById() {
        return nationalityAffiliationsById;
    }

    public void setNationalityAffiliationsById(Collection<NationalityAffiliationEntity> nationalityAffiliationsById) {
        this.nationalityAffiliationsById = nationalityAffiliationsById;
    }

    public Collection<PreparationStageEntity> getPreparationStagesById() {
        return preparationStagesById;
    }

    public void setPreparationStagesById(Collection<PreparationStageEntity> preparationStagesById) {
        this.preparationStagesById = preparationStagesById;
    }

    public UserDataEntity getUserDataByIdUserData() {
        return userDataByIdUserData;
    }

    public void setUserDataByIdUserData(UserDataEntity userDataByIdUserData) {
        this.userDataByIdUserData = userDataByIdUserData;
    }

    public Collection<RecipeTypeEntity> getRecipeTypesById() {
        return recipeTypesById;
    }

    public void setRecipeTypesById(Collection<RecipeTypeEntity> recipeTypesById) {
        this.recipeTypesById = recipeTypesById;
    }

    public Collection<TimeOfReceiptEntity> getTimeOfReceiptsById() {
        return timeOfReceiptsById;
    }

    public void setTimeOfReceiptsById(Collection<TimeOfReceiptEntity> timeOfReceiptsById) {
        this.timeOfReceiptsById = timeOfReceiptsById;
    }

    public Collection<TypeDishEntity> getTypeDishesById() {
        return typeDishesById;
    }

    public void setTypeDishesById(Collection<TypeDishEntity> typeDishesById) {
        this.typeDishesById = typeDishesById;
    }

    public Collection<UserDataEntity> getUserDataById() {
        return userDataById;
    }

    public void setUserDataById(Collection<UserDataEntity> userDataById) {
        this.userDataById = userDataById;
    }
}
