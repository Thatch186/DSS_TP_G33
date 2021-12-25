public class Contacto {
    private String email;
    private String telemovel;

    public Contacto(String email, String telemovel){
        this.email = email;
        this.telemovel = telemovel;
    }

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
}
