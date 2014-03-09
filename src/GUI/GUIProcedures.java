/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.util.HashMap;
import java.util.Map;
import logic.pojos.*;

/**
 *
 * @author carlosmagno
 */
public interface GUIProcedures {
    
    public static final HashMap<Class<?>,String> typeNameMap = new HashMap<Class<?>,String>(){{
        put(Client.class, "Cliente");
        put(Product.class, "Produto");
        put(PublicSale.class, "Leilão");
        put(Deal.class, "Negócio");
    }};
    
    public int displayMenu();
    
    /*REALIZA AS REQUISIÇÕES DOS DADOS E RETORNA UM OBJETO PRONTO*/
    public Client clientRegisteringGUI();
    public Product productRegisteringGUI();
    public PublicSale pSaleRegisteringGUI();
    public Deal dealRegisteringGUI();
    
    /*REQUISITA UM ID PARA O USUÁRIO E RETORNA-O
      O TIPO SERVE PARA EXIBIR A MENSSAGEM CORRETA*/
    public long idRequestGUI(Class<?> type);
    
    /*RECEBE UM OBJETO E EXIBI OS DADOS DELE DE FORMA APROPRIADA
      USADO PARA RETORNAR AO CLIENTE O ID DE UM OBJETO CRIADO*/
    public void clientViewingGUI(Client c);
    public void productViewingGUI(Product p);
    public void pSaleViewingGUI(PublicSale ps);
    public void dealViewingGUI(Deal d);
    
    /*RECEBE UM OBJETO PARA EXBIR O QUE SERÁ EDITADO E RETORNA-O EDITADO*/
    public Client clientUpdatingGUI(Client c);
    public Product productUpdatingGUI(Product p);
    public PublicSale pSaleUpdatingGUI(PublicSale ps);
    public Deal dealUpdatingGUI(Deal d);
    
    /*RECEBE UM OBJETO PARA EXIBIR IFORMAR O USUÁRIO O QUE SERÁ APAGADO
      RETORNA UM BOOLEAN DE CONFIRMAÇÃO
      O DAO QUE É O RESPONSÁVEL POR APAGAR*/
    public boolean clientDeletingGUI(Client c);
    public boolean productDeletingGUI(Product p);
    public boolean pSaleDeletingGUI(PublicSale ps);
    public boolean dealDeletingGUI(Deal d);
    
    /*EXIBE UMA MENSSAGEM INFORMANDO SUCESSO NA OPERAÇÃO
      MENSSAGEM GENÉRICA*/
    public void operationSucessGUI();
    /*EXIBE A MENSSAGEM DE ERRO*/
    public void operationFailedGUI(String erro);
}
