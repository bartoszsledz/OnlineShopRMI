package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import interfacermi.RMIInterface;

public class RMIImplementation extends UnicastRemoteObject implements RMIInterface {

	private static final LoginInfo adminLoginInfo = new LoginInfo("admin", "admin123");
	private ArrayList<Customer> customers = new ArrayList<>();
	private ArrayList<Product> products = new ArrayList<>();
	private ArrayList<Order> orders = new ArrayList<>();

	private static final long serialVersionUID = 1L;

	protected RMIImplementation() throws RemoteException {
		super();
	}

	@Override
	public Product buyProduct() throws RemoteException {
		// DODAC
		return null;
	}

	@Override
	public void viewProduct(Product produkt) throws RemoteException {
		// DODAC

	}

	@Override
	public void viewProducts() throws RemoteException {
		// DODAC
	}

	@Override
	public Product addProduct(Product product) throws RemoteException {
		products.add(product);
		return product;
	}

	@Override
	public boolean checkAdmin(LoginInfo loginInfo) throws RemoteException {
		if (adminLoginInfo.equals(loginInfo)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean checkUser(LoginInfo loginInfo) throws RemoteException {
		for (Customer customer : customers) {
			if (loginInfo.getId().equals(customer.getId()) && loginInfo.getPass().equals(customer.getPassword())) {
				return true;
			}
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

	@Override
	public Customer getCustomer(String id) throws RemoteException {
		for (Customer customer : customers) {
			if (id.equals(customer.getId())) {
				return customer;
			}
		}
		return null;
	}

	@Override
	public ArrayList<Order> getOrders() throws RemoteException {
		return orders;
	}

	@Override
	public ArrayList<Product> getProducts() throws RemoteException {
		return products;
	}
}