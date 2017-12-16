package projetoProgramacaoAvancada.GUI.Funcionarios;

import java.awt.Component;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import projetoProgramacaoAvancada.Entity.Endereco;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Exceptions.Excecao;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.LimiteDigitosECaractere;
import projetoProgramacaoAvancada.Controler.IControlerEmployee;
import projetoProgramacaoAvancada.Entity.EnumSexo;
import projetoProgramacaoAvancada.Utils.Msg;
import projetoProgramacaoAvancada.Utils.SqlCommand;
import projetoProgramacaoAvancada.Utils.Utils;

//OBS: COLOCAR ITENS -> CARGO/ DEPARTAMENTO <- VIA BANCO DE DADOS...
public class JpanelGUIDashBoardInsert extends javax.swing.JPanel {

    private FrameGUIDashBoard iFrameGUIDashBoard;
    private IControlerEmployee controlerEmployee;
    private Funcionario funcionario;
    private int screenMode;

    public JpanelGUIDashBoardInsert(FrameGUIDashBoard iFrameGUIDashBoard, IControlerEmployee controlerEmployee) {
        initComponents();
        this.iFrameGUIDashBoard = iFrameGUIDashBoard;
        this.controlerEmployee = controlerEmployee;
        this.setConfJPanel();
    }

    /*<--- INSERT MODE ---->*/
    public void openInsertMode() {
        this.enableComponents();
        this.resetJPanel();
        this.screenMode = 0;
    }

    public void changePanelDataToInsert() {
        this.jLabelTitle.setText(Constt.INSERT_FUNC);
        this.jButtonSalvar.setText(Constt.INSERT_FUNC_BUTTON);
    }

    public void resetJPanel() {
        this.clearScreen();
        this.jComboBoxCargo.setSelectedIndex(0);
        this.jComboBoxDeptamento.setSelectedIndex(0);
        this.jRadioButtonMasc.setSelected(false);
        this.jRadioButtonFem.setSelected(false);
    }

