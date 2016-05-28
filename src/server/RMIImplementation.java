package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfacermi.RemoteInterface;

public class RMIImplementation extends UnicastRemoteObject implements RemoteInterface {

	private static final LoginInfo adminLoginInfo = new LoginInfo("admin", "admin123");
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	protected RMIImplementation() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<Product> getProducts() throws RemoteException {
		return products;
	}

	@Override
	public Product buyProduct() throws RemoteException {
		return null;
	}

	@Override
	public void viewProduct(Product produkt) throws RemoteException {
		// TODO Auto-generated method stub

	}

	@Override
	public void viewProducts() throws RemoteException {

	}

	@Override
	public Product addProduct(Product product) throws RemoteException {
		products.add(product);
		return product;
	}

	@Override
	public boolean checkUser(LoginInfo loginInfo) throws RemoteException {
		if (adminLoginInfo.equals(loginInfo)) {
			return true;
		}
		return false;
	}

	@Override
	public Customer addCustomer(Customer customer) throws RemoteException {
		customers.add(customer);
		return customer;
	}
	
	@Override
	public ArrayList<Customer> getCustomers() throws RemoteException {
		return customers;
	}
}