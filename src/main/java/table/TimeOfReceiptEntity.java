package table;

import jakarta.persistence.*;

@Entity
@Table(name = "time_of_receipt", schema = "public", catalog = "proekt")
public class TimeOfReceiptEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_time_of_receipt")
    private String nameTimeOfReceipt;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameTimeOfReceipt() {
        return nameTimeOfReceipt;
    }
    public void setNameTimeOfReceipt(String nameTimeOfReceipt) {
        this.nameTimeOfReceipt = nameTimeOfReceipt;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeOfReceiptEntity that = (TimeOfReceiptEntity) o;
        if (id != that.id) return false;
        if (nameTimeOfReceipt != null ? !nameTimeOfReceipt.equals(that.nameTimeOfReceipt) : that.nameTimeOfReceipt != null)
            return false;
        return true;}
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameTimeOfReceipt != null ? nameTimeOfReceipt.hashCode() : 0);
        return result;}
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
}
