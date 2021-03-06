import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class WarehouseServer {
	public static void main(String[] args) throws Exception {

		System.out.println("Constructing server implementation...");
		WarehouseImpl centralWarehouse = new WarehouseImpl();

		//Codebase is passed by argument to the virtual machine, an alternative method is the following
		//System.setProperty("java.rmi.server.codebase", "http://localhost:8080/bin/");
		System.out.println("Shared codebase can be found at...");
		System.out.println(System.getProperty("java.rmi.server.codebase"));
		
		System.out.println("Binding server implementation to registry...");
		//The registry must be online on localhost:1099
		//An alternative method would be to create the registry here using the createRegistry() method
		Registry registry = LocateRegistry.getRegistry();		
		registry.bind("central_warehouse", centralWarehouse);
		
		System.out.println("Waiting for invocations from clients...");
	}
}
