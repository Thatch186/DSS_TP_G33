import java.util.ArrayList;
import java.util.List;

public class Estatisticas {
    private List<PedidoOrcamento> listPedOrc;

    public Estatisticas(){
        listPedOrc = new ArrayList<>();
    }

    void addPedOrc(PedidoOrcamento po){
        listPedOrc.add(po.clone());
    }

    List<PedidoOrcamento> getListPedOrc(){
        List<PedidoOrcamento> po = new ArrayList<>();
        for(PedidoOrcamento p: listPedOrc){
            po.add(p.clone());
        }
        return po;
    }
}
