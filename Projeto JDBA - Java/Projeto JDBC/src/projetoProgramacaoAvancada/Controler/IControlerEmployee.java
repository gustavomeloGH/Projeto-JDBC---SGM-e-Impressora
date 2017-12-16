package projetoProgramacaoAvancada.Controler;

import java.util.ArrayList;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Exceptions.Excecao;

public interface IControlerEmployee {

    //INSERTS
    public void insert(Funcionario funcionario) throws Exception;
    public void insertRemovedFuncTable(RemovedEmployee funcionarioToRemove) throws Exception;
    
    //UPDATES
    public void update(Funcionario funcionario) throws Exception;
    
    //LISTS
    public ArrayList listBySql(String sql, int type) throws Exception;
    public ArrayList<String> getNameBySql(String sql) throws Excecao;
    public ArrayList<Funcionario> getFuncionariosBySql(String sql) throws Excecao;
    public ArrayList<Funcionario> listFuncionarioFromInput(String inputStr) throws Excecao;
    
    //DELETES
    public void delete(String idFuncionario) throws Exception;
    
    //complements
    public String checkLogin(String login, String password) throws Exception;
    public void  sendToPrint(Funcionario func) throws Exception;
    
}
