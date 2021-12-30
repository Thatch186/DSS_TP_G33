import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Armazem implements IModel {
    private static int codEquip = 1; //A cada pedido efetuado, o código incrementa, assim já sabemos o código do equip
    private Map<String,Equipamento> equipamentos;
    private Map<String,Funcionario> funcionarios;
    private Map<String,Cliente> clientes;
    private Map<String,Tecnico> tecnicos;
    private Map<String,PedidoOrcamento> pedidosOrcamento;
    private Map<String,Orcamento> orcamentos;
    private Map<String,Orcamento> orcamentosArquivados;
    private Map<String, Expresso> expressos;
    private Map<String,Levantamento> filaDeLevantamentos;
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
        orcamentosArquivados = new HashMap<>();
        expressos = new HashMap<>();
        pedidosOrcamento = new HashMap<>();
        filaDeLevantamentos = new HashMap<>();
        estat = new Estatisticas();
    }

       public void init(){

        Equipamento e1 = new Equipamento("equipamento1");
        Equipamento e2 = new Equipamento("equipamento2");
        Equipamento e3 = new Equipamento("equipamento3");
        Equipamento e4 = new Equipamento("equipamento4");
        equipamentos.put(e1.getCodRegisto(),e1);
        equipamentos.put(e2.getCodRegisto(),e2);
        equipamentos.put(e3.getCodRegisto(),e3);
        equipamentos.put(e4.getCodRegisto(),e4);

        Funcionario f1 = new Funcionario("F1", "f1");
        Funcionario f2 = new Funcionario("F2", "f2");
        Funcionario f3 = new Funcionario("F3", "f3");
        Funcionario f4 = new Funcionario("F4", "f4");
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

        Tecnico t1 = new Tecnico("T1", "pass1");
        Tecnico t2 = new Tecnico("T2", "pass2");
        Tecnico t3 = new Tecnico("T3", "pass3");
        Tecnico t4 = new Tecnico("T4", "pass4");
        tecnicos.put(t1.getId(),t1);
        tecnicos.put(t2.getId(),t2);
        tecnicos.put(t3.getId(),t3);
        tecnicos.put(t4.getId(),t4);

        registarPedido("1","F1",false);
        registarPedido("2","F2",false);
        registarPedido("3","F3",true);
        registarPedido("4","F4",true);



           gestor = new Gestor("G1", "pass1");

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

    public Map<String, Levantamento> getFilaDeLevantamentos() {
        Map<String,Levantamento> ret = new HashMap<>();
        for(Levantamento l : this.filaDeLevantamentos.values())
            ret.put(l.getEquipmentID(),l.clone());
        return ret;
    }

    public void setFilaDeLevantamentos(Map<String, Levantamento> filaDeLevantamentos) {
        this.filaDeLevantamentos = filaDeLevantamentos;
    }

    /*
        METHODS
         */
    public  boolean validarFuncionario(String idF, String password){
        if(!funcionarios.containsKey(idF)) return false;

        Funcionario e = this.funcionarios.get(idF);
        return e.getPassword().equals(password);
    }

    public boolean validarCliente(String idC){
        return clientes.containsKey(idC);
    }

       public boolean validarTecnico(String idT, String password){
           if(!tecnicos.containsKey(idT)) return false;

           Tecnico e = this.tecnicos.get(idT);
           return e.getPassword().equals(password);
       }

       public boolean validarGestor(String idG, String password){
        return this.gestor.getPassword().equals(password) && this.gestor.getId().equals(idG);
    }

       public boolean addFuncionario(String idF, String password){
        if(funcionarios.containsKey(idF)) return false;
        funcionarios.put(idF, new Funcionario(idF, password));
        return true;
    }

       public boolean addCliente(String nif, String email, String telemovel){
        if(clientes.containsKey(nif)) return false;
        clientes.put(nif, new Cliente(nif,email,telemovel));
        return true;
    }

       public  boolean addTecnico(String idT, String password){
        if(tecnicos.containsKey(idT)) return false;
        tecnicos.put(idT, new Tecnico(idT, password));
        return true;
    }
    //
    public boolean removerFuncionario(String idF){
        if(!funcionarios.containsKey(idF)) return false;
        funcionarios.remove(idF);
        return true;
    }

       public boolean removerCliente(String nif){
        if(!clientes.containsKey(nif)) return false;
        clientes.remove(nif);
        return true;
    }

       public  boolean removerTecnico(String idT){
        if(!tecnicos.containsKey(idT)) return false;
        tecnicos.remove(idT);
        return true;
    }

    //Faz registo quando cliente levanta algum equipamento da loja
    public boolean registarLevantamento(String idEquipamento, String idFuncionario){
        if(this.equipamentos.containsKey(idEquipamento) && this.funcionarios.containsKey(funcionarios) &&
        this.filaDeLevantamentos.containsKey(idEquipamento)){
            Equipamento e = this.equipamentos.get(idEquipamento);

            if(e.getLevantado()) return false; //Verifica que ainda não foi levantado
            e.setLevantado(true);

            Funcionario f = this.funcionarios.get(idFuncionario);
            this.filaDeLevantamentos.remove(idEquipamento);

            return f.addEntrega(idEquipamento);
        }
        return false;
    }

    public boolean pedeOrcamento(String cliente, String funcionario){
        return registarPedido(cliente,funcionario,false);
    }

    public boolean pedeExpresso(String cliente, String funcionario){
        return registarPedido(cliente,funcionario,true);
    }

    private boolean registarPedido(String nifCliente, String idFuncionario, boolean isExpresso){

        String idEquipamento = "idEquipamento"+ codEquip;
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
                Tecnico t = this.tecnicos.get(idTecnico);
                t.setOcupado(true);
                t.setaReparar(idEquipamento);
                this.expressos.put(idEquipamento, expresso);
            }
            else
                return false;
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

    public boolean registarEquipamentoReparado(String idEquipamento, String idTecnico){
        if(this.equipamentos.containsKey(idEquipamento) && this.tecnicos.containsKey(idTecnico) &&
                (!this.filaDeLevantamentos.containsKey(idEquipamento))){
            Equipamento e = this.equipamentos.get(idEquipamento);

            if(e.isReparado()) return false; //Verifica que ainda não foi reparado
            e.setReparado(true);

            Tecnico t = this.tecnicos.get(idTecnico);
            t.setOcupado(false);

            String nif = getCliente(idEquipamento);
            Cliente c = this.clientes.get(nif);
            if(isExpresso(idEquipamento))
                c.sendMessage("Reparo do Equipamento " + idEquipamento + " está concluido.",idTecnico);
            else if(isNormal(idEquipamento)){
                Orcamento o = this.orcamentos.get(idEquipamento);
                if(!o.estaConcluido()) return false;
                c.sendMail("Reparo do Equipamento " + idEquipamento + " está concluido.",idTecnico);
            }
            this.filaDeLevantamentos.put(idEquipamento,new Levantamento(idEquipamento));
            return t.addReparado(idEquipamento);
        }
        return false;
    }

    public boolean registarOrcamento( PlanoTrabalho pt, String idPedidoOrcamento, String idTecnico){

        if(this.pedidosOrcamento.containsKey(idPedidoOrcamento) && this.tecnicos.containsKey(idTecnico) ){
           Orcamento orcamento = new Orcamento(pt, idPedidoOrcamento);
           this.orcamentos.put(idPedidoOrcamento,orcamento);

            Tecnico t = this.tecnicos.get(idTecnico);
            return t.addRealizado(idPedidoOrcamento);
        }
        return false;
    }

    public boolean clienteConfirmaOrcamento(String nifCliente, String idEquipamento){
        if(this.clientes.containsKey(nifCliente) && this.equipamentos.containsKey(idEquipamento) &&
        this.pedidosOrcamento.containsKey(idEquipamento) &&
        this.orcamentos.containsKey(idEquipamento)){
            if(isExpresso(idEquipamento)) return false; //Nao ha orcamentos para servicos expresso

            Cliente c = this.clientes.get(nifCliente);
            if(!c.temEquipamento(idEquipamento)) return false; //Certifica-se que cliente tem equipamento em seu nome

            Orcamento o = this.orcamentos.get(idEquipamento);
            if(o.isConfirmado()) return true; //Já estava confirmado
            this.pedidosOrcamento.remove(idEquipamento);
            o.atualizaData(); //Atualiza data para compensar tempo que cliente demorou a responder
            o.setConfirmado(true); //Atualiza orcamento com confirmaçao do cliente
            return true;
        }
        return false;
    }
    public boolean clienteRejeitaOrcamento(String nifCliente, String idEquipamento){
        if(this.clientes.containsKey(nifCliente) && this.equipamentos.containsKey(idEquipamento) &&
                this.pedidosOrcamento.containsKey(idEquipamento) &&
                this.orcamentos.containsKey(idEquipamento)){
            if(isExpresso(idEquipamento)) return false; //Nao ha orcamento para servicos expresso

            Cliente c = this.clientes.get(nifCliente);
            if(!c.temEquipamento(idEquipamento)) return false; //Certifica-se que cliente tem equipamento em seu nome

            Orcamento o = this.orcamentos.get(idEquipamento);
            o.setConfirmado(false);
            this.pedidosOrcamento.remove(idEquipamento);
            arquivarOrcamento(idEquipamento);
            this.filaDeLevantamentos.put(idEquipamento,new Levantamento(idEquipamento));
            return true;
        }
        return false;
    }

    public boolean iniciarReparo(String tecnicoId, String equipamentoID){
        if(this.tecnicos.containsKey(tecnicoId) && this.equipamentos.containsKey(equipamentoID) &&
                this.orcamentos.containsKey(equipamentoID) &&
                (!this.filaDeLevantamentos.containsKey(equipamentoID))){
            Orcamento o = this.orcamentos.get(equipamentoID);
            if(!o.isConfirmado()) return false;

            Tecnico t = this.tecnicos.get(tecnicoId);
            if(t.isOcupado()) return false;

            t.setOcupado(true);
            t.setaReparar(equipamentoID);
            return (o.iniciarPlanoTrabalho());
        }
        return false;
    }
    public boolean pausarReparo(String tecnicoId, String equipamentoID){
        if(this.tecnicos.containsKey(tecnicoId) && this.equipamentos.containsKey(equipamentoID) &&
        this.orcamentos.containsKey(equipamentoID)){
            Tecnico t = this.tecnicos.get(tecnicoId);
            if(!t.getaReparar().equals(equipamentoID)) return false; //Este tecnico quer por em pausa algo que nao esta a reparar
            if(!t.isOcupado()) return false; //Se nao estao ocupado nao precisa de pausar nada

            Orcamento o = this.orcamentos.get(equipamentoID);
            if(o.estaEmPausa()) return false; //Orçamento já estava em pausa

            return o.pausarPlanoTrabalho();
        }
        return false;
    }

    public boolean marcarPassoComoConcluido(String tecnicoId, String orcamentoId, int custoDinheiro, float horasGastas){
        if(this.tecnicos.containsKey(tecnicoId) && this.orcamentos.containsKey(orcamentoId) &&
        this.equipamentos.containsKey(orcamentoId) &&
                (!this.filaDeLevantamentos.containsKey(orcamentoId))){
            Tecnico t = this.tecnicos.get(tecnicoId);
            Orcamento o = this.orcamentos.get(orcamentoId);
            Equipamento e = this.equipamentos.get(orcamentoId);
            boolean ret;

            if(t.isOcupado() && t.getaReparar().equals(orcamentoId)){
                ret = o.marcarPassoComoConcluido(custoDinheiro,horasGastas);
            }
            else
                return false;

            if(ret)
            {
                if(o.estaConcluido()){ //Este era o último passo
                    registarEquipamentoReparado(orcamentoId,tecnicoId);
                    return true;
                }
                else if(!o.isConfirmado()) //Ultrapassamos o limite, preciso refazer orçamento
                {
                    String nif = getCliente(orcamentoId);
                    if(nif != null){
                        this.clientes.get(nif).sendMail("Orcamento para equipamento " + orcamentoId +
                                " tera de ser refeito!",tecnicoId);
                    }
                    t.setOcupado(false);
                }
                return true;
            }
        }
        return false;
    }

    private String getCliente(String eqId){
        for(Cliente c : this.clientes.values()){
            if(c.getCodigosEquipamento().contains(eqId))
                return c.getNIF();
        }
        return null;
    }

    public void notificaClienteReparacaoImpossivel (String nifCliente, String idFuncionario, String idEquipamento) {
        if (clientes.containsKey(nifCliente) && funcionarios.containsKey(idFuncionario)) {
            PedidoOrcamento pe = this.pedidosOrcamento.get(idEquipamento);
            if (!pe.isPossivelReparacao()) {
                Cliente cliente = this.clientes.get(nifCliente);
                cliente.sendMessage("Equipamento não pode ser reparado", idFuncionario);
            }
        }
    }

    private boolean isExpresso(String eqId){
        return (this.expressos.containsKey(eqId));
    }
    private boolean isNormal(String eqId){
        return (this.orcamentos.containsKey(eqId));
    }
    public float mediaTempoGasto(String idTecnico){
        float ret = 0;
        float n = 0;
        if(!this.tecnicos.containsKey(idTecnico)) return ret;
        Tecnico t = this.tecnicos.get(idTecnico);
        for(String o : t.getIdReparados()){
            Orcamento orc = this.orcamentos.get(o);
            n++;
            ret += orc.tempoGasto();
        }
        if(ret == 0) return 0;
        else
            return ret/n;
    }
    public float mediaTempoEstimado(String idTecnico){
        float ret = 0;
        float n = 0;
        if(!this.tecnicos.containsKey(idTecnico)) return ret;
        Tecnico t = this.tecnicos.get(idTecnico);
        for(String o : t.getIdReparados()){
            Orcamento orc = this.orcamentos.get(o);
            n++;
            ret += orc.tempoEstimado();
        }
        if(ret == 0) return 0;
        else
            return ret/n;
    }

    private boolean arquivarOrcamento(String idOrcamento){
        if(this.orcamentosArquivados.containsKey(idOrcamento)) return false;
        if(!this.orcamentos.containsKey(idOrcamento)) return false;

        Orcamento o = this.orcamentos.get(idOrcamento);
        this.orcamentos.remove(idOrcamento);
        this.orcamentosArquivados.put(idOrcamento,o);
        return true;
    }

    public int atualizarArquivo(){
        List<String> toBeArquived = new ArrayList<>();

        for(Orcamento o : this.orcamentos.values()){
            if(!o.isConfirmado()) //Confirmar se passaram 30 dias desde que foi criado
            {
                if(o.getDataCriacao().plusDays(30).isBefore(LocalDateTime.now().toLocalDate()))
                    toBeArquived.add(o.getIdPedido());
            }
        }

        for(String s : toBeArquived)
            arquivarOrcamento(s);
        return toBeArquived.size();
    }
    public int atualizarEquipamentosAbandonados(){
        int ret = 0;
        for(Levantamento l : this.filaDeLevantamentos.values()){
            if(l.getData().isBefore(LocalDate.now().minusDays(90))) //Mais de 90 dias para ser levantado
            {
                ret++;
                this.equipamentos.get(l.getEquipmentID()).setAbandonado(true);
                arquivarOrcamento(l.getEquipmentID());
                this.pedidosOrcamento.remove(l.getEquipmentID());
                //Contactar cliente
                String nif = getCliente(l.getEquipmentID());
                Cliente c = this.clientes.get(nif);
                c.sendMail("O seu equipamento foi dado como abandonado","Reparacoes");
            }
        }
        return ret;
    }

    public List<String> intervencoes(String idTecnico){
        List<String> ret = new ArrayList<>();
        if(!this.tecnicos.containsKey(idTecnico)) return ret;
        Tecnico t = this.tecnicos.get(idTecnico);

        for(String conc : t.getIdReparados()){
            if(isExpresso(conc))
                ret.add("Servico Expresso: " + conc);
            else
            {
                ret.add("Servico Normal: " + conc);
                ret.add(this.orcamentos.get(conc).getPlanoTrabalho().getPassos().toString());
            }
        }
        return ret;
    }
}





