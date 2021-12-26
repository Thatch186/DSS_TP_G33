public class PedidoOrcamento {
    private boolean expresso;
    private String nifCliente;
    private String idEquipamento;
    private String idFuncionario;

    public PedidoOrcamento(String c, String e, String f, boolean expresso){
        nifCliente = c;
        idEquipamento = e;
        idFuncionario = f;
        this.expresso = expresso;
    }

    public PedidoOrcamento(PedidoOrcamento po){
        this.nifCliente = po.nifCliente;
        this.expresso = po.expresso;
        this.idEquipamento = po.idEquipamento;
        this.idEquipamento = po.idFuncionario;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setCliente(String cliente) {
        this.nifCliente = cliente;
    }

    public boolean isExpresso() {
        return expresso;
    }

    public void setExpresso(boolean expresso) {
        this.expresso = expresso;
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


    public PedidoOrcamento clone(){
        return new PedidoOrcamento(nifCliente,idEquipamento,idFuncionario, expresso);

    }
}
