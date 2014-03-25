/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra.persistence;

import infra.exceptions.ObjectIdNotFoundException;
import java.util.HashMap;
import java.util.Map;
import logic.pojos.*;

/**
 *
 * @author carlosmagno
 */
public class DAOMemoryPersistence implements DAOTemplate{
    
    private static DAOMemoryPersistence dao;
    private static long lastId;
    private static HashMap<Long, Pojo> mapCli, mapProd, mapPSale, mapDeal;
    private static HashMap<Class<?>, HashMap<Long, Pojo>> mapType = new HashMap<>();
    static{
        mapCli = new HashMap<>();
        mapProd = new HashMap<>();
        mapPSale = new HashMap<>();
        mapDeal = new HashMap<>();
        mapType.put(Client.class, mapCli);
        mapType.put(Product.class, mapProd);
        mapType.put(PublicSale.class, mapPSale);
        mapType.put(Deal.class, mapDeal);
    }
    
    private DAOMemoryPersistence(){
    }
    
    public static DAOMemoryPersistence getInstance(){
        if(dao == null){
            dao = new DAOMemoryPersistence();
            return dao;
        }
        return dao;
    }
    
    @Override
    public void add(Object o, Class<?> type) {
        long id = lastId++;
        ((Pojo)o).setId(id);
        ((HashMap)mapType.get(type)).put(id , (type.cast(o)));
    }

    @Override
    public Object get(long id, Class<?> type) throws ObjectIdNotFoundException {
        return ((HashMap)mapType.get(type)).get(id);
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
