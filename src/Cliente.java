import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
class Mensagem{
    String conteudo;
    String sender;
    LocalDateTime hora;
    int tipo; //0 email, 1 tele.

    public Mensagem(String conteudo, String sender, LocalDateTime hora, int tipo){
        this.conteudo = conteudo;
        this.sender = sender;
        this.hora = hora;
        this.tipo = tipo;
    }
}
public class Cliente {
    private String NIF;
    private Contacto contacto;
    private List<String> codigosEquipamento;
    private List<Mensagem> mensagensEnviadas;
    /*
    CONSTRUCTORS
     */
    public Cliente(String NIF, Contacto contacto){
        this.NIF=NIF;
        this.contacto=contacto;
        this.codigosEquipamento =new ArrayList<>();
        this.mensagensEnviadas = new ArrayList<>();
    }
    public Cliente(String NIF, String email, String telemovel){
        this.NIF=NIF;
        this.contacto= new Contacto(email,telemovel);
        this.codigosEquipamento =new ArrayList<>();
        this.mensagensEnviadas = new ArrayList<>();
    }
    public Cliente(String NIF,Contacto contacto, List<String> codigosEquipamento, List<Mensagem> mensagensEnviadas){
        this.NIF = NIF;
        this.contacto = contacto;
        this.codigosEquipamento = new ArrayList<>(codigosEquipamento);
        this.mensagensEnviadas = new ArrayList<>(mensagensEnviadas);
    }
    public Cliente(Cliente outro){
        this.NIF = outro.getNIF();
        this.contacto = outro.getContacto();
        this.codigosEquipamento = outro.getCodigosEquipamento();
        this.mensagensEnviadas = outro.getMensagensEnviadas();
    }

    /*
    GETTERS e SETTERS
     */
    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public Contacto getContacto() {
        return this.contacto.clone();
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto.clone();
    }

    public List<String> getCodigosEquipamento() {
        return new ArrayList<>(this.codigosEquipamento);
    }

    public void setCodigosEquipamento(List<String> codigosEquipamento) {
        this.codigosEquipamento = new ArrayList<>(codigosEquipamento);
    }

    public List<Mensagem> getMensagensEnviadas() {
        return new ArrayList<>(this.mensagensEnviadas);
    }

    public void setMensagensEnviadas(List<Mensagem> mensagensEnviadas) {
        this.mensagensEnviadas = new ArrayList<>(mensagensEnviadas);
    }
    /*
    METHODS
     */

    public boolean addEquipamento(String idE){
        if(codigosEquipamento.contains(idE)) return false;
        codigosEquipamento.add(idE);
        return true;
    }

    public boolean dadosValidos(){
        return contacto.getEmail() != null && contacto.getTelemovel() != null;
    }

    public boolean temEquipamento(String idE){
        return (this.codigosEquipamento.contains(idE));
    }

    public void sendMail(String mail, String sender){
        StringBuilder sb = new StringBuilder();
        sb.append("Sending to: " + this.contacto.getEmail()).append("\n");
        sb.append("From: " + sender).append("\n");
        sb.append("Message: " + mail);
        System.out.println(sb);
        Mensagem m = new Mensagem(sb.toString(),sender,LocalDateTime.now(),0);
        this.mensagensEnviadas.add(m);
    }

    public void sendMessage(String message, String sender){
        StringBuilder sb = new StringBuilder();
        sb.append("Sending to: " + this.contacto.getTelemovel()).append("\n");
        sb.append("From: " + sender).append("\n");
        sb.append("Message: " + message);
        System.out.println(sb);
        Mensagem m = new Mensagem(sb.toString(),sender,LocalDateTime.now(),1);
        this.mensagensEnviadas.add(m);
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
        Cliente c = (Cliente) o;
        return (this.NIF.equals(c.getNIF()) &&
                this.codigosEquipamento.equals(c.getCodigosEquipamento()) &&
                this.contacto.equals(c.getContacto()) &&
                this.mensagensEnviadas.equals(c.getMensagensEnviadas()));
    }

    /*
    CLONE
     */
    @Override
    public Cliente clone(){
        return new Cliente(this);
    }

    /*
    TO STRING
     */
    @Override
    public String toString() {
        return "Cliente("
                + NIF +
                ", " + contacto +
                "," + codigosEquipamento.toString() +
                '}';
    }
}
