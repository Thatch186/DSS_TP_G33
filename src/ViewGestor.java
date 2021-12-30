import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class ViewGestor implements IViewerGeral {
    private Scanner sc;
    private String id;
    private IControllerGestor controller;

    public ViewGestor(IControllerGestor controller, String id){
        sc=new Scanner(System.in);
        this.controller = controller;
        this.id = id;
    }

    public void run()  {
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
                case (0):break;
                case (1):
                   // consultaEstatisticas();
                    break;
                case (2):
                    try {
                        removeTecnico();
                        break;
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                case (3):
                    try {
                        removeFuncionario();
                        break;
                    }catch (IOException e){
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
        if(result) System.out.println("Técnico removido");
        else System.out.println("ERRO: técnico não removido");
    }

    private void removeFuncionario() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira idFuncionário ");
        String idFuncionario = sc.nextLine();

        boolean result = this.controller.removerFuncionario(idFuncionario);
        //REVS em KEY | USERS em VALUES
        if(result) System.out.println("Funcionário removido");
        else System.out.println("ERRO: funcionário não removido");
    }

    public ViewGestor(ViewGestor m){
        this.setnomeGestor(m.getnomeGestor());
    }

    public ViewGestor clone(ViewGestor m){
        return new ViewGestor(m);
    }

    public String getnomeGestor() { return id; }

    public void setnomeGestor(String nomeGestor) { this.id = nomeGestor; }

    public void line(String ask){
        System.out.print("|-> " + ask);
    }

    public void whiteline(int howMANY){
        for(int i = 0; i < howMANY ; i++)
            System.out.print("\n");
    }

    /**
     * Imprime as opções de um ViewGestor
     * @param options Array de opções para imprimir
     */
    public void optionsViewGestor(String [] options){
        StringBuilder s = new StringBuilder("|");
        int length = 0;
        for(String str : options) length += str.length();
        int spaces = (200 - length)/(options.length + 1);
        StringBuilder space = new StringBuilder();
        space.append(" ".repeat(Math.max(0, spaces)));
        for(int i = 0; i < options.length; i++) s.append(space).append(options[i]);
        s.append(space).append(" ".repeat(((200-length) % ((options.length) +1)))).append("|\n|").append("*".repeat(200)).append("|");
        System.out.println(s);
    }

    public void genericViewGestor(String generic){
        System.out.println(generic);
    }

    public void header(String ViewGestor) {
        System.out.print("\n\n|");
        System.out.print("*".repeat(200));
        System.out.print("|\n");
        System.out.print("|");
        int length = 200 - id.length() - ViewGestor.length();
        String repeat = " ".repeat(Math.max(0, length / 3));
        System.out.print(repeat);
        System.out.print(id);
        System.out.print(repeat);
        System.out.print(ViewGestor);
        System.out.print(repeat);
        System.out.print(" ".repeat(Math.max(0,length % 3)));
        System.out.print("|\n");
        System.out.println("|" + "*".repeat(200) + "|");
    }

    public ViewGestor clone(){
        return new ViewGestor(this);
    }

}
