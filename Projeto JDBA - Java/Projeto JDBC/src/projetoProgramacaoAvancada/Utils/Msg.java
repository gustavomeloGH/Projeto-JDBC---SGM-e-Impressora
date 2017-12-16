package projetoProgramacaoAvancada.Utils;

public class Msg {

    //printer msg --->
    public static final String ERROR_FILE_NOT_FINDED = "Não foi possível realizar a impressão, pois não há arquivos a serem imprimidos!";
    public static final String ERROR_FILE_NOT_READED = "Não foi possível realizar a leitura dos arquivos!";
    public static final String PRINTING = "Imprimindo: ";
    public static final String FINALIZED = "Finalizado:";
    public static final String PAUSED = "Pausado:";
    public static final String SENDEDPRINT =  "Os arquivos foram enviados! \nAguarde a impressão.";
    public static final String ERROR_LOGIN_PASSWD =  "Login ou Password inválidos!\nTente novamente";
    public static final String ERROR_LOGIN_EMPTY =  "Para acessar ao sistema digite seu login e senha";
    public static final String ERROR_PASSWORD =  "Senha não confere!\nTente novamente.";
    public static final String ERROR_SYSTEM =  " Relatório não gerado!\nEntre em contato com o administrador de sistema ";

    //error msg --->
    public static final String INVALIDO_NOME = "\n- Nome incorreto";
    public static final String INVALIDO_IDFUNCIONARIO = "ID funcionário deve ser apenas números\nObrigatório: 5 dígitos";
    public static final String INVALIDO_SEXO = "\n- Sexo deve ser \nM - Masculino ou F - Feminino";
    public static final String INVALIDO_TELEFONE = "\n- Verificar telefone";
    public static final String INVALIDO_DATA_NASC = "\n- Funcionário deve ser maior de idade";
    public static final String INVALIDO_CPF = "\n- Nº CPF não existe";
    public static final String INVALIDO_CARGO = "\n- Cargo não existe no sistema";
    public static final String INVALIDO_DEPARTAMENTO = "\n- Departamento não existe no sistema";
    public static final String INVALIDO_RUA = "\n- Verificar nome de Rua";
    public static final String INVALIDO_BAIRRO = "\n- Verificar nome do Bairro";
    public static final String INVALIDO_UF = "\n- Verificar estado\nNão pode ultrapassar 3 caracteres!\nApenas letras";
    public static final String INVALIDO_NUM = "\n- Verifique o número do endereço";
    public static final String INVALIDO_COMPLEMENTO = "\n- Verifique o complemento";
    public static final String INVALIDO_CIDADE = "\n- Verifique a cidade";
    public static final String ESPECIFICAR_QTT = "Especifique a quantidade!";
    public static final String LIMITE_CARACTERE = "Limite de caractere atingido!";
    public static final String VALIDATE_ERROR = "Erro de validação dos campos: ";
    public static final String ERROR_EMPTY_PATH = "Não há arquivos na pasta para ser impresso!";
    public static final String ENTITY_EXISTS = "Já existe um cadastro com número de matrícula ou cpf.\nFavor, verifique com setor responsável";

    //crud msg --->
    public static final String UPDATE_SUCCESS = "Cadastro atualizado com sucesso!";
    public static final String INSERT_SUCCESS = "Cadastro realizado com sucesso!";
    public static final String DELETE_SUCCESS = "Removido com sucesso!";
    public static final String DAO_ERROR = "Houve um problema interno: ";

    //another msgs -> 
    public static final String SEARCH_MSG = " Nome, CPF ou Matrícula do funcionário";
    public static final String DATABASE_SUCESS = "A conexão com o banco foi realizada com sucesso!";
    public static final String DATABASE_FAIL = "Problema na conexão com o SGBD: ";
    public static final String REMOV_FUNC = "Excluir funcionário";
    public final static String EXCLUSION_REASON = "Informe o motivo da exclusão: ";
    public final static String REMOVED_SUCESS = "Funcionário removido com sucesso!";
    public final static String THERE_IS_EMPTY_FIELD = "Todos os campos devem ser preenchidos!";
    public final static String ERROR_CONSULT_SELECT = "Para consultar é necessário selecionar algum funcionário!";

    public final static String TITLE_REPORTS_EMPLOYEE = "Relatórios de Funcionários - SGM";
    public final static String TITLE_REPORTS_EMPLOYEE_REMOVED = "Relatórios de Exclusão de Funcionários - SGM";
    public final static String TITLE_REPORTS_PRINT = "Relatórios de Exclusão de Funcionários - SGM";
    public final static String REPORTS_SUCESS = "O relatório selecionado foi gerado com sucesso!\nVerifique na pasta Relatórios.";
    public final static String ERROR_REPORTS = "Não foram encontrados dados!\nRelatório não foi gerado.";

}
