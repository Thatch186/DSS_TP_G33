public class Equipamento {
    private String cod_registo;
    private boolean reparado;

    public Equipamento(String cod){
        this.cod_registo=cod;
        reparado=false;
    }

    public String getCod_registo() {
        return cod_registo;
    }

    public void setCod_registo(String cod_registo) {
        this.cod_registo = cod_registo;
    }

    public boolean isReparado() {
        return reparado;
    }

    public void setReparado(boolean reparado) {
        this.reparado = reparado;
    }

    @Override
    public String toString() {
        return "Equipamento(" +
                "'" + cod_registo + '\'' +
                ", " + reparado +
                ')';
    }
}
