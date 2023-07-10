package table;

import jakarta.persistence.*;

@Entity
@Table(name = "nationality_affiliation", schema = "public", catalog = "proekt")
public class NationalityAffiliationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_nationality_affiliation")
    private String nameNationalityAffiliation;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameNationalityAffiliation() {
        return nameNationalityAffiliation;
    }
    public void setNameNationalityAffiliation(String nameNationalityAffiliation) {
        this.nameNationalityAffiliation = nameNationalityAffiliation;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NationalityAffiliationEntity that = (NationalityAffiliationEntity) o;
        if (id != that.id) return false;
        if (nameNationalityAffiliation != null ? !nameNationalityAffiliation.equals(that.nameNationalityAffiliation) : that.nameNationalityAffiliation != null)
            return false;
        return true;}
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameNationalityAffiliation != null ? nameNationalityAffiliation.hashCode() : 0);
        return result;
    }
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
}
