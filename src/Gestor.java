public class Gestor {
    private String id;
    private String password;

    /*
    CONTRUCTORS
     */
    public Gestor(String id, String password){
        this.id=id;
        this.password = password;
    }
    public Gestor(Gestor o){
        this.id = o.getId();
        this.password = o.getPassword();
    }


    /*
    GETTERS e SETTERS
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

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
