import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public interface InterfM extends Serializable {
    void init();
    public Map<String, PedidoOrcamento> getPedidosOrcamento();
    public Map<String, Orcamento> getOrcamentos();


    public boolean removerFuncionario(String idF);
    public boolean removerCliente(String nif);
    public  boolean removerTecnico(String idT);


    public boolean registarLevantamento(String idEquipamento, String idFuncionario);

    public boolean pedeOrcamento(String cliente, String funcionario);

    public boolean pedeExpresso(String cliente, String funcionario);

    public boolean registarPedido(String nifCliente, String idFuncionario, boolean isExpresso);
    public boolean addCliente(String nif, String email, String telemovel);

    public boolean iniciarReparo(String tecnicoId, String equipamentoID);

    public boolean registarOrcamento( PlanoTrabalho pt, String idPedidoOrcamento, String idTecnico);

}
