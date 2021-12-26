import jdk.nashorn.internal.ir.LiteralNode;

import java.util.Date;

public class Orcamento {
    private String idPedido; //Identificado pelo Pedido Orçamento
    private Date prazoMax;
    private PlanoTrabalho planoTrabalho;

    /*
    CONSTRUCTORS
     */
    public Orcamento(String idPedido, Date prazoMax, PlanoTrabalho pt){
        this.idPedido = idPedido;
        this.prazoMax=prazoMax;
        this.planoTrabalho = pt;
    }
    public Orcamento(Orcamento outro){
        this.idPedido = outro.getIdPedido();
        this.prazoMax = outro.getPrazoMax();
        this.planoTrabalho = outro.getPlanoTrabalho();
    }

    /*
    GETTERS e SETTERS
     */
    public String getIdPedido() {
        return idPedido;
    }

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
