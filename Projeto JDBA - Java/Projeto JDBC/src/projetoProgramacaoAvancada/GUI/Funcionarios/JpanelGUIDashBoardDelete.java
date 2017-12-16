package projetoProgramacaoAvancada.GUI.Funcionarios;

import java.awt.Color;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Entity.EnumCargo;
import projetoProgramacaoAvancada.Entity.EnumDepartamento;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.Msg;

public class JpanelGUIDashBoardDelete extends javax.swing.JPanel {

    private Funcionario funcionarioToRemove;
    private final IControlerEmployee controlerEmployee;
    private final FrameGUIDashBoard iFrameGUIDashBoard;
    private boolean isClicked;

    public JpanelGUIDashBoardDelete(FrameGUIDashBoard iFrameGUIDashBoard, IControlerEmployee controlerEmployee) {
        initComponents();
        this.iFrameGUIDashBoard = iFrameGUIDashBoard;
        this.controlerEmployee = controlerEmployee;
        this.setBorder();
    }

    public void deleteEmployee(Funcionario funcionario) {
        this.funcionarioToRemove = funcionario;
        this.setFuncDataInLabel();
    }

    private void setFuncDataInLabel() {
        String cargo = EnumCargo.values()[Integer.parseInt(funcionarioToRemove.getIdCargo()) - 1].getValue();
        String departamento = EnumDepartamento.values()[Integer.parseInt(funcionarioToRemove.getIdDepartamento()) - 1].getValue();
        this.jLabelDeleteNome.setText("Nome: " + funcionarioToRemove.getNome());
        this.jLabelDeleteCpf.setText("Cpf: " + funcionarioToRemove.getCpf());
        this.jLabelDeleteMatricula.setText("Matrícula: " + funcionarioToRemove.getIdFuncionario());
        this.jLabelDeleteCargo.setText("Cargo: " + cargo);
        this.jLabelDeleteDepartamento.setText("Departamento: " + departamento);
    }

