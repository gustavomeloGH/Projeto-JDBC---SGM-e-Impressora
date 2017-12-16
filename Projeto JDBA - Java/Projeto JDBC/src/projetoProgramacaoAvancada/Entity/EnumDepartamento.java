
package projetoProgramacaoAvancada.Entity;

import projetoProgramacaoAvancada.Utils.Constt;

public enum EnumDepartamento {
    
    A(Constt.VENDAS),
    B(Constt.ADM),
    C(Constt.RH);

     private final String name;     

    private EnumDepartamento(String s) {
        name = s;
    }
    
    public String getValue() {
       return this.name;
    }
}
