/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

/**
 *
 * @author carlosmagno
 */
public class GUIGraphicalPopupWindow implements GUIProcedures{
    
    private static GUIGraphicalPopupWindow gui;
    
    private GUIGraphicalPopupWindow(){}
    
    public static GUIGraphicalPopupWindow getInstance(){
        if(gui == null){
            gui = new GUIGraphicalPopupWindow();
            return gui;
        }
        return gui;
    }
}
