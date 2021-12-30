import java.util.Date;
import java.util.EnumMap;

enum TipoServicoExpresso{
    trocarEcra,
    instalarOS,
    limparComputador,
    limparTelemovel,
    formatarComputador;
}

class TabelaPrecos{
    private static EnumMap<TipoServicoExpresso,Integer> tabelaPrecos = new EnumMap<TipoServicoExpresso, Integer>(TipoServicoExpresso.class);
    static{
        tabelaPrecos.put(TipoServicoExpresso.trocarEcra,150);
        tabelaPrecos.put(TipoServicoExpresso.instalarOS,50);
        tabelaPrecos.put(TipoServicoExpresso.limparComputador,30);
        tabelaPrecos.put(TipoServicoExpresso.limparTelemovel,15);
        tabelaPrecos.put(TipoServicoExpresso.formatarComputador,20);
    }
    public static Integer getPreco(TipoServicoExpresso t){
        return TabelaPrecos.tabelaPrecos.get(t);
    }
}

public class Expresso {
    private String idEquipamento;
    private String nifCliente;
    private String idFuncionario;
    private String idTecnico;
    private TipoServicoExpresso tipoServico;

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

    public TipoServicoExpresso getTipoServico() {
        return this.tipoServico;
    }

    public void setTipoServico(TipoServicoExpresso tipoServico) {
        this.tipoServico = tipoServico;
    }

    /*
    METHODS
     */
    public int getCusto(){
        return TabelaPrecos.getPreco(this.tipoServico);
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
                this.idTecnico.equals(orc.getIdTecnico()) &&
                this.tipoServico == orc.getTipoServico());
    }
    /*
    CLONE
     */
    @Override
    public Expresso clone(){
        return new Expresso(this);
    }
}
