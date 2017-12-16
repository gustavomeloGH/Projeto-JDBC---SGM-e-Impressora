package projetoProgramacaoAvancada.GUI.Funcionarios;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Entity.EnumEntity;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Entity.ReportsPrinter;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.Msg;
import projetoProgramacaoAvancada.Utils.SqlCommand;
import projetoProgramacaoAvancada.Utils.Utils;

public class JpanelGUIDashBoardReports extends javax.swing.JPanel {

    private final FrameGUIDashBoard iFrameGUIDashBoard;
    private final IControlerEmployee controlerEmployee;

    public JpanelGUIDashBoardReports(FrameGUIDashBoard iFrameGUIDashBoard, IControlerEmployee controlerEmployee) {
        initComponents();
        this.iFrameGUIDashBoard = iFrameGUIDashBoard;
        this.controlerEmployee = controlerEmployee;
        this.jButtonRelatorioFuncRemovido.setText("<html><center>Relatório de Funcionários <br/> Removidos</center></html>");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelReportsTitle = new javax.swing.JLabel();
        jButtonRelatorioFuncionario = new javax.swing.JButton();
        jButtonRelatoriosImpressos = new javax.swing.JButton();
        jButtonRelatorioFuncRemovido = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();

        setBackground(new java.awt.Color(237, 237, 237));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(237, 237, 237));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 708, -1));

        jLabelReportsTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabelReportsTitle.setForeground(new java.awt.Color(42, 63, 84));
        jLabelReportsTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/pdf-file-format-symbol.png"))); // NOI18N
        jLabelReportsTitle.setText("Gerar Relatórios:");
        add(jLabelReportsTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 190, 40));

        jButtonRelatorioFuncionario.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRelatorioFuncionario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRelatorioFuncionario.setForeground(new java.awt.Color(102, 102, 102));
        jButtonRelatorioFuncionario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/script.png"))); // NOI18N
        jButtonRelatorioFuncionario.setText("Relatórios de Funcionários");
        jButtonRelatorioFuncionario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 222, 222)));
        jButtonRelatorioFuncionario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorioFuncionario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatorioFuncionario.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorioFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRelatorioFuncionarioMouseClicked(evt);
            }
        });
        add(jButtonRelatorioFuncionario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 190, 150));

        jButtonRelatoriosImpressos.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRelatoriosImpressos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRelatoriosImpressos.setForeground(new java.awt.Color(102, 102, 102));
        jButtonRelatoriosImpressos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/printer.png"))); // NOI18N
        jButtonRelatoriosImpressos.setText("Relatórios Impressos");
        jButtonRelatoriosImpressos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 222, 222)));
        jButtonRelatoriosImpressos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatoriosImpressos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatoriosImpressos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatoriosImpressos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRelatoriosImpressosMouseClicked(evt);
            }
        });
        add(jButtonRelatoriosImpressos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, 150));

        jButtonRelatorioFuncRemovido.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRelatorioFuncRemovido.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonRelatorioFuncRemovido.setForeground(new java.awt.Color(102, 102, 102));
        jButtonRelatorioFuncRemovido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/remove-user.png"))); // NOI18N
        jButtonRelatorioFuncRemovido.setText("Relatório de Funcionários Removidos");
        jButtonRelatorioFuncRemovido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(222, 222, 222)));
        jButtonRelatorioFuncRemovido.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRelatorioFuncRemovido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonRelatorioFuncRemovido.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButtonRelatorioFuncRemovido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRelatorioFuncRemovidoMouseClicked(evt);
            }
        });
        add(jButtonRelatorioFuncRemovido, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 190, 150));

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/back-arrow.png"))); // NOI18N
        jButtonBack.setText("Voltar");
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });
        add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 100, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        iFrameGUIDashBoard.backInitialJPanel();
    }//GEN-LAST:event_jButtonBackMouseClicked

    private void jButtonRelatoriosImpressosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRelatoriosImpressosMouseClicked
        try {
            ArrayList<ReportsPrinter> funcList = this.controlerEmployee.listBySql(SqlCommand.SELECTPRINTERREPORTS, EnumEntity.REPORTSPRINTER);
            if (!funcList.isEmpty()) {
                String dest = Constt.DIRECTORY_PATH_RELATORIO_PRINTER;
                String title = Msg.TITLE_REPORTS_PRINT;
                Utils.reportsEmployeeGenerator(funcList, dest, title, EnumEntity.REPORTSPRINTER);
                JOptionPane.showMessageDialog(null, Msg.REPORTS_SUCESS);
            } else {
                JOptionPane.showMessageDialog(null, Msg.ERROR_REPORTS);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }//GEN-LAST:event_jButtonRelatoriosImpressosMouseClicked

    private void jButtonRelatorioFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRelatorioFuncionarioMouseClicked
        try {
            ArrayList<Funcionario> funcList = this.controlerEmployee.listBySql(SqlCommand.SELECTALLFROMFUNCIONARIOS, EnumEntity.EMPLOYEE);
            if (!funcList.isEmpty()) {
                String dest = Constt.DIRECTORY_PATH_RELATORIO_EMPLOYEE;
                String title = Msg.TITLE_REPORTS_EMPLOYEE;
                Utils.reportsEmployeeGenerator(funcList, dest, title, EnumEntity.EMPLOYEE);
                JOptionPane.showMessageDialog(null, Msg.REPORTS_SUCESS);
            } else {
                JOptionPane.showMessageDialog(null, Msg.ERROR_REPORTS);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonRelatorioFuncionarioMouseClicked

    private void jButtonRelatorioFuncRemovidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRelatorioFuncRemovidoMouseClicked
        try {
            ArrayList<RemovedEmployee> funcList = this.controlerEmployee.listBySql(SqlCommand.SELECTALLFROMFUNCIONARIOSEXCLUIDOS, EnumEntity.REMOVEDEMPLOYEE);
            if (!funcList.isEmpty()) {
                String dest = Constt.DIRECTORY_PATH_RELATORIO_REMOVED;
                String title = Msg.TITLE_REPORTS_EMPLOYEE_REMOVED;
                Utils.reportsEmployeeGenerator(funcList, dest, title, EnumEntity.REMOVEDEMPLOYEE);
                JOptionPane.showMessageDialog(null, Msg.REPORTS_SUCESS);
            } else {
                JOptionPane.showMessageDialog(null, Msg.ERROR_REPORTS);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }//GEN-LAST:event_jButtonRelatorioFuncRemovidoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonRelatorioFuncRemovido;
    private javax.swing.JButton jButtonRelatorioFuncionario;
    private javax.swing.JButton jButtonRelatoriosImpressos;
    private javax.swing.JLabel jLabelReportsTitle;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
