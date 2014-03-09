/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.swing.JOptionPane;

/**
 *
 * @author carlosmagno
 */
public class GUIFactory {
    
    public static GUIProcedures getInstance(){
        switch(showGUITypeAsk()){
            case 0:
                return GUITextLine.getInstance();
            case 1:
                return GUIGraphicalPopupWindow.getInstance();
            default:
                return null;
        }
    }
    
    private static int showGUITypeAsk(){
        Object[] options = new Object[]{"Linha de Texto","Janelas Poppup Gráficas"};
        return JOptionPane.showOptionDialog(null, 
                "Qual tipo de GUI você deseja?",
                "Escolha de GUI", 
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                options, options[0]);
    } 
    
}
