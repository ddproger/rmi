package ua.kh.gerasimyuk.learn.rmi;


import ua.kh.gerasimyuk.learn.rmi.Interfaces.Warehouse;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * Created by gerasymiuk on 16.01.17.
 */
public class ClientMain {
    public static void main(String[] args) throws RemoteException, NamingException {
        Context naming = new InitialContext();
        Enumeration<NameClassPair> e = naming.list("rmi://localhost/");
        while (e.hasMoreElements()){
            System.out.println(e.nextElement().getName());

            String url = "rmi://localhost/central_warehouse";
            Warehouse central = (Warehouse)naming.lookup(url);
            String descr = "Blackwall";
            double price = central.getPrice(descr);
            System.out.println(price);
        }

    }
}
