package projetoProgramacaoAvancada.Controler;

import java.util.ArrayList;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Exceptions.Excecao;
import projetoProgramacaoAvancada.Utils.Msg;
import projetoProgramacaoAvancada.Utils.ValidacoesDeEntradas;
import projetoProgramacaoAvancada.Dao.FactoryDao;
import projetoProgramacaoAvancada.Dao.IDaoJDBC;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Utils.Constt;

public class ControlerEmployee implements IControlerEmployee {

    private final IDaoJDBC daoJDBC;

    public ControlerEmployee() {
        this.daoJDBC = FactoryDao.getInstanceDaoJDBC();
    }

    //------------------------------------------------- INSERTS -------------------------------------------------------------
    @Override
    public void insert(Funcionario funcionario) throws Exception {
        String insertValidate = msgExcecaoEntradaInvalida(funcionario);
        if (insertValidate.isEmpty()) {
            if(!daoJDBC.checkExists(funcionario.getIdFuncionario(), funcionario.getCpf())) {
                 daoJDBC.insert(funcionario);
            } else {
                throw new Excecao(Msg.ENTITY_EXISTS);
            }
        } else {
            throw new Excecao(Msg.VALIDATE_ERROR + insertValidate);
        }
    }
    
    @Override
     public void insertRemovedFuncTable(RemovedEmployee funcionarioToRemove) throws Exception {
         daoJDBC.insertRemovedFuncTable(funcionarioToRemove);
     }

    //------------------------------------------------- UPDATES -------------------------------------------------------------
    @Override
    public void update(Funcionario funcionario) throws Exception {
        String updateValidate = msgExcecaoEntradaInvalida(funcionario);
        if (updateValidate.isEmpty()) {
            daoJDBC.update(funcionario);
        } else {
            throw new Excecao(Msg.VALIDATE_ERROR + updateValidate);
        }
    }

    //------------------------------------------------- DELETES -------------------------------------------------------------
    @Override
    public void delete(String idFuncionario) throws Exception {
        daoJDBC.delete(idFuncionario);
    }

    //------------------------------------------------- LISTS -------------------------------------------------------------

     @Override
    public ArrayList listBySql(String sql, int type) throws Exception {
        return daoJDBC.listBySql(sql, type);
    }

    @Override
    public ArrayList<String> getNameBySql(String sql) throws Excecao {
        return daoJDBC.getNameBySql(sql);
    }

    @Override
    public ArrayList<Funcionario> getFuncionariosBySql(String sql) throws Excecao {
        return daoJDBC.getFuncionariosBySql(sql);
    }

    @Override
    public ArrayList<Funcionario> listFuncionarioFromInput(String inputStr) throws Excecao {
        return daoJDBC.listFuncionarioFromInput(inputStr);
    }
    

    //------------------------------------------------- COMPLEMENTS -----------------------------------------------------
    @Override
    public String checkLogin(String login, String password) throws Exception {
        return daoJDBC.checkLogin(login, password);
    }
    
    @Override 
    public void  sendToPrint(Funcionario func) throws Exception {
         daoJDBC.sendToPrint(func);
    }

    //------------- complements PRIVATES -------------------------------------------------------------
    private String msgExcecaoEntradaInvalida(Funcionario funcionario) {
        String strResul = Constt.EMPTY;

        if (!ValidacoesDeEntradas.validarNumero(funcionario.getIdFuncionario())) {
            strResul = Msg.INVALIDO_IDFUNCIONARIO;
        } else if (funcionario.getIdFuncionario().length() != 5) {
            strResul = Msg.INVALIDO_IDFUNCIONARIO;
        } else if (!ValidacoesDeEntradas.validarString(funcionario.getNome())) {
            strResul = Msg.INVALIDO_NOME;
        } else if (!ValidacoesDeEntradas.validarDataNasc(funcionario.getDataNascimento())) {
            strResul = Msg.INVALIDO_DATA_NASC;
        } else if (!ValidacoesDeEntradas.validarCPF(funcionario.getCpf())) {
            strResul = Msg.INVALIDO_CPF;
        } else if (!ValidacoesDeEntradas.validarNumero(funcionario.getTelefone())) {
            strResul = Msg.INVALIDO_TELEFONE;
        } else if (!ValidacoesDeEntradas.validarNumero(funcionario.getEndereco().getNumero())) {
            strResul = Msg.INVALIDO_NUM;
        } else if (!ValidacoesDeEntradas.validarString(funcionario.getEndereco().getRua())) {
            strResul = Msg.INVALIDO_RUA;
        } else if (!ValidacoesDeEntradas.validarString(funcionario.getEndereco().getCidade())) {
            strResul = Msg.INVALIDO_CIDADE;
        } else if (!ValidacoesDeEntradas.validarString(funcionario.getEndereco().getBairro())) {
            strResul = Msg.INVALIDO_BAIRRO;
        } else if (!ValidacoesDeEntradas.validarString(funcionario.getEndereco().getUf())) {
            strResul = Msg.INVALIDO_UF;
        } else if (funcionario.getEndereco().getUf().length() > 3) {
            strResul = Msg.INVALIDO_UF;
        }
        return strResul;
    }

}
