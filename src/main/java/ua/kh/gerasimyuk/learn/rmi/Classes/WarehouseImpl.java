package ua.kh.gerasimyuk.learn.rmi.Classes;

import ua.kh.gerasimyuk.learn.rmi.Interfaces.Warehouse;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by gerasymiuk on 16.01.17.
 */
public class WarehouseImpl extends UnicastRemoteObject implements Warehouse {
    private Map<String,Double> prices;
    public WarehouseImpl() throws RemoteException {
        prices = new HashMap<>();
        prices.put("Blackwall", 24.55);
        prices.put("ZapXpress", 101.2);

    }

    @Override
    public double getPrice(String description) throws RemoteException {
        Double price = prices.get(description);
        return price == null?0:price;
    }
}
