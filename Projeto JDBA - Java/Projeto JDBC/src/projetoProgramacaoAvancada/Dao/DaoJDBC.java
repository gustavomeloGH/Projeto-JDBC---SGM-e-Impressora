package projetoProgramacaoAvancada.Dao;

import java.io.File;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import projetoProgramacaoAvancada.Entity.Endereco;
import projetoProgramacaoAvancada.Entity.EnumCargo;
import projetoProgramacaoAvancada.Entity.EnumDepartamento;
import projetoProgramacaoAvancada.Entity.EnumEntity;
import projetoProgramacaoAvancada.Entity.EnumSexo;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Entity.ReportsPrinter;
import projetoProgramacaoAvancada.Exceptions.Excecao;
import projetoProgramacaoAvancada.Utils.ConnectionUtilJDBC;
import projetoProgramacaoAvancada.Utils.Constt;
import projetoProgramacaoAvancada.Utils.Msg;
import projetoProgramacaoAvancada.Utils.SqlCommand;
import projetoProgramacaoAvancada.Utils.Utils;

public class DaoJDBC implements IDaoJDBC {

    private Connection conn;

    public DaoJDBC() {
        conn = null;
    }

    //------------------------------------------------- INSERTS -------------------------------------------------------------
    @Override
    public void insert(Funcionario funcionario) throws Excecao, ParseException {
        try {
            this.openDatabase();
            PreparedStatement stm = conn.prepareStatement(SqlCommand.INSERTENDERECO, Statement.RETURN_GENERATED_KEYS);
            setEnderecoToTable(funcionario.getEndereco(), stm);
            stm.execute();
            int idEndereco = getLastInd(stm);
            stm = conn.prepareStatement(SqlCommand.INSERTFUNCIONARIO);
            setFuncionarioToTable(funcionario, stm);
            stm.setInt(9, idEndereco);
            stm.execute();
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
    }

    @Override
    public void insertRemovedFuncTable(RemovedEmployee funcionarioToRemove) throws Exception {
        try {
            this.openDatabase();
            PreparedStatement stm = conn.prepareStatement(SqlCommand.INSERTRELATORIOEXCLUIDOS);
            funcionarioToRemove.setDateNascimento(Utils.formatSqlDateString(funcionarioToRemove.getDataNascimento()));
            setFuncionarioToTable(funcionarioToRemove, stm);
            setRemovedFuncionarioToTable(funcionarioToRemove, stm);
            
            stm.execute();
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
    }

    @Override
    public void sendToPrint(Funcionario func) throws Exception {
        File diretorio = new File(Constt.PRINTER_FILES);
        File[] arquivos = diretorio.listFiles();
        PreparedStatement stm = null;
        if (arquivos.length != 0) {
            for (File currFIle : arquivos) {
                try {
                    this.openDatabase();
                    stm = conn.prepareStatement(SqlCommand.INSERTDOCTYPE, Statement.RETURN_GENERATED_KEYS);
                    setDocType(stm);
                    int idDocType = this.getLastInd(stm);
                    stm = conn.prepareStatement(SqlCommand.INSERTPRINTDETAILS, Statement.RETURN_GENERATED_KEYS);
                    setPrintDetailsToTable(stm, currFIle, func.getIdCargo(), idDocType);
                    int idPrintDetail = this.getLastInd(stm);
                    stm = conn.prepareStatement(SqlCommand.INSERTBLIMPRESSAOHISTORICO);
                    setPrintHisToTable(stm, func.getIdFuncionario(), idPrintDetail);
                    conn.close();
                    currFIle.delete();
                } catch (SQLException ex) {
                    throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
                }
            }
        } else {
            throw new Excecao(Msg.ERROR_EMPTY_PATH);
        }
    }

    //------------------------------------------------- UPDATES  -------------------------------------------------------------
    
    @Override
    public void update(Funcionario funcionario) throws Exception {
        try {
            this.openDatabase();
            PreparedStatement stm = conn.prepareStatement(SqlCommand.UPDATEENDERECO);
            setEnderecoToTable(funcionario.getEndereco(), stm);
            stm.setString(7, funcionario.getIdEndereco());
            stm.executeUpdate();

            stm = conn.prepareStatement(SqlCommand.UPDATEFUNCIONARIO);
            setFuncionarioToTable(funcionario, stm);
            stm.setInt(9, Integer.parseInt(funcionario.getIdEndereco()));
            stm.setInt(10, Integer.parseInt(funcionario.getIdFuncionario()));
            stm.executeUpdate();

            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }

    }

    //------------------------------------------------- DELETES -------------------------------------------------------------
    @Override
    public void delete(String idFuncionario) throws Exception {
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            stm.executeUpdate(SqlCommand.DELETEFUNCIONARIO + idFuncionario);
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
    }

    //------------------------------------------------- LISTS -------------------------------------------------------------
    @Override
    public ArrayList listBySql(String sql, int entity) throws Exception {
        ArrayList arrayList = new ArrayList();
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                arrayList.add(this.doSwitchEntityType(entity, rs));
            }
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
        return arrayList;
    }

    @Override
    public ArrayList<Funcionario> listFuncionarioFromInput(String inputStr) throws Excecao {
        ArrayList<Funcionario> funcList = new ArrayList();
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            String[] sqlList = {
                SqlCommand.SELECTALLFROMFUNCIONARIOSBYNOME + "'%" + inputStr + "%'" + SqlCommand.ORDERBYNAME,
                SqlCommand.SELECTALLFROMFUNCIONARIOSBYMATRICULA + "'" + inputStr + "'" + SqlCommand.ORDERBYNAME,
                SqlCommand.SELECTALLFROMFUNCIONARIOSBYCPF + "'" + inputStr + "'" + SqlCommand.ORDERBYNAME
            };
            for (String sqlCommand : sqlList) {
                ResultSet rs = stm.executeQuery(sqlCommand);
                while (rs.next()) {
                    funcList.add(getFuncionarioFromResultSet(rs));
                }
            }
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
        return funcList;
    }

    @Override
    public ArrayList<String> getNameBySql(String sql) throws Excecao {
        ArrayList<String> cargoList = new ArrayList();
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cargoList.add(rs.getString(Constt.NOME));
            }
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
        return cargoList;
    }

