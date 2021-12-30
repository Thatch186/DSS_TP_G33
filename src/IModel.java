import java.util.List;
import java.util.Map;

public interface IModel{
    void init();
    /*
    GETTERS
     */
    Map<String, Equipamento> getEquipamentos();
    Map<String, Funcionario> getFuncionarios();
    Map<String, Cliente> getClientes();
    Map<String, Tecnico> getTecnicos();
    Map<String, PedidoOrcamento> getPedidosOrcamento();
    Map<String, Orcamento> getOrcamentos();
    Gestor getGestor();

    /*
    VALIDACOES
     */
    boolean isExpresso(String eqId);
    boolean validarFuncionario(String idF, String password);
    boolean validarCliente(String idC);
    boolean validarTecnico(String idT, String password);
    boolean validarGestor(String idG, String password);

    /*
    ADDS
     */
    boolean addFuncionario(String idF, String password);
    boolean addCliente(String nif, String email, String telemovel);
    boolean addTecnico(String idT, String password);

    /*
    REMOVES
     */
    boolean removerFuncionario(String idF);
    boolean removerCliente(String nif);
    boolean removerTecnico(String idT);

    /*
    REGISTOS
     */
    boolean registarLevantamento(String idEquipamento, String idFuncionario);
    boolean pedeOrcamento(String cliente, String funcionario);
    boolean pedeExpresso(String cliente, String funcionario,int tipo);
    boolean registarOrcamento( PlanoTrabalho pt, String idPedidoOrcamento, String idTecnico);
    boolean registarEquipamentoReparado(String idEquipamento, String idTecnico);
    /*
    AÇOES DO CLIENTE
     */
    boolean clienteConfirmaOrcamento(String nifCliente, String idEquipamento);
    boolean clienteRejeitaOrcamento(String nifCliente, String idEquipamento);

    /*
    ACOES FUNCIONARIO
     */
    int atualizarArquivo();
    int atualizarEquipamentosAbandonados();

    /*
    REPARACOES
     */
    boolean iniciarReparo(String tecnicoId, String equipamentoID);
    boolean pausarReparo(String tecnicoId, String equipamentoID);
    boolean marcarPassoComoConcluido(String tecnicoId, String orcamentoId, int custoDinheiro, float horasGastas);
    /*
    ESTATISTICAS
     */
    float mediaTempoGasto(String idTecnico);
    float mediaTempoEstimado(String idTecnico);
    List<String> intervencoes(String idTecnico);
    String printReparo(String idO);
    List<String> printLinhaReparo();
}