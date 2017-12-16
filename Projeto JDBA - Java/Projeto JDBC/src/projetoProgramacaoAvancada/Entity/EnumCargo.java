package projetoProgramacaoAvancada.Entity;

import projetoProgramacaoAvancada.Utils.Constt;

public enum EnumCargo {

    A(Constt.CHEFE_VENDAS),
    B(Constt.VENDEDOR),
    C(Constt.VENDEDOR_JUNIOR),
    D(Constt.CHEFE_ADM),
    E(Constt.AUX_ADM),
    F(Constt.CONS_ADM),
    G(Constt.CHEFE_RH),
    H(Constt.ANALIST_RH),
    I(Constt.GERENTE_RH);

     private final String name;     

    private EnumCargo(String s) {
        name = s;
    }
    
    public String getValue() {
       return this.name;
    }

}
