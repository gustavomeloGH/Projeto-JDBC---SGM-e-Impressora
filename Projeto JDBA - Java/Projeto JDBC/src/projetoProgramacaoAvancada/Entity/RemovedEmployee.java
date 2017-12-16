package projetoProgramacaoAvancada.Entity;

import java.util.Date;

public class RemovedEmployee extends Funcionario {

    private final String cargo;
    private final String departamento;
    private final String idGerente;
    private final String nomeGerente;
    private final Date dataExclusao;
    private final String motivo;

    public RemovedEmployee(String idFuncionario, String nome, EnumSexo sexo,
            String dataNascimento, String cpf, String telefone, String idCargo, String idDepartamento,
            String idGerente, String nomeGerente, Date dataExclusao, String motivo) {

        super(idFuncionario, nome, sexo, dataNascimento, cpf, telefone, idCargo, idDepartamento);
        this.cargo = super.convertEnumToString()[0];
        this.departamento = super.convertEnumToString()[1];
        this.idGerente = idGerente;
        this.nomeGerente = nomeGerente;
        this.dataExclusao = dataExclusao;
        this.motivo = motivo;

    }

    public String getIdGerente() {
        return idGerente;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getCargo() {
        return cargo;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getNomeGerente() {
        return nomeGerente;
    }

    public String[] toStringArray() {

        String[] enumStr = this.convertEnumToString();

        return new String[]{ this.getIdFuncionario(), this.getNome(), this.getSexo().name(), this.getDataNascimento(),
            this.getCpf(), this.getTelefone(), enumStr[0], enumStr[1],  this.idGerente,  this.getNomeGerente(), this.dataExclusao.toString(),  this.motivo };
    }   

}
