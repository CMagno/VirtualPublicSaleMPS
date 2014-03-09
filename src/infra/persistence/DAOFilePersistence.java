/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra.persistence;

import GUI.GUIGraphicalPopupWindow;
import infra.Exception.ObjectIdNotFoundException;
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
public class DAOFilePersistence implements DAO{
    
    private final static String ID_REFERENCE_FILE;
    private final static Map<Class<?>, String> fileNameMap = new HashMap<Class<?>, String>();
    static{
        ID_REFERENCE_FILE = "lastID.dat";
        fileNameMap.put(Client.class, "clients.dat");
        fileNameMap.put(Product.class, "produts.dat");
        fileNameMap.put(PublicSale.class, "psales.dat");
        fileNameMap.put(Deal.class, "deals.dat");
    }
    
    private static DAOFilePersistence dao;
    
    private DAOFilePersistence(){}
    
    public static DAOFilePersistence getInstance(){
        if(dao == null){
            return new DAOFilePersistence();
        }
        return dao;
    }

    @Override
    public int add(Object o, Class<?> type) {
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
    
    private static long getCurrentId() throws FileNotFoundException, IOException{
        long id;
        DataInputStream dos = new DataInputStream(new FileInputStream(new File(ID_REFERENCE_FILE)));
        DataOutputStream dis = new DataOutputStream(new FileOutputStream(new File(ID_REFERENCE_FILE),false));
        id = dos.readLong();
        dos.close();
        dis.writeLong(id + 1);
        dis.close();
        return id;
    }
}