    @Override
    public ArrayList<Funcionario> getFuncionariosBySql(String sql) throws Excecao {
        ArrayList<Funcionario> funcList = new ArrayList();
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                funcList.add(getFuncionarioFromResultSet(rs));
            }
            conn.close();
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }

        return funcList;
    }

    //------------------------------------------------- COMPLEMENTS -------------------------------------------------------------
    @Override
    public String checkLogin(String login, String password) throws Excecao {
        String idDepartamento = Constt.EMPTY;
        String loginType = Constt.EMPTY;
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            ResultSet rs = stm.executeQuery(SqlCommand.getSqlCheckLogin(login, password));

            if (!resultSetIsEmpty(rs)) {
                idDepartamento = rs.getString(Constt.IDFUNCIONARIO);
                stm = (Statement) conn.createStatement();
                rs = stm.executeQuery(SqlCommand.SELECTGERENTFROMDEPARTAMENTOBYID + idDepartamento + SqlCommand.LIMIT1);
                loginType = (resultSetIsEmpty(rs)) ? Constt.EMPLOYEE : Constt.MANAGER;

            }
            conn.close();
        } catch (SQLException | Excecao ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
        return loginType;
    }

    @Override
    public boolean checkExists(String idFuncionario, String cpf) throws Excecao {
          boolean boo = false;
        try {
            this.openDatabase();
            Statement stm = (Statement) conn.createStatement();
            ResultSet rs = stm.executeQuery(SqlCommand.getSqlCheckUNIQUE(idFuncionario, cpf));
            boo = !resultSetIsEmpty(rs);
            conn.close();
            return boo;
        } catch (SQLException ex) {
            throw new Excecao(Msg.DAO_ERROR + ex.getMessage());
        }
    }
            
    //----------- complements PRIVATES  -----------
    private void openDatabase() throws Excecao {

        try {
            conn = (Connection) ConnectionUtilJDBC.getConnection();
            if (conn.getMetaData().getDatabaseProductName().equals(Constt.MY_SQL)) {
                System.out.println(Msg.DATABASE_SUCESS);
            }
        } catch (SQLException e) {
            throw new Excecao(Msg.DATABASE_FAIL + e.getMessage());
        }
    }

    private void setEnderecoToTable(Endereco endereco, PreparedStatement stm) throws SQLException {
        stm.setString(1, endereco.getRua());
        stm.setString(2, endereco.getNumero());
        stm.setString(3, endereco.getCidade());
        stm.setString(4, endereco.getBairro());
        stm.setString(5, endereco.getUf());
        stm.setString(6, endereco.getComplemento());
    }

    private void setFuncionarioToTable(Funcionario funcionario, PreparedStatement stm) throws SQLException, ParseException {
        stm.setInt(1, Integer.parseInt(funcionario.getIdFuncionario()));
        stm.setString(2, funcionario.getNome());
        stm.setString(3, funcionario.getSexo().name());
        stm.setDate(4, this.getSqlDateFromString(funcionario.getDataNascimento()));
        stm.setString(5, funcionario.getCpf());
        stm.setString(6, funcionario.getTelefone());
        stm.setInt(7, Integer.parseInt(funcionario.getIdCargo()));
        stm.setInt(8, Integer.parseInt(funcionario.getIdDepartamento()));
    }

    private void setRemovedFuncionarioToTable(RemovedEmployee funcionarioToRemove, PreparedStatement stm) throws SQLException {
        String cargo = EnumCargo.values()[Integer.parseInt(funcionarioToRemove.getIdCargo()) - 1].getValue();
        String departamento = EnumDepartamento.values()[Integer.parseInt(funcionarioToRemove.getIdDepartamento()) - 1].getValue();
        stm.setString(7, funcionarioToRemove.getIdCargo());
        stm.setString(8, funcionarioToRemove.getIdDepartamento());
        stm.setString(9, funcionarioToRemove.getIdGerente());
        stm.setString(10, funcionarioToRemove.getNomeGerente());
        stm.setDate(11, this.convertUtilToSql(funcionarioToRemove.getDataExclusao()));
        stm.setString(12, funcionarioToRemove.getMotivo());
    }

    private java.sql.Date getSqlDateFromString(String dateString) throws ParseException {
        dateString = Utils.formatDate(dateString);
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(dateString);
        java.sql.Date sDate = convertUtilToSql(date);

        return sDate;
    }

    public java.sql.Date getSqlDateFromDate(Date date) throws ParseException {
        java.sql.Date sDate = convertUtilToSql(date);
        return sDate;
    }

    private java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

    private Funcionario getFuncionarioFromResultSet(ResultSet rs) throws SQLException {

        //ENDEREÇO DO FUNCIONÁRIO
        String rua = rs.getString(Constt.RUA);
        String numero = rs.getString(Constt.NUMERO);
        String cidade = rs.getString(Constt.CIDADE);
        String uf = rs.getString(Constt.UF);
        String bairro = rs.getString(Constt.BAIRRO);
        String complemento = rs.getString(Constt.COMPLEMENTO);

        Endereco endereco = new Endereco(rua, numero, cidade, bairro, uf, complemento);

        //FUNCIONÁRIO
        String idFuncionario = String.valueOf(rs.getInt(Constt.IDFUNCIONARIO));
        String nome = rs.getString(Constt.NOME);
        EnumSexo sexo = Enum.valueOf(EnumSexo.class, rs.getString(Constt.SEXO));
        String dataNascimento = rs.getDate(Constt.DATANASCIMENTO).toString();
        String cpf = rs.getString(Constt.CPF);
        String telefone = rs.getString(Constt.TELEFONE);
        String idCargo = String.valueOf(rs.getInt(Constt.IDCARGO));
        String idDepartamento = String.valueOf(rs.getInt(Constt.IDDEPARTAMENTO));
        String idEndereco = String.valueOf(rs.getInt(Constt.IDENDERECO));

        return new Funcionario(idFuncionario, nome, sexo, dataNascimento, cpf, telefone, idCargo, idDepartamento, endereco, idEndereco);

    }

    private RemovedEmployee getFuncionarioRemovedFromResultSet(ResultSet rs) throws SQLException {

        //FUNCIONÁRIO
        String idFuncionario = String.valueOf(rs.getInt(Constt.IDFUNCIONARIO));
        String nome = rs.getString(Constt.NOME);
        EnumSexo sexo = Enum.valueOf(EnumSexo.class, rs.getString(Constt.SEXO));
        String dataNascimento = rs.getDate(Constt.DATANASCIMENTO).toString();
        String cpf = rs.getString(Constt.CPF);
        String telefone = rs.getString(Constt.TELEFONE);
        String idCargo = String.valueOf(rs.getInt(Constt.IDCARGO));
        String idDepartamento = String.valueOf(rs.getInt(Constt.IDDEPARTAMENTO));
        String idGerente = String.valueOf(rs.getInt(Constt.IDGERENTE));
        String nomeGerente = rs.getString(Constt.NOMEGERENTE);
        Date dataExclusao = rs.getDate(Constt.DATAEXCLUSAO);
        String motivo = rs.getString(Constt.MOTIVO);

        return new RemovedEmployee(idFuncionario, nome, sexo, dataNascimento, cpf, telefone, idCargo, idDepartamento, idGerente, nomeGerente, dataExclusao, motivo);
    }

    private ReportsPrinter getReportsPrinterFromResultSet(ResultSet rs) throws SQLException {

        //REPORTSPRINTER
        Date dataImpressao = rs.getDate(Constt.DATA_IMPRESSAO);
        String idFuncionario = rs.getString(Constt.IDFUNCIONARIO);
        String nomeFuncionario = rs.getString(Constt.NOME);
        String cpfFuncionario = rs.getString(Constt.CPF);
        String marcaImpressora = rs.getString(Constt.MARCA);
        String modeloImpressora = rs.getString(Constt.MODELO);
        int tamanhoArquivo = rs.getInt(Constt.TAM_ARQ);
        int prioridade = rs.getInt(Constt.PRIORIDADE);
        String tipoDocumento = rs.getString(Constt.TIPODOC);

        return new ReportsPrinter(dataImpressao, idFuncionario, nomeFuncionario, cpfFuncionario, marcaImpressora, modeloImpressora, tamanhoArquivo, prioridade, tipoDocumento);

    }

    private Object doSwitchEntityType(int entity, ResultSet rs) throws SQLException {
        Object obj = null;
        switch (entity) {
            case EnumEntity.EMPLOYEE:
                obj = getFuncionarioFromResultSet(rs);
                break;
            case EnumEntity.REMOVEDEMPLOYEE:
                obj = getFuncionarioRemovedFromResultSet(rs);
                break;
            case EnumEntity.REPORTSPRINTER:
                 obj =  getReportsPrinterFromResultSet(rs);
                break;
            default:
                break;
        }
        return obj;
    }

    private int getLastInd(PreparedStatement stm) throws SQLException {
        int id = 0;
        ResultSet rs = stm.getGeneratedKeys();
        if (rs.next()) {
            id = rs.getInt(1);
        }
        return id;
    }

    private boolean resultSetIsEmpty(ResultSet rs) throws SQLException {
        return !rs.next();
    }

    private void setPrintHisToTable(PreparedStatement stm, String idFuncionario, int idImpressoraDetalhe) throws SQLException {
        stm.setDate(1, this.convertUtilToSql(new Date()));
        stm.setInt(2, Integer.parseInt(idFuncionario));
        stm.setInt(3, Utils.getIdImpressora());
        stm.setInt(4, idImpressoraDetalhe);
        stm.execute();
    }

    private void setDocType(PreparedStatement stm) throws SQLException {
        stm.setString(1, "txt");
        stm.execute();
    }

    private void setPrintDetailsToTable(PreparedStatement stm, File file, String idCargo, int idTipoDoc) throws SQLException {
        stm.setBigDecimal(1, new BigDecimal(file.length()));
        stm.setInt(2, Utils.getPriorityByCargo(Integer.parseInt(idCargo)));
        stm.setInt(3, idTipoDoc);
        stm.execute();
    }

}
