public interface IControllerFuncionario {
    public boolean registarPedidoOrcamento(String nifCliente, String idFuncionario);

    public boolean registaCliente(String nif, String email, String telemovel);

    public boolean registarExpresso(String nifCliente, String idFuncionario);

    public boolean registaLevantamento(String nifCliente, String idFuncionario);
}
