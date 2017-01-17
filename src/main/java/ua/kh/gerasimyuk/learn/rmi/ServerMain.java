package ua.kh.gerasimyuk.learn.rmi;

import ua.kh.gerasimyuk.learn.rmi.Classes.WarehouseImpl;
import ua.kh.gerasimyuk.learn.rmi.Interfaces.Warehouse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by gerasymiuk on 16.01.17.
 */
public class ServerMain {
    public static void main(String[] args) throws RemoteException, NamingException {
        Warehouse centralWarehouse = new WarehouseImpl();
        Registry reg = LocateRegistry.createRegistry(1099);
        Context namingContext = new InitialContext();
        try {
            namingContext.bind("rmi://localhost:1099/central_warehouse", centralWarehouse);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
