import java.util.Date;

public class Expresso {
    private String idEquipamento;
    private String nifCliente;
    private String idFuncionario;
    private String idTecnico;



    /*
    CONSTRUCTORS
     */
    public Expresso(String idEquipamento,String nifCliente,String idFuncionario,String idTecnico){
        this.idEquipamento = idEquipamento;
        this.nifCliente = nifCliente;
        this.idFuncionario = idFuncionario;
        this.idTecnico = idTecnico;
    }

    public Expresso(Expresso outro){
        this.idEquipamento = outro.getIdEquipamento();
        this.nifCliente = outro.getNifCliente();
        this.idFuncionario = outro.getIdFuncionario();
        this.idTecnico = outro.getIdTecnico();
    }

    /*
    GETTERS e SETTERS
     */

    public String getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(String idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
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
        Expresso orc = (Expresso) o;
        return (this.idEquipamento.equals(orc.getIdEquipamento()) &&
                this.nifCliente.equals(orc.getNifCliente()) &&
                this.idFuncionario.equals(orc.getIdFuncionario()) &&
                this.idTecnico.equals(orc.getIdTecnico()));
    }
    /*
    CLONE
     */
    @Override
    public Expresso clone(){
        return new Expresso(this);
    }
}
