/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.HashMap;
import logic.pojos.Client;
import logic.pojos.Deal;
import logic.pojos.Product;
import logic.pojos.PublicSale;

/**
 *
 * @author carlosmagno
 */
public abstract class GUIAbsTemplate {
    
    protected static GUIImplTemplate guiImpl;
    protected GUIAbsTemplate sucessor;
    protected Class<?> type;
    
    private static final HashMap<Class<?>,String> typeNameMap = new HashMap<Class<?>,String>(){{
        put(Client.class, "Cliente");
        put(Product.class, "Produto");
        put(PublicSale.class, "Leilão");
        put(Deal.class, "Negócio");
    }};
    
    public static GUIAbsTemplate getChainInstance(GUIImplTemplate impl){
        guiImpl = impl;
        return GUIAbsClient.getInstance(
               GUIAbsDeal.getInstance(
               GUIAbsProduct.getInstance(
               GUIAbsPublicSale.getInstance(null))));
    }
    
    public static int displayMenu(){
        int nOp = Integer.MAX_VALUE;
        while(true){
            String op = guiImpl.requestData(
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
                        + "Digite a opção:");
            try{
                nOp = Integer.parseInt(op);
                if(!(nOp >= 0 && nOp <= 16)){
                    throw new NumberFormatException();
                }
            }catch(NumberFormatException e){
                operationFailedGUI("Opção inválida");
            }
            break;
        }
        return nOp;
    }
    
    /*EXIBE UMA MENSSAGEM INFORMANDO SUCESSO NA OPERAÇÃO
      MENSSAGEM GENÉRICA*/
    public static void operationSucessGUI(){
        guiImpl.showInformation("Operação realizada com sucesso!");
    }
    
    /*EXIBE A MENSSAGEM DE ERRO*/
    public static void operationFailedGUI(String erro){
        guiImpl.showInformation("!Erro:" + erro);
    }
    
    /*REQUISITA UM ID PARA O USUÁRIO E RETORNA-O
      O TIPO SERVE PARA EXIBIR A MENSSAGEM CORRETA*/
    public long idRequestGUI(Class<?> type){
        return Long.valueOf(guiImpl.requestData("Digite o ID do " + typeNameMap.get(type) + ":"));
    }
    public abstract long idResquest();
    
    /*REALIZA AS REQUISIÇÕES DOS DADOS E RETORNA UM OBJETO PRONTO*/
    protected abstract Object registeringGUI();
    
    /*RECEBE UM OBJETO E EXIBI OS DADOS DELE DE FORMA APROPRIADA
      USADO PARA RETORNAR AO CLIENTE O ID DE UM OBJETO CRIADO*/
    protected abstract void viewingGUI(Object o);
    
    /*RECEBE UM OBJETO PARA EXBIR O QUE SERÁ EDITADO E RETORNA-O EDITADO*/
    protected abstract Object updatingGUI(Object o);
    
    /*RECEBE UM OBJETO PARA EXIBIR IFORMAR O USUÁRIO O QUE SERÁ APAGADO
      RETORNA UM BOOLEAN DE CONFIRMAÇÃO
      O DAO QUE É O RESPONSÁVEL POR APAGAR*/
    protected abstract boolean deletingGUI(Object o);
    
    /*CHAIN OF RESPONSABILITY*/
    protected void setSucessor(GUIAbsTemplate guiAT){
        sucessor = guiAT;
    }
    public Object registeringGUI(Class<?> type) {
        if(type == this.type){
            return registeringGUI();
        }
        return sucessor.registeringGUI(type);
    }
    public void viewingGUI(Class<?> type, Object o) {
        if(type == this.type){
            viewingGUI(o);
            return;
        }
        sucessor.viewingGUI(type, o);
    }
    public Object updatingGUI(Class<?> type, Object o) {
        if(type == this.type){
            return updatingGUI(o);
        }
        return sucessor.updatingGUI(type,o);
    }
    public boolean deletingGUI(Class<?> type, Object o) {
        if(type == this.type){
            return deletingGUI(o);
        }
        return sucessor.deletingGUI(type,o);
    }
    
}
