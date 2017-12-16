package projetoProgramacaoAvancada.Entity;

public class Funcionario {

    private final String idFuncionario;
    private final String nome;
    private final EnumSexo sexo;
    private String dataNascimento;
    private final String cpf;
    private final String telefone;
    private final String idCargo;
    private final String idDepartamento;
    private Endereco endereco;
    private String idEndereco;

    public Funcionario(String idFuncionario, String nome, EnumSexo sexo,
            String dataNascimento, String cpf, String telefone,
            String idCargo, String idDepartamento, Endereco endereco) {

        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.idCargo = idCargo;
        this.idDepartamento = idDepartamento;
        this.endereco = endereco;
    }

    public Funcionario(String idFuncionario, String nome, EnumSexo sexo,
            String dataNascimento, String cpf, String telefone,
            String idCargo, String idDepartamento, Endereco endereco, String idEndereco) {

        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.idCargo = idCargo;
        this.idDepartamento = idDepartamento;
        this.endereco = endereco;
        this.idEndereco = idEndereco;
    }

    public Funcionario(String idFuncionario, String nome, EnumSexo sexo,
            String dataNascimento, String cpf, String telefone,
            String idCargo, String idDepartamento) {

        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.telefone = telefone;
        this.idCargo = idCargo;
        this.idDepartamento = idDepartamento;
    }

    public String getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(String idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public EnumSexo getSexo() {
        return sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getIdCargo() {
        return idCargo;
    }

    public String getIdDepartamento() {
        return idDepartamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setDateNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Funcionario{" + "idFuncionario=" + idFuncionario + ", nome=" + nome + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", cpf=" + cpf + ", telefone=" + telefone + ", idCargo=" + idCargo + ", idDepartamento=" + idDepartamento + ", endereco=" + endereco + '}';
    }

    public String[] toStringArrayFull() {
        String[] enumStr = this.convertEnumToString();
        return new String[]{this.idFuncionario, this.nome, this.sexo.name(), this.dataNascimento,
            this.cpf, this.telefone, enumStr[0], enumStr[1], this.endereco.getRua(),
            this.endereco.getNumero(), this.endereco.getCidade(), this.endereco.getBairro(), this.endereco.getUf(), this.endereco.getComplemento()};
    }

    public String[] convertEnumToString() {
        String cargo = EnumCargo.values()[Integer.parseInt(this.getIdCargo()) - 1].getValue();
        String departamento = EnumDepartamento.values()[Integer.parseInt(this.getIdDepartamento()) - 1].getValue();
        return new String[]{cargo, departamento};
    }

}
