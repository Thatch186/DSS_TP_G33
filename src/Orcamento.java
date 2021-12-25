import java.util.Date;

public class Orcamento {
    private PedidoOrcamento po;
    private Date prazoMax;
    private float custoTotal;

    public Orcamento(PedidoOrcamento po, Date prazoMax, float custoTotal){
        this.po = po;
        this.prazoMax=prazoMax;
        this.custoTotal=custoTotal;
    }

    public PedidoOrcamento getPo() {
        return po.clone();
    }

    public void setPo(PedidoOrcamento po) {
        this.po = po;
    }

    public Date getPrazoMax() {
        return prazoMax;
    }

    public void setPrazoMax(Date prazoMax) {
        this.prazoMax = prazoMax;
    }

    public float getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(float custoTotal) {
        this.custoTotal = custoTotal;
    }

    public Orcamento clone(){
        return new Orcamento(po,prazoMax, custoTotal);
    }


}
