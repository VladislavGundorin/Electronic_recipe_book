package table;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "user_data", schema = "public", catalog = "proekt")
public class UserDataEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "fio")
    private String fio;
    @Basic
    @Column(name = "mail")
    private String mail;
    @Basic
    @Column(name = "dish_rating")
    private Short dishRating;
    @Basic
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "city")
    private String city;
    @Basic
    @Column(name = "id_recipe_dish", insertable = false, updatable = false)
    private Integer idRecipeDish;
    @Basic
    @Column(name = "id_recipe_type")
    private Integer idRecipeType;
    @OneToMany(mappedBy = "userDataByIdUserData")
    private Collection<DonenessDegreeEntity> donenessDegreesById;
    @OneToMany(mappedBy = "userDataByIdUserData")
    private Collection<RecipeDishEntity> recipeDishesById;
    @OneToMany(mappedBy = "userDataByIdUserData")
    private Collection<RecipeTypeEntity> recipeTypesById;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFio() {
        return fio;
    }
    public void setFio(String fio) {
        this.fio = fio;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public Short getDishRating() {
        return dishRating;
    }
    public void setDishRating(Short dishRating) {
        this.dishRating = dishRating;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public Integer getIdRecipeDish() {
        return idRecipeDish;
    }
    public void setIdRecipeDish(Integer idRecipeDish) {
        this.idRecipeDish = idRecipeDish;
    }
    public Integer getIdRecipeType() {
        return idRecipeType;
    }
    public void setIdRecipeType(Integer idRecipeType) {
        this.idRecipeType = idRecipeType;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDataEntity that = (UserDataEntity) o;
        if (id != that.id) return false;
        if (fio != null ? !fio.equals(that.fio) : that.fio != null) return false;
        if (mail != null ? !mail.equals(that.mail) : that.mail != null) return false;
        if (dishRating != null ? !dishRating.equals(that.dishRating) : that.dishRating != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (city != null ? !city.equals(that.city) : that.city != null) return false;
        if (idRecipeDish != null ? !idRecipeDish.equals(that.idRecipeDish) : that.idRecipeDish != null) return false;
        if (idRecipeType != null ? !idRecipeType.equals(that.idRecipeType) : that.idRecipeType != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fio != null ? fio.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        result = 31 * result + (dishRating != null ? dishRating.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (idRecipeDish != null ? idRecipeDish.hashCode() : 0);
        result = 31 * result + (idRecipeType != null ? idRecipeType.hashCode() : 0);
        return result;}
    public Collection<DonenessDegreeEntity> getDonenessDegreesById() {
        return donenessDegreesById;
    }
    public void setDonenessDegreesById(Collection<DonenessDegreeEntity> donenessDegreesById) {
        this.donenessDegreesById = donenessDegreesById;}
    public Collection<RecipeDishEntity> getRecipeDishesById() {
        return recipeDishesById;
    }
    public void setRecipeDishesById(Collection<RecipeDishEntity> recipeDishesById) {
        this.recipeDishesById = recipeDishesById;}
    public Collection<RecipeTypeEntity> getRecipeTypesById() {
        return recipeTypesById;
    }
    public void setRecipeTypesById(Collection<RecipeTypeEntity> recipeTypesById) {
        this.recipeTypesById = recipeTypesById;}
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;}
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
}
