import java.rmi.*;
import java.rmi.server.*;
import java.util.*;

public class WarehouseImpl extends UnicastRemoteObject implements Warehouse{

	private static final long serialVersionUID = 1L;
	private Map<String, Product> products;
      private Product backup;

       public WarehouseImpl(Product backup) throws RemoteException{
               products = new HashMap<String, Product>();
               this.backup = backup;
       }

      public void add(String keyword, Product product){
               product.setLocation(this);
               products.put(keyword, product);
       }

       public double getPrice(String description) throws RemoteException{
               for (Product p : products.values())
                       if (p.getDescription().equals(description)) return p.getPrice();
               if (backup == null) return 0;
               else return backup.getPrice();
       }

       public Product getProduct(List<String> keywords) throws RemoteException{
               for (String keyword : keywords){
                       Product p = products.get(keyword);
                       if (p != null) return p;
               }
               return backup;
       }
}
