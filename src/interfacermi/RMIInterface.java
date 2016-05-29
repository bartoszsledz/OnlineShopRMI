package interfacermi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.Customer;
import server.LoginInfo;
import server.Order;
import server.Product;

public interface RMIInterface extends Remote {
	public ArrayList<Product> getProducts() throws RemoteException;

	public Product buyProduct() throws RemoteException;

	public void viewProduct(Product produkt) throws RemoteException;

	public void viewProducts() throws RemoteException;
	
	public boolean checkAdmin(LoginInfo loginInfo) throws RemoteException;
	
	public boolean checkUser(LoginInfo loginInfo) throws RemoteException;

	public Product addProduct(Product product) throws RemoteException;
	
	public Customer addCustomer(Customer customer) throws RemoteException;

	public ArrayList<Customer> getCustomers() throws RemoteException;

	public ArrayList<Order> getOrders() throws RemoteException;
	
	public Customer getCustomer(String id) throws RemoteException;
}