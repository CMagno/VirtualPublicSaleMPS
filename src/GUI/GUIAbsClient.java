/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import GUI.validations.ValidationStrategy;
import logic.pojos.Client;

/**
 *
 * @author carlosmagno
 */
public class GUIAbsClient extends GUIAbsTemplate{
    
    private static GUIAbsClient self;
    
    private GUIAbsClient(GUIAbsTemplate s){
        sucessor = s;
        type =  Client.class;
    }
    
    public static GUIAbsClient getInstance(GUIAbsTemplate s){
        if(self == null){
            self = new GUIAbsClient(s);
        }
        return self;
    }
    
    @Override
    public long idResquest() {
        return super.idRequestGUI(Client.class);
    }

    @Override
    protected Object registeringGUI() {
        String nome;
        String cpf;
        while(true){
            nome = guiImpl.requestData("Nome:");
            if(ValidationStrategy.isValid(nome, ValidationStrategy.NAME)){
                break;
            }else{
                GUIAbsTemplate.operationFailedGUI("Nome inválido.");
            }
        }
        while(true){
            cpf = guiImpl.requestData("CPF:");
            if(ValidationStrategy.isValid(cpf, ValidationStrategy.CPF)){
                break;
            }else{
                GUIAbsTemplate.operationFailedGUI("CPF inválido.");
            }
        }
        return new Client(nome, cpf);
    }

    @Override
    protected void viewingGUI(Object o) {
        Client cli = (Client)o;
        guiImpl.showInformation("====Cliente====\n"
                              + cli.toString()
                              + "\n==============");
    }

    @Override
    protected Object updatingGUI(Object o) {
        viewingGUI(o);
        return registeringGUI();
    }

    @Override
    protected boolean deletingGUI(Object o) {
        viewingGUI(o);
        String op;
        while(true){
            op = guiImpl.requestData("Deseja apagar esse Cliente? S/N:");
            op = op.toLowerCase();
            if(op.charAt(0)=='s'){
                return true;
            }
            if(op.charAt(0)=='n'){
                return false;
            }
            guiImpl.showInformation("Opção Inválida");
        }
        
    }
    
}
