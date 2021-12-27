public class Equipamento {
    private String codRegisto;
    private boolean reparado;
    private boolean levantado;
    private boolean abandonado;


    /*
    CONSTRUCTORS
     */
    public Equipamento(String cod){
        this.codRegisto =cod;
        reparado = false;
        this.levantado = false;
        this.abandonado = false;
    }

    public Equipamento(String cod, boolean reparado, boolean levantado, boolean abandonado){
        this.codRegisto = cod;
        this.reparado = reparado;
        this.levantado = levantado;
        this.abandonado = abandonado;
    }

    public Equipamento(Equipamento outro){
        this.codRegisto = outro.getCodRegisto();
        this.reparado = outro.isReparado();
        this.levantado = outro.getLevantado();
        this.abandonado = outro.getAbandonado();
    }

    /*
    GETTERS e SETTERS
     */


    public void setAbandonado(boolean abandonado) { this.abandonado = abandonado;}

    public boolean getAbandonado(){ return this.abandonado;}

    public void setLevantado(boolean levantado) { this.levantado = levantado;}


    public boolean getLevantado(){ return this.levantado;}

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
