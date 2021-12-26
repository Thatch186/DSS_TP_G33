import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Funcionario {
    private String id;
    private List<String> idAtendimentos;
    private List<String> idEntregas;

    public Funcionario(String id){
        this.id=id;
        idAtendimentos = new ArrayList<>();
        idEntregas = new ArrayList<>();
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id) && sListsIguais(idAtendimentos ,that.idAtendimentos) && sListsIguais(idEntregas, that.idEntregas);
    }

    boolean sListsIguais(List<String> a, List<String>b){
        if(a==b) return true;
        for(int i=0; i<a.size(); i++)
            if(!Objects.equals(a.get(i), b.get(i)))
                return false;
        return true;
    }

}

