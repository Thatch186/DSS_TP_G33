import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//E EXPRESSOS ? HÀ EXPRESSOS ?

public class ViewTecnico implements IViewerGeral{
    private Scanner sc;
    private IControllerTecnico controller;
    private final String id;

    public ViewTecnico(IControllerTecnico controller, String id){
        sc=new Scanner(System.in);
        this.controller = controller;
        this.id = id;
    }

    public void run(){
        Menu menu = new Menu(new String[]{
                "Consultar Pedido de Orçamento",
                "Consultar Orçamentos",
                "Criar Orçamento",
                "Reparar Equipamento",
                "Consultar estado de Reparação"
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (0):break;
                case (1):
                    consultarPedidosOrcamento();
                    break;
                case (2):
                    consultarOrcamentos();
                    break;
                case (3):
                    try {
                        criarOrcamento();
                        break;
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                case (4):
                    try {
                        repararEquipamento();
                        break;
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                case (5):
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
        List<PedidoOrcamento> pedidos = controller.consultarPedidoOrcamento();
        for(PedidoOrcamento po: pedidos){
            System.out.println(po.toString());
        }
    }

    void consultarOrcamentos(){
        List<Orcamento> orcs = controller.consultarOrcamentos();
        for(Orcamento o: orcs){
            System.out.println(o.toString());
        }
    }

    void criarOrcamento() throws IOException {
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
                case (0):break;
                case (1):
                    pt=adicionaPasso(pt);
                    break;
                case (2):
                    concluirPlano(pt,idPO);
                    op=0;
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
        System.out.println("Adicionar descrição ? Sim-s | Não-n");
        String trash = sc.nextLine();
        String choice = sc.nextLine();
        if(choice.equals("s")){
            System.out.println("Insira a descrição");
            descricao = sc.nextLine();
        }
        else System.out.println("Nenhuma descrição adicionada");
        novo.setCusto(custo);
        novo.setTempo(tempo);
        novo.setDescricao(descricao);
        pt.addPasso(novo);
        return pt.clone();
    }

    void concluirPlano(PlanoTrabalho pt, String idPO) throws IOException {
        if(controller.criarOrcamento(pt,idPO, id))
            System.out.println("Orcamento Registado");
        else
            System.out.println("Nao Registado");
    }
    //ENVIAR EMAIL AO CLIENTE
    void rejeitar(){
        System.out.println("Não é possível reparar o equipamento");
    }

    void repararEquipamento() throws IOException {
        System.out.println("Insira ID do Equipamento:");
        String idE= sc.nextLine();
        if(controller.repararEquipamento(id,idE))
            System.out.println("Reparo Iniciado");
        else
            System.out.println("ERRO: Reparo não iniciado");
    }

    void consultarEstadoReparacao() {
        if (controller.isOcupado(id)) {
            System.out.println(controller.printReparo(controller.aReparar(id)));
            String idEquipamento = controller.aReparar(id);
            Menu menu = new Menu(new String[]{
                    "Pausar reparação",
                    "Marcar passo concluído",
                    "Terminar reparação expresso"
            });
            int op;
            do {
                menu.executa();
                op = menu.getOpcao();
                switch (op) {
                    case (0):
                        break;
                    case (1):
                        pausaReparo(idEquipamento);
                        op=0;
                        break;
                    case (2):
                        marcaPassoConcluido(idEquipamento);
                        break;
                    case (3):
                        terminarExpresso(idEquipamento);
                        op=0;
                        break;
                    default:
                        sc.nextLine();
                        System.out.println("Comando não reconhecido!");
                        break;
                }
            } while (op != 0);
        }
        else{
            System.out.println("Técncio parado. Sem reparo ativo");
        }
    }

    void pausaReparo(String idE){
        if(controller.pausaReparo(id,idE))
            System.out.println("Reparo pausado");
        else
            System.out.println("ERRO: Reparo não foi pausado");
    }

    void marcaPassoConcluido(String idE){
        System.out.println("Quanto custou o passo:");
        int custo = sc.nextInt();
        System.out.println("Quanto tempo demorou:");
        float tempo = sc.nextFloat();

        if(controller.marcarConcluido(id,idE,custo,tempo))
            System.out.println("Passo marcado como concluido");
        else
            System.out.println("ERRO: falha ao marcar passo como concluído");
    }

    void terminarExpresso(String idE){
        if(controller.terminarExpresso(id,idE))
            System.out.println("Expresso terminado");
        else
            System.out.println("ERRO: Não terminado");
    }
}
