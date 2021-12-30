import java.util.List;

public interface IControllerFuncionario {
    boolean registarPedidoOrcamento(String nifCliente, String idFuncionario);

    boolean registaCliente(String nif, String email, String telemovel);

    boolean registarExpresso(String nifCliente, String idFuncionario, int tipo);

    boolean registaLevantamento(String nifCliente, String idFuncionario);

    boolean validaFuncionario(String id, String pass);

    boolean registaFuncionario(String id, String pass);

    boolean removeCliente(String nif);

    int atualizarArquivo();

    int atualizarEquipamentosAbandonados();

    boolean clienteRejeitaOrcamento(String nif,String idEquipamento);

    String lastEquipamento(String nif);

    String tecReparaEquip(String idEquipamento);

    boolean clienteConfirmaOrcamento(String nif, String idE);

    List<String> imprimeLevantamentos();
}
