package client;

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
import server.LoginInfo;
import server.Product;

public class ClientFrameManager implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean isUser = false;
	private DefaultTableModel model;
	private ClientFrame clientFrame;
	RMIInterface server;

	public ClientFrameManager(ClientFrame clientFrame) {
		this.clientFrame = clientFrame;
		addButtonsListeners();
		createProductsTableModel();
	}

	private void addButtonsListeners() {
		loginBtnListener();
		showAllPRoductsListener();
		searchBtnListener();
	}

	private void connectToServer() {
		try {
			Registry registry = LocateRegistry.getRegistry(Configuration.REMOTE_HOST, Configuration.REMOTE_PORT);
			server = (RMIInterface) (registry.lookup(Configuration.REMOTE_ID));
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
			isUser = server.checkUser(new LoginInfo(clientFrame.getTxtUsername(), clientFrame.getPwdPassword()));
			if (isUser) {
				JOptionPane.showMessageDialog(null, "Zosta³eœ po³¹czony z serverem jako U¿ytkownik!");
				clientFrame.setOffLoginBtn();
			} else {
				JOptionPane.showMessageDialog(null, "Brak takiego u¿ytkownika!");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	private void loginBtnListener() {
		clientFrame.loginBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				connectToServer();
				checkUser();
			}
		});
	}

	private void showAllPRoductsListener() {
		clientFrame.showAllProductsBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isUser) {
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

	private void searchBtnListener() {
		clientFrame.searchBtnActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				refreshSelectedTable(model);
				try {
					showProductsInTable(server.searchProduct(clientFrame.getTxtSearch(), clientFrame.getSliderValue()));
				} catch (RemoteException e1) {
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Z³y format!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Zaloguj siê!");
				}
			}
		});
	}

	private void createProductsTableModel() {
		model = (DefaultTableModel) clientFrame.getTable().getModel();
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

	private void refreshSelectedTable(DefaultTableModel model) {
		if (model.getRowCount() > 0) {
			for (int i = model.getRowCount() - 1; i > -1; i--) {
				model.removeRow(i);
			}
		}
	}

}