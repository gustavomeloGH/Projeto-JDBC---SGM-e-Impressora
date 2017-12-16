
package projetoProgramacaoAvancada.GUI.Funcionarios;

import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import projetoProgramacaoAvancada.Controler.FactoryControl;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.Msg;

public class FrameGUILogin extends javax.swing.JFrame {

    private boolean isClickedLogin;
    private boolean isClickedPassword;
    private IControlerEmployee controlerEmployee;
    private FrameGUIDashBoard frameGUIDashBoard;
    private FrameGUIDashBoardFuncionario frameGUIDBFunc;

    public FrameGUILogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.controlerEmployee = FactoryControl.getInstanceControlEmployee();
    }

    private void doLogin() {
        String login = this.jTextFieldLogin.getText().trim();
        String password = this.jTextFieldSenha.getText().trim();
        String loginResult = Constt.EMPTY;
        try {
            loginResult = this.controlerEmployee.checkLogin(login, password);
        } catch (Exception ex) {
             // JOptionPane.showMessageDialog(null, ex.getMessage());
        }

        switch (loginResult) {
            case Constt.EMPTY:
                JOptionPane.showMessageDialog(null, Msg.ERROR_LOGIN_PASSWD);
                break;
            case Constt.MANAGER:
                frameGUIDashBoard = new FrameGUIDashBoard();
                frameGUIDashBoard.setFuncionarioLogin(login);
                frameGUIDashBoard.setVisible(true);
                this.dispose();
                break;
            case Constt.EMPLOYEE:
                frameGUIDBFunc = new FrameGUIDashBoardFuncionario();
                frameGUIDBFunc.setFuncionarioLogin(login);
                frameGUIDBFunc.setVisible(true);
                this.dispose();
                break;
        }
    }
    
    private boolean checkIsEmptyJtext() {
        return jTextFieldLogin.getText().equals(Constt.EMPTY) || jTextFieldSenha.getText().equals(Constt.EMPTY);
    }

    
    private void cleanFields(MouseEvent evt) {
        this.jTextFieldLoginMouseClicked(evt);
        this.jTextFieldSenhaMouseClicked(evt);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldLogin = new javax.swing.JTextField();
        jLabelIconMain = new javax.swing.JLabel();
        jLabelIconSenha = new javax.swing.JLabel();
        jLabelIconLogin = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldSenha = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabelBackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldLogin.setForeground(new java.awt.Color(204, 204, 204));
        jTextFieldLogin.setText("    Login");
        jTextFieldLogin.setToolTipText("");
        jTextFieldLogin.setBorder(null);
        jTextFieldLogin.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jTextFieldLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldLoginMouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 220, 30));

        jLabelIconMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/briefcase.png"))); // NOI18N
        getContentPane().add(jLabelIconMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 120));

        jLabelIconSenha.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/userIcon2.png"))); // NOI18N
        jLabelIconSenha.setText("jLabelIconLogin");
        jLabelIconSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        getContentPane().add(jLabelIconSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 30, 30));

        jLabelIconLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/userIcon.png"))); // NOI18N
        jLabelIconLogin.setText("jLabelIconLogin");
        jLabelIconLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 204, 255)));
        getContentPane().add(jLabelIconLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 30, 30));

        jButtonLogin.setBackground(new java.awt.Color(51, 153, 255));
        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        jButtonLogin.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setBorder(null);
        jButtonLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLogin.setFocusPainted(false);
        jButtonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonLoginMouseClicked(evt);
            }
        });
        getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 250, 30));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Faça o login:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 180, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("STF - Sistema de Funcionários");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 120, -1, -1));

        jTextFieldSenha.setText("jPasswordField1");
        jTextFieldSenha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSenhaMouseClicked(evt);
            }
        });
        getContentPane().add(jTextFieldSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 220, 30));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Senha: Cpf do funcionário");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 160, 20));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("Obs.:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 190, 20));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Login: Matrícula do funcionário");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 190, 20));

        jLabelBackground.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelBackground.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/bckLogin.jpg"))); // NOI18N
        jLabelBackground.setLabelFor(this);
        jLabelBackground.setToolTipText("");
        getContentPane().add(jLabelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldLoginMouseClicked
        if (!this.isClickedLogin) {
            this.jTextFieldLogin.setText(Constt.EMPTY);
            this.jTextFieldLogin.setForeground(Color.DARK_GRAY);
            this.isClickedLogin = true;
        }
    }//GEN-LAST:event_jTextFieldLoginMouseClicked

    private void jTextFieldSenhaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSenhaMouseClicked
        if (!this.isClickedPassword) {
            this.jTextFieldSenha.setText(Constt.EMPTY);
            this.jTextFieldSenha.setForeground(Color.DARK_GRAY);
            this.isClickedPassword = true;
        }
    }//GEN-LAST:event_jTextFieldSenhaMouseClicked

    private void jButtonLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonLoginMouseClicked
  
        if (this.jTextFieldLogin.getText().contains("Login")) {
            this.cleanFields(evt);
            JOptionPane.showMessageDialog(null, Msg.ERROR_LOGIN_EMPTY);
        } else {
            if(this.checkIsEmptyJtext()) {
                this.isClickedLogin = this.isClickedPassword = false;
                this.cleanFields(evt);
                JOptionPane.showMessageDialog(null, Msg.ERROR_LOGIN_EMPTY);
            } else {
                this.doLogin();
            }
        }

    }//GEN-LAST:event_jButtonLoginMouseClicked

    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGUILogin().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelBackground;
    private javax.swing.JLabel jLabelIconLogin;
    private javax.swing.JLabel jLabelIconMain;
    private javax.swing.JLabel jLabelIconSenha;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JPasswordField jTextFieldSenha;
    // End of variables declaration//GEN-END:variables
}
