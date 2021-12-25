import java.util.ArrayList;
import java.util.List;

public class Armazem {
    List<PedidoOrcamento> porFazer;
    List<PedidoOrcamento> expressos;
    List<Orcamento> orcamentos;

    public Armazem(){
        porFazer = new ArrayList<>();
        expressos = new ArrayList<>();
        orcamentos = new ArrayList<>();
    }

    public List<PedidoOrcamento> getPorFazer() {
        List<PedidoOrcamento> list = new ArrayList<>();
        for(PedidoOrcamento p: porFazer)
            list.add(p.clone());
        return list;
    }

    public void setPorFazer(List<PedidoOrcamento> porFazer) {
        this.porFazer = porFazer;
    }


    public List<Orcamento> getOrcamento() {
        List<Orcamento> list = new ArrayList<>();
        for(Orcamento o: orcamentos)
            list.add(o.clone());
        return list;
    }

    public void setOrcamento(List<Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }

    void addExpresso(PedidoOrcamento po){
        expressos.add(po.clone());
    }

    void addPorFazer(PedidoOrcamento po){
        this.porFazer.add(po.clone());
    }


}
