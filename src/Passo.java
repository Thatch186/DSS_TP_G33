import java.sql.Time;

public class Passo {
    private float tempo;
    private float custo;

    /*
    CONSTRUCTORS
     */

    public Passo(float tempo, float custo) {
        this.tempo = tempo;
        this.custo = custo;
    }
    public Passo(Passo outro){
        this.tempo = outro.getTempo();
        this.custo = outro.getCusto();
    }

    /*
        GETTERS e SETTERS
         */
    public float getTempo() {
        return this.tempo;
    }

    public void setTempo(float tempo) {
        this.tempo = tempo;
    }

    public float getCusto() {
        return this.custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
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
        Passo p = (Passo) o;
        return (this.tempo == p.getTempo() &&
                this.custo == p.getCusto());
    }
    /*
    CLONE
     */
    @Override
    public Passo clone(){
        return new Passo(this);
    }
}
