public class Contacto {
    private String email;
    private String telemovel;

    /*
    CONSTRUCTORS
     */

    public Contacto(String email, String telemovel){
        this.email = email;
        this.telemovel = telemovel;
    }

    public Contacto(Contacto c){
        this.email = c.getEmail();
        this.telemovel = c.getTelemovel();
    }

    /*
    GETTERS e SETTERS
     */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel){this.telemovel = telemovel;}

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
        Contacto c = (Contacto) o;
        return (this.telemovel.equals(c.getTelemovel()) &&
                this.email.equals(c.getEmail()));
    }

    /*
    CLONE
     */
    @Override
    public Contacto clone(){
        return new Contacto(this);
    }
}
