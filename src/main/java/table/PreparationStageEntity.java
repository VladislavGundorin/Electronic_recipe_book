package table;

import jakarta.persistence.*;

@Entity
@Table(name = "preparation_stage", schema = "public", catalog = "proekt")
public class PreparationStageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "stage_number")
    private short stageNumber;
    @Basic
    @Column(name = "cooking_time")
    private String cookingTime;
    @Basic
    @Column(name = "stage_description")
    private String stageDescription;
    @Basic
    @Column(name = "cooking_method")
    private String cookingMethod;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public short getStageNumber() {
        return stageNumber;
    }
    public void setStageNumber(short stageNumber) {
        this.stageNumber = stageNumber;
    }
    public String getCookingTime() {
        return cookingTime;
    }
    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }
    public String getStageDescription() {
        return stageDescription;
    }
    public void setStageDescription(String stageDescription) {
        this.stageDescription = stageDescription;
    }
    public String getCookingMethod() {
        return cookingMethod;
    }
    public void setCookingMethod(String cookingMethod) {
        this.cookingMethod = cookingMethod;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreparationStageEntity that = (PreparationStageEntity) o;

        if (id != that.id) return false;
        if (stageNumber != that.stageNumber) return false;
        if (cookingTime != null ? !cookingTime.equals(that.cookingTime) : that.cookingTime != null) return false;
        if (stageDescription != null ? !stageDescription.equals(that.stageDescription) : that.stageDescription != null)
            return false;
        if (cookingMethod != null ? !cookingMethod.equals(that.cookingMethod) : that.cookingMethod != null)
            return false;
//        if (idRecipeDish != null ? !idRecipeDish.equals(that.idRecipeDish) : that.idRecipeDish != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (int) stageNumber;
        result = 31 * result + (cookingTime != null ? cookingTime.hashCode() : 0);
        result = 31 * result + (stageDescription != null ? stageDescription.hashCode() : 0);
        result = 31 * result + (cookingMethod != null ? cookingMethod.hashCode() : 0);
//        result = 31 * result + (idRecipeDish != null ? idRecipeDish.hashCode() : 0);
        return result;
    }

    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }

    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
}
