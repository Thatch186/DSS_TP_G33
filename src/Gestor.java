public class Gestor {
    private String id;

    /*
    CONTRUCTORS
     */
    public Gestor(String id){
        this.id=id;
    }
    public Gestor(Gestor o){
        this.id = o.getId();
    }
    /*
    GETTERS e SETTERS
     */
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
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
        Gestor g = (Gestor) o;
        return (this.id.equals(g.getId()));
    }
    /*
    CLONE
     */
    public Gestor clone(){
        return new Gestor(this);
    }
}
