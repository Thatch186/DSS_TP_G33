public class Equipamento {
    private String codRegisto;
    private boolean reparado;

    /*
    CONSTRUCTORS
     */
    public Equipamento(String cod){
        this.codRegisto =cod;
        reparado=false;
    }
    public Equipamento(String cod, boolean reparado){
        this.codRegisto = cod;
        this.reparado = reparado;
    }
    public Equipamento(Equipamento outro){
        this.codRegisto = outro.getCodRegisto();
        this.reparado = outro.isReparado();
    }

    /*
    GETTERS e SETTERS
     */

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

    /*
    EQUALS
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        Equipamento e = (Equipamento) o;
        return ((this.reparado == e.isReparado()) &&
                this.codRegisto.equals(e.getCodRegisto()));
    }
    /*
    CLONE
     */
    public Equipamento clone(){
        return new Equipamento(this);
    }
    /*
    TO STRING
     */
    @Override
    public String toString() {
        return "Equipamento(" +
                "'" + codRegisto + '\'' +
                ", " + reparado +
                ')';
    }
}
