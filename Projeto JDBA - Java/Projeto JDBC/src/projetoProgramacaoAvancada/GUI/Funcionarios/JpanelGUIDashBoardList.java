package projetoProgramacaoAvancada.GUI.Funcionarios;

import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Entity.EnumEntity;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Exceptions.Excecao;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.Msg;
import projetoProgramacaoAvancada.Utils.SqlCommand;
import projetoProgramacaoAvancada.Utils.Utils;

public class JpanelGUIDashBoardList extends javax.swing.JPanel {

    private final FrameGUIDashBoard iFrameGUIDashBoard;
    private final IControlerEmployee controlerEmployee;
    private boolean isClicked;
    private ArrayList<Funcionario> funcionarios;

    public JpanelGUIDashBoardList(FrameGUIDashBoard iFrameGUIDashBoard, IControlerEmployee controlerEmployee) {
        initComponents();
        this.iFrameGUIDashBoard = iFrameGUIDashBoard;
        this.controlerEmployee = controlerEmployee;
        this.initializeList();
        this.listEmployee();
        this.isClicked = false;
        this.setJComboBoxFromTable();
    }

    private void initializeList() {
        try {
            this.funcionarios = controlerEmployee.listBySql(SqlCommand.SELECTALLFROMFUNCIONARIOS, EnumEntity.EMPLOYEE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void listEmployee() {

        DefaultTableModel model = (DefaultTableModel) jTableList.getModel();
        model.setRowCount(0);
        if(funcionarios != null) {
              for (Funcionario funcionario : funcionarios) {
                model.addRow(new String[]{funcionario.getIdFuncionario(), funcionario.getNome(), Utils.reformatarCpf(funcionario.getCpf())});
            }
            jTableList.setModel(model);
            if (jTableList.getRowCount() > 0) {
                jTableList.setRowSelectionInterval(0, 0);
            }
        }
      
    }

    private void setJComboBoxFromTable() {
        try {
            ArrayList<String> cargoList = controlerEmployee.getNameBySql(SqlCommand.SELECTALLFROMCARGONAME);
            ArrayList<String> departamentoList = controlerEmployee.getNameBySql(SqlCommand.SELECTALLFROMDEPARTAMENTONAME);

            cargoList.forEach(c -> jComboBoxSearchCargo.addItem(c));
            departamentoList.forEach(d -> jComboBoxSearchDeptamento.addItem(d));
        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    private void setVisibleFromItem() {
        switch (jComboBoxSearch.getSelectedIndex()) {
            case 0:
                jComboBoxSearchCargo.setVisible(false);
                jComboBoxSearchDeptamento.setVisible(false);
                jTextFieldSearch.setVisible(true);
                break;
            case 1:
                jComboBoxSearchCargo.setVisible(true);
                jComboBoxSearchDeptamento.setVisible(false);
                jTextFieldSearch.setVisible(false);
                break;
            case 2:
                jComboBoxSearchCargo.setVisible(false);
                jComboBoxSearchDeptamento.setVisible(true);
                jTextFieldSearch.setVisible(false);
                break;
        }
    }

    public void refresh() {
        jComboBoxSearch.setSelectedIndex(0);
        jTextFieldSearch.setText(Constt.EMPTY);
        this.searchEmployee();
    }

    private void searchEmployee() {
        ArrayList arrayList = new ArrayList();
        try {
            switch (jComboBoxSearch.getSelectedIndex()) {
                case 0:
                    if (jTextFieldSearch.getText().equals(Constt.EMPTY)) {
                        arrayList =  controlerEmployee.listBySql(SqlCommand.SELECTALLFROMFUNCIONARIOS, EnumEntity.EMPLOYEE);
                    } else {
                         arrayList = controlerEmployee.listFuncionarioFromInput(jTextFieldSearch.getText());
                    }
                    break;
                case 1:
                    int idCargo = jComboBoxSearchCargo.getSelectedIndex() + 1;
                    arrayList = controlerEmployee.getFuncionariosBySql(SqlCommand.SELECTALLFROMCARGOBYID + idCargo + SqlCommand.ORDERBYNAME);
                   break;
                case 2:
                    int idDepartamento = jComboBoxSearchDeptamento.getSelectedIndex() + 1;
                    arrayList = controlerEmployee.getFuncionariosBySql(SqlCommand.SELECTALLFROMPARTAMENTOBYID + idDepartamento + SqlCommand.ORDERBYNAME);
                    break;
            }
            funcionarios = arrayList;
            this.listEmployee();
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelBuscar = new javax.swing.JLabel();
        jButtonSearch = new javax.swing.JButton();
        jTextFieldSearch = new javax.swing.JTextField();
        jButtonConsult = new javax.swing.JButton();
        jButtonRemove = new javax.swing.JButton();
        jComboBoxSearch = new javax.swing.JComboBox<>();
        jLabelBuscar1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableList = new javax.swing.JTable();
        jComboBoxSearchCargo = new javax.swing.JComboBox<>();
        jComboBoxSearchDeptamento = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(237, 237, 237));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelBuscar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelBuscar.setForeground(new java.awt.Color(42, 63, 84));
        jLabelBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/magnifier.png"))); // NOI18N
        jLabelBuscar.setText("Buscar por:");
        jLabelBuscar.setIconTextGap(5);
        add(jLabelBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jButtonSearch.setText("Buscar");
        jButtonSearch.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });
        add(jButtonSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, -1, 30));

        jTextFieldSearch.setForeground(new java.awt.Color(153, 153, 153));
        jTextFieldSearch.setText(" Nome, CPF ou Matrícula do funcionário");
        jTextFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextFieldSearchMouseClicked(evt);
            }
        });
        add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 240, 30));

        jButtonConsult.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/search.png"))); // NOI18N
        jButtonConsult.setText("Consultar");
        jButtonConsult.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonConsult.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonConsultMouseClicked(evt);
            }
        });
        add(jButtonConsult, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 100, -1));

        jButtonRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/waste-binDelete.png"))); // NOI18N
        jButtonRemove.setText("Remover");
        jButtonRemove.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRemove.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonRemoveMouseClicked(evt);
            }
        });
        add(jButtonRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, 100, -1));

        jComboBoxSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcionários", "Funcionários de um Cargo", "Funcionários de um Departamento" }));
        jComboBoxSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchActionPerformed(evt);
            }
        });
        add(jComboBoxSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 30, 180, 30));

        jLabelBuscar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelBuscar1.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBuscar1.setText("Nome funcionário:");
        jLabelBuscar1.setIconTextGap(15);
        add(jLabelBuscar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 82, 675, 30));

        jTableList.setBackground(new java.awt.Color(255, 255, 255));
        jTableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Matrícula", "Nome", "CPF"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTableList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(jTableList);
        if (jTableList.getColumnModel().getColumnCount() > 0) {
            jTableList.getColumnModel().getColumn(0).setResizable(false);
            jTableList.getColumnModel().getColumn(1).setResizable(false);
            jTableList.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 650, 280));

        add(jComboBoxSearchCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 240, 30));

        add(jComboBoxSearchDeptamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, 240, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
        if (jTextFieldSearch.getText().equals(Msg.SEARCH_MSG)) {
            jTextFieldSearch.setText(Constt.EMPTY);
        }
        this.searchEmployee();
    }//GEN-LAST:event_jButtonSearchActionPerformed

    private void jComboBoxSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchActionPerformed
        this.setVisibleFromItem();
    }//GEN-LAST:event_jComboBoxSearchActionPerformed

    private void jTextFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextFieldSearchMouseClicked
        if (!this.isClicked) {
            jTextFieldSearch.setForeground(Color.black);
            jTextFieldSearch.setText(Constt.EMPTY);
            this.isClicked = true;
        }
    }//GEN-LAST:event_jTextFieldSearchMouseClicked

    private void jButtonConsultMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonConsultMouseClicked

        if (jTableList.getRowCount() > 0) {
            Funcionario func = this.funcionarios.get(jTableList.getSelectedRow());
            iFrameGUIDashBoard.openUpdate(func);
        } else {
            JOptionPane.showMessageDialog(null, Msg.ERROR_CONSULT_SELECT);
        }


    }//GEN-LAST:event_jButtonConsultMouseClicked

    private void jButtonRemoveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonRemoveMouseClicked

        if (jTableList.getRowCount() > 0) {
            Funcionario func = this.funcionarios.get(jTableList.getSelectedRow());
            iFrameGUIDashBoard.openRemove(func);
        } else {
            JOptionPane.showMessageDialog(null, Msg.ERROR_CONSULT_SELECT);
        }
    }//GEN-LAST:event_jButtonRemoveMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConsult;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboBoxSearch;
    private javax.swing.JComboBox<String> jComboBoxSearchCargo;
    private javax.swing.JComboBox<String> jComboBoxSearchDeptamento;
    private javax.swing.JLabel jLabelBuscar;
    private javax.swing.JLabel jLabelBuscar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableList;
    private javax.swing.JTextField jTextFieldSearch;
    // End of variables declaration//GEN-END:variables
}
