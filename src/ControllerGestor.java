import java.io.IOException;
import java.util.*;

public class ControllerGestor implements IControllerGestor{
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

    public boolean validaGestor(String id, String pass){
        return armazem.validarGestor(id,pass);
    }

    public Map<String, ControllerGestor.Triplo<Integer,Float,Float>> estatistica1(){
        Map<String, ControllerGestor.Triplo<Integer,Float,Float>> map = new HashMap<>();
        for(Tecnico t: armazem.getTecnicos().values()){
            int nrReparacoes = t.getIdReparados().size();
            float tempoMedio = armazem.mediaTempoGasto(t.getId());
            float desvioTempoEstimado = Math.abs(armazem.mediaTempoEstimado(t.getId())-armazem.mediaTempoGasto(t.getId()));
            ControllerGestor.Triplo<Integer, Float, Float> triplo= new ControllerGestor.Triplo<>(nrReparacoes, tempoMedio, desvioTempoEstimado);
            map.put(t.getId(),triplo);
        }
        return map;
    }

    public Map<String, ControllerGestor.Par<Integer,Integer>> estatistica2(){
        Map<String,ControllerGestor.Par<Integer,Integer>> map = new HashMap<>();
        for(Funcionario f:armazem.getFuncionarios().values()){
            Par<Integer,Integer> par = new Par<>(f.getIdAtendimentos().size(), f.getIdEntregas().size());
            map.put(f.getId(),par);
        }
        return map;
    }

    public Map<String,List<String>> estatistica3(){
        Map<String,List<String>> map = new HashMap<>();
        for(String idTecnico: armazem.getTecnicos().keySet()){
            List<String> list = armazem.intervencoes(idTecnico);
            map.put(idTecnico,list);
        }
        return map;
    }

    public static class Triplo<T, U, V> {
        public final T t;
        public final U u;
        public final V v;

        public Triplo(T t, U u, V v) {
            this.t = t;
            this.u = u;
            this.v = v;
        }

        public T getFst() {
            return t;
        }

        public U getSnd() {
            return u;
        }

        public V getTrd(){
            return v;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("( ");
            sb.append(t).append(", ").append(u).append(", ").append(v).append(")");
            return sb.toString();
        }
    }

    public static class Par<T, U> {
        public final T t;
        public final U u;

        public Par(T t, U u) {
            this.t= t;
            this.u= u;
        }

        public T getFst(){
            return t;
        }
        public U getSnd(){
            return u;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("( ");
            sb.append(t).append(", ").append(u).append(")");
            return sb.toString();
        }
    }
}
