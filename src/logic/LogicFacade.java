/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

import GUI.GUIAbsTemplate;
import GUI.GUIFactory;
import infra.exceptions.ObjectIdNotFoundException;
import infra.persistence.DAOTemplate;
import infra.persistence.DAOFactory;
import logic.pojos.*;

/**
 *
 * @author carlosmagno
 */
public class LogicFacade {
    
    private static GUIAbsTemplate gui;
    private static DAOTemplate dao;
    private static LogicFacade logic;
    
    // PROCEDURES ID's
    final int CLIENT_REGISTERING = 0,
            PRODUCT_REGISTERING = 1,
            PSALE_REGISTERING = 2,
            DEAL_REGISTERING = 3,
            CLIENT_VIEW = 4,
            PRODUCT_VIEW = 5,
            PSALE_VIEW = 6,
            DEAL_VIEW = 7,
            CLIENT_UPDATE = 8,
            PRODUCT_UPDATE = 9,
            PSALE_UPDATE = 10,
            DEAL_UPDATE = 11,
            CLIENT_DELETE = 12,
            PRODUCT_DELETE = 13,
            PSALE_DELETE = 14,
            DEAL_DELETE = 15,
            EXIT= 16;
    
    public static LogicFacade getInstance(){
        if(logic == null){
            gui = GUIFactory.getInstance();
            dao = DAOFactory.getInstance();
            logic = new LogicFacade(gui, dao);
            return logic;
        }
        return logic;
    }
    
    private LogicFacade(GUIAbsTemplate gui, DAOTemplate dao){
        LogicFacade.gui = gui;
        LogicFacade.dao = dao;
    }
    
    private void callProcedures(int type){
        switch(type){
            case 0:
                Client c = (Client)gui.registeringGUI(Client.class);
                dao.add(c, Client.class);
                gui.operationSucessGUI();
                gui.viewingGUI(Client.class,c);
                break;
            case 1:
                Product p = (Product)gui.registeringGUI(Product.class);
                dao.add(p, Product.class);
                gui.operationSucessGUI();
                break;
            case 2:
                PublicSale ps = (PublicSale)gui.registeringGUI(PublicSale.class);
                dao.add(ps, PublicSale.class);
                gui.operationSucessGUI();
                break;
            case 3:
                Deal d = (Deal)gui.registeringGUI(Deal.class);
                dao.add(d, Deal.class);
                gui.operationSucessGUI();
                break;
            case 4:
                try {
                    Client cview = (Client)dao.get(gui.idRequestGUI(Client.class), Client.class);
                    gui.viewingGUI(Client.class, cview);
                } catch (ObjectIdNotFoundException ex) {
                    gui.operationFailedGUI(ex.getMessage());
                }
                break;
            case 5:
                try {
                    Product pview = (Product)dao.get(gui.idRequestGUI(Product.class), Product.class);
                    gui.viewingGUI(Product.class, pview);
                } catch (ObjectIdNotFoundException ex) {
                    gui.operationFailedGUI(ex.getMessage());
                }
                break;
            case 6:
                try {
                    PublicSale psview = (PublicSale)dao.get(gui.idRequestGUI(PublicSale.class), PublicSale.class);
                    gui.viewingGUI(PublicSale.class, psview);
                } catch (ObjectIdNotFoundException ex) {
                    gui.operationFailedGUI(ex.getMessage());
                }
                break;
            case 7:
                try {
                    Deal dview = (Deal)dao.get(gui.idRequestGUI(Deal.class), Deal.class);
                    gui.viewingGUI(PublicSale.class, dview);
                } catch (ObjectIdNotFoundException ex) {
                    gui.operationFailedGUI(ex.getMessage());
                }
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                break;
            case 12:
                break;
            case 13:
                break;
            case 14:
                break;
            case 15:
                break;
            case 16:
                System.exit(0);
            default:
                break;
        }
    }
    
    public void mainLoop(){
        while(true){
            callProcedures(gui.displayMenu());
        }
    }
    
    public static void main(String args[]){
        LogicFacade logicEngine = LogicFacade.getInstance();
        logicEngine.mainLoop();
    }
}
