import java.time.LocalDateTime;
import java.util.Date;


public class Orcamento {
    private String idPedido; //Identificado pelo Pedido Orçamento
    private Date dataCriacao;
    private Date prazoMax;
    private float custoMax;
    private PlanoTrabalho planoTrabalho; //Null se é expresso

    /*
    CONSTRUCTORS
     */
    public Orcamento(String idPedido, Date prazoMax, PlanoTrabalho pt, float custoMax){
        this.idPedido = idPedido;
        this.prazoMax = prazoMax;
        this.dataCriacao = new Date();
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
         this.planoTrabalho = pt;
         this.idPedido = idPedidoOrcamento;
         //this.dataCriacao = LocalDateTime.now();
         this.custoMax = (float)((pt.totalCusto() * 1.2));
         //this.prazoMax = pt.tempoPorConcluir() *
    }

    /*
    GETTERS e SETTERS
     */
    public float getCustoMax() { return  custoMax; }

    public void setCustoMax(float custoMax){ this.custoMax = custoMax; }

    public String getIdPedido() {
        return idPedido;
    }

    public Date getDataCriacao() { return dataCriacao; }

    public void setDataCriacao(Date data) { this.dataCriacao = data;}

    public void setDataCriacao() { this.dataCriacao = new Date(); }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public Date getPrazoMax() {
        return (Date) prazoMax.clone();
    }

    public void setPrazoMax(Date prazoMax) {
        this.prazoMax = (Date) prazoMax.clone();
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
