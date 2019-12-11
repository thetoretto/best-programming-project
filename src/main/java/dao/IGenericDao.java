/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Ntwali
 */
public interface IGenericDao <X> extends Remote{
    public void create(X x)throws RemoteException;
    public void Delete(X x)throws RemoteException;
    public void update(X x)throws RemoteException;
    public List<X> getAll(String str)throws RemoteException;
   public List<X> searchById(Class<X> c, Long id) throws RemoteException;
    public X searchById(Class<X> c, Serializable id) throws RemoteException;
}
