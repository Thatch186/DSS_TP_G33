import java.util.ArrayList;
import java.util.List;

public class PlanoTrabalho {
    private List<Passo> passos;
    private Orcamento orcamento;

    /*
    CONSTRUCTORS
     */
    public PlanoTrabalho(List<Passo> passos, Orcamento orcamento){
        this.passos = new ArrayList<>();
        for(Passo p : passos)
            this.passos.add(p.clone());
        this.orcamento = new Orcamento(orcamento);
    }
    public PlanoTrabalho(PlanoTrabalho pt){
        this.passos = pt.getPassos();
        this.orcamento = pt.getOrcamento();
    }
    /*
    GETTERS e SETTERS
     */
    public List<Passo> getPassos() {
       List<Passo> ret = new ArrayList<>();
       for(Passo p : this.passos)
           ret.add(p.clone());
       return ret;
    }

    public void setPassos(List<Passo> passos) {
        this.passos = new ArrayList<>();
        for(Passo p : passos)
            this.passos.add(p.clone());
    }

    public Orcamento getOrcamento() {
        return orcamento.clone();
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento.clone();
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
        PlanoTrabalho pt = (PlanoTrabalho) o;
        return (this.orcamento.equals(pt.getOrcamento()) &&
                this.passos.equals(pt.getPassos()));
    }
    /*
    CLONE
     */
    @Override
    public PlanoTrabalho clone(){
        return new PlanoTrabalho(this);
    }
}
