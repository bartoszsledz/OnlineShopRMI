package server;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String password;
	private ArrayList<Order> orders = new ArrayList<>();

	public Customer(String id, String password) {
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public ArrayList<String> getUserOrders() throws Exception {
		ArrayList<String> listNameOrder = new ArrayList<>();
		for (Order o : orders) {
			listNameOrder.add(o.getNazwa());
		}
		return listNameOrder;
	}

	public void addUserOrders(Order order) {
		this.orders.add(order);
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", password=" + password + ", orders=" + orders + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}