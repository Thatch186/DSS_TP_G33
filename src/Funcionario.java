import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Funcionario {
    private String id;
    private List<String> idAtendimentos; //Ids de Equipamentos
    private List<String> idEntregas; //Ids de Equipamentos

    /*
    Constructors
     */
    public Funcionario(String id){
        this.id=id;
        idAtendimentos = new ArrayList<>();
        idEntregas = new ArrayList<>();
    }
    public Funcionario(String id, List<String> idAtendimentos, List<String> idEntregas){
        this.id = id;
        this.idAtendimentos = new ArrayList<>(idAtendimentos);
        this.idEntregas = new ArrayList<>(idEntregas);
    }
    public Funcionario(Funcionario o){
        this.id = o.getId();
        this.idAtendimentos = o.getIdAtendimentos();
        this.idEntregas = o.getIdEntregas();
    }

    /*
    GETTERS e SETTERS
     */
    String getId(){
        return id;
    }

    void setId(String id){
        this.id=id;
    }

    public List<String> getIdAtendimentos() {
        return new ArrayList<>(idAtendimentos);
    }

    public void setIdAtendimentos(List<String> idAtendimentos) {
        this.idAtendimentos = new ArrayList<>(idAtendimentos);
    }

    public List<String> getIdEntregas() {
        return new ArrayList<>(idEntregas);
    }

    public void setIdEntregas(List<String> idEntregas) {
        this.idEntregas = new ArrayList<>(idEntregas);
    }
    /*
    METHODS
     */
    boolean addAtendimento(String idE){
        if(idAtendimentos.contains(idE)) return false;
        idAtendimentos.add(idE);
        return true;
    }

    boolean addEntrega(String idE){
        if(idEntregas.contains(idE)) return false;
        idEntregas.add(idE);
        return true;
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
        Funcionario f = (Funcionario) o;
        return (this.id.equals(f.getId()) &&
                this.idEntregas.equals(f.getIdEntregas()) &&
                this.idAtendimentos.equals(f.getIdAtendimentos()));
    }
    /*
    CLONE
     */
    @Override
    public Funcionario clone(){
        return new Funcionario(this);
    }
}

