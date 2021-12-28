import java.util.ArrayList;
import java.util.List;

public class PlanoTrabalho {
    private List<Passo> passos;
    int passosConcluidos;
    boolean pausado; //Temos de ter atencao mas deve fazer sentido começar em pausa
                    // pq ainda vai esperar pela confirmacao do cliente
                    // Por agora no metodo de adicionar passos, sempre q se adiciona um fica em pausa

    /*
    CONSTRUCTORS
     */
    public PlanoTrabalho(){
        this.passos = new ArrayList<>();
        this.passosConcluidos = 0;
        this.pausado = false;
    }
    public PlanoTrabalho(List<Passo> passos){
        this.passos = new ArrayList<>();
        for(Passo p : passos)
            this.passos.add(p.clone());
        this.passosConcluidos = 0;
        this.pausado = false;
    }
    public PlanoTrabalho(List<Passo> passos, int passosConcluidos){
        this.passos = new ArrayList<>();
        for(Passo p : passos)
            this.passos.add(p.clone());
        this.passosConcluidos = passosConcluidos;
        this.pausado = false;
    }
    public PlanoTrabalho(PlanoTrabalho pt){
        this.passos = pt.getPassos();
        this.passosConcluidos = pt.getPassosConcluidos();
        this.pausado = false;
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

    public int getPassosConcluidos() {
        return passosConcluidos;
    }

    public void setPassosConcluidos(int passosConcluidos) {
        this.passosConcluidos = passosConcluidos;
    }

    /*
    METHODS
     */

    // Verifica se plano de trabalhos já foi concluido
    public boolean estaConcluido(){
        return (this.passosConcluidos == this.passos.size());
    }

    //Soma de tempo de todos os passos no plano de trabalho
    public float totalTime(){
        float res = 0;
        for(Passo p : this.passos)
            res += p.getTempo();
        return res;
    }

    //Custo total de todos os passo no plano de trabalho
    public float totalCusto(){
        float res = 0;
        for(Passo p : this.passos)
            res += p.getCusto();
        return res;
    }

    //Total de tempo que falta para concluir plano de trabalho
    public float tempoPorConcluir(){
        float res = 0;
        for(Passo p : this.passos.subList(this.passosConcluidos,this.passos.size()))
            res += p.getTempo();
        return res;
    }

    public float jaGastoTempo(){
        float tempoGasto = 0;

        for(Passo p : this.passos.subList(0, this.passosConcluidos)){
            tempoGasto += p.getTempo();
        }
        return tempoGasto;
    }

    public float jaGastoDinheiro(){
        float dinheiroGasto = 0;

        for(Passo p : this.passos.subList(0, this.passosConcluidos)){
            dinheiroGasto += p.getCusto();
        }
        return dinheiroGasto;
    }

    public void addPasso(Passo p){
        this.passos.add(p);
        this.pausado = true;
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
        return (this.passos.equals(pt.getPassos()) &&
                this.passosConcluidos == pt.getPassosConcluidos());
    }
    /*
    CLONE
     */
    @Override
    public PlanoTrabalho clone(){
        return new PlanoTrabalho(this);
    }
}
