import java.util.*;

public class Armazem {
    private static int codEquip = 0; //A cada pedido efetuado, o código incrementa, assim já sabemos o código do equip
    private Map<String,Equipamento> equipamentos;
    private Map<String,Funcionario> funcionarios;
    private Map<String,Cliente> clientes;
    private Map<String,Tecnico> tecnicos;
    private Map<String,PedidoOrcamento> pedidosOrcamento;
    private Map<String,Orcamento> orcamentos;
    private Map<String, Expresso> expressos;
    private Estatisticas estat;
    private Gestor gestor;

    /*
    CONSTRUCTORS
     */
    public Armazem(){
        equipamentos = new HashMap<>();
        funcionarios = new HashMap<>();
        clientes = new HashMap<>();
        tecnicos = new HashMap<>();
        orcamentos = new HashMap<>();
        expressos = new HashMap<>();
        pedidosOrcamento = new HashMap<>();
    }

    void init(){

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

        Cliente cliente1 = new Cliente("1", c1);
        Cliente cliente2 = new Cliente("2", c2);
        Cliente cliente3 = new Cliente("3", c3);
        Cliente cliente4 = new Cliente("4", c4);
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
    /*
    GETTERS e SETTERS
     */
    public Map<String, Equipamento> getEquipamentos() {
        Map<String,Equipamento> novo = new HashMap<>();
        for(String k: equipamentos.keySet())
            novo.put(k,equipamentos.get(k).clone());
        return novo;
    }

    public void setEquipamentos(Map<String, Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public Map<String, Funcionario> getFuncionarios() {
        Map<String,Funcionario> novo = new HashMap<>();
        for(String k: funcionarios.keySet())
            novo.put(k,funcionarios.get(k).clone());
        return novo;
    }

    public void setFuncionarios(Map<String, Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    public Map<String, Cliente> getClientes() {
        Map<String,Cliente> novo = new HashMap<>();
        for(String k: clientes.keySet())
            novo.put(k,clientes.get(k).clone());
        return novo;
    }

    public void setClientes(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<String, Tecnico> getTecnicos() {
        Map<String,Tecnico> novo = new HashMap<>();
        for(String k: tecnicos.keySet())
            novo.put(k,tecnicos.get(k).clone());
        return novo;
    }

    public void setTecnicos(Map<String, Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Map<String, PedidoOrcamento> getPedidosOrcamento() {
        Map<String,PedidoOrcamento> novo = new HashMap<>();
        for(String k: pedidosOrcamento.keySet())
            novo.put(k,pedidosOrcamento.get(k).clone());
        return novo;
    }

    public void setPedidosOrcamento(Map<String, PedidoOrcamento> pedidosOrcamento) {
        this.pedidosOrcamento = pedidosOrcamento;
    }


    public Map<String, Orcamento> getOrcamentos() {
        Map<String,Orcamento> novo = new HashMap<>();
        for(String k: orcamentos.keySet())
            novo.put(k,orcamentos.get(k).clone());
        return novo;
    }

    public void setOrcamentos(Map<String, Orcamento> orcamentos) {
        this.orcamentos = orcamentos;
    }

    public Estatisticas getEstat() {
        return estat;
    }

    public void setEstat(Estatisticas estat) {
        this.estat = estat;
    }

    public Gestor getGestor() {
        return gestor.clone();
    }

    public void setGestor(Gestor gestor) {
        this.gestor = gestor.clone();
    }
    /*
    METHODS
     */
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
        return this.gestor.getId().equals(idG);
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

    public void registarLevantamento(String nifCliente, String idFuncionario){
        if(this.clientes.containsKey(nifCliente)){
            if(this.funcionarios.containsKey(idFuncionario)){

                Cliente cliente = this.clientes.get(nifCliente);

                Funcionario funcionario = this.funcionarios.get(idFuncionario);

                for(String id : cliente.getCodigosEquipamento()) {

                    Equipamento equipamento = equipamentos.get(id);

                    if (equipamento.isReparado() && !equipamento.isLevantado()) {
                        equipamento.setLevantado(true);
                    }
                    funcionario.addEntrega(id);
                }
            }
        }
    }

    public boolean pedeOrcamento(String cliente, String funcionario){
        return registarPedido(cliente,funcionario,false);
    }

    boolean pedeExpresso(String cliente, String funcionario){
        return registarPedido(cliente,funcionario,true);
    }

    boolean registarPedido(String nifCliente, String idFuncionario, boolean isExpresso){

        String idEquipamento = "idEquipamento"+codEquip;
        if(pedidosOrcamento.containsKey(idEquipamento) || expressos.containsKey(idEquipamento)) return false;
        if(!isExpresso){
            Cliente cliente = this.clientes.get(nifCliente);
            cliente.addEquipamento(idEquipamento);

            PedidoOrcamento pedido = new PedidoOrcamento(nifCliente, idEquipamento, idFuncionario);
            this.pedidosOrcamento.put(idEquipamento,pedido);
        }
        else {
            String idTecnico = verificaDisponibilidade();
            if(idTecnico != null){
                Cliente cliente = this.clientes.get(nifCliente);
                cliente.addEquipamento(idEquipamento);

                Expresso expresso = new Expresso(idEquipamento, nifCliente, idFuncionario, idTecnico);
                this.expressos.put(idEquipamento, expresso);
            }
        }
        codEquip++;
        return true;
    }


    public String verificaDisponibilidade(){

        for (Tecnico e : this.tecnicos.values()) {
             if(!e.isOcupado()) return e.getId();
        }
        return null;
    }
}