    private void saveData() {
        funcionario = this.getEmployeeFromInput();
        try {
            controlerEmployee.insert(funcionario);
            JOptionPane.showMessageDialog(null, Msg.INSERT_SUCCESS);
            this.iFrameGUIDashBoard.backInitialJPanel();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private Funcionario getEmployeeFromInput() {

        //ENDEREÇO DO FUNCIONÁRIO
        String rua = this.jTextFieldRua.getText();
        String numero = this.jTextFieldNumero.getText();
        String cidade = this.jTextFieldCidade.getText();
        String uf = this.jTextFieldUF.getText();
        String bairro = this.jTextFieldBairro.getText();
        String complemento = this.jTextFieldComplemento.getText();

        Endereco endereco = new Endereco(rua, numero, cidade, bairro, uf, complemento);

        //FUNCIONÁRIO
        String idFuncionario = this.jTextFieldId.getText();
        String nome = this.jTextFieldNome.getText();
        EnumSexo sexo = this.getFuncSex();
        String dataNascimento = this.jTextFieldNasc.getText();
        String cpf = Utils.retirarCaracterEspecial(this.jTextFieldCpf.getText());
        String telefone = Utils.retirarCaracterEspecial(this.jTextFieldTelefone.getText());
        String idCargo = String.valueOf(this.jComboBoxCargo.getSelectedIndex() + 1);
        String idDepartamento = String.valueOf(this.jComboBoxDeptamento.getSelectedIndex() + 1);

        return new Funcionario(idFuncionario, nome, sexo, dataNascimento, cpf, telefone, idCargo, idDepartamento, endereco);
    }

    private EnumSexo getFuncSex() {
        EnumSexo sex = null;
        if (this.jRadioButtonMasc.isSelected()) {
            sex = EnumSexo.M;
            this.jRadioButtonFem.setSelected(false);
        }
        if (this.jRadioButtonFem.isSelected()) {
            sex = EnumSexo.F;
            this.jRadioButtonFem.setSelected(true);
        }
        return sex;
    }


    /*<------ CONSULT MODE ---->*/
    public void openConsultMode(Funcionario funcionario) {
        try {
            this.funcionario = this.controlerEmployee.getFuncionariosBySql(SqlCommand.SELECTFROMFUNCIONARIOBYID + funcionario.getIdFuncionario()).get(0);
        } catch (Excecao ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        this.resetJPanel();
        this.changePanelDataToConsult();
        this.setEmployeeToInput();
        this.disableComponents();
        this.screenMode = 1;
    }

    private void changePanelDataToConsult() {
        this.jLabelTitle.setText(Constt.CONSULT_FUNC);
        this.jButtonSalvar.setText(Constt.UPDATE_FUNC_BUTTON);
        this.jButtonCancelar.setText(Constt.BACK_BUTTON);
    }

    /*<------ UPDATE MODE ---->*/
    private void openUpdateMode() {
        this.screenMode = 2;
        this.enableComponents();
        this.changePanelDataToUpdate();
    }

    private void changePanelDataToUpdate() {
        this.jLabelTitle.setText(Constt.UPDATE_FUNC);
        this.jButtonCancelar.setText(Constt.CANCEL_BUTTON);
        this.jTextFieldCpf.setEnabled(false);
        this.jTextFieldId.setEnabled(false);
        
    }

    private void setConfJPanel() {
        this.setConfigJText();
        this.setJComboBoxFromTable();
    }

    private void updateData() {
        try {
            Funcionario newFuncionario = this.getEmployeeFromInput();
            newFuncionario.setIdEndereco(funcionario.getIdEndereco());
            this.controlerEmployee.update(newFuncionario);
            JOptionPane.showMessageDialog(null, Msg.UPDATE_SUCCESS);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void setEmployeeToInput() {
        //ENDEREÇO DO FUNCIONÁRIO
        this.jTextFieldRua.setText(funcionario.getEndereco().getRua());
        this.jTextFieldNumero.setText(funcionario.getEndereco().getNumero());
        this.jTextFieldCidade.setText(funcionario.getEndereco().getCidade());
        this.jTextFieldUF.setText(funcionario.getEndereco().getUf());
        this.jTextFieldBairro.setText(funcionario.getEndereco().getBairro());
        this.jTextFieldComplemento.setText(funcionario.getEndereco().getComplemento());

        //FUNCIONÁRIO
        this.jTextFieldId.setText(funcionario.getIdFuncionario());
        this.jTextFieldNome.setText(funcionario.getNome());
        this.setFuncSex(funcionario.getSexo());
        this.jTextFieldNasc.setText(Utils.reformatarData(funcionario.getDataNascimento()));
        this.jTextFieldCpf.setText(funcionario.getCpf());
        this.jTextFieldTelefone.setText(funcionario.getTelefone());
        this.jComboBoxCargo.setSelectedIndex(Integer.parseInt(funcionario.getIdCargo()) - 1);
        this.jComboBoxDeptamento.setSelectedIndex(Integer.parseInt(funcionario.getIdDepartamento()) - 1);
    }

    private void setFuncSex(EnumSexo sex) {
        if (sex.name().equals("M")) {
            System.out.print(sex.name() + "aaa");
            this.jRadioButtonMasc.setSelected(true);
            this.jRadioButtonFem.setSelected(false);
        } else {
            this.jRadioButtonFem.setSelected(true);
            this.jRadioButtonMasc.setSelected(false);
        }
    }

    /*<--- AUXILIAR METHODS ---->*/
    private void setConfigJText() {
        try {
            jTextFieldId.setDocument(new LimiteDigitosECaractere(5));
            jTextFieldNumero.setDocument(new LimiteDigitosECaractere(3));
        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    private void setJComboBoxFromTable() {
        try {
            ArrayList<String> cargoList = controlerEmployee.getNameBySql(SqlCommand.SELECTALLFROMCARGONAME);
            ArrayList<String> departamentoList = controlerEmployee.getNameBySql(SqlCommand.SELECTALLFROMDEPARTAMENTONAME);

            cargoList.forEach(c -> jComboBoxCargo.addItem(c));
            departamentoList.forEach(d -> jComboBoxDeptamento.addItem(d));
        } catch (Excecao ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void clearScreen() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            Component c = this.getComponent(i);
            if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText(Constt.EMPTY);
            }
        }
    }

    public void disableComponents() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            Component c = this.getComponent(i);
            if (c instanceof JTextField || c instanceof JComboBox || c instanceof JRadioButton) {
                c.setEnabled(false);
            }
        }
    }

    public void enableComponents() {
        for (int i = 0; i < this.getComponentCount(); i++) {
            Component c = this.getComponent(i);
            if (c instanceof JTextField || c instanceof JComboBox || c instanceof JRadioButton) {
                c.setEnabled(true);
            }
        }
    }

    public boolean checkThereIsEmptyField() {
        boolean boo = false;
        for (int i = 0; i < this.getComponentCount(); i++) {
            Component c = this.getComponent(i);
            if (c instanceof JTextField) {
                if (((JTextField) c).getText().equals(Constt.EMPTY)) {
                    boo = true;
                    break;
                }
            }
        }

        if (!boo) {
            if (!this.jRadioButtonMasc.isSelected() && !this.jRadioButtonFem.isSelected()) {
                boo = true;
            }
        }
        return boo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldRua = new javax.swing.JTextField();
        jTextFieldNumero = new javax.swing.JTextField();
        jTextFieldCidade = new javax.swing.JTextField();
        jTextFieldBairro = new javax.swing.JTextField();
        jTextFieldUF = new javax.swing.JTextField();
        jTextFieldComplemento = new javax.swing.JTextField();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelMatricula = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelDtNasc = new javax.swing.JLabel();
        jLabelComplemento = new javax.swing.JLabel();
        jLabelCpf = new javax.swing.JLabel();
        jLabelMatCargo = new javax.swing.JLabel();
        jLabelMtDept = new javax.swing.JLabel();
        jLabelRua = new javax.swing.JLabel();
        jLabelNumero = new javax.swing.JLabel();
        jLabelCidade = new javax.swing.JLabel();
        jLabelBairro = new javax.swing.JLabel();
        jLabelEstado = new javax.swing.JLabel();
        jButtonSalvar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jLabelEndereco = new javax.swing.JLabel();
        jLabelSexo = new javax.swing.JLabel();
        jRadioButtonMasc = new javax.swing.JRadioButton();
        jRadioButtonFem = new javax.swing.JRadioButton();
        jComboBoxDeptamento = new javax.swing.JComboBox<>();
        jComboBoxCargo = new javax.swing.JComboBox<>();
        jTextFieldTelefone = new javax.swing.JFormattedTextField();
        jTextFieldCpf = new javax.swing.JFormattedTextField();
        jTextFieldNasc = new javax.swing.JFormattedTextField();

        setBackground(new java.awt.Color(237, 237, 237));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelTitle.setBackground(new java.awt.Color(204, 204, 204));
        jLabelTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(42, 63, 84));
        jLabelTitle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/userAdd.png"))); // NOI18N
        jLabelTitle.setText("Cadastro de Funcionário");
        jLabelTitle.setIconTextGap(10);
        add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 720, 50));

        jTextFieldId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        jTextFieldId.setMargin(new java.awt.Insets(10, 10, 10, 10));
        add(jTextFieldId, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 230, 35));

        jTextFieldNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 230, 35));

        jTextFieldRua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, 230, 35));

        jTextFieldNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 230, 35));

        jTextFieldCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 230, 35));

        jTextFieldBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, 230, 35));

        jTextFieldUF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldUF, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 230, 35));

        jTextFieldComplemento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 223, 223)));
        add(jTextFieldComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 230, 35));

        jLabelTelefone.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelTelefone.setForeground(new java.awt.Color(0, 0, 0));
        jLabelTelefone.setText("Telefone:");
        jLabelTelefone.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 60, 28));

        jLabelMatricula.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelMatricula.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMatricula.setText("Matrícula:");
        jLabelMatricula.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 60, 28));

        jLabelNome.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelNome.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNome.setText("Nome:");
        jLabelNome.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 28));

        jLabelDtNasc.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelDtNasc.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDtNasc.setText("Data Nasc.:");
        jLabelDtNasc.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelDtNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 70, 28));

        jLabelComplemento.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelComplemento.setForeground(new java.awt.Color(0, 0, 0));
        jLabelComplemento.setText("Complem.:");
        jLabelComplemento.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelComplemento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, 70, 28));

        jLabelCpf.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelCpf.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCpf.setText("Cpf:");
        jLabelCpf.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 60, 28));

        jLabelMatCargo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelMatCargo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMatCargo.setText("Mat. Cargo:");
        jLabelMatCargo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelMatCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 70, 28));

        jLabelMtDept.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelMtDept.setForeground(new java.awt.Color(0, 0, 0));
        jLabelMtDept.setText("Mat. Dept.:");
        jLabelMtDept.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelMtDept, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 70, 28));

        jLabelRua.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelRua.setForeground(new java.awt.Color(0, 0, 0));
        jLabelRua.setText("Rua:");
        jLabelRua.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelRua, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 60, 28));

        jLabelNumero.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelNumero.setForeground(new java.awt.Color(0, 0, 0));
        jLabelNumero.setText("Número:");
        jLabelNumero.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 60, 28));

        jLabelCidade.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelCidade.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCidade.setText("Cidade:");
        jLabelCidade.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelCidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 60, 28));

        jLabelBairro.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelBairro.setForeground(new java.awt.Color(0, 0, 0));
        jLabelBairro.setText("Bairro:");
        jLabelBairro.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelBairro, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 60, 28));

        jLabelEstado.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelEstado.setForeground(new java.awt.Color(0, 0, 0));
        jLabelEstado.setText("Estado:");
        jLabelEstado.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 60, 28));

        jButtonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/confirm.png"))); // NOI18N
        jButtonSalvar.setText("Salvar");
        jButtonSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSalvar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonSalvarMouseClicked(evt);
            }
        });
        add(jButtonSalvar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 450, 100, -1));

        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/close-button.png"))); // NOI18N
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonCancelarMouseClicked(evt);
            }
        });
        add(jButtonCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 100, -1));

        jLabelEndereco.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabelEndereco.setForeground(new java.awt.Color(42, 63, 84));
        jLabelEndereco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projetoProgramacaoAvancada/GUI/Img/placeholder-on-map-paper-in-perspective.png"))); // NOI18N
        jLabelEndereco.setText("     Endereço:");
        add(jLabelEndereco, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 260, 20));

        jLabelSexo.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabelSexo.setForeground(new java.awt.Color(0, 0, 0));
        jLabelSexo.setText("Sexo:");
        jLabelSexo.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        add(jLabelSexo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 70, 28));

        jRadioButtonMasc.setText("Masculino");
        jRadioButtonMasc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonMascMouseClicked(evt);
            }
        });
        add(jRadioButtonMasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jRadioButtonFem.setText("Feminino");
        jRadioButtonFem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jRadioButtonFemMouseClicked(evt);
            }
        });
        add(jRadioButtonFem, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, -1, -1));

        add(jComboBoxDeptamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 230, 30));

        add(jComboBoxCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 355, 230, 30));

        try {
            jTextFieldTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)-#-####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(jTextFieldTelefone, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 230, 35));

        try {
            jTextFieldCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(jTextFieldCpf, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 230, 35));

        try {
            jTextFieldNasc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        add(jTextFieldNasc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, 230, 35));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSalvarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonSalvarMouseClicked
        switch (screenMode) {
            case 0:
                if (!checkThereIsEmptyField()) {
                    this.saveData();
                } else {
                    JOptionPane.showMessageDialog(null, Msg.THERE_IS_EMPTY_FIELD);
                }
                break;
            case 1:
                this.openUpdateMode();
                break;
            case 2:
                this.updateData();
                this.openConsultMode(funcionario);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_jButtonSalvarMouseClicked

    private void jButtonCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonCancelarMouseClicked

        if (screenMode != 0) {
            iFrameGUIDashBoard.backListJPanel();
        } else {
            iFrameGUIDashBoard.backInitialJPanel();
        }

    }//GEN-LAST:event_jButtonCancelarMouseClicked

    private void jRadioButtonMascMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonMascMouseClicked
       this.jRadioButtonFem.setSelected(false);
    }//GEN-LAST:event_jRadioButtonMascMouseClicked

    private void jRadioButtonFemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jRadioButtonFemMouseClicked
        this.jRadioButtonMasc.setSelected(false);
    }//GEN-LAST:event_jRadioButtonFemMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonSalvar;
    private javax.swing.JComboBox<String> jComboBoxCargo;
    private javax.swing.JComboBox<String> jComboBoxDeptamento;
    private javax.swing.JLabel jLabelBairro;
    private javax.swing.JLabel jLabelCidade;
    private javax.swing.JLabel jLabelComplemento;
    private javax.swing.JLabel jLabelCpf;
    private javax.swing.JLabel jLabelDtNasc;
    private javax.swing.JLabel jLabelEndereco;
    private javax.swing.JLabel jLabelEstado;
    private javax.swing.JLabel jLabelMatCargo;
    private javax.swing.JLabel jLabelMatricula;
    private javax.swing.JLabel jLabelMtDept;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNumero;
    private javax.swing.JLabel jLabelRua;
    private javax.swing.JLabel jLabelSexo;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JRadioButton jRadioButtonFem;
    private javax.swing.JRadioButton jRadioButtonMasc;
    private javax.swing.JTextField jTextFieldBairro;
    private javax.swing.JTextField jTextFieldCidade;
    private javax.swing.JTextField jTextFieldComplemento;
    private javax.swing.JFormattedTextField jTextFieldCpf;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JFormattedTextField jTextFieldNasc;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNumero;
    private javax.swing.JTextField jTextFieldRua;
    private javax.swing.JFormattedTextField jTextFieldTelefone;
    private javax.swing.JTextField jTextFieldUF;
    // End of variables declaration//GEN-END:variables
}
