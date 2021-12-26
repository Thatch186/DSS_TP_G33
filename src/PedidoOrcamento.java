public class PedidoOrcamento {
    private boolean expresso;
    private String nifCliente;
    private String idEquipamento;
    private String idFuncionario;

    public PedidoOrcamento(Cliente c, Equipamento e, Funcionario f, boolean expresso){
        cliente = c;
        equipamento = e;
        funcionario = f;
        this.expresso = expresso;
    }

    public PedidoOrcamento(PedidoOrcamento po){
        this.cliente = po.cliente;
        this.expresso = po.expresso;
        this.equipamento = po.equipamento;
        this.funcionario = po.funcionario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean isExpresso() {
        return expresso;
    }

    public void setExpresso(boolean expresso) {
        this.expresso = expresso;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        if(expresso) return "Expresso <<" +
                cliente.getContacto().getEmail() +
                ", " + equipamento.getCod_registo() +
                ", " + funcionario.getId() +
                ">> ";
        return "Pedido <<" +
                cliente.getContacto().getEmail() +
                ", " + equipamento.getCod_registo() +
                ", " + funcionario.getId() +
                ">> ";
    }

    public PedidoOrcamento clone(){
        return new PedidoOrcamento(cliente,equipamento, funcionario, expresso);

    }
}
