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
public class GUITextLine implements GUIProcedures{
    
    private static GUITextLine gui;
    
    private GUITextLine(){}
    
    public static GUITextLine getInstance(){
        if(gui == null){
            return new GUITextLine();
        }
        return gui;
    }
}
