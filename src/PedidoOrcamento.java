public class PedidoOrcamento {
    private Cliente cliente;
    private Equipamento equipamento;
    private Funcionario funcionario;

    public PedidoOrcamento(Cliente c, Equipamento e, Funcionario f){
        cliente = c;
        equipamento = e;
        funcionario = f;
    }

    public PedidoOrcamento clone(){
        return new PedidoOrcamento(cliente,equipamento, funcionario);
    }
}
