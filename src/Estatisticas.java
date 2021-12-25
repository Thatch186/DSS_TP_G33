import java.util.List;

public class Estatisticas {
    private List<PedidoOrcamento> listPedOrc;

    void addPedOrc(PedidoOrcamento po){
        listPedOrc.add(po.clone());
    }
}
