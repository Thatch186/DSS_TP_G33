import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String NIF;
    private Contacto contacto;
    private List<String> codigosEquipamento;

    /*
    CONSTRUCTORS
     */
    public Cliente(String NIF, Contacto contacto){
        this.NIF=NIF;
        this.contacto=contacto;
        this.codigosEquipamento =new ArrayList<>();
    }
    public Cliente(String NIF, String email, String telemovel){
        this.NIF=NIF;
        this.contacto= new Contacto(email,telemovel);
        this.codigosEquipamento =new ArrayList<>();
    }
    public Cliente(String NIF,Contacto contacto, List<String> codigosEquipamento){
        this.NIF = NIF;
        this.contacto = contacto;
        this.codigosEquipamento = new ArrayList<>(codigosEquipamento);
    }
    public Cliente(Cliente outro){
        this.NIF = outro.getNIF();
        this.contacto = outro.getContacto();
        this.codigosEquipamento = outro.getCodigosEquipamento();
    }

    /*
    GETTERS e SETTERS
     */
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Contacto getContacto() {
        return this.contacto.clone();
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto.clone();
    }

    public List<String> getCodigosEquipamento() {
        return new ArrayList<>(this.codigosEquipamento);
    }

    public void setCodigosEquipamento(List<String> codigosEquipamento) {
        this.codigosEquipamento = new ArrayList<>(codigosEquipamento);
    }

    /*
    METHODS
     */

    boolean addEquipamento(String idE){
        if(codigosEquipamento.contains(idE)) return false;
        codigosEquipamento.add(idE);
        return true;
    }

    public boolean dadosValidos(){
        return contacto.getEmail() != null && contacto.getTelemovel() != null;
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
        Cliente c = (Cliente) o;
        return (this.NIF.equals(c.getNIF()) &&
                this.codigosEquipamento.equals(c.getCodigosEquipamento()) &&
                this.contacto.equals(c.getContacto()));
    }

    /*
    CLONE
     */
    @Override
    public Cliente clone(){
        return new Cliente(this);
    }

    /*
    TO STRING
     */
    @Override
    public String toString() {
        return "Cliente("
                + NIF +
                ", " + contacto +
                "," + codigosEquipamento.toString() +
                '}';
    }
}
