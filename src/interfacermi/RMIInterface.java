package interfacermi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.Customer;
import server.LoginInfo;
import server.Order;
import server.Product;

public interface RMIInterface extends Remote {
	ArrayList<Product> getProducts() throws RemoteException;

	void addProductsOnStart() throws RemoteException;

	boolean checkAdmin(LoginInfo loginInfo) throws RemoteException;

	boolean checkUser(LoginInfo loginInfo) throws RemoteException;

	Product addProduct(Product product) throws RemoteException, Exception;

	Customer addCustomer(Customer customer) throws RemoteException, Exception;

	ArrayList<Customer> getCustomers() throws RemoteException;

	ArrayList<Order> getOrders() throws RemoteException;

	Customer getCustomer(String id) throws RemoteException;

	ArrayList<Product> searchProduct(String searchTerm, int valueOfSlider) throws RemoteException;

	Order addToCartProduct(Object object, String customerId) throws RemoteException, Exception;

	ArrayList<Order> deleteFromCart() throws RemoteException;
}