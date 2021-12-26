import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Armazem {
    private Map<String,Equipamento> equipamentos;
    private Map<String,Funcionario> funcionarios;
    private Map<String,Cliente> clientes;
    private Map<String,Tecnico> tecnicos;
    private Map<String,PedidoOrcamento> porFazer;
    private Map<String,PedidoOrcamento> expressos;
    private Map<String, Orcamento> realizados;
    private Estatisticas estat;
    private Gestor gestor;

    public Armazem(){
        equipamentos = new HashMap<>();
        funcionarios = new HashMap<>();
        clientes = new HashMap<>();
        tecnicos = new HashMap<>();
        porFazer = new HashMap<>();
        expressos = new HashMap<>();
        realizados = new HashMap<>();
    }

    void initArmazem(){

        Equipamento e1 = new Equipamento("equipamento1");
        Equipamento e2 = new Equipamento("equipamento2");
        Equipamento e3 = new Equipamento("equipamento3");
        Equipamento e4 = new Equipamento("equipamento4");
        equipamentos.put(e1.getCodRegisto(),e1);
        equipamentos.put(e2.getCodRegisto(),e2);
        equipamentos.put(e3.getCodRegisto(),e3);
        equipamentos.put(e4.getCodRegisto(),e4);

        Funcionario f1 = new Funcionario("F1");
        Funcionario f2 = new Funcionario("F2");
        Funcionario f3 = new Funcionario("F3");
        Funcionario f4 = new Funcionario("F4");
        funcionarios.put(f1.getId(),f1);
        funcionarios.put(f2.getId(),f2);
        funcionarios.put(f3.getId(),f3);
        funcionarios.put(f4.getId(),f4);

        Contacto c1 = new Contacto("c1@gmail.com","912345789");
        Contacto c2 = new Contacto("c2@gmail.com","922345789");
        Contacto c3 = new Contacto("c3@gmail.com","932345789");
        Contacto c4 = new Contacto("c4@gmail.com","942345789");

        Cliente cliente1 = new Cliente("1",c1);
        Cliente cliente2 = new Cliente("2",c2);
        Cliente cliente3 = new Cliente("3",c3);
        Cliente cliente4 = new Cliente("4",c4);
        clientes.put(cliente1.getNIF(),cliente1);
        clientes.put(cliente2.getNIF(),cliente2);
        clientes.put(cliente3.getNIF(),cliente3);
        clientes.put(cliente4.getNIF(),cliente4);

        Tecnico t1 = new Tecnico("T1");
        Tecnico t2 = new Tecnico("T2");
        Tecnico t3 = new Tecnico("T3");
        Tecnico t4 = new Tecnico("T4");
        tecnicos.put(t1.getId(),t1);
        tecnicos.put(t2.getId(),t2);
        tecnicos.put(t3.getId(),t3);
        tecnicos.put(t4.getId(),t4);

        gestor = new Gestor("G1");

        Estatisticas estatisticas = new Estatisticas();
    }

    public boolean pedeOrcamento(String cliente, String equipamento, String funcionario, boolean expresso){
        PedidoOrcamento po = new PedidoOrcamento(cliente,equipamento,funcionario,expresso);
        return regPedidoOrcamento(po);
    }

    boolean regPedidoOrcamento(PedidoOrcamento po){
        boolean autenticado = clientes.get(po.getNifCliente()).dadosValidos();
        if(autenticado) {
            if(po.isExpresso())
                expressos.put(po.getEquipamento(),po); //registoExpresso
            else
                porFazer.put(po.getEquipamento(),po);//registoNormal

            estat.addPedOrc(po);
            return true;
        }
        return false;
    }

    boolean validarFuncionario(String idF){
        return funcionarios.containsKey(idF);
    }

    boolean validarCliente(String idC){
        return clientes.containsKey(idC);
    }

    boolean validarTecnico(String idT){
        return tecnicos.containsKey(idT);
    }

    boolean validarGestor(String idG){
        return Objects.equals(gestor.getId(), idG);
    }

    boolean addFuncionario(String idF){
        if(funcionarios.containsKey(idF)) return false;
        funcionarios.put(idF, new Funcionario(idF));
        return true;
    }

    boolean addCliente(String nif, String email, String telemovel){
        if(clientes.containsKey(nif)) return false;
        clientes.put(nif, new Cliente(nif,email,telemovel));
        return true;
    }

    boolean addTecnico(String idT){
        if(tecnicos.containsKey(idT)) return false;
        tecnicos.put(idT, new Tecnico(idT));
        return true;
    }
    //
    boolean removerFuncionario(String idF){
        if(!funcionarios.containsKey(idF)) return false;
        funcionarios.remove(idF);
        return true;
    }

    boolean removerCliente(String nif){
        if(!clientes.containsKey(nif)) return false;
        clientes.remove(nif);
        return true;
    }

    boolean removerTecnico(String idT){
        if(!tecnicos.containsKey(idT)) return false;
        tecnicos.remove(idT);
        return true;
    }



}
