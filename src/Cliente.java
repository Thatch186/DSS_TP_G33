import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int NIF;
    private Contacto contacto;
    private List<Equipamento> equip_list;

    public Cliente(int NIF, Contacto contacto){
        this.NIF=NIF;
        this.contacto=contacto;
        this.equip_list=new ArrayList<>();
    }

    public int getNIF() {
        return NIF;
    }

    public void setNIF(int NIF) {
        this.NIF = NIF;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Equipamento> getEquip_list() {
        return equip_list;
    }

    public void setEquip_list(List<Equipamento> equip_list) {
        this.equip_list = equip_list;
    }

    public boolean pedeOrcamento(Equipamento e, Funcionario f, boolean expresso){
        boolean b=false;
        this.equip_list.add(e);
        f.recebePedidoOrcamento(this,e, expresso);
        return b;
    }

    public boolean dadosValidos(){
        return contacto.getEmail() != null && contacto.getTelemovel() != null;
    }


    public void recolherEquipamento(String cod_registo){
        equip_list.removeIf(e -> e.getCod_registo().equals(cod_registo));
    }

    @Override
    public String toString() {
        return "Cliente(" +
                 + NIF +
                ", " + contacto +
                "," + equip_list.toString() +
                '}';
    }
}
