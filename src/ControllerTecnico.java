import java.io.IOException;
import java.util.*;

public class ControllerTecnico implements InterfaceTecnico {
    private InterfM armazem;

    public ControllerTecnico(InterfM model) {
        this.armazem = model;
    }

    public void consultarPedidosOrcamento(String bf, String rf, String uf) throws IOException {
        this.armazem.consultarPedidosOrcamento(bf, rf, uf);
    }

    public void consultarOrcamento(String bf, String rf, String uf) throws IOException {
        this.armazem.consultarOrcamento(bf, rf, uf);
    }

    public void refazerOrcamento(String bf, String rf, String uf) throws IOException {
        this.armazem.refazerOrcamento(bf, rf, uf);
    }

    public void criarOrcamento(String bf, String rf, String uf) throws IOException {
        this.armazem.criarOrcamento(bf, rf, uf);
    }

    public void repararEquipamento(String bf, String rf, String uf) throws IOException {
        this.armazem.repararEquipamento(bf, rf, uf);
    }


    public void consultarEstadoReparacao(String bf, String rf, String uf) throws IOException {
        this.armazem.consultarEstadoReparacao(bf, rf, uf);
    }
}