
package projetoProgramacaoAvancada.Dao;


public class FactoryDao {
    
    public static IDaoJDBC getInstanceDaoJDBC() {
            return new DaoJDBC();
    }
    
}
