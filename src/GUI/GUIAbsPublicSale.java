/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.Calendar;
import logic.pojos.PublicSale;

/**
 *
 * @author carlosmagno
 */
public class GUIAbsPublicSale extends GUIAbsTemplate{
    
    private static GUIAbsPublicSale self;
    
    private GUIAbsPublicSale(GUIAbsTemplate s){
        sucessor = s;
        type =  PublicSale.class;
    }
    
    public static GUIAbsPublicSale getInstance(GUIAbsTemplate s){
        if(self == null){
            self = new GUIAbsPublicSale(s);
        }
        return self;
    }
    
    @Override
    public long idResquest() {
        return super.idRequestGUI(PublicSale.class);
    }

    @Override
    public Object registeringGUI() {
        long prodId;
        Calendar initDate = Calendar.getInstance(), 
                 finalDate = Calendar.getInstance();
        
        while(true){
            try{
                prodId = Long.parseLong(guiImpl.requestData("ID do produto:"));
                break;
            }catch(NumberFormatException e){
                GUIAbsTemplate.operationFailedGUI("ID inválido.");
            }
        }
        int day, month, year;
        while(true){
            try{
                day = Integer.parseInt(guiImpl.requestData("Data de início(dia):"));
                month =  Integer.parseInt(guiImpl.requestData("Data de início(mês):"));
                year = Integer.parseInt(guiImpl.requestData("Data de início(ano):"));
                initDate.set(year, month, day);
                break;
            }catch(Exception e){
                GUIAbsTemplate.operationFailedGUI("Data inválida.");
            }
        }
        while(true){
            try{
                day = Integer.parseInt(guiImpl.requestData("Data de término(dia):"));
                month =  Integer.parseInt(guiImpl.requestData("Data de término(mês):"));
                year = Integer.parseInt(guiImpl.requestData("Data de término(ano):"));
                finalDate.set(year, month, day);
                break;
            }catch(Exception e){
                GUIAbsTemplate.operationFailedGUI("Data inválida.");
            }
        }
        
        return new PublicSale(prodId, initDate, finalDate);
    }

    @Override
    protected void viewingGUI(Object o) {
        PublicSale ps = (PublicSale)o;
        guiImpl.showInformation("====Leilão====\n"
                              + ps.toString()
                              + "\n==============");
    }

    @Override
    protected Object updatingGUI(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean deletingGUI(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
