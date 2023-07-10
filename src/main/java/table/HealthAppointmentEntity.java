package table;

import jakarta.persistence.*;

@Entity
@Table(name = "health_appointment", schema = "public", catalog = "proekt")
public class HealthAppointmentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_health_appointment")
    private String nameHealthAppointment;
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNameHealthAppointment() {
        return nameHealthAppointment;
    }
    public void setNameHealthAppointment(String nameHealthAppointment) {
        this.nameHealthAppointment = nameHealthAppointment;}
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HealthAppointmentEntity that = (HealthAppointmentEntity) o;
        if (id != that.id) return false;
        if (nameHealthAppointment != null ? !nameHealthAppointment.equals(that.nameHealthAppointment) : that.nameHealthAppointment != null)
            return false;
        return true;}
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameHealthAppointment != null ? nameHealthAppointment.hashCode() : 0);
        return result;}
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;
    }
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;
    }
}
