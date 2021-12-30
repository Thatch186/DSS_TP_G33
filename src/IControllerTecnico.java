import java.io.IOException;
import java.util.List;

public interface IControllerTecnico {
    List<PedidoOrcamento> consultarPedidoOrcamento();

    List<Orcamento> consultarOrcamentos();

    Orcamento refazerOrcamento(String idOrcamento);

    boolean criarOrcamento(PlanoTrabalho pt, String idPO, String idTecnico) throws IOException ;

    boolean repararEquipamento(String tecnico, String equipamento) throws IOException;

     String printOrcamento(String idO);

     boolean validaTecnico(String id, String pass);

     boolean registaTecnico(String id,String pass);

}
