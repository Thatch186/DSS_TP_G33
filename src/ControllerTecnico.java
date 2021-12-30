import java.util.*;

public class ControllerTecnico implements IControllerTecnico{
    private IModel armazem;

    public ControllerTecnico(IModel model) {
        this.armazem = model;
    }

    public List<PedidoOrcamento> consultarPedidoOrcamento() {
        return new ArrayList<>(this.armazem.getPedidosOrcamento().values());
    }

    public List<Orcamento> consultarOrcamentos() {
        return new ArrayList<>(this.armazem.getOrcamentos().values());
    }


    public Orcamento refazerOrcamento(String idOrcamento) {
        return this.armazem.getOrcamentos().get(idOrcamento).clone();
    }

    public boolean criarOrcamento(PlanoTrabalho pt, String idPedido, String idTec){
        return  this.armazem.registarOrcamento(pt, idPedido, idTec);

    }

    public boolean repararEquipamento(String tecnico, String equipamento){
        return this.armazem.iniciarReparo(tecnico, equipamento);
    }
    public String printOrcamento(String idO){
        if(armazem.getOrcamentos().containsKey(idO))
            return  armazem.getOrcamentos().get(idO).toString();
        return "ID introduzido inválido";
    }
    public String printReparo(String idO){
        return armazem.printReparo(idO);
    }

    public boolean validaTecnico(String id, String pass){
        return armazem.validarTecnico(id,pass);
    }

    public boolean registaTecnico(String id,String pass){
        return armazem.addTecnico(id,pass);
    }

    public boolean isOcupado(String id) {
        return armazem.getTecnicos().get(id).isOcupado();
    }

    public String aReparar(String id){
        return armazem.getTecnicos().get(id).getaReparar();
    }

    public boolean pausaReparo(String id,String idE){
        return armazem.pausarReparo(id,idE);
    }

    public boolean marcarConcluido(String id, String idEquipamento, int custo, float tempo){
        return armazem.marcarPassoComoConcluido(id,idEquipamento,custo,tempo);
    }

    public boolean terminarExpresso(String idTecnico, String idEquipamento){
        if(armazem.isExpresso(idEquipamento)){
            return armazem.registarEquipamentoReparado(idEquipamento,idTecnico);
        }
        else return false;
    }
}