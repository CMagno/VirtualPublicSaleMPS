/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import logic.pojos.Deal;

/**
 *
 * @author carlosmagno
 */
public class GUIAbsDeal extends GUIAbsTemplate{
    
    private static GUIAbsDeal self;
    
    private GUIAbsDeal(GUIAbsTemplate s){
        sucessor = s;
        type =  Deal.class;
    }
    
    public static GUIAbsDeal getInstance(GUIAbsTemplate s){
        if(self == null){
            self = new GUIAbsDeal(s);
        }
        return self;
    }
    
    @Override
    public long idResquest() {
        return super.idRequestGUI(Deal.class);
    }
    
    //implementar exceção de id
    @Override
    protected Object registeringGUI() {
        long idProd, idBuyer, idSeller;
        while(true){
            try{
                idProd = Long.parseLong(guiImpl.requestData("Código do produto:"));
                break;
            }catch(NumberFormatException e){
                GUIAbsTemplate.operationFailedGUI("ID inválido.");
            }
        }
        while(true){
            try{
                idBuyer = Long.parseLong(guiImpl.requestData("Código do comprador:"));
                break;
            }catch(NumberFormatException e){
                GUIAbsTemplate.operationFailedGUI("ID inválido.");
            }
        }
        while(true){
            try{
                idSeller = Long.parseLong(guiImpl.requestData("Código do vendedor:"));
                break;
            }catch(NumberFormatException e){
                GUIAbsTemplate.operationFailedGUI("ID inválido.");
            }
        }
        
        return new Deal(idBuyer, idSeller, idProd);
    }

    @Override
    protected void viewingGUI(Object o) {
        Deal deal = (Deal)o;
        guiImpl.showInformation("====Negócio====\n"
                              + deal.toString()
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
