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
	public ArrayList<Product> searchProduct(String searchTerm, int valueOfSlider) throws RemoteException {
		ArrayList<Product> lista = new ArrayList<>();
		switch (valueOfSlider) {
		case 0:
			for (Product product : products) {
				if (String.valueOf(product.getId()) != null && product.getId() == Integer.parseInt(searchTerm)) {
					lista.add(product);
				}
			}
			break;
		case 1:
			for (Product product : products) {
				if (product.getNazwa() != null && product.getNazwa().contains(searchTerm)) {
					lista.add(product);
				}
			}
			break;
		case 2:
			for (Product product : products) {
				if (String.valueOf(product.getCena()) != null && product.getCena() == Double.parseDouble(searchTerm)) {
					lista.add(product);
				}
			}
			break;
		case 3:
			for (Product product : products) {
				if (product.getProducent() != null && product.getProducent().contains(searchTerm)) {
					lista.add(product);
				}
			}
			break;
		case 4:
			for (Product product : products) {
				if (String.valueOf(product.getIloscWMagazynie()) != null
						&& product.getIloscWMagazynie() == Integer.parseInt(searchTerm)) {
					lista.add(product);
				}
			}
			break;
		default:
			break;
		}
		return lista;
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