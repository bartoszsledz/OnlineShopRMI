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
import interfacermi.RemoteInterface;
import server.Customer;
import server.LoginInfo;
import server.Product;

public class AdminFrameManager implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean isAdmin = false;
	private DefaultTableModel model, model2;
	private AdminFrame clientFrame;
	RemoteInterface server;

	public AdminFrameManager(AdminFrame clientFrame) {
		this.clientFrame = clientFrame;
		addButtonsListeners();
	}

	public void addButtonsListeners() {
		przegladajBtnListener();
		loginBtnListener();
		addProductBtnListener();
		addUserBtnListner();
		refreshBtnListner();
	}

	private void connecttoServer() {
		try {
			Registry registry = LocateRegistry.getRegistry(Configuration.REMOTE_HOST, Configuration.REMOTE_PORT);
			server = (RemoteInterface) (registry.lookup(Configuration.REMOTE_ID));
		} catch (AccessException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, "Z³e dane!");
			e.printStackTrace();
		}
	}

	private void checkUser() {
		try {
			isAdmin = server.checkUser(new LoginInfo(clientFrame.getTxtUsername(), clientFrame.getPwdPassword()));
			if (isAdmin) {
				JOptionPane.showMessageDialog(null, "Zosta³eœ po³¹czony z serverem jako Admin!");
			} else {
				JOptionPane.showMessageDialog(null, "Z³e dane logowania.");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void addUserBtnListner() {
		clientFrame.addUserBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Customer c = server
							.addCustomer(new Customer(clientFrame.getNewLogin(), clientFrame.getNewPassword()));
					JOptionPane.showMessageDialog(null, "Prawid³owo dodano u¿ytkownika: " + c.getId());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	private void refreshBtnListner() {
		clientFrame.refreshBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createCustomersTableModel();
				refreshSelectedTable(model2);
				showCustomersInTable();
			}
		});

	}

	private void przegladajBtnListener() {
		clientFrame.addShowProductsBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isAdmin) {
					createProductsTableModel();
					refreshSelectedTable(model);
					showProductsInTable();
				} else {
					JOptionPane.showMessageDialog(null, "Zaloguj siê!");
				}
			}
		});
	}

	private void loginBtnListener() {
		clientFrame.addLoginBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				connecttoServer();
				checkUser();
			}
		});
	}

	private void addProductBtnListener() {
		clientFrame.addDodajProduktBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Product p = server.addProduct(new Product(clientFrame.getTxtId(), clientFrame.getTxtNazwa(),
							clientFrame.getTxtProducent(), clientFrame.getTxtCena(), clientFrame.getTxtIlosc()));
					JOptionPane.showMessageDialog(null, "Dodano produkt: " + p.getNazwa());
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Poda³eœ b³êdne dane albo nie jesteœ zalogowany.");
				}
			}
		});
	}

	private void createProductsTableModel() {
		model = (DefaultTableModel) clientFrame.getTable().getModel();
	}

	private void createCustomersTableModel() {
		model2 = (DefaultTableModel) clientFrame.getTable2().getModel();
	}

	private void showProductsInTable() {
		try {
			ArrayList<Product> list = server.getProducts();
			Object[] row = new Object[5];
			for (int i = 0; i < list.size(); i++) {
				row[0] = list.get(i).getId();
				row[1] = list.get(i).getNazwa();
				row[2] = list.get(i).getCena();
				row[3] = list.get(i).getProducent();
				row[4] = list.get(i).getIloscWMagazynie();
				model.addRow(row);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void showCustomersInTable() {
		try {
			ArrayList<Customer> list = server.getCustomers();
			Object[] row = new Object[3];
			for (int i = 0; i < list.size(); i++) {
				row[0] = list.get(i).getId();
				row[1] = list.get(i).getPassword();
				row[2] = list.get(i).getOrders();
				model2.addRow(row);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
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