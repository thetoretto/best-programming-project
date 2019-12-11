/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.PizzaConfig;
import Model.Util;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author root
 */

public class GenericDao<X> implements IGenericDao<X>{

    public void create(X x){
       Session ss = Util.sessionFactory.openSession();
       Transaction tx = ss.beginTransaction();
       ss.save(x);
       tx.commit();
       ss.close();
    }

    /**
     *
     * @param x
     * @throws Exception
     */
    @Override
    public void Delete(X x)throws RemoteException{
       Session ss=Util.sessionFactory.openSession();
       Transaction tx = ss.beginTransaction();
       ss.delete(x);
       tx.commit();
       ss.close();
        
    }
    @Override
    public void update(X x)throws RemoteException{
       Session ss=Util.sessionFactory.openSession();
        Transaction tx = ss.beginTransaction();
       ss.update(x);
       tx.commit();
       ss.close();
        
    }
    @Override
    public List<X> getAll(String str)throws RemoteException{
		Session ss = Util.sessionFactory.openSession();
		return ss.createQuery("From "+str).list();
	}
    
    @Override
    public List<X> searchById(Class<X> c, Long id) throws RemoteException{
		Session ss = Util.sessionFactory.openSession();
		Query q=ss.createQuery("from "+c.getName()+" where id=:d");
                q.setLong("d", id);
                List<X> list=q.list();
                ss.close();
		return list;
	}
    
    public List<X> searchByName(Class<X> c, String name)throws RemoteException {
		Session ss = Util.sessionFactory.openSession();
		Query q=ss.createQuery("from "+c.getName()+" where name=:d");
                q.setString("d", name);
                List<X> list=q.list();
                ss.close();
		return list;
	}

    @Override
    public X searchById(Class<X> c, Serializable id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
