import java.io.IOException;
import java.util.*;

public class ControllerTecnico implements IControllerTecnico{
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

    public boolean criarOrcamento(PlanoTrabalho pt, String idPedido, String idTec) throws IOException {
        return  this.armazem.registarOrcamento(pt, idPedido, idTec);

    }

    public void repararEquipamento(String tecnico, String equipamento) throws IOException {
        this.armazem.iniciarReparo(tecnico, equipamento);
    }

    public String printOrcamento(String idO){
        if(armazem.getOrcamentos().containsKey(idO))
            return  armazem.getOrcamentos().get(idO).toString();
        return "ID introduzido inválido";
    }
}