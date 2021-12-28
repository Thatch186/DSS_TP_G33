public class PedidoOrcamento {
    private String nifCliente;
    private String idEquipamento; //Identificado por idEquipamento
    private String idFuncionario;
    //adicionar a data em que pedido foi feito

    /*
    CONSTRUCTORS
     */
    public PedidoOrcamento(String c, String e, String f){
        nifCliente = c;
        idEquipamento = e;
        idFuncionario = f;
    }
    public PedidoOrcamento(PedidoOrcamento po){
        this.nifCliente = po.nifCliente;
        this.idEquipamento = po.idEquipamento;
        this.idEquipamento = po.idFuncionario;
    }

    /*
    GETTERS e SETTERS
     */
    public String getNifCliente() {
        return nifCliente;
    }

    public void setCliente(String cliente) {
        this.nifCliente = cliente;
    }

    public String getEquipamento() {
        return idEquipamento;
    }

    public void setEquipamento(String equipamento) {
        this.idEquipamento = equipamento;
    }

    public String getFuncionario() {
        return idFuncionario;
    }

    public void setFuncionario(String funcionario) {
        this.idFuncionario = funcionario;
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
        PedidoOrcamento po = (PedidoOrcamento) o;
        return  this.nifCliente.equals(po.getNifCliente()) &&
                this.idEquipamento.equals(po.getEquipamento()) &&
                this.idFuncionario.equals(po.getFuncionario());
    }
    /*
    CLONE
     */
    public PedidoOrcamento clone(){
        return new PedidoOrcamento(this);
    }

    @Override
    public String toString() {

        String pedido = "Pedido de Orçamento | ";
        StringBuilder sb = new StringBuilder(pedido);
        sb.append(nifCliente);
        sb.append(" | ");
        sb.append(idEquipamento);
        sb.append(" | ");
        sb.append(idFuncionario);
        return pedido;
    }
}