    private void setBorder() {
        Color blueColor = new Color(204, 204, 204);
        jPanelDeleteInfo.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(blueColor, 2),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)));
    }

    public RemovedEmployee newInstanceRemovedEmployee(String idGerente, String nomeGerente, String motivo) {
        return new RemovedEmployee(funcionarioToRemove.getIdFuncionario(), funcionarioToRemove.getNome(), funcionarioToRemove.getSexo(),
                funcionarioToRemove.getDataNascimento(), funcionarioToRemove.getCpf(), funcionarioToRemove.getTelefone(),
                funcionarioToRemove.getIdCargo(), funcionarioToRemove.getIdDepartamento(), idGerente, nomeGerente, new Date(), motivo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDelete = new javax.swing.JLabel();
        jLabelDelete6 = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelDelete1 = new javax.swing.JLabel();
        jButtonRemove = new javax.swing.JButton();
        jTextFieldSenha = new javax.swing.JPasswordField();
        jPanelDeleteInfo = new javax.swing.JPanel();
        jLabelDeleteCpf = new javax.swing.JLabel();
        jLabelDeleteNome = new javax.swing.JLabel();
        jLabelDeleteMatricula = new javax.swing.JLabel();
        jLabelDeleteDepartamento = new javax.swing.JLabel();
        jLabelDeleteCargo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(237, 237, 237));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDelete.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelDelete.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDelete.setText("Digite sua senha para remover");
        jLabelDelete.setIconTextGap(15);
        add(jLabelDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, -1, -1));

        jLabelDelete6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabelDelete6.setForeground(new java.awt.Color(42, 63, 84));
        jLabelDelete6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/user.png"))); // NOI18N
        jLabelDelete6.setText("Remover funcionário:");
        jLabelDelete6.setIconTextGap(8);
        add(jLabelDelete6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButtonBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/back-arrow.png"))); // NOI18N
        jButtonBack.setText("Cancelar");
        jButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonBackMouseClicked(evt);
            }
        });
        add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 100, 30));

        jLabelDelete1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 18)); // NOI18N
        jLabelDelete1.setForeground(new java.awt.Color(204, 0, 51));
        jLabelDelete1.setText("Tem certeza que deseja removê-lo (a)? ");
        jLabelDelete1.setIconTextGap(15);
        add(jLabelDelete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, -1, -1));

        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/waste-binDelete.png"))); // NOI18N
        jButtonRemove.setText("Remover");
        jButtonRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemoveMouseClicked(evt);
            }
        });
        add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 100, 30));

        jTextFieldSenha.setForeground(new java.awt.Color(102, 102, 102));
        jTextFieldSenha.setText("jPasswordField1");
        jTextFieldSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSenhaMouseClicked(evt);
            }
        });
        add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 400, 270, 30));

        jPanelDeleteInfo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelDeleteInfo.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelDeleteInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelDeleteCpf.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDeleteCpf.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDeleteCpf.setText("Cpf:");
        jLabelDeleteCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabelDeleteCpf.setIconTextGap(15);
        jPanelDeleteInfo.add(jLabelDeleteCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 500, 40));

        jLabelDeleteNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDeleteNome.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDeleteNome.setText("Nome:");
        jLabelDeleteNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabelDeleteNome.setIconTextGap(15);
        jPanelDeleteInfo.add(jLabelDeleteNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, 500, 40));

        jLabelDeleteMatricula.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDeleteMatricula.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDeleteMatricula.setText("Matrícula:");
        jLabelDeleteMatricula.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabelDeleteMatricula.setIconTextGap(15);
        jPanelDeleteInfo.add(jLabelDeleteMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 500, 40));

        jLabelDeleteDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDeleteDepartamento.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDeleteDepartamento.setText("Departamento:");
        jLabelDeleteDepartamento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabelDeleteDepartamento.setIconTextGap(15);
        jPanelDeleteInfo.add(jLabelDeleteDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 500, 40));

        jLabelDeleteCargo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelDeleteCargo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDeleteCargo.setText("Cargo:");
        jLabelDeleteCargo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jLabelDeleteCargo.setIconTextGap(15);
        jPanelDeleteInfo.add(jLabelDeleteCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 500, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/id-card.png"))); // NOI18N
        jPanelDeleteInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 70));

        add(jPanelDeleteInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 640, 390));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSenhaMouseClicked
        if (!isClicked) {
            jTextFieldSenha.setText(Constt.EMPTY);
            jTextFieldSenha.setForeground(Color.black);
            isClicked = true;
        }
    }//GEN-LAST:event_jTextFieldSenhaMouseClicked

    private void jButtonRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoveMouseClicked

        if (!this.isClicked || this.jTextFieldSenha.getText().equals(Constt.EMPTY)) {
            jTextFieldSenha.setText(Constt.EMPTY);
            jTextFieldSenha.setForeground(Color.black);
            isClicked = true;
            JOptionPane.showMessageDialog(null, Msg.ERROR_PASSWORD);
        } else {

            String password = this.jTextFieldSenha.getText();
            Funcionario funcLogin = iFrameGUIDashBoard.getFuncionarioLogin();
            if (funcLogin != null) {

                if (funcLogin.getCpf().equals(password)) {
                    String exclusionReason = JOptionPane.showInputDialog(Msg.EXCLUSION_REASON);
                    if (exclusionReason != null) {
                        try {
                            this.controlerEmployee.delete(funcionarioToRemove.getIdFuncionario());
                            RemovedEmployee funcionarioRemove = newInstanceRemovedEmployee(funcLogin.getIdFuncionario(), funcLogin.getNome(), exclusionReason);
                            this.controlerEmployee.insertRemovedFuncTable(funcionarioRemove);
                            JOptionPane.showMessageDialog(null, Msg.REMOVED_SUCESS);
                            jTextFieldSenha.setText("");
                            iFrameGUIDashBoard.backListJPanel();
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }

                } else {
                    JOptionPane.showMessageDialog(null, Msg.ERROR_PASSWORD);
                }
            }
        }


    }//GEN-LAST:event_jButtonRemoveMouseClicked

    private void jButtonBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBackMouseClicked
        jTextFieldSenha.setText("• • • • • • •");
        Color grayColor = new Color(102, 102, 102);
        isClicked = false;
        jTextFieldSenha.setForeground(grayColor);
        iFrameGUIDashBoard.backListJPanel();
    }//GEN-LAST:event_jButtonBackMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelDelete;
    private javax.swing.JLabel jLabelDelete1;
    private javax.swing.JLabel jLabelDelete6;
    private javax.swing.JLabel jLabelDeleteCargo;
    private javax.swing.JLabel jLabelDeleteCpf;
    private javax.swing.JLabel jLabelDeleteDepartamento;
    private javax.swing.JLabel jLabelDeleteMatricula;
    private javax.swing.JLabel jLabelDeleteNome;
    private javax.swing.JPanel jPanelDeleteInfo;
    private javax.swing.JPasswordField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables
}
