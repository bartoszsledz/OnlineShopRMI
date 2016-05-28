package server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import interfacermi.Configuration;

public class ServerMain {
	public static void main(String[] args) throws Exception {
		try {
			//System.setSecurityManager(new SecurityManager());
			Registry registry = LocateRegistry.createRegistry(Configuration.REMOTE_PORT);
			registry.rebind(Configuration.REMOTE_ID, new RMIImplementation());
			System.out.println("Server started !");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}