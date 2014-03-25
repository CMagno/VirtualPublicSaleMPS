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
public class GUIImplGPopupWindow implements GUIImplTemplate{
    
    private static GUIImplGPopupWindow self;
    
    private GUIImplGPopupWindow(){
    }
    
    public static GUIImplGPopupWindow getInstance(){
        if(self == null){
            self = new GUIImplGPopupWindow();
        }
        return self;
    }
    
    @Override
    public String requestData(String msg) {
        return JOptionPane.showInputDialog(msg);
    }

    @Override
    public void showInformation(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    
}
