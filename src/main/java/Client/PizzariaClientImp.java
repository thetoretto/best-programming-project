/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Ntwali
 */
public class PizzariaClientImp extends UnicastRemoteObject implements PizzeriaClientInterface{

    public PizzariaClientImp() throws RemoteException{
        super();
    }

    @Override
    public String notifyClient(String message) throws RemoteException {
        System.out.println(message+". Message Received");
        return message+". Message Received";
    }
}
