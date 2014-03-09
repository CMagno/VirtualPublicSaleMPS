/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra.Exception;

import java.util.HashMap;
import java.util.Map;
import logic.pojos.*;

/**
 *
 * @author carlosmagno
 */
public class ObjectIdNotFoundException extends Exception {
    
    private static Map nameMap = new HashMap<Class<?>,String>();
    static{
        nameMap.put(Client.class, "Cliente");
        nameMap.put(Product.class, "Produto");
        nameMap.put(PublicSale.class, "Leilão");
        nameMap.put(Deal.class, "Negócio");
    }
    public ObjectIdNotFoundException(Class<?> t, long id){
        super("Não foi encontrado uma entidade " + nameMap.get(t) + "com ID igual a " + id + ".");
    }
    
}
