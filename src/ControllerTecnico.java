import java.io.IOException;
import java.util.*;

public class ControllerTecnico {
    private IModel armazem;

    public ControllerTecnico(IModel model) {
        this.armazem = model;
    }

    public List<PedidoOrcamento> consultarPedidoOrcamento() {
        return new ArrayList<>(this.armazem.getPedidosOrcamento().values());
    }

    public List<Orcamento> consultarOrcamentos() {
        return new ArrayList<>(this.armazem.getOrcamentos().values());
    }


    public Orcamento refazerOrcamento(String idOrcamento) {
        return this.armazem.getOrcamentos().get(idOrcamento).clone();
    }

    public void criarOrcamento(String bf, String rf, String uf) throws IOException {
       // this.armazem.registarOrcamento(bf, rf, uf);
    }

    public void repararEquipamento(String tecnico, String equipamento) throws IOException {
        this.armazem.iniciarReparo(tecnico, equipamento);
    }

}
