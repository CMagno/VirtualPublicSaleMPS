/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra.persistence;

import infra.exceptions.ObjectIdNotFoundException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import logic.pojos.*;

/**
 *
 * @author carlosmagno
 */
public class DAOMemoryPersistence implements DAO{
    
    private static DAOMemoryPersistence dao;
    private static long lastId;
    private static Map mapCli, mapProd, mapPSale, mapDeal;
    private static final Map mapType = new HashMap<Class<?>, HashMap<Long, Object>>();
    static{
        mapType.put(Client.class, mapCli);
        mapType.put(Product.class, mapProd);
        mapType.put(PublicSale.class, mapPSale);
        mapType.put(Deal.class, mapDeal);
    }
    
    private DAOMemoryPersistence(){
        mapCli = new HashMap<Long, Client>();
        mapProd = new HashMap<Long, Product>();
        mapPSale = new HashMap<Long, PublicSale>();
        mapDeal = new HashMap<Long, Deal>();
    }
    
    public static DAOMemoryPersistence getInstance(){
        if(dao == null){
            dao = new DAOMemoryPersistence();
            return dao;
        }
        return dao;
    }
    
    @Override
    public int add(Object o, Class<?> type) {
        ((HashMap)mapType.get(type)).put(lastId++, (type.cast(o)));
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object get(long id, Class<?> type) throws ObjectIdNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(long id, Class<?> type) throws ObjectIdNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delet(long id, Class<?> type) throws ObjectIdNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static long getCurrentId(){
        return lastId++;
    }
}
