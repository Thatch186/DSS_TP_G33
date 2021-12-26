import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Armazem {
    private Map<String,Equipamento> equipamentos;
    private Map<String,Funcionario> funcionarios;
    private Map<String,Cliente> clientes;
    private Map<String,Tecnico> tecnicos;
    private Map<String,PedidoOrcamento> porFazer;
    private Map<String,PedidoOrcamento> expressos;
    private Map<String, Orcamento> orcamentos;
    private Estatisticas estat;
    private Gestor gestor;




    /*
    public boolean pedeOrcamento(Cliente c, Equipamento e, Funcionario f, boolean expresso){
        boolean b=false;
        recebePedidoOrcamento(c ,e, expresso);
        return b;
    }

    void recebePedidoOrcamento(Cliente c, Equipamento e, Funcionario f, boolean expresso){
        PedidoOrcamento po = new PedidoOrcamento(c,e,f,expresso );
        regPedidoOrcamento(f,po);
    }

    void regPedidoOrcamento(Funcionario f, PedidoOrcamento po){
        if(po.getCliente().dadosValidos()) {
            if(po.isExpresso())
                addExpresso(po); //registoExpresso
            else
                addPorFazer(po);//registoNormal

            estat.addPedOrc(po.clone());
        }
    }*/


}
