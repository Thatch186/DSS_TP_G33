import java.time.LocalDate;
import java.time.LocalDateTime;

public class Orcamento {
    private String idPedido; //Identificado pelo Pedido Orçamento
    private LocalDate dataCriacao;
    private LocalDate prazoMax;
    private float custoMax;
    private PlanoTrabalho planoTrabalho;
    private boolean confirmado;

    /*
    CONSTRUCTORS
     */
    public Orcamento(String idPedido, LocalDate prazoMax, PlanoTrabalho pt, float custoMax){
        this.idPedido = idPedido;
        this.prazoMax = prazoMax;
        this.dataCriacao = LocalDateTime.now().toLocalDate();
        this.planoTrabalho = pt;
        this.custoMax = custoMax;
        this.confirmado = false;
    }

    public Orcamento(Orcamento outro){
        this.idPedido = outro.getIdPedido();
        this.prazoMax = outro.getPrazoMax();
        this.planoTrabalho = outro.getPlanoTrabalho();
        this.dataCriacao = outro.getDataCriacao();
        this.custoMax = outro.getCustoMax();
        this.confirmado = outro.isConfirmado();
    }
    public Orcamento(PlanoTrabalho pt, String idPedidoOrcamento){
         this.planoTrabalho = pt.clone();
         this.idPedido = idPedidoOrcamento;
         this.dataCriacao = LocalDateTime.now().toLocalDate();
         this.custoMax = (float)((pt.totalCusto() * 1.2));
         float diasParaConcluir = (pt.tempoPorConcluir() / 24) + 1;
         this.prazoMax = this.dataCriacao.plusDays((long) diasParaConcluir);
         this.confirmado = false;
    }

    /*
    GETTERS e SETTERS
     */
    public float getCustoMax() { return  custoMax; }

    public void setCustoMax(float custoMax){ this.custoMax = custoMax; }

    public String getIdPedido() {
        return idPedido;
    }

    public LocalDate getDataCriacao() { return dataCriacao; }

    public void setDataCriacao(LocalDate data) { this.dataCriacao = data;}

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDate getPrazoMax() {
        return (LocalDate) prazoMax;
    }

    public void setPrazoMax(LocalDate prazoMax) {
        this.prazoMax = prazoMax;
    }

    public PlanoTrabalho getPlanoTrabalho(){
        return this.planoTrabalho.clone();
    }

    public void setPlanoTrabalho(PlanoTrabalho pt){
        this.planoTrabalho = pt.clone();
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    /*
    METHODS
     */
    public boolean estaConcluido(){
        return this.planoTrabalho.estaConcluido();
    }
    public void atualizaData(){
        float diasParaConcluir = (this.planoTrabalho.tempoPorConcluir() / 24) + 1;
        this.prazoMax = LocalDateTime.now().toLocalDate().plusDays((long) diasParaConcluir);
    }
    public boolean iniciarPlanoTrabalho(){
        if(this.confirmado){
            this.planoTrabalho.setPausado(false);
            return true;
        }
        return false;
    }
    public boolean pausarPlanoTrabalho(){
        if(!this.confirmado) return false;
        if(this.planoTrabalho.isPausado()) return false;
        this.planoTrabalho.setPausado(true);
        return true;
    }
    public boolean estaEmPausa(){
        return this.planoTrabalho.isPausado();
    }
    public boolean marcarPassoComoConcluido(int dinheiroGasto, float horasGastas){
        boolean ret = planoTrabalho.marcarPassoComoConcluido(dinheiroGasto,horasGastas);
        if(this.planoTrabalho.dinheiroGasto >= this.custoMax * 1.20)
            refazerOrcamento();
        return ret;
    }
    public void refazerOrcamento(){
        this.confirmado = false;
        this.planoTrabalho.setPausado(true);
        this.custoMax = this.planoTrabalho.getDinheiroGasto() + this.planoTrabalho.dinheiroPorConcluir() + 50;
        float diasPorConcluir = (this.planoTrabalho.tempoPorConcluir() / 24) + 1;
        this.prazoMax = LocalDateTime.now().toLocalDate().plusDays((int)diasPorConcluir);
    }
    public float tempoGasto(){
        return this.planoTrabalho.getHorasGastas();
    }
    public float tempoEstimado(){
        return this.planoTrabalho.totalTime();
    }
    public float dinheiroGasto(){
        return this.planoTrabalho.getDinheiroGasto();
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
        Orcamento orc = (Orcamento) o;
        return (this.idPedido.equals(orc.getIdPedido()) &&
                this.prazoMax.equals(orc.getPrazoMax()) &&
                this.planoTrabalho.equals(orc.getPlanoTrabalho()) &&
                this.confirmado == orc.isConfirmado() &&
                this.custoMax == orc.getCustoMax() &&
                this.dataCriacao.equals(orc.getDataCriacao()));
    }
    /*
    CLONE
     */
    @Override
    public Orcamento clone(){
        return new Orcamento(this);
    }

    @Override
    public String toString() {
        String s = "Orçamento: ";
        StringBuilder sb = new StringBuilder(s);
        sb.append(idPedido);
        sb.append(" | ");
        sb.append(prazoMax);
        sb.append(" | ");
        sb.append(dataCriacao.toString());
        sb.append(" | ");
        sb.append(custoMax);
        sb.append(" | ");
        sb.append(confirmado);
        sb.append('\n');
        sb.append(planoTrabalho.toString());

        return sb.toString();
    }
}
