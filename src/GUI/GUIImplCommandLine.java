/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carlosmagno
 */
public class GUIImplCommandLine implements GUIImplTemplate{
    
    private final BufferedReader inReader;
    private static GUIImplCommandLine self;
    
    private GUIImplCommandLine(){
        inReader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static GUIImplCommandLine getInstance(){
        if(self == null){
            self = new GUIImplCommandLine();
        }
        return self;
    }
    
    @Override
    public String requestData(String msg) {
        System.out.print(msg);
        try {
            return inReader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(GUIImplCommandLine.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
        return ""; //trecho não alcançado
    }

    @Override
    public void showInformation(String msg) {
        System.out.print(msg);
    }
    
}
