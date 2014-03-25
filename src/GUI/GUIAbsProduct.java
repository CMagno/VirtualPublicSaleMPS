/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import logic.pojos.Product;

/**
 *
 * @author carlosmagno
 */
public class GUIAbsProduct extends GUIAbsTemplate{
    
    private static GUIAbsProduct self;
    
    private GUIAbsProduct(GUIAbsTemplate s){
        sucessor = s;
        type =  Product.class;
    }
    
    public static GUIAbsProduct getInstance(GUIAbsTemplate s){
        if(self == null){
            self = new GUIAbsProduct(s);
        }
        return self;
    }
    
    @Override
    public long idResquest() {
        return super.idRequestGUI(Product.class);
    }

    @Override
    public Object registeringGUI() {
        String name, descr;
        int year;
        double initPrice;
        
        name = guiImpl.requestData("Nome:");
        descr =  guiImpl.requestData("Decrição:");
        while(true){
            try{
                year = Integer.parseInt(guiImpl.requestData("Ano:"));
                break;
            }catch(NumberFormatException e){
                GUIAbsTemplate.operationFailedGUI("Ano inválido");
            }
        }
        while(true){
            try{
                initPrice = Float.parseFloat(guiImpl.requestData("Preço:"));
                break;
            }catch(NumberFormatException e){
                GUIAbsTemplate.operationFailedGUI("Preço inválido");
            }
        }
        return new Product(name, descr, initPrice, year);
    }

    @Override
    public void viewingGUI(Object o) {
        Product prod = (Product)o;
        guiImpl.showInformation("====Produto====\n"
                              + prod.toString()
                              + "\n==============");
    }

    @Override
    public Object updatingGUI(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deletingGUI(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
