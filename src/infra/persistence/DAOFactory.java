/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra.persistence;

import javax.swing.JOptionPane;

/**
 *
 * @author carlosmagno
 */
public class DAOFactory {
    
    public static DAO getInstance(){
        switch(showPersistenceTypeAsk()){
            case 0:
                return DAOFilePersistence.getInstance();
            case 1:
                return DAOMemoryPersistence.getInstance();
            default:
                return null;
        }
    }
    
    private static int showPersistenceTypeAsk(){
        Object[] options = new Object[]{"Em Arquivo","Em Memória"};
        return JOptionPane.showOptionDialog(null, 
                "Qual tipo de persistência você deseja?",
                "Escolha de persistência", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                options, options[0]);
    }
}
