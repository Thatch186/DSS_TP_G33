import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;


public class Orcamento {
    private String idPedido; //Identificado pelo Pedido Orçamento
    private LocalDate dataCriacao;
    private LocalDate prazoMax;
    private float custoMax;
    private PlanoTrabalho planoTrabalho;

    /*
    CONSTRUCTORS
     */
    public Orcamento(String idPedido, LocalDate prazoMax, PlanoTrabalho pt, float custoMax){
        this.idPedido = idPedido;
        this.prazoMax = prazoMax;
        this.dataCriacao = LocalDateTime.now().toLocalDate();
        this.planoTrabalho = pt;
        this.custoMax = custoMax;
    }

    public Orcamento(Orcamento outro){
        this.idPedido = outro.getIdPedido();
        this.prazoMax = outro.getPrazoMax();
        this.planoTrabalho = outro.getPlanoTrabalho();
        this.dataCriacao = outro.getDataCriacao();
        this.custoMax = outro.getCustoMax();
    }
    public Orcamento(PlanoTrabalho pt, String idPedidoOrcamento){
         this.planoTrabalho = pt.clone();
         this.idPedido = idPedidoOrcamento;
         this.dataCriacao = LocalDateTime.now().toLocalDate();
         this.custoMax = (float)((pt.totalCusto() * 1.2));
         float diasParaConcluir = (pt.tempoPorConcluir() / 24) + 1;
         this.prazoMax = this.dataCriacao.plusDays((long) diasParaConcluir);
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
                this.planoTrabalho.equals(orc.getPlanoTrabalho()));
    }
    /*
    CLONE
     */
    @Override
    public Orcamento clone(){
        return new Orcamento(this);
    }
}
