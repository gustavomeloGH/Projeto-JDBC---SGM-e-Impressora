
package projetoProgramacaoAvancada.Controler;

public class FactoryControl {
        
     public static IControlerEmployee getInstanceControlEmployee() {
        return new ControlerEmployee();
    }
}
