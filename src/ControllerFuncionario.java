import java.util.ArrayList;
import java.util.List;

public class ControllerFuncionario {

    private InterfM armazem;

    public ControllerFuncionario(InterfM e){
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
}
