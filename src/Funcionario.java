import java.util.List;

public class Funcionario {
    private int id;
    Estatisticas estat;

    public Funcionario(int id, Estatisticas estatisticas){
        this.id = id;
        this.estat = estatisticas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    void recebePedidoOrcamento(Cliente c, Equipamento e){
        regPedidoOrcamento(c,e);
    }

    void regPedidoOrcamento(Cliente c,Equipamento e){
        if(c.dadosValidos()) {
            PedidoOrcamento po = new PedidoOrcamento(c, e, this);
            estat.addPedOrc(po); //nao sei bem a melhoor forma de adicionar as estatistica
        }
    }
    void regServicoExpresso(){}
}

