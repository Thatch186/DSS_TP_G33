import java.io.IOException;

public interface IControllerGestor {

    public boolean removerTecnico(String id) throws IOException ;

    public boolean removerFuncionario(String id) throws IOException;

    public boolean validaGestor(String id, String pass);
}
