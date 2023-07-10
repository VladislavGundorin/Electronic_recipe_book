package table;

import jakarta.persistence.*;

@Entity
@Table(name = "components", schema = "public", catalog = "proekt")
public class ComponentsEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "kaloriynost_dish")
    private Short kaloriynostDish;
    @Basic
    @Column(name = "name_components")
    private String nameComponents;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Short getKaloriynostDish() {
        return kaloriynostDish;
    }
    public void setKaloriynostDish(Short kaloriynostDish) {
        this.kaloriynostDish = kaloriynostDish;
    }
    public String getNameComponents() {
        return nameComponents;
    }
    public void setNameComponents(String nameComponents) {
        this.nameComponents = nameComponents;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComponentsEntity that = (ComponentsEntity) o;
        if (id != that.id) return false;
        if (kaloriynostDish != null ? !kaloriynostDish.equals(that.kaloriynostDish) : that.kaloriynostDish != null)
            return false;
        if (nameComponents != null ? !nameComponents.equals(that.nameComponents) : that.nameComponents != null)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (kaloriynostDish != null ? kaloriynostDish.hashCode() : 0);
        result = 31 * result + (nameComponents != null ? nameComponents.hashCode() : 0);
        return result;
    }
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
    public void setRecipeDish(RecipeDishEntity recipeDish) {
        this.recipeDishByIdRecipeDish = recipeDish;
        if (recipeDish != null) {
            recipeDish.getComponentsById().add(this);
        }
    }
    public RecipeDishEntity getRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
}
