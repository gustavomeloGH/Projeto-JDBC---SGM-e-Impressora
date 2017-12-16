package projetoProgramacaoAvancada.Utils;

public class SqlCommand {

    public static final String SELECTALLFROMFUNCIONARIOS = "SELECT * FROM `tbl_funcionario`, "
            + "`tbl_endereco` where `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco`"
            + " ORDER BY  `tbl_funcionario`.`nome` ;";
    
    public static final String SELECTPRINTERREPORTS = "select `imp_hist`.`data_impressao`, `func`.`id_funcionario`, `func`.`nome`, "
            + " `func`.`cpf`, `imp`.`marca`, `imp`.`modelo`,  `impDet`.`tamanho_arquivo`,"
            + " `impDet`.`prioridade`, `tDoc`.`nome` from `tbl_impressao_historico` as `imp_hist`, "
            + "`tbl_funcionario` as `func`,`tbl_impressora` as `imp`,`tbl_impressao_detalhe` as `impDet`,"
            + "`tbl_tipo_documento` as `tDoc` where`imp_hist`.`id_funcionario` = `func`.`id_funcionario` "
            + " and `imp_hist`.`id_impressora` = `imp`.`id_impressora` and `imp_hist`.`id_impressao_detalhe` = `impDet`.`id_impressao_detalhe`"
            + "  and `impDet`.`id_tipo_documento` = `tDoc`.`id_tipo_documento`;";
    
     public static final String SELECTALLFROMFUNCIONARIOSEXCLUIDOS = "SELECT * FROM  `tbl_relatorio_excluidos`;";

    public static final String INSERTFUNCIONARIO = "INSERT INTO `tbl_funcionario`  "
            + " (id_funcionario, nome, sexo, data_nascimento, cpf, telefone, id_cargo, id_departamento, id_endereco) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
    
    public static final String INSERTDOCTYPE = "INSERT INTO `tbl_tipo_documento` "
            + " (`nome`) VALUES  (?);";
    
    public static final String INSERTPRINTDETAILS = "INSERT INTO `tbl_impressao_detalhe` "
            + " (`tamanho_arquivo`, `prioridade`, `id_tipo_documento`) VALUES  (?, ?, ?);";
            
    public static final String INSERTBLIMPRESSAOHISTORICO = "INSERT INTO `tbl_impressao_historico` "
            + " (`data_impressao`, `id_funcionario`, `id_impressora`, `id_impressao_detalhe`) VALUES  (?, ?, ?, ?);";
    

    public static final String INSERTENDERECO = "INSERT INTO `tbl_endereco` "
            + " (rua, numero, cidade, bairro, uf, complemento) "
            + "VALUES (?, ?, ?, ?, ?, ?);";
    
    public static final String DELETEFUNCIONARIO = "DELETE FROM `tbl_funcionario` "
            + " where `tbl_funcionario`.`id_funcionario` = ";
    
    public static final String INSERTRELATORIOEXCLUIDOS = "INSERT INTO `tbl_relatorio_excluidos` " 
            + " (id_funcionario, nome, sexo, data_nascimento, cpf, telefone, id_cargo, id_departamento, id_gerente, nome_gerente, data_exclusao, motivo) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

    public static final String SELECTALLFROMCARGONAME = "SELECT `nome` from `tbl_cargo`";

    public static final String SELECTALLFROMDEPARTAMENTONAME = "SELECT `nome` from `tbl_departamento`";

    public static final String SELECTALLFROMCARGOBYID = "SELECT * from `tbl_funcionario`, `tbl_endereco`"
            + " where  `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco` and `id_cargo` = ";

    public static final String SELECTALLFROMPARTAMENTOBYID = "SELECT * from `tbl_funcionario` , `tbl_endereco`"
            + "where  `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco` and `id_departamento` = ";

    public static final String SELECTALLFROMFUNCIONARIOSBYCPF = "SELECT * FROM `tbl_funcionario`, "
            + "`tbl_endereco` where `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco` and `tbl_funcionario`.`cpf` LIKE ";
    
    public static final String SELECTFROMFUNCIONARIOBYID = "SELECT * FROM `tbl_funcionario`, "
            + "`tbl_endereco` where `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco` and `tbl_funcionario`.`id_funcionario` LIKE ";

    public static final String SELECTALLFROMFUNCIONARIOSBYNOME = "SELECT * FROM `tbl_funcionario`, "
            + "`tbl_endereco` where `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco` and `tbl_funcionario`.`nome` LIKE ";

    public static final String SELECTALLFROMFUNCIONARIOSBYMATRICULA = "SELECT * FROM `tbl_funcionario`, "
            + "`tbl_endereco` where `tbl_funcionario`.`id_endereco` = `tbl_endereco`.`id_endereco`  and `tbl_funcionario`.`id_funcionario` LIKE ";

    public static final String SELECTGERENTFROMDEPARTAMENTOBYID = "SELECT * FROM `tbl_departamento` "
            + " where `tbl_departamento`.`id_gerente_func` =  ";
    
    
    public static final String UPDATEENDERECO = "UPDATE  `tbl_endereco` SET "
            + " rua = ?, numero = ?, cidade = ?, bairro = ?, uf = ?, complemento = ? "
            + " where `tbl_endereco`.`id_endereco` =  ? ;";
    
    public static final String UPDATEFUNCIONARIO = "UPDATE  `tbl_funcionario` SET "
            + " id_funcionario = ?, nome = ?, sexo = ?, data_nascimento = ?, cpf = ?, telefone = ?, id_cargo = ?, id_departamento = ?, id_endereco = ? "
            + " where `tbl_funcionario`.`id_funcionario` = ? ;";
    
    public static String getSqlCheckLogin(String login, String password) {
        return String.format("SELECT * FROM `tbl_funcionario` "
                + " where `tbl_funcionario`.`id_funcionario` = %s and `tbl_funcionario`.`cpf` = '%s' LIMIT 1;", login, password);
    }
    
    public static String getSqlCheckUNIQUE(String id, String cpf) {
        return "SELECT * FROM `tbl_funcionario` where `tbl_funcionario`.`id_funcionario` =  " + id + " or cpf = " + cpf;
    }

    public static final String ORDERBYNAME = " ORDER BY  `tbl_funcionario`.`nome` ;";
    public static final String LIMIT1 = " LIMIT 1;";
}
