import java.io.IOException;
import java.util.*;

public class ControllerTecnico implements InterfaceTecnico {
    private InterfM armazem;

    public ControllerTecnico(InterfM model) {
        this.armazem = model;
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

    public void criarOrcamento(String bf, String rf, String uf) throws IOException {
        this.armazem.criarOrcamento(bf, rf, uf);
    }

    public void repararEquipamento(String bf, String rf, String uf) throws IOException {
        this.armazem.repararEquipamento(bf, rf, uf);
    }


    public void consultarEstadoReparacao(String bf, String rf, String uf) throws IOException {
        this.armazem.consultarEstadoReparacao(bf, rf, uf);
    }
}
