/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package infra.persistence;

import infra.exceptions.ObjectIdNotFoundException;

/**
 *
 * @author carlosmagno
 */
public interface DAO {
    
    public int add(Object o, Class<?> type);
    public Object get(long id, Class<?> type) throws ObjectIdNotFoundException;
    public void update(long id, Class<?> type) throws ObjectIdNotFoundException;
    public void delet(long id, Class<?> type) throws ObjectIdNotFoundException;
    
}
