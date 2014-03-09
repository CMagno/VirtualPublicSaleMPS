/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logic.pojos.Client;
import logic.pojos.Deal;
import logic.pojos.Product;
import logic.pojos.PublicSale;

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
    
    

    @Override
    public int displayMenu() {
        while(true){
            try{
                int op = Integer.valueOf(JOptionPane.showInputDialog(
                        "Menu:\n"
                        + "-Cadastrar:\n"
                        + "----(0) Cliente\n"
                        + "----(1) Produto\n"
                        + "----(2) Leilão\n"
                        + "----(3) Negócio\n"
                        + "-Consultar:\n"
                        + "----(4) Cliente\n"
                        + "----(5) Produto\n"
                        + "----(6) Leilão\n"
                        + "----(7) Negócio\n"
                        + "-Editar:\n"
                        + "----(8 ) Cliente\n"
                        + "----(9 ) Produto\n"
                        + "----(10) Leilão\n"
                        + "----(11) Negócio\n"
                        + "-Apagar:\n"
                        + "----(12) Cliente\n"
                        + "----(13) Produto\n"
                        + "----(14) Leilão\n"
                        + "----(15) Negócio\n"
                        + "-Sair:\n"
                        + "----(16)\n"
                        + "======================\n"
                        + "Digite a opção:"));
                if(op >= 0 && op <= 16){
                    return op;
                }else{
                    throw new NumberFormatException();
                }

            }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "!!Opção inválida.");
            }
        }
    }

    @Override
    public Client clientRegisteringGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product productRegisteringGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PublicSale pSaleRegisteringGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Deal dealRegisteringGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long idRequestGUI(Class<?> type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clientViewingGUI(Client c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void productViewingGUI(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pSaleViewingGUI(PublicSale ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void dealViewingGUI(Deal d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Client clientUpdatingGUI(Client c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product productUpdatingGUI(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PublicSale pSaleUpdatingGUI(PublicSale ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Deal dealUpdatingGUI(Deal d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean clientDeletingGUI(Client c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean productDeletingGUI(Product p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean pSaleDeletingGUI(PublicSale ps) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean dealDeletingGUI(Deal d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void operationSucessGUI() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void operationFailedGUI(String erro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
