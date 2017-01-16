package ua.kh.gerasimyuk.learn.rmi.Interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by gerasymiuk on 16.01.17.
 */
public interface Warehouse extends Remote {
    double getPrice(String description) throws RemoteException;
}
