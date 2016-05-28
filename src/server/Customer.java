package server;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String password;
	private ArrayList<Order> orders;

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

	public ArrayList<Order> getOrders() {
		return orders;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", password=" + password + ", orders=" + orders + "]";
	}
}