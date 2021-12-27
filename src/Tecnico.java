import java.util.ArrayList;
import java.util.List;

public class Tecnico {
    private String id;
    private String aReparar; // Id de Orçamento cujo equipamento está a ser reparado
    private List<String> idRealizados; // Id de Orçamento realizados pelo tecnico
    private List<String> idReparados; // Id de Orçamento cujo equipamento foi reparado

    /*
     CONSTUCTORS
     */
    public Tecnico(String id){
        this.id=id;
        this.aReparar = null;
        this.idRealizados = new ArrayList<>();
        this.idReparados = new ArrayList<>();

    }
    public Tecnico(String id, String aReparar, List<String> irea, List<String> irep){
        this.id = id;
        this.aReparar = aReparar;
        this.idRealizados = new ArrayList<>(irea);
        this.idReparados = new ArrayList<>(irep);
    }
    public Tecnico(Tecnico outro){
        this.id = outro.getId();
        this.aReparar = outro.getaReparar();
        this.idRealizados = outro.getIdRealizados();
        this.idReparados = outro.getIdReparados();
    }

    /*
    GETTERS e SETTERS
     */
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getaReparar() {
        return aReparar;
    }

    public void setaReparar(String aReparar) {
        this.aReparar = aReparar;
    }

    public List<String> getIdRealizados() {
        return new ArrayList<>(idRealizados);
    }
    public void setIdRealizados(List<String> idRealizados) {
        this.idRealizados = new ArrayList<>(idRealizados);
    }
    public List<String> getIdReparados() {
        return new ArrayList<>(this.idReparados);
    }
    public void setIdReparados(List<String> idReparados) {
        this.idReparados = new ArrayList<>(idReparados);
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
        Tecnico tec = (Tecnico) o;
        return (this.id.equals(tec.getId()) &&
                this.idRealizados.equals(tec.getIdRealizados()) &&
                this.idReparados.equals(tec.getIdReparados()) &&
                this.aReparar.equals(tec.getaReparar()));
    }
    /*
    CLONE
     */
    @Override
    public Tecnico clone(){
        return new Tecnico(this);
    }
}
