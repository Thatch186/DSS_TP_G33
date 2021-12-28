import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class ViewTecnico implements InterfaceViwer{
    private Scanner sc;
    private Controller controller;
    private String id;

    public ViewTecnico(Controller controller, String id){
        sc=new Scanner(System.in);1
        this.controller = controller;
        this.id = id;
    }

    public void run() { ///entao
        Menu menu = new Menu(new String[]{
                "Consultar Pedido de Orçamento",
                "Consultar Orçamentos",
                "Refazer Orçamento",
                "Criar Orçamento",
                "Reparar Equipamento",
                "Consultar estado de Reparação",

        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (1):
                    consultarPedidosOrcamento();
                    break;
                case (2):
                    consultarOrcamentos();
                    break;
                case (3):
                    refazerOrcamento();
                    break;
                case (4):
                    criarOrcamento();
                    break;
                case (5):
                    repararEquipamento();
                    break;
                case (6):
                    consultarEstadoReparacao();
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    void consultarPedidosOrcamento(){
        ArrayList<PedidoOrcamento> pedidos = pedidosOrcamento.getValues();
        for(PedidoOrcamento po: pedidos){
            System.out.println(po.toString());
        }
    }

    void consultarOrcamentos(){
        ArrayList<Orcamento> orcs = orcamentos.getValues();
        for(Orcamento o: orcs){
            System.out.println(o.toString());
        }
    }

    void refazerOrcamento(){
    }

    void criarOrcamento(){
        System.out.println("Insira Id do Pedido de Orçamento: ");
        String idPO = sc.nextLine();
        PlanoTrabalho pt = new PlanoTrabalho();
        Menu menuO = new Menu(new String[]{
                "Adicionar passo",
                "Concluir Plano",
                "Rejeitar(Não é possível reparar equipamento)"
        });
        int op;
        do {
            menuO.executa();
            op = menuO.getOpcao();
            switch (op) {
                case (1):
                    pt=adicionaPasso(pt);
                    break;
                case (2):
                    concluirPlano(pt,idPO);
                    break;
                case (3):
                    rejeitar();
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    PlanoTrabalho adicionaPasso(PlanoTrabalho pt){
        Passo novo = new Passo();
        System.out.println("Custo do passo:");
        float custo = sc.nextFloat();
        System.out.println("Tempo do passo:");
        float tempo = sc.nextFloat();
        String descricao=null;
        System.out.println("Adicionar descrição ? Sim-1 | Não-2");
        if(sc.nextInt()==1){
            System.out.println("Insira a descrição");
            descricao = sc.nextLine();
        }
        pt.addPasso(novo);
        return pt;
    }

    void concluirPlano(PlanoTrabalho pt, String idPO){
        Orcamento o = new Orcamento(pt,idPO);
        //orcamentos.add(idPO,Orcamento);
        //Cliente confirma
        System.out.println("Orcamento Registado");
    }

    void rejeitar(){
        System.out.println("Não é possível reparar o equipamento");
    }

    void repararEquipamento(){
        System.out.println("Insira ID do Orçamento:");
        String idO= sc.nextLine();

        //...
    }

    void consultarEstadoReparacao(){
        //..
    }
}
