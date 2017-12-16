package projetoProgramacaoAvancada.GUI.Funcionarios;

import javax.swing.JOptionPane;
import projetoProgramacaoAvancada.Controler.FactoryControl;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Exceptions.Excecao;
import projetoProgramacaoAvancada.Utils.DefaultLayout;
import projetoProgramacaoAvancada.Utils.Msg;
import projetoProgramacaoAvancada.Utils.SqlCommand;

public class FrameGUIDashBoardFuncionario extends javax.swing.JFrame {

    private Funcionario funcLogin;
    private IControlerEmployee controlerEmployee;
    private FrameGUIDashBoard iFrameGUIDashBoard;

    public FrameGUIDashBoardFuncionario() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        DefaultLayout.alterarLayout();
        this.controlerEmployee = FactoryControl.getInstanceControlEmployee();
    }

    public void setFuncionarioLogin(String idFuncionario) {
        try {
            this.funcLogin = this.controlerEmployee.getFuncionariosBySql(SqlCommand.SELECTFROMFUNCIONARIOBYID + idFuncionario + SqlCommand.LIMIT1).get(0);
        } catch (Excecao ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         }
    }

    public Funcionario getFuncLogin() {
        return funcLogin;
    }

    public void setFrameGuiDashBoard(FrameGUIDashBoard iFrameGUIDashBoard) {
        this.iFrameGUIDashBoard = iFrameGUIDashBoard;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelWrppDBF = new javax.swing.JPanel();
        jButtonBackGBFunc = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabelTitleFunc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabelCompl = new javax.swing.JLabel();
        jLabelInfo3 = new javax.swing.JLabel();
        jLabelInfo2 = new javax.swing.JLabel();
        jButtonSendToPrint = new javax.swing.JButton();
        jLabelInfo1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelWrppDBF.setBackground(new java.awt.Color(237, 237, 237));
        jPanelWrppDBF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonBackGBFunc.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBackGBFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/reply-all-button.png"))); // NOI18N
        jButtonBackGBFunc.setText("Sair");
        jButtonBackGBFunc.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonBackGBFunc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonBackGBFunc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackGBFuncMouseClicked(evt);
            }
        });
        jPanelWrppDBF.add(jButtonBackGBFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 90, 30));

        jLabel3.setBackground(new java.awt.Color(204, 204, 204));
        jLabel3.setForeground(new java.awt.Color(153, 153, 153));
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelWrppDBF.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 150, -1));

        jLabelTitleFunc.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabelTitleFunc.setForeground(new java.awt.Color(42, 63, 84));
        jLabelTitleFunc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/briefcase.png"))); // NOI18N
        jLabelTitleFunc.setText("Tela de Recurso");
        jLabelTitleFunc.setIconTextGap(40);
        jLabelTitleFunc.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanelWrppDBF.add(jLabelTitleFunc, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 320, 80));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SGM");
        jPanelWrppDBF.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 30, 20));

        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanelWrppDBF.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 70, -1));

        jLabelCompl.setBackground(new java.awt.Color(42, 63, 84));
        jLabelCompl.setOpaque(true);
        jPanelWrppDBF.add(jLabelCompl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 360));

        jLabelInfo3.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabelInfo3.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInfo3.setText("Após isso, seus arquivos entrarão na fila para impressão e serão imprimidos");
        jPanelWrppDBF.add(jLabelInfo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 100, 480, 30));

        jLabelInfo2.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabelInfo2.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInfo2.setText("e depois clicar no botão logo abaixo: \"Enviar para impressão!\"");
        jPanelWrppDBF.add(jLabelInfo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 460, 30));

        jButtonSendToPrint.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSendToPrint.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jButtonSendToPrint.setForeground(new java.awt.Color(102, 102, 102));
        jButtonSendToPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/print.png"))); // NOI18N
        jButtonSendToPrint.setText("Enviar arquivos na pasta para Impressao");
        jButtonSendToPrint.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButtonSendToPrint.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSendToPrint.setFocusPainted(false);
        jButtonSendToPrint.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonSendToPrint.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonSendToPrint.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSendToPrintMouseClicked(evt);
            }
        });
        jPanelWrppDBF.add(jButtonSendToPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 290, 120));

        jLabelInfo1.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        jLabelInfo1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelInfo1.setText("Para imprimir algum arquivo, você precisa colocar estes na pasta \"Imprimir\",");
        jPanelWrppDBF.add(jLabelInfo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 470, 30));

        getContentPane().add(jPanelWrppDBF, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackGBFuncMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackGBFuncMouseClicked
        this.dispose();
        if (iFrameGUIDashBoard != null) {
            iFrameGUIDashBoard.setVisible(true);
        }
    }//GEN-LAST:event_jButtonBackGBFuncMouseClicked

    private void jButtonSendToPrintMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSendToPrintMouseClicked
        try {
            this.controlerEmployee.sendToPrint(this.funcLogin);
            JOptionPane.showMessageDialog(null, Msg.SENDEDPRINT);
            this.jButtonBackGBFunc.doClick();
        } catch (Exception ex) {  
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonSendToPrintMouseClicked

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameGUIDashBoardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameGUIDashBoardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameGUIDashBoardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameGUIDashBoardFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGUIDashBoardFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBackGBFunc;
    private javax.swing.JButton jButtonSendToPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelCompl;
    private javax.swing.JLabel jLabelInfo1;
    private javax.swing.JLabel jLabelInfo2;
    private javax.swing.JLabel jLabelInfo3;
    private javax.swing.JLabel jLabelTitleFunc;
    private javax.swing.JPanel jPanelWrppDBF;
    // End of variables declaration//GEN-END:variables
}
