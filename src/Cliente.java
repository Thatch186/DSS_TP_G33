import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String NIF;
    private Contacto contacto;
    private List<String> codigosEquipamento;

    public Cliente(String NIF, Contacto contacto){
        this.NIF=NIF;
        this.contacto=contacto;
        this.codigosEquipamento =new ArrayList<>();
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Contacto getContacto() {
        return new Contacto(this.contacto);
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<String> getCodigosEquipamento() {
        return codigosEquipamento;
    }

    public void setCodigosEquipamento(List<String> codigosEquipamento) {
        this.codigosEquipamento = codigosEquipamento;
    }


    public boolean dadosValidos(){
        return contacto.getEmail() != null && contacto.getTelemovel() != null;
    }

    @Override
    public String toString() {
        return "Cliente("
                + NIF +
                ", " + contacto +
                "," + codigosEquipamento.toString() +
                '}';
    }
}
