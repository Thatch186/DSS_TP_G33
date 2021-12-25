import java.util.List;

public class Funcionario {
    private int id;

    public Funcionario(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void regPedidoOrcamento(Cliente c,Equipamento e, Estatisticas estat){
        PedidoOrcamento po = new PedidoOrcamento(c,e,this);
        estat.addPedOrc(po); //nao sei bem a melhoor forma de adicionar as estatisticas
    }
    void regServicoExpresso(){}
}

