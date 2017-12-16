
package projetoProgramacaoAvancada.GUI.Funcionarios;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import projetoProgramacaoAvancada.Controler.FactoryControl;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.DefaultLayout;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Exceptions.Excecao;
import projetoProgramacaoAvancada.Utils.SqlCommand;

public class FrameGUIDashBoard extends javax.swing.JFrame {
    
    private HashMap<String, JPanel> staticJpanels;
    private final IControlerEmployee controlerEmployee;
    private Funcionario funcLogin;
      
    public FrameGUIDashBoard() {
        initComponents();
        this.controlerEmployee = FactoryControl.getInstanceControlEmployee();
        DefaultLayout.alterarLayout();
        this.setLocationRelativeTo(null);
        this.initializeStaticJpanels();
        this.setBorder();
        this.initializeJPanel();
    }
    
     private void initializeStaticJpanels() {
        JpanelGUIDashBoardInitial jPanelInitial = new JpanelGUIDashBoardInitial();
        JpanelGUIDashBoardInsert jPanelInsertInsert = new JpanelGUIDashBoardInsert(this, controlerEmployee);
        JpanelGUIDashBoardList jPanelList = new JpanelGUIDashBoardList(this, controlerEmployee);
        JpanelGUIDashBoardDelete jPanelDelete =  new JpanelGUIDashBoardDelete(this, controlerEmployee);
        JpanelGUIDashBoardReports jPanelReports =  new JpanelGUIDashBoardReports(this, controlerEmployee);
        
        this.staticJpanels =  new HashMap<String , JPanel>() { {
            put(Constt.JPANELINITIAL, jPanelInitial);
            put(Constt.JPANELINSERT, jPanelInsertInsert);
            put(Constt.JPANELIST, jPanelList);
            put(Constt.JPANEDELETE, jPanelDelete);
            put(Constt.JPANELREPORTS, jPanelReports);
        }  };
    }
   
    private void setBorder() {
        this.setBorder(jButtonInserir);
        this.setBorder(jButtonListar);
        this.setBorder(jButtonImpressora);
        this.setBorder(jButtonGerarRelatorio);
    }
    
