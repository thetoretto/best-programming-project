/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Server.ServerInterface;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Ntwali
 */
public class PizzaClient {
        public static void main(String []args) throws RemoteException, NotBoundException, MalformedURLException {
        String host = args[0];
        final Registry registry = LocateRegistry.getRegistry(host,Integer.parseInt(args[1]));
        ServerInterface inter = (ServerInterface)registry.lookup("Service");
        
        PizzeriaClientInterface client=new PizzariaClientImp();
    
        System.out.println("Client Registered.");
        while(true){

        }
    }
}
