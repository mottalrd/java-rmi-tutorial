import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse{
    
	private static final long serialVersionUID = 1L;

	public WarehouseImpl() throws RemoteException
       {
               prices = new HashMap<String, Double>();
               prices.put("Blackwell Toaster", 24.95);
               prices.put("ZapXpress Microwave Oven", 49.95);
       }

       public double getPrice(String description) throws RemoteException
       {
               Double price = prices.get(description);
               return price == null ? 0 : price;
       }

       private Map<String, Double> prices;
}

