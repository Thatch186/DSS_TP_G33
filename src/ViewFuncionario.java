import java.util.Scanner;

public class ViewFuncionario implements IViewerGeral{
    private Scanner sc;
    private IControllerFuncionario controller;
    private final String id;

    public ViewFuncionario(IControllerFuncionario controller, String id){
        sc=new Scanner(System.in);
        this.controller = controller;
        this.id = id;
    }

    public void run() { ///entao
        Menu menu = new Menu(new String[]{
                "Registar Pedido de Orçamento",
                "Registar Cliente",
                "Remover Cliente",
                "Registar Serviço Expresso",
                "Registar Entrega de Equipamentos aos Clientes",
                "Atualizar arquivo",
                "Atualizar equipamentos abandonados",
                "Cliente rejeita Orçamento"
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (0):break;
                case (1):
                    registaPedidoOrcamento();
                    break;
                case (2):
                    registaCliente();
                    break;
                case (3):
                    removeCliente();
                    break;
                case (4):
                    registaExpresso();
                    break;
                case (5):
                    registaLevantamento();
                    break;
                case (6):
                    atualizaArquivo();
                    break;
                case (7):
                    atualizaEquipamentosAbandonados();
                    break;
                case (8):
                    clienteRejeitaOrcamento();
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

        boolean r= controller.registarPedidoOrcamento(nif, id);
        if(r)System.out.println("Pedido registado");
        else System.out.println("ERRO: Registo Falhado");
    }

    void registaCliente(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();
        System.out.println("Insira email do cliente:");
        String email = sc.nextLine();
        System.out.println("Insira telemovel do cliente:");
        String telemovel = sc.nextLine();
        boolean r = controller.registaCliente(nif, email, telemovel);
        if(r)System.out.println("Cliente registado");
        else System.out.println("ERRO: Registo Falhado");

    }

    void removeCliente(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();
        if(controller.removeCliente(nif))
            System.out.println("Cliente removido");
        else
            System.out.println("ERRO: Cliente não existe ou tem pedidos de orçamentos associados");

    }

    void registaExpresso(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();

        int i = 1;
        for(TipoServicoExpresso s :  TipoServicoExpresso.values()){
            System.out.println(i + ": " + s);
            i++;
        }
        System.out.println("Escolha Tipo de Serviço: ");
        int tipo = scan_int(sc,1,TipoServicoExpresso.values().length);

        boolean r= controller.registarExpresso(nif, id, tipo);
        if(r)System.out.println("Expresso registado");
        else System.out.println("ERRO: Registo Falhado");
    }

    void registaLevantamento(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();
        /*System.out.println("Insira id do Equipamento:");
        String idE = sc.nextLine();*/

        boolean r= controller.registaLevantamento(nif,id);
        if(r)System.out.println("Levantamento efetuado");
        else System.out.println("ERRO: Levantamento Falhado");
    }

    void atualizaArquivo(){
        int n = controller.atualizarArquivo();
        if(n==1)
            System.out.println("1 Orçamento adicionado ao arquivo");
        else
            System.out.println(n+" Orçamentos adicionados ao arquivo");
    }

    void atualizaEquipamentosAbandonados(){
        int n = controller.atualizarEquipamentosAbandonados();
        if(n==1)
            System.out.println("1 Equipamento adicionado aos Abandonados");
        else
            System.out.println(n+" Orçamentos adicionados ao Abandonados");
    }

    void clienteRejeitaOrcamento(){
        System.out.println("Insira nif do cliente:");
        String nif = sc.nextLine();
        System.out.println("Insira id do Equipamento:");
        String idE = sc.nextLine();

        if(controller.clienteRejeitaOrcamento(nif,idE))
            System.out.println("Orçamento rejeitado");
        else
            System.out.println("ERRO: Não foi possivel rejeitar");
    }

    public static int scan_int(Scanner in, int min, int max) {
        int integer;
        try {
            integer = in.nextInt();
            if (integer < min || integer > max) {
                System.out.println("Número inválido, tente outra vez!");
                in.nextLine();
                integer = scan_int(in, min, max);
            }
            else
                in.nextLine();
        } catch (Exception e) {
            System.out.println("Formato inválido: ");
            if (in.hasNext()) in.nextLine();
            integer = scan_int(in, min, max);
        }
        return integer;
    }
}
