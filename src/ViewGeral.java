import java.io.IOException;
import java.util.Scanner;

public class ViewGeral implements IViewerGeral{
    private Scanner sc;
    private ControllerTecnico ct;
    private ControllerGestor cg;
    private ControllerFuncionario cf;
    private ViewTecnico vt;
    private ViewGestor vg;
    private ViewFuncionario vf;

    public ViewGeral(ControllerTecnico ct,ControllerGestor cg,ControllerFuncionario cf){
        sc=new Scanner(System.in);
    }

    public void run(){
        Menu menu = new Menu(new String[]{
                "Login",
                "Registar",
                "Sair"

        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (1):
                    try {
                        login();
                        break;
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                case (2):
                    registar();
                    break;
                case (3):
                    System.out.println("Introduza 0");
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    void login() throws IOException {
        Menu menu = new Menu(new String[]{
                "Tecnico",
                "Funcionario",
                "Gestor"
        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (1):
                    loginTecnico();
                    break;
                case (2):
                    loginFuncionario();
                    break;
                case (3):
                    loginGestor();
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    void loginTecnico() throws IOException {
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();

        //if(!ct.existeTecnico) System.out.println("Login Inválido"); return;

        vt = new ViewTecnico(ct,userName);
        vt.run();
    }

    void loginFuncionario(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();

        //if(!ct.existeTecnico) System.out.println("Login Inválido"); return;

        vf = new ViewFuncionario(cf,userName);
        vf.run();
    }

    void loginGestor(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();

        //if(!ct.existeTecnico) System.out.println("Login Inválido"); return;

        vg = new ViewGestor(cg,userName);
        vg.run();
    }

    void registar(){
        Menu menu = new Menu(new String[]{
                "Técnico",
                "Funcionário"

        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (1):
                    registaTecnico();
                    break;
                case (2):
                    registaFuncionario();
                    break;
                default:
                    sc.nextLine();
                    System.out.println("Comando não reconhecido!");
                    break;
            }
        } while (op != 0);
    }

    void registaTecnico(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();
        System.out.println("Reintroduza Password:");
        String password2= sc.nextLine();

        if(!password.equals(password2)){
            System.out.println("Password diferente. Registo Falhou.");
            return;
        }

        //ct.addTecnico(userName,Password);
    }

    void registaFuncionario(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();
        System.out.println("Reintroduza Password:");
        String password2= sc.nextLine();

        if(!password.equals(password2)){
            System.out.println("Password diferente. Registo Falhou.");
            return;
        }

        //cf.addTecnico(userName,Password);
    }

}
