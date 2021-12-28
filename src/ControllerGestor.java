import java.io.IOException;
import java.util.*;

public class ControllerGestor  {
    private IModel armazem;

    public ControllerGestor(IModel model) {
        this.armazem = model;
    }

    public boolean removerTecnico(String id) throws IOException {
         return this.armazem.removerTecnico(id);
    }

    public boolean removerFuncionario(String id) throws IOException {
        return this.armazem.removerFuncionario(id);
    }

}
