package table;

import jakarta.persistence.*;

@Entity
@Table(name = "type_dish", schema = "public", catalog = "proekt")
public class TypeDishEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_type_dish")
    private String nameTypeDish;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameTypeDish() {
        return nameTypeDish;
    }
    public void setNameTypeDish(String nameTypeDish) {
        this.nameTypeDish = nameTypeDish;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeDishEntity that = (TypeDishEntity) o;
        if (id != that.id) return false;
        if (nameTypeDish != null ? !nameTypeDish.equals(that.nameTypeDish) : that.nameTypeDish != null) return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameTypeDish != null ? nameTypeDish.hashCode() : 0);
        return result;}
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
}
