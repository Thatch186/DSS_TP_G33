public class Passo {
    private float tempo; //Horas para concluir passo
    private float custo;
    private String descricao;

    /*
    CONSTRUCTORS
     */
    public Passo(){
        this.tempo = 0;
        this.custo = 0;
        this.descricao = null;
    }
    public Passo(float tempo, float custo) {
        this.tempo = tempo;
        this.custo = custo;
        this.descricao = null;
    }
    public Passo(float tempo, float custo, String descricao){
        this.tempo = tempo;
        this.custo = custo;
        this.descricao = descricao;
    }
    public Passo(Passo outro){
        this.tempo = outro.getTempo();
        this.custo = outro.getCusto();
        this.descricao = outro.getDescricao();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
                this.custo == p.getCusto() &&
                this.descricao.equals(p.getDescricao()));
    }
    /*
    CLONE
     */
    @Override
    public Passo clone(){
        return new Passo(this);
    }
}
