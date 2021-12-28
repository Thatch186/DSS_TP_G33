import java.io.Serializable;
import java.util.*;

public class ViewGestor implements InterfaceGestor {
    /**
     * Nome da equipa que o utilizador escolheu
     */
    private Scanner sc;
    private String id;
    private ControllerGestor controller;

    /**
     * Construtor por parâmetros da classe View
     * @param controller Controlador
     */
    public ViewGestor(ControllerGestor controller, String id){
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
                case (1):
                   // consultaEstatisticas();
                    break;
                case (2):
                    //removeTecnico();
                    break;
                case (3):
                    //removeFuncionario();
                    break;
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

    private void removeTecnico() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira idTecnico: ");
        String user_id = sc.nextLine();




        AbstractMap.SimpleEntry<Integer, Integer> result = this.controller.removeTecnico(id);
        //REVS em KEY | USERS em VALUES
        System.out.println("Técnico removido: " + result.getKey());
    }

    private void removeFuncionario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira idFuncionário ");
        String idFuncionario = sc.nextLine();

        AbstractMap.SimpleEntry<Integer, Integer> result = this.controller.removeTecnico(idFuncionario);
        //REVS em KEY | USERS em VALUES
        System.out.println("Funcionário removido com sucesso " + result.getKey());
    }

    /**
     * Construtor Nulo
     */
    public ViewGestor(){
        nomeGestor = "";
    }

    /**
     * Construtor de cópia
     * @param m Objeto da classe ViewGestor a ser copiado
     */
    public ViewGestor(ViewGestor m){
        this.setnomeGestor(m.getnomeGestor());
    }

    public ViewGestor clone(ViewGestor m){
        return new ViewGestor(m);
    }

    /**
     * Getter do atributo nomeGestor
     * @return o nome da equipa
     */
    public String getnomeGestor() { return nomeGestor; }

    /**
     * Setter do atributo nomeGestor
     * @param nomeGestor o nome novo da equipa
     */
    public void setnomeGestor(String nomeGestor) { this.nomeGestor = nomeGestor; }

    /**
     * Interface para o Prompt
     * @param ask Lina de comando introduzida pelo utilizador
     */
    public void line(String ask){
        System.out.print("|-> " + ask);
    }

    /**
     * Imprime linhas vazias, ou seja, só '\n'
     * @param howMANY número de linhas vazias a imprimir
     */
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

    /**
     * Imprime um ViewGestor passado como String
     * @param generic ViewGestor contido numa String
     */
    public void genericViewGestor(String generic){
        System.out.println(generic);
    }



    /**
     * Imprime o cabeçalho à volta do ViewGestor
     * @param ViewGestor ViewGestor contido numa String
     */
    public void header(String ViewGestor) {
        System.out.print("\n\n|");
        System.out.print("*".repeat(200));
        System.out.print("|\n");
        System.out.print("|");
        int length = 200 - nomeGestor.length() - ViewGestor.length();
        String repeat = " ".repeat(Math.max(0, length / 3));
        System.out.print(repeat);
        System.out.print(nomeGestor);
        System.out.print(repeat);
        System.out.print(ViewGestor);
        System.out.print(repeat);
        System.out.print(" ".repeat(Math.max(0,length % 3)));
        System.out.print("|\n");
        System.out.println("|" + "*".repeat(200) + "|");
    }

    /**
     * Imprime o ViewGestor principal do Programa com as opcões principais
     */
    public void mainViewGestor() {
        header("ViewGestor principal");
        optionsViewGestor(new String[]{"1 - Consultar Estatísticas ","2 - Remover Técnico","3 - Remover Funcionario"});
        line("Pretende a opção: ");
    }






    /**
     * Metodo clone da classe ViewGestor
     * @return Cópia do ViewGestor
     */
    public ViewGestor clone(){
        return new ViewGestor(this);
    }

}
