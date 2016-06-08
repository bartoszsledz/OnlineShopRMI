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
		addProductsOnStart();
	}

	@Override
	public Order addToCartProduct(Object object, String customerId) throws RemoteException, Exception {
		int productId = (int) object;
		for (Product p : products) {
			if (p.getId() == productId) {
				for (Customer c : customers) {
					if (c.getId().equals(customerId)) {
						if (p.getIloscWMagazynie() > 1) {
							int i = p.getIloscWMagazynie();
							i--;
							p.setIloscWMagazynie(i);
							Order order = new Order(p.getId(), p.getNazwa(), p.getProducent(), p.getCena(),
									p.getIloscWMagazynie());
							c.addUserOrders(order);
							orders.add(order);
							return order;
						} else if (p.getIloscWMagazynie() == 1) {
							Order order = new Order(p.getId(), p.getNazwa(), p.getProducent(), p.getCena(),
									p.getIloscWMagazynie());
							c.addUserOrders(order);
							orders.add(order);
							products.remove(p);
							return order;
						}
					}
				}
			}
		}
		throw new Exception();
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
				if (product.getNazwa() != null && product.getNazwa().toLowerCase().contains(searchTerm.toLowerCase())) {
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
				if (product.getProducent() != null
						&& product.getProducent().toLowerCase().contains(searchTerm.toLowerCase())) {
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
	public void addProductsOnStart() throws RemoteException {
		products.add(new Product(1, "Myszka", "Samsung", 15.50, 55));
		products.add(new Product(2, "Klawiatura", "S", 19.80, 15));
		products.add(new Product(3, "Monitor", "Benq", 700, 8));
		products.add(new Product(50, "Procesor", "Intel", 900.99, 5));
		products.add(new Product(885, "Dysk 2T", "Samsung", 249.99, 50));
		products.add(new Product(886, "Dysk 1T", "Toshiba", 149.99, 30));
		products.add(new Product(8, "G³oœniki", "Trust", 155.50, 155));
		products.add(new Product(555, "Karta graficzna", "Gigabyte", 1999.99, 2));
		products.add(new Product(98, "S³uchawki", "Sony", 70, 110));
		products.add(new Product(55, "Gamepad", "Microsoft", 149.99, 40));
		customers.add(new Customer("user", "user123"));
	}

	@Override
	public Product addProduct(Product product) throws RemoteException, Exception {
		if (!products.contains(product)) {
			products.add(product);
			return product;
		}
		throw new Exception();
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
	public Customer addCustomer(Customer customer) throws RemoteException, IllegalArgumentException, Exception {
		if (!customers.contains(customer)) {
			customers.add(customer);
			return customer;
		}
		throw new IllegalArgumentException();
	}

	@Override
	public ArrayList<Order> deleteFromCart() throws RemoteException {
		for (Order o : orders) {
			orders.remove(orders.indexOf(o));
			return orders;
		}
		return orders;
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