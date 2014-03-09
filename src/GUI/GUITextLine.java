/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import GUI.validations.ValidationStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import logic.pojos.Client;
import logic.pojos.Deal;
import logic.pojos.Product;
import logic.pojos.PublicSale;

/**
 *
 * @author carlosmagno
 */
public class GUITextLine implements GUIProcedures{
    
    private static GUITextLine gui;
    private static BufferedReader inReader;
    
    private GUITextLine(){
        inReader = new BufferedReader(new InputStreamReader(System.in));
    }
    
    public static GUITextLine getInstance(){
        if(gui == null){
            gui = new GUITextLine();
            return gui;
        }
        return gui;
    }

    @Override
    public int displayMenu() {
        while(true){
            try{
                System.out.print("Menu:\n"
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
                        + "Digite a opção:");
                int op = Integer.valueOf(inReader.readLine());
                if(op >= 0 && op <= 16){
                    return op;
                }else{
                    throw new NumberFormatException();
                }

            }catch(NumberFormatException e){
                    operationFailedGUI("Opção inválida.");
            } catch (IOException ex) {
                Logger.getLogger(GUITextLine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public Client clientRegisteringGUI() {
        String nome = "";
        String cpf = "";
        System.out.println("== CADSATRO DE CLIENTE ==\n");
        while(true){
            try {
                System.out.print("Nome:");
                nome = inReader.readLine();
                if(ValidationStrategy.isValid(nome, ValidationStrategy.NAME)){
                    break;
                }else{
                    this.operationFailedGUI("Nome inválido.");
                }
            } catch (IOException ex) {
                Logger.getLogger(GUITextLine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        while(true){
            try {
                System.out.print("CPF:");
                cpf = inReader.readLine();
                if(ValidationStrategy.isValid(cpf, ValidationStrategy.CPF)){
                    break;
                }else{
                    this.operationFailedGUI("CPF inválido.");
                }
            } catch (IOException ex) {
                Logger.getLogger(GUITextLine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new Client(nome, cpf);
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
        long id = 0;
        while(true){
            System.out.print("Digite o ID do " + GUIProcedures.typeNameMap.get(type) + ":");
            try {
                id = Long.valueOf(inReader.readLine());
                break;
            } catch (IOException ex) {
                Logger.getLogger(GUITextLine.class.getName()).log(Level.SEVERE, null, ex);
            } catch(NumberFormatException e){
                this.operationFailedGUI("ID inválido. Digite somente números.");
            }
        }
        return id;
    }

    @Override
    public void clientViewingGUI(Client c) {
        System.out.print("Cliente Id(" + c.getId() + "):\n"
                + "----Nome: " + c.getNome() + "\n"
                + "----CPF: " + c.getCpf() + "\n"
                + "Tecle ENTER para continuar...");
        try {
            inReader.readLine();
        } catch (IOException ex) {
            Logger.getLogger(GUITextLine.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        System.out.println("Operação realizada com sucesso.");
    }

    @Override
    public void operationFailedGUI(String erro) {
        System.out.println("!Erro: " + erro);
    }
}
