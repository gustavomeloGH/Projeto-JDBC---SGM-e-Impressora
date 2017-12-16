package projetoProgramacaoAvancada.Entity;

import java.util.Date;

public class ReportsPrinter {

    private final Date dataImpressao;
    private final String idFuncionario;
    private final String nomeFuncionario;
    private final String cpfFuncionario;
    private final String marcaImpressora;
    private final String modeloImpressora;
    private final int tamanhoArquivo;
    private final int prioridade;
    private final String tipoDocumento;

    public ReportsPrinter(Date dataImpressao, String idFuncionario, String nomeFuncionario,
            String cpfFuncionario, String marcaImpressora, String modeloImpressora, int tamanhoArquivo, int prioridade, String tipoDocumento) {
        this.dataImpressao = dataImpressao;
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.cpfFuncionario = cpfFuncionario;
        this.marcaImpressora = marcaImpressora;
        this.modeloImpressora = modeloImpressora;
        this.tamanhoArquivo = tamanhoArquivo;
        this.prioridade = prioridade;
        this.tipoDocumento = tipoDocumento;
    }

    public Date getDataImpressao() {
        return dataImpressao;
    }

    public String getIdFuncionario() {
        return idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public String getNomeImpressora() {
        return modeloImpressora;
    }

    public String getMarcaImpressora() {
        return marcaImpressora;
    }

    public int getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public String[] toStringArray() {
        return new String[]{ this.dataImpressao.toString(), this.idFuncionario, 
            this.nomeFuncionario, this.cpfFuncionario, this.marcaImpressora, this.modeloImpressora, 
            String.valueOf(this.tamanhoArquivo), String.valueOf(prioridade), String.valueOf(this.tipoDocumento) };
    }

}
