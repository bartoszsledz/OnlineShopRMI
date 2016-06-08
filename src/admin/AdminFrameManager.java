package admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import interfacermi.Configuration;
import interfacermi.RMIInterface;
import server.Customer;
import server.LoginInfo;
import server.Product;

public class AdminFrameManager implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean isAdmin = false;
	private DefaultTableModel model, model2;
	private AdminFrame adminFrame;
	RMIInterface server;

	public AdminFrameManager(AdminFrame clientFrame) {
		this.adminFrame = clientFrame;
		addButtonsListeners();
		createProductsTableModel();
		createCustomersTableModel();
	}

	public void addButtonsListeners() {
		przegladajBtnListener();
		loginBtnListener();
		addProductBtnListener();
		addUserBtnListner();
		refreshBtnListner();
	}

	private void connectToServer() {
		try {
			Registry registry = LocateRegistry.getRegistry(Configuration.REMOTE_HOST, Configuration.REMOTE_PORT);
			server = (RMIInterface) (registry.lookup(Configuration.REMOTE_ID));
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "Brak po³¹czenia z serverem.!");
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, "Z³e dane!");
		}
	}

	private void checkAdmin() {
		try {
			isAdmin = server.checkAdmin(new LoginInfo(adminFrame.getTxtUsername(), adminFrame.getPwdPassword()));
			if (isAdmin) {
				JOptionPane.showMessageDialog(null, "Zosta³eœ po³¹czony z serverem jako Admin!");
				adminFrame.setOffLoginBtn();
				adminFrame.setLoginTxtOff();
			} else {
				JOptionPane.showMessageDialog(null, "Z³e dane logowania.");
			}
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "Brak po³¹czenia z serverem.!");
		}
	}

	private void addUserBtnListner() {
		adminFrame.addUserBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Customer c = server
							.addCustomer(new Customer(adminFrame.getNewLogin(), adminFrame.getNewPassword()));
					refreshSelectedTable(model2);
					showCustomersInTable(server.getCustomers());
					JOptionPane.showMessageDialog(null, "Prawid³owo dodano u¿ytkownika: " + c.getId());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(null, "Taki u¿ytkownik ju¿ istnieje!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Zaloguj siê!");
				}
			}
		});
	}

	private void refreshBtnListner() {
		adminFrame.refreshBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAdmin) {
					refreshSelectedTable(model2);
					try {
						showCustomersInTable(server.getCustomers());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Brak zamówieñ!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Zaloguj siê!");
				}
			}
		});

	}

	private void przegladajBtnListener() {
		adminFrame.addShowProductsBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAdmin) {
					refreshSelectedTable(model);
					try {
						showProductsInTable(server.getProducts());
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Zaloguj siê!");
				}
			}
		});
	}

	private void loginBtnListener() {
		adminFrame.loginBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connectToServer();
				checkAdmin();
			}
		});
	}

	private void addProductBtnListener() {
		adminFrame.addDodajProduktBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Product p = server.addProduct(new Product(adminFrame.getTxtId(), adminFrame.getTxtNazwa(),
							adminFrame.getTxtProducent(), adminFrame.getTxtCena(), adminFrame.getTxtIlosc()));
					refreshSelectedTable(model);
					showProductsInTable(server.getProducts());
					adminFrame.setEmptyFields();
					JOptionPane.showMessageDialog(null, "Dodano produkt: " + p.getNazwa());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Zaloguj siê!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Taki produkt ju¿ istnieje w sklepie albo nie jesteœ zalogowany.");
				}
			}
		});
	}

	private void createProductsTableModel() {
		model = (DefaultTableModel) adminFrame.getTable().getModel();
	}

	private void createCustomersTableModel() {
		model2 = (DefaultTableModel) adminFrame.getTable2().getModel();
	}

	private void showProductsInTable(ArrayList<Product> list) {
		ArrayList<Product> listOfProducts = list;
		Object[] row = new Object[5];
		for (int i = 0; i < list.size(); i++) {
			row[0] = listOfProducts.get(i).getId();
			row[1] = listOfProducts.get(i).getNazwa();
			row[2] = listOfProducts.get(i).getCena();
			row[3] = listOfProducts.get(i).getProducent();
			row[4] = listOfProducts.get(i).getIloscWMagazynie();
			model.addRow(row);
		}
	}

	private void showCustomersInTable(ArrayList<Customer> list) throws Exception {
		ArrayList<Customer> listOfCustomers = list;
		Object[] row = new Object[3];
		for (int i = 0; i < list.size(); i++) {
			row[0] = listOfCustomers.get(i).getId();
			row[1] = listOfCustomers.get(i).getPassword();
			row[2] = listOfCustomers.get(i).getUserOrders();
			model2.addRow(row);
			System.out.println("Zamówienia u¿ytkownika: " +listOfCustomers.get(i).getId() +" to: " + listOfCustomers.get(i).getUserOrders());
		}
	}

	private void refreshSelectedTable(DefaultTableModel model) {
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
	}
}