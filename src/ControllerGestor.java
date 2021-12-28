import java.io.IOException;
import java.util.*;

public class ControllerGestor  {
    private InterfM armazem;

    public ControllerGestor(InterfM model) {
        this.armazem = model;
    }

    public void removerTecnico(String id) throws IOException {
        this.armazem.removerTecnico(id);
    }

    public void removerFuncionario(String id) throws IOException {
        this.armazem.removerFuncionario(id);
    }
}
