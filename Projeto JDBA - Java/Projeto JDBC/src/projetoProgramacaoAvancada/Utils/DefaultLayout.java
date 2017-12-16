/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoProgramacaoAvancada.Utils;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class DefaultLayout {
    
     public static void alterarLayout() {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }  
}
