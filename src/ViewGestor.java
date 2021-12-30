import java.io.IOException;
import java.util.*;


public class ViewGestor implements IViewerGeral {
    private Scanner sc;
    private final String id;
    private IControllerGestor controller;

    public ViewGestor(IControllerGestor controller, String id) {
        sc = new Scanner(System.in);
        this.controller = controller;
        this.id = id;
    }

    public void run() {
        Menu menu = new Menu(new String[]{
                "Consultar Estatísticas ",
                "Remover Técnico",
                "Remover Funcionario"
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (0):
                    break;
                case (1):
                    consultaEstatisticas();
                    break;
                case (2):
                    try {
                        removeTecnico();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                case (3):
                    try {
                        removeFuncionario();
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }


    private void consultaEstatisticas() {
        Menu menu = new Menu(new String[]{
                "Para cada Técnico: Número de Reparações e tempos",
                "Para cada Funcionário: Número de Atendimentos e Entregas",
                "Para cada Técnico: Todas as intervenções",
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (0):
                    break;
                case (1):
                    estatistica1();
                    break;
                case (2):
                    estatistica2();
                    break;
                case (3):
                    estatistica3();
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    private void estatistica1(){
        Map<String,ControllerGestor.Triplo<Integer,Float,Float>> map = controller.estatistica1();
        for(String id: map.keySet()){
            System.out.println("Técnico  "+id+": "+map.get(id).toString());
        }
    }

    private void estatistica2(){
        Map<String,ControllerGestor.Par<Integer,Integer>> map = controller.estatistica2();
        for(String id: map.keySet()){
            System.out.println("Funcionário "+id+": "+map.get(id).toString());
        }
    }

    private void estatistica3(){
        Map<String,List<String>> map = controller.estatistica3();
        for(String id: map.keySet()){
            System.out.println("Técnico "+id+": "+map.get(id).toString());
        }
    }


    private void removeTecnico() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira idTecnico: ");
        String idTecnico = sc.nextLine();

        boolean result = this.controller.removerTecnico(idTecnico);
        //REVS em KEY | USERS em VALUES
        if (result) System.out.println("Técnico removido");
        else System.out.println("ERRO: técnico não removido");
    }

    private void removeFuncionario() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira idFuncionário ");
        String idFuncionario = sc.nextLine();

        boolean result = this.controller.removerFuncionario(idFuncionario);
        //REVS em KEY | USERS em VALUES
        if (result) System.out.println("Funcionário removido");
        else System.out.println("ERRO: funcionário não removido");
    }
}
