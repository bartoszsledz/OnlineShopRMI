package client;

import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ClientFrame implements Serializable{
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane, scrollPane2;
	private JTable table, table2;
	private DefaultTableModel model, model2;
	private JButton searchBtn, loginBtn, refreshBtn, showAllProducts;
	private JTextField txtSearch, txtUsername;
	private JPasswordField txtPassword;
	private JLabel shopLabel, loginLabel, passwordLabel, cartLabel;
	private JButton buyBtn;

	public ClientFrame() {
		initialize();
	}

	public void initialize() {
		createAllComponents();
		frameSettings();
		labelSettings();
		buttonsSettings();
		txtSettings();
		tableSettings();
	}

	private void createAllComponents() {
		frame = new JFrame("Online Shop");
		panel = new JPanel();
		model = new DefaultTableModel();
		model2 = new DefaultTableModel();
		table = new JTable(model);
		table2 = new JTable(model2);
		scrollPane = new JScrollPane();
		scrollPane2 = new JScrollPane();
	}

	private void frameSettings() {
		frame.setContentPane(panel);
		frame.getContentPane().add(scrollPane);
		frame.getContentPane().add(scrollPane2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 650, 600);
		frame.getContentPane().setLayout(null);
	}

	private void labelSettings() {
		shopLabel = new JLabel("Sklep");
		shopLabel.setBounds(10, 11, 46, 15);
		panel.add(shopLabel);

		cartLabel = new JLabel("Koszyk");
		cartLabel.setBounds(10, 309, 76, 15);
		panel.add(cartLabel);

		loginLabel = new JLabel("Login: ");
		loginLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		loginLabel.setBounds(232, 11, 46, 15);
		panel.add(loginLabel);

		passwordLabel = new JLabel("Has\u0142o:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(384, 11, 46, 15);
		panel.add(passwordLabel);
	}

	private void tableSettings() {
		model.addColumn("Id");
		model.addColumn("Nazwa");
		model.addColumn("Cena");
		model.addColumn("Producent");
		model.addColumn("Ilosc");
		table.setEnabled(false);
		scrollPane.setBounds(10, 35, 615, 165);
		scrollPane.setViewportView(table);

		model2.addColumn("Id");
		model2.addColumn("Nazwa");
		model2.addColumn("Cena");
		model2.addColumn("Producent");
		model2.addColumn("Ilosc");
		table2.setEnabled(false);
		scrollPane2.setBounds(10, 335, 615, 182);
		scrollPane2.setViewportView(table2);
	}

	private void buttonsSettings() {
		searchBtn = new JButton("Szukaj");
		searchBtn.setBounds(232, 211, 110, 25);
		panel.add(searchBtn);

		loginBtn = new JButton("Zaloguj");
		loginBtn.setBounds(536, 6, 89, 25);
		panel.add(loginBtn);

		refreshBtn = new JButton("Od\u015Bwie\u017C");
		refreshBtn.setBounds(10, 527, 120, 23);
		panel.add(refreshBtn);
		
		showAllProducts = new JButton("Poka\u017C wszystkie");
		showAllProducts.setBounds(485, 211, 140, 25);
		panel.add(showAllProducts);
		
		buyBtn = new JButton("Kup");
		buyBtn.setBounds(352, 211, 89, 25);
		panel.add(buyBtn);
	}

	private void txtSettings() {
		txtSearch = new JTextField();
		txtSearch.setText("Szukany produkt");
		txtSearch.setBounds(10, 211, 206, 25);
		panel.add(txtSearch);
		txtSearch.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setText("user");
		txtUsername.setBounds(288, 6, 86, 25);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setText("user123");
		txtPassword.setBounds(440, 6, 86, 25);
		panel.add(txtPassword);
	}

	public void searchBtnActionListener(ActionListener actionListener) {
		searchBtn.addActionListener(actionListener);
	}
	
	public void showAllProductsBtnActionListener(ActionListener actionListener) {
		showAllProducts.addActionListener(actionListener);
	}

	public void loginBtnActionListener(ActionListener actionListener) {
		loginBtn.addActionListener(actionListener);
	}

	public void refreshBtnActionListener(ActionListener actionListener) {
		refreshBtn.addActionListener(actionListener);
	}

	public void showClientFrame() {
		frame.setVisible(true);
	}
	
	public void setOffLoginBtn() {
		loginBtn.setEnabled(false);
	}

	public JTable getTable() {
		return table;
	}

	public JTable getTable2() {
		return table2;
	}

	public String getTxtProducent() {
		return txtSearch.getText();
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getPwdPassword() {
		return String.valueOf(txtPassword.getPassword());
	}
}