/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Ntwali
 */
public interface PizzeriaClientInterface extends Remote {
    public String notifyClient(String message) throws RemoteException;
}

