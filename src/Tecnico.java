import java.util.ArrayList;
import java.util.List;

public class Tecnico {
    private String id;
    private List<String> idPorRealizar;
    private List<String> idExpressos;
    private List<String> idRealizados;

    /*
     CONSTUCTORS
     */

    public Tecnico(String id){
        this.id=id;
        this.idPorRealizar = new ArrayList<>();
        this.idExpressos = new ArrayList<>();
        this.idRealizados = new ArrayList<>();

    }
    public Tecnico(String id, List<String> ipr, List<String> ie, List<String> ir){
        this.id = id;
        this.idPorRealizar = new ArrayList<>(ipr);
        this.idExpressos = new ArrayList<>(ie);
        this.idRealizados = new ArrayList<>(ir);
    }
    public Tecnico(Tecnico outro){
        this.id = outro.getId();
        this.idPorRealizar = outro.getIdPorRealizar();
        this.idExpressos = outro.getIdExpressos();
        this.idRealizados = outro.getIdRealizados();
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
    public List<String> getIdPorRealizar() {
        return new ArrayList<>(this.idPorRealizar);
    }
    public void setIdPorRealizar(List<String> idPorRealizar) {
        this.idPorRealizar = new ArrayList<>(idPorRealizar);
    }

    public List<String> getIdExpressos() {
        return new ArrayList<>(idExpressos);
    }

    public void setIdExpressos(List<String> idExpressos) {
        this.idExpressos = new ArrayList<>(idExpressos);
    }

    public List<String> getIdRealizados() {
        return new ArrayList<>(idRealizados);
    }
    public void setIdRealizados(List<String> idRealizados) {
        this.idRealizados = new ArrayList<>(idRealizados);
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
                this.idExpressos.equals(tec.getIdExpressos()) &&
                this.idPorRealizar.equals(tec.getIdPorRealizar()));
    }
    /*
    CLONE
     */
    @Override
    public Tecnico clone(){
        return new Tecnico(this);
    }
}
