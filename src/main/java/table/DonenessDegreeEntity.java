package table;

import jakarta.persistence.*;

@Entity
@Table(name = "doneness_degree", schema = "public", catalog = "proekt")
public class DonenessDegreeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name_doneness_degree")
    private String nameDonenessDegree;
    @Basic
    @Column(name = "doneness_degree")
    private String donenessDegree;
    public int getId() {
        return id;}
    public void setId(int id) {
        this.id = id;}
    public String getNameDonenessDegree() {
        return nameDonenessDegree;}
    public void setNameDonenessDegree(String nameDonenessDegree) {
        this.nameDonenessDegree = nameDonenessDegree;}
    @ManyToOne
    @JoinColumn(name = "id_recipe_dish", referencedColumnName = "id")
    private RecipeDishEntity recipeDishByIdRecipeDish;
    @ManyToOne
    @JoinColumn(name = "id_user_data", referencedColumnName = "id")
    private UserDataEntity userDataByIdUserData;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DonenessDegreeEntity that = (DonenessDegreeEntity) o;

        if (id != that.id) return false;
        if (nameDonenessDegree != null ? !nameDonenessDegree.equals(that.nameDonenessDegree) : that.nameDonenessDegree != null)
            return false;
        return true;
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nameDonenessDegree != null ? nameDonenessDegree.hashCode() : 0);
        return result;}
    public RecipeDishEntity getRecipeDishByIdRecipeDish() {
        return recipeDishByIdRecipeDish;}
    public void setRecipeDishByIdRecipeDish(RecipeDishEntity recipeDishByIdRecipeDish) {
        this.recipeDishByIdRecipeDish = recipeDishByIdRecipeDish;}
    public UserDataEntity getUserDataByIdUserData() {
        return userDataByIdUserData;}
    public void setUserDataByIdUserData(UserDataEntity userDataByIdUserData) {
        this.userDataByIdUserData = userDataByIdUserData;}
    public void setDonenessDegree(String donenessDegree) {
        this.donenessDegree = donenessDegree;}
    public String getDonenessDegree() {
        return donenessDegree;}
}
