import java.time.LocalDate;

public class Levantamento{
    private String equipmentID;
    private LocalDate data;

    /*
    CONSTRUCTORS
     */
    public Levantamento(String equipmentID, LocalDate data){
        this.equipmentID = equipmentID;
        this.data = data;
    }
    public Levantamento(Levantamento outro){
        this.equipmentID = outro.getEquipmentID();
        this.data = outro.getData();
    }
    /*
    GETTERS e SETTERS
     */

    public String getEquipmentID() {
        return equipmentID;
    }

    public void setEquipmentID(String equipmentID) {
        this.equipmentID = equipmentID;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    /*
    EQUALS
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Levantamento l = (Levantamento) o;
        return (this.equipmentID.equals(l.getEquipmentID()) &&
                this.data.equals(l.getData()));
    }

    /*
    CLONE
     */
    public Levantamento clone(){
        return new Levantamento(this);
    }
}