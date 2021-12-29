import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface IControllerTecnico {

    public List<PedidoOrcamento> consultarPedidoOrcamento();

    public List<Orcamento> consultarOrcamentos();


    public Orcamento refazerOrcamento(String idOrcamento);

    public boolean criarOrcamento(PlanoTrabalho pt, String idPO, String idTecnico) throws IOException ;

    public void repararEquipamento(String tecnico, String equipamento) throws IOException;

    public String printOrcamento(String idO);
}
