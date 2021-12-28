import java.util.Scanner;

public class ViewFuncionario implements IViewerGeral{
    private Scanner sc;
    private ControllerFuncionario controller;
    private String id;

    public ViewFuncionario(ControllerFuncionario controller, String id){
        sc=new Scanner(System.in);
        this.controller = controller;
        this.id = id;
    }

    public void run() { ///entao
        Menu menu = new Menu(new String[]{
                "Registar Pedido de Orçamento",
                "Registar Cliente",
                "Registar Serviço Expresso",
                "Registar Entrega de Equipamentos aos Clientes"
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (1):
                    registaPedidoOrcamento();
                    break;
                case (2):
                    registaCliente();
                    break;
                case (3):
                    registaExpresso();
                    break;
                case (4):
                    registaLevantamento();
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    void registaPedidoOrcamento(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();

        //boolean r=registarPedido(nif,id,false);
        //if(r)System.out.println("Pedido registado");
        //else System.out.println("Registo Falhado");
    }

    void registaCliente(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();
        System.out.println("Insira email do cliente:");
        String email = sc.nextLine();
        System.out.println("Insira telemovel do cliente:");
        String telemovel = sc.nextLine();
        //boolean r = addCliente(nif,email,telemovel);
        //if(r)System.out.println("Cliente registado");
        //else System.out.println("Registo Falhado");

    }

    void registaExpresso(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();

        //boolean r=registarPedido(nif,id,true);
        //if(r)System.out.println("Pedido registado");
        //else System.out.println("Registo Falhado");
    }

    void registaLevantamento(){
        System.out.println("Insira id do Equipamento:");
        String idE = sc.nextLine();

        //boolean r=registaLevantamento(idE,id);
        //if(r)System.out.println("Levantamento efetuado");
        //else System.out.println("Levantamento Falhado");
    }



}
