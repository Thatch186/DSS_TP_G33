import java.io.IOException;
import java.util.*;

public class ControllerGestor implements InterfaceGestor {
    private InterfM amarazem;

    public ControllerGestor(InterfM model) {
        this.armazem = model;
    }

    public void removeTecnico(String id) throws IOException {
        this.amarazem.removeTecnico(id);
    }

    public void removeFuncionario(String id) throws IOException {
        this.amarazem.removeFuncionario(id);
    }
}
