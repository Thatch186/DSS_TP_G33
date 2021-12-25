import java.util.Arrays;
import java.util.List;

public class Funcionario {
    static Armazem armazem = new Armazem();
    static Estatisticas estat = new Estatisticas();
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

    void recebePedidoOrcamento(Cliente c, Equipamento e, boolean expresso){
        PedidoOrcamento po = new PedidoOrcamento(c,e,this,expresso );
        regPedidoOrcamento(po);
    }

    void regPedidoOrcamento(PedidoOrcamento po){
        if(po.getCliente().dadosValidos()) {
            if(po.isExpresso())
                armazem.addExpresso(po); //registoExpresso
            else
                armazem.addPorFazer(po);//registoNormal

            estat.addPedOrc(po.clone());
        }
    }

    void printArmazem(){
        System.out.println("Pedidos por Fazer: "+ armazem.porFazer.toString());
        System.out.println("Expressos: "+ armazem.expressos.toString());
        System.out.println("Orçamentos: "+ armazem.orcamentos.toString());
    }

}

