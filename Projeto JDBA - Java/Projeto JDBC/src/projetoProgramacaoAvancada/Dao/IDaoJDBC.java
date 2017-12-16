
package projetoProgramacaoAvancada.Dao;

import java.text.ParseException;
import java.util.ArrayList;
import projetoProgramacaoAvancada.Entity.Funcionario;
import projetoProgramacaoAvancada.Entity.RemovedEmployee;
import projetoProgramacaoAvancada.Exceptions.Excecao;

public interface IDaoJDBC {
    
    //INSERTS
    public void insert(Funcionario funcionario) throws Excecao, ParseException;
     public void insertRemovedFuncTable(RemovedEmployee funcionarioToRemove) throws Exception;
     
    //UPDATES
    public void update(Funcionario funcionario) throws Exception;
    
    //DELETES
    public void delete(String idFuncionario) throws Exception;
    
    //LISTS
    public ArrayList listBySql(String sql, int entity) throws Exception;
    public ArrayList<String> getNameBySql(String sql) throws Excecao;
    public ArrayList<Funcionario> getFuncionariosBySql(String sql) throws Excecao ;
    public ArrayList<Funcionario> listFuncionarioFromInput(String inputStr) throws Excecao;
     
    //complements
    public String checkLogin(String login, String password) throws Excecao;
    public void sendToPrint(Funcionario func) throws Exception;
    public boolean checkExists(String idFuncionario, String cpf) throws Excecao;
    
   
     
    
    
    
}
