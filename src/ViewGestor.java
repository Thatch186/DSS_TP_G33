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
                "Remover Funcionario",
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (0):
                    break;
                case (1):
                    // consultaEstatisticas();
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
        Scanner sc = new Scanner(System.in);
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
