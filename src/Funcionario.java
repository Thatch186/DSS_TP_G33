import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
}

