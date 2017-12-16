
package projetoProgramacaoAvancada.Entity;

public class Endereco {
    private final String rua;
    private final String numero;
    private final String cidade;
    private final String uf;
    private final String bairro;
    private final String complemento;

    public Endereco(String rua, String numero, String cidade, String bairro, String uf, String complemento) {
        this.rua = rua;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }
    
    public String getUf() {
        return uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }
    
    public String[] toStringArray() {
        return new String[] {this.rua, this.numero, this.cidade, this.bairro, this.uf, this.complemento};
    }
    
    
}