    private void setBorder(JButton j) {
        Color blueColor = new Color(88,117,146);
        j.setBorder(BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(blueColor,1),
        BorderFactory.createEmptyBorder(10, 15, 10, 10)));
    }
        
    
    private void initializeJPanel() {
         GridBagLayout layout = new GridBagLayout();
         jPanelDynamic.setLayout(layout);
         
         for (JPanel currJPanel : staticJpanels.values()) {
             addGridBadConstraints(currJPanel);
        }
         this.backInitialJPanel();
      }
    
    private void addGridBadConstraints(JPanel jPanel) {
         GridBagConstraints c = new GridBagConstraints();
          c.gridx = c.gridy = 0;
         jPanelDynamic.add(jPanel);
    }
         
    private void openJPanel(String jPanel) {
     this.setAllVisibleFalse();
        ((JPanel) staticJpanels.get(jPanel)).setVisible(true);
    }
    
    public void backInitialJPanel() {
        this.setAllVisibleFalse();
        ((JPanel) staticJpanels.get(Constt.JPANELINITIAL)).setVisible(true);
    }
    
    public void backListJPanel() {
        this.setAllVisibleFalse();
        ((JPanel) staticJpanels.get(Constt.JPANELIST)).setVisible(true);
         ((JpanelGUIDashBoardList) staticJpanels.get(Constt.JPANELIST)).refresh();
    }
    
    private void setAllVisibleFalse() {
       for (JPanel currJPanel : staticJpanels.values()) {
             ((JPanel) currJPanel).setVisible(false);
        }
    }
    
    public void openUpdate(Funcionario funcionario) {
        this.openJPanel(Constt.JPANELINSERT);
        ((JpanelGUIDashBoardInsert) staticJpanels.get(Constt.JPANELINSERT)).openConsultMode(funcionario);
    }
    
    public void openRemove(Funcionario funcionario) {
          this.openJPanel(Constt.JPANEDELETE);
         ((JpanelGUIDashBoardDelete) staticJpanels.get(Constt.JPANEDELETE)).deleteEmployee(funcionario);
    }
    
    public void setFuncionarioLogin(String idFuncionario) {
        try {
            this.funcLogin = this.controlerEmployee.getFuncionariosBySql(SqlCommand.SELECTFROMFUNCIONARIOBYID + idFuncionario + SqlCommand.LIMIT1).get(0);
        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public Funcionario getFuncionarioLogin() {
        return this.funcLogin;
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        jPanelDynamic = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButtonInserir = new javax.swing.JButton();
        jButtonListar = new javax.swing.JButton();
        jButtonImpressora = new javax.swing.JButton();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelRecurso = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelSubTitulo = new javax.swing.JLabel();
        jButtonGerarRelatorio = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelDynamic.setBackground(new java.awt.Color(237, 237, 237));
        jPanelDynamic.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(42, 63, 84));

        jButtonInserir.setBackground(new java.awt.Color(42, 63, 84));
        jButtonInserir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInserir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/insertUserIcon.png"))); // NOI18N
        jButtonInserir.setBorder(null);
        jButtonInserir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonInserir.setFocusPainted(false);
        jButtonInserir.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButtonInserir.setIconTextGap(10);
        jButtonInserir.setLabel("Inserir funcionário");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonListar.setBackground(new java.awt.Color(42, 63, 84));
        jButtonListar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/listUserIcon.png"))); // NOI18N
        jButtonListar.setBorder(null);
        jButtonListar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonListar.setFocusPainted(false);
        jButtonListar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButtonListar.setIconTextGap(10);
        jButtonListar.setLabel("Listar funcionários");
        jButtonListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListarActionPerformed(evt);
            }
        });

        jButtonImpressora.setBackground(new java.awt.Color(42, 63, 84));
        jButtonImpressora.setForeground(new java.awt.Color(255, 255, 255));
        jButtonImpressora.setText("Utilizar Impressora");
        jButtonImpressora.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonImpressora.setFocusPainted(false);
        jButtonImpressora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonImpressoraMouseClicked(evt);
            }
        });

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("SGF");

        jLabelRecurso.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelRecurso.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRecurso.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelRecurso.setText("Recursos");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/briefcase.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabelSubTitulo.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabelSubTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSubTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSubTitulo.setText("Sistema Gestor de Funcionários");

        jButtonGerarRelatorio.setBackground(new java.awt.Color(42, 63, 84));
        jButtonGerarRelatorio.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGerarRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/file.png"))); // NOI18N
        jButtonGerarRelatorio.setText("Gerar Relatórios");
        jButtonGerarRelatorio.setBorder(null);
        jButtonGerarRelatorio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGerarRelatorio.setFocusPainted(false);
        jButtonGerarRelatorio.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonGerarRelatorio.setIconTextGap(10);
        jButtonGerarRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonGerarRelatorioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButtonInserir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButtonListar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabelTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabelSubTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelRecurso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(0, 0, 0)
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelSubTitulo)
                .addGap(34, 34, 34)
                .addComponent(jButtonInserir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonListar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jButtonGerarRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(116, 116, 116)
                .addComponent(jLabelRecurso, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonImpressora, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelDynamic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        ((JpanelGUIDashBoardInsert) staticJpanels.get(Constt.JPANELINSERT)).openInsertMode();
        this.openJPanel(Constt.JPANELINSERT);
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListarActionPerformed
          this.openJPanel(Constt.JPANELIST);
    }//GEN-LAST:event_jButtonListarActionPerformed

    private void jButtonGerarRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonGerarRelatorioMouseClicked
        this.openJPanel(Constt.JPANELREPORTS);
    }//GEN-LAST:event_jButtonGerarRelatorioMouseClicked

    private void jButtonImpressoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonImpressoraMouseClicked
        FrameGUIDashBoardFuncionario frameGUIDashBoardFuncionario = new FrameGUIDashBoardFuncionario();
         frameGUIDashBoardFuncionario.setFuncionarioLogin(funcLogin.getIdFuncionario());
         frameGUIDashBoardFuncionario.setFrameGuiDashBoard(this);
         frameGUIDashBoardFuncionario.setVisible(true);
         this.setVisible(false);
         
    }//GEN-LAST:event_jButtonImpressoraMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameGUIDashBoard().setVisible(true);
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGerarRelatorio;
    private javax.swing.JButton jButtonImpressora;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonListar;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelRecurso;
    private javax.swing.JLabel jLabelSubTitulo;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDynamic;
    // End of variables declaration//GEN-END:variables
}
