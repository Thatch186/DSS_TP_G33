public class ControllerFuncionario implements IControllerFuncionario{

    private IModel armazem;

    public ControllerFuncionario(IModel e){
        this.armazem = e;
    }

    public boolean registarPedidoOrcamento(String nifCliente, String idFuncionario){
            return this.armazem.pedeOrcamento(nifCliente, idFuncionario);
    }

    public boolean registaCliente(String nif, String email, String telemovel){
        return this.armazem.addCliente(nif, email, telemovel);
    }

    public boolean registarExpresso(String nifCliente, String idFuncionario){
        return this.armazem.pedeExpresso(nifCliente, idFuncionario);
    }

    public boolean registaLevantamento(String nifCliente, String idFuncionario){
        return this.armazem.registarLevantamento(nifCliente, idFuncionario);
    }

    public boolean removeCliente(String nif){
        return armazem.removerCliente(nif);
    }

    public boolean validaFuncionario(String id, String pass){
        return armazem.validarFuncionario(id,pass);
    }

    public boolean registaFuncionario(String id, String pass){
        return armazem.addFuncionario(id, pass);
    }

    public int atualizarArquivo(){
        return armazem.atualizarArquivo();
    }

    public int atualizarEquipamentosAbandonados(){
        return armazem.atualizarEquipamentosAbandonados();
    }

    public boolean clienteRejeitaOrcamento(String nif,String idEquipamento){
        return armazem.clienteRejeitaOrcamento(nif,idEquipamento);
    }
}
