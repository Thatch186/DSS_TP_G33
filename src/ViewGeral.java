import java.io.IOException;
import java.util.Scanner;

public class ViewGeral implements IViewerGeral{
    private Scanner sc;
    private IControllerTecnico ct;
    private IControllerGestor cg;
    private IControllerFuncionario cf;

    public ViewGeral(IControllerTecnico ct,IControllerGestor cg,IControllerFuncionario cf){
        sc=new Scanner(System.in);
        this.ct = ct;
        this.cf=cf;
        this.cg = cg;
    }

    public void run(){
        Menu menu = new Menu(new String[]{
                "Login",
                "Registar"

        });
        int op;
        do {
            menu.executa();
            op = menu.getOpcao();
            switch (op) {
                case (0):break;
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
                case (0):break;
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

    void loginTecnico() {
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();

        if(ct.validaTecnico(userName,password)) {
            ViewTecnico vt = new ViewTecnico(ct, userName);
            vt.run();
        }
        else
            System.out.println("ERRO: Dados de Login inválidos");
    }

    void loginFuncionario(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();

        if(cf.validaFuncionario(userName,password)) {
            ViewFuncionario vf = new ViewFuncionario(cf, userName);
            vf.run();
        }
        else
            System.out.println("ERRO: Dados de Login inválidos");
    }

    void loginGestor(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();

        if(cg.validaGestor(userName,password)) {
            ViewGestor vg = new ViewGestor(cg, userName);
            vg.run();
        }
        else
            System.out.println("ERRO: Dados de Login inválidos");
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
                case (0):break;
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
        System.out.println("Clique ENTER para continuar");
    }

    void registaTecnico(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();
        System.out.println("Reintroduza Password:");
        String password2= sc.nextLine();

        if(!password.equals(password2)){
            System.out.println("ERRO: Password diferente. Registo Falhou.");
            return;
        }

        if(ct.registaTecnico(userName,password))
            System.out.println("Registo efetuado");
        else
            System.out.println("ERRO: Registo falhou");
    }

    void registaFuncionario(){
        System.out.println("Introduza Username:");
        String userName = sc.nextLine();
        System.out.println("Introduza Password");
        String password = sc.nextLine();
        System.out.println("Reintroduza Password:");
        String password2= sc.nextLine();

        if(!password.equals(password2)){
            System.out.println("ERRO: Password diferente. Registo Falhou.");
            return;
        }

        if(cf.registaFuncionario(userName,password))
            System.out.println("Registo efetuado");
        else
            System.out.println("ERRO: Registo falhou");
    }

}
