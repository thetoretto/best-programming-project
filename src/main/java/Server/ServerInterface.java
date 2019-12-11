package Server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ServerInterface<X> extends Remote {
     public void create(X x)throws RemoteException;
    public void Delete(X x)throws RemoteException;
    public void update(X x)throws RemoteException;
    public List<X> getAll(String str)throws RemoteException;
    public X searchById(Class<X> c, Serializable id) throws RemoteException;
}
