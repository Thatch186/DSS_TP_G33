public class Equipamento {
    private String codRegisto;
    private boolean reparado;

    public Equipamento(String cod){
        this.codRegisto =cod;
        reparado=false;
    }

    public String getCodRegisto() {
        return codRegisto;
    }

    public void setCodRegisto(String codRegisto) {
        this.codRegisto = codRegisto;
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
                "'" + codRegisto + '\'' +
                ", " + reparado +
                ')';
    }
}
