import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerTecnico {

    private Armazem armazem;

    public ControllerTecnico(Armazem e) {
        this.armazem = e;
    }

    public List<PedidoOrcamento> consultarPedidoOrcamento() {
        return new ArrayList<>(this.armazem.getPedidosOrcamento().values());
    }

    public List<Orcamento> consultarOrcamentos(){
        return new ArrayList<>(this.armazem.getOrcamentos().values());
    }

    public Orcamento refazerOrcamento(String idOrcamento){
        return this.armazem.getOrcamentos().get(idOrcamento).clone();
    }

    


}
