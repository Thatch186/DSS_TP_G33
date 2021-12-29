import java.util.ArrayList;
import java.util.List;

public class PlanoTrabalho {
    private List<Passo> passos;
    int passosConcluidos;
    int dinheiroGasto;
    float horasGastas;
    boolean pausado;

    /*
    CONSTRUCTORS
     */
    public PlanoTrabalho(){
        this.passos = new ArrayList<>();
        this.passosConcluidos = 0;
        this.dinheiroGasto = 0;
        this.horasGastas = 0;
        this.pausado = true;
    }
    public PlanoTrabalho(List<Passo> passos){
        this.passos = new ArrayList<>();
        for(Passo p : passos)
            this.passos.add(p.clone());
        this.passosConcluidos = 0;
        this.dinheiroGasto = 0;
        this.pausado = true;
    }
    public PlanoTrabalho(List<Passo> passos, int passosConcluidos){
        this.passos = new ArrayList<>();
        for(Passo p : passos)
            this.passos.add(p.clone());
        this.passosConcluidos = passosConcluidos;
        this.dinheiroGasto = 0;
        this.horasGastas = 0;
        this.pausado = true;
    }
    public PlanoTrabalho(PlanoTrabalho pt){
        this.passos = pt.getPassos();
        this.passosConcluidos = pt.getPassosConcluidos();
        this.pausado = pt.isPausado();
        this.dinheiroGasto = pt.getDinheiroGasto();
        this.horasGastas = pt.getHorasGastas();
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

    public boolean isPausado() {
        return pausado;
    }

    public void setPausado(boolean pausado) {
        this.pausado = pausado;
    }

    public int getDinheiroGasto() {
        return dinheiroGasto;
    }

    public void setDinheiroGasto(int dinheiroGasto) {
        this.dinheiroGasto = dinheiroGasto;
    }

    public float getHorasGastas() {
        return horasGastas;
    }

    public void setHorasGastas(float horasGastas) {
        this.horasGastas = horasGastas;
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

    public float dinheiroPorConcluir(){
        float res = 0;
        for(Passo p : this.passos.subList(this.passosConcluidos,this.passos.size()))
            res += p.getCusto();
        return res;
    }

    public void addPasso(Passo p){
        this.passos.add(p.clone());
        this.pausado = true;
    }

    public boolean marcarPassoComoConcluido(int dinheirGasto, float tempoGasto){
        if(this.passosConcluidos == this.passos.size()) return false;
        if(this.pausado) return false;

        this.dinheiroGasto += dinheirGasto;
        this.horasGastas += tempoGasto;
        this.passosConcluidos++;
        return true;
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
                this.passosConcluidos == pt.getPassosConcluidos() &&
                this.pausado == pt.isPausado() &&
                this.dinheiroGasto == pt.getDinheiroGasto() &&
                this.horasGastas == pt.getHorasGastas());
    }
    /*
    CLONE
     */
    @Override
    public PlanoTrabalho clone(){
        return new PlanoTrabalho(this);
    }

    @Override
    public String toString() {
        String r = "Plano de Trabalho: ";
        StringBuilder sb = new StringBuilder(r);
        sb.append(passos.toString());
        sb.append(" | ");
        sb.append(passosConcluidos);
        sb.append(" | ");
        sb.append(horasGastas);
        sb.append(" | ");
        sb.append(pausado);

        return sb.toString();
    }
}
