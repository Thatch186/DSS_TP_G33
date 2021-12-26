import java.util.Date;

public class Orcamento {
    private String idPedido;
    private Date prazoMax;
    private float custoTotal;

    public Orcamento(String idPedido, Date prazoMax, float custoTotal){
        this.idPedido = idPedido;
        this.prazoMax=prazoMax;
        this.custoTotal=custoTotal;
    }

    public String getPo() {
        return idPedido;
    }

    public void setPo(String po) {
        this.idPedido = po;
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
        return new Orcamento(idPedido,prazoMax, custoTotal);
    }


}
