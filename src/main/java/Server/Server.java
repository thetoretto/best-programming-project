package Server;

import dao.GenericDao;
import dao.IGenericDao;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public Server(int port) throws RemoteException, AlreadyBoundException {
        IGenericDao genericDao=new GenericDao();
        // remote = (IGenericDao) UnicastRemoteObject.exportObject((Remote) genericDao, 0);
        final Registry registry = LocateRegistry.getRegistry(port);
        //.rebind("Service", (Remote) remote);
        System.err.println("Server is running");
    }
    
    public static void main(String []args) throws Exception {
        new Server(Integer.parseInt(args[0]));
    }
}
