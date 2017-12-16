package projetoProgramacaoAvancada.Utils;

import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.PlainDocument;
import projetoProgramacaoAvancada.Exceptions.Excecao;

public class LimiteDigitosECaractere extends PlainDocument {

    private static final long serialVersionUID = 1L;
    private int quantidadeMax = 0;

    public LimiteDigitosECaractere(int maxLen) throws Excecao {
        super();
        if (maxLen <= 0) {
            throw new Excecao(Msg.ESPECIFICAR_QTT);
        }
        quantidadeMax = maxLen;
    }

    @Override
    public void insertString(int offSet, String str, AttributeSet attr) {
        try {
            if (str == null || getLength() == quantidadeMax) {
                return;
            }
            int totalQuantia = (getLength() + str.length());
            if (totalQuantia <= quantidadeMax) {
                super.insertString(offSet, str.replaceAll("[^0-9]", ""), attr);
                return;
            }
            String nova = str.substring(0, getLength() - quantidadeMax);
            super.insertString(offSet, nova, attr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, Msg.LIMITE_CARACTERE);
        }
    }
}
