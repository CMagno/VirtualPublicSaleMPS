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
    
    public static final Map typeNameMap = new HashMap<Class<?>,String>(){{
        put(Client.class, "Cliente");
        put(Product.class, "Produto");
        put(PublicSale.class, "Leilão");
        put(Deal.class, "Negócio");
    }};
    
    public int displayMenu();
    
    public Client clientRegisteringGUI();
    public Product productRegisteringGUI();
    public PublicSale pSaleRegisteringGUI();
    public Deal dealRegisteringGUI();
    
    public long idRequestGUI(Class<?> type);
    
    public void clientViewingGUI(Client c);
    public void productViewingGUI(Product p);
    public void pSaleViewingGUI(PublicSale ps);
    public void dealViewingGUI(Deal d);
    
    public Client clientUpdatingGUI(Client c);
    public Product productUpdatingGUI(Product p);
    public PublicSale pSaleUpdatingGUI(PublicSale ps);
    public Deal dealUpdatingGUI(Deal d);
    
    public void clientDeletingGUI(Client c);
    public void productDeletingGUI(Product p);
    public void pSaleDeletingGUI(PublicSale ps);
    public void dealDeletingGUI(Deal d);
    
    public void operationSucessGUI();
    public void operationFailedGUI(String erro);
}
