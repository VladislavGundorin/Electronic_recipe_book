package table;

import jakarta.persistence.*;

@Entity
@Table(name = "recipe_type", schema = "public", catalog = "proekt")
public class RecipeTypeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_recipe_type")
    private String nameRecipeType;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    @ManyToOne
    @JoinColumn(name = "id_user_data", referencedColumnName = "id")
    private UserDataEntity userDataByIdUserData;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameRecipeType() {
        return nameRecipeType;
    }
    public void setNameRecipeType(String nameRecipeType) {
        this.nameRecipeType = nameRecipeType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeTypeEntity that = (RecipeTypeEntity) o;
        if (id != that.id) return false;
        if (nameRecipeType != null ? !nameRecipeType.equals(that.nameRecipeType) : that.nameRecipeType != null)
            return false;
        return true;}
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameRecipeType != null ? nameRecipeType.hashCode() : 0);
        return result;}
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;}
    public UserDataEntity getUserDataByIdUserData() {
        return userDataByIdUserData;
    }
    public void setUserDataByIdUserData(UserDataEntity userDataByIdUserData) {
        this.userDataByIdUserData = userDataByIdUserData;
    }
}
