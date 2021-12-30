import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface IControllerGestor {

    public boolean removerTecnico(String id) throws IOException ;

    public boolean removerFuncionario(String id) throws IOException;

    public boolean validaGestor(String id, String pass);

    public Map<String, ControllerGestor.Triplo<Integer,Float,Float>> estatistica1();//Para cada tecnico: NrReparos,
                                                                                    //TempoGastoMedio, DesvioMedio
    public Map<String, ControllerGestor.Par<Integer,Integer>> estatistica2();   //Para cada Funcionario: NrAtendimentos
                                                                                                        //NrEntregas
    public Map<String, List<String>> estatistica3(); //Para cada Técnico: Todas Intervenções
}
