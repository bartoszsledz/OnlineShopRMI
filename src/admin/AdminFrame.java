package admin;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.io.Serializable;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

public class AdminFrame implements Serializable {
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane, scrollPane2;
	private JTable table, table2;
	private DefaultTableModel model, model2;
	private JButton showProductsBtn, addProductBtn, loginBtn, addUserBtn, refreshBtn;
	private JTextField txtId, txtName, txtManufacturer, txtPrice, txtQuantity, txtUsername, txtNewUsername;
	private JPasswordField txtPassword, txtNewPassword;
	private JLabel shopLabel, loginLabel, passwordLabel, newLoginLabel, newPasswordLabel;

	public AdminFrame() {
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

		shopLabel = new JLabel("U¿ytkownicy");
		shopLabel.setBounds(10, 309, 76, 15);
		panel.add(shopLabel);

		loginLabel = new JLabel("Login: ");
		loginLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		loginLabel.setBounds(232, 11, 46, 15);
		panel.add(loginLabel);

		passwordLabel = new JLabel("Has\u0142o:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(384, 11, 46, 15);
		panel.add(passwordLabel);

		newLoginLabel = new JLabel("Login:");
		newLoginLabel.setBounds(505, 336, 76, 15);
		panel.add(newLoginLabel);

		newPasswordLabel = new JLabel("Password:");
		newPasswordLabel.setBounds(505, 398, 76, 15);
		panel.add(newPasswordLabel);
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
		model2.addColumn("Has³o");
		model2.addColumn("Zamówienia");
		table2.setEnabled(false);
		scrollPane2.setBounds(10, 335, 470, 182);
		scrollPane2.setViewportView(table2);
	}

	private void buttonsSettings() {
		showProductsBtn = new JButton("Przegl¹daj");
		showProductsBtn.setBounds(515, 211, 110, 25);
		panel.add(showProductsBtn);

		addProductBtn = new JButton("Dodaj produkt");
		addProductBtn.setBounds(385, 211, 120, 25);
		panel.add(addProductBtn);

		loginBtn = new JButton("Zaloguj");
		loginBtn.setBounds(536, 6, 89, 25);
		panel.add(loginBtn);

		addUserBtn = new JButton("Dodaj usera");
		addUserBtn.setBounds(505, 460, 120, 23);
		panel.add(addUserBtn);
		
		refreshBtn = new JButton("Od\u015Bwie\u017C");
		refreshBtn.setBounds(505, 494, 120, 23);
		panel.add(refreshBtn);
	}

	private void txtSettings() {
		txtId = new JTextField();
		txtId.setText("ID");
		txtId.setBounds(10, 211, 46, 25);
		panel.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setText("Nazwa");
		txtName.setBounds(178, 211, 86, 25);
		panel.add(txtName);
		txtName.setColumns(10);

		txtManufacturer = new JTextField();
		txtManufacturer.setText("Producent");
		txtManufacturer.setBounds(274, 211, 86, 25);
		panel.add(txtManufacturer);
		txtManufacturer.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setText("Cena");
		txtPrice.setBounds(66, 211, 46, 25);
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		txtQuantity = new JTextField();
		txtQuantity.setText("Ilosc");
		txtQuantity.setBounds(122, 211, 46, 25);
		panel.add(txtQuantity);
		txtQuantity.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setText("admin");
		txtUsername.setBounds(288, 6, 86, 25);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setText("admin123");
		txtPassword.setBounds(440, 6, 86, 25);
		panel.add(txtPassword);

		txtNewUsername = new JTextField();
		txtNewUsername.setText("user");
		txtNewUsername.setColumns(10);
		txtNewUsername.setBounds(505, 362, 120, 25);
		panel.add(txtNewUsername);

		txtNewPassword = new JPasswordField();
		txtNewPassword.setText("user123");
		txtNewPassword.setColumns(10);
		txtNewPassword.setBounds(505, 424, 120, 25);
		panel.add(txtNewPassword);
	}

	public void addShowProductsBtnActionListener(ActionListener actionListener) {
		showProductsBtn.addActionListener(actionListener);
	}

	public void addLoginBtnActionListener(ActionListener actionListener) {
		loginBtn.addActionListener(actionListener);
	}

	public void addDodajProduktBtnActionListener(ActionListener actionListener) {
		addProductBtn.addActionListener(actionListener);
	}

	public void addUserBtnActionListener(ActionListener actionListener) {
		addUserBtn.addActionListener(actionListener);
	}
	
	public void refreshBtnActionListener(ActionListener actionListener) {
		refreshBtn.addActionListener(actionListener);
	}

	public void showClientFrame() {
		frame.setVisible(true);
	}

	public JTable getTable() {
		return table;
	}
	
	public JTable getTable2() {
		return table2;
	}

	public int getTxtId() {
		return Integer.parseInt(txtId.getText());
	}

	public String getTxtNazwa() {
		return txtName.getText();
	}

	public String getTxtProducent() {
		return txtManufacturer.getText();
	}

	public double getTxtCena() {
		return Double.parseDouble(txtPrice.getText());
	}

	public int getTxtIlosc() {
		return Integer.parseInt(txtQuantity.getText());
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getPwdPassword() {
		return String.valueOf(txtPassword.getPassword());
	}

	public String getNewLogin() {
		return String.valueOf(txtNewUsername.getText());
	}
	
	public String getNewPassword() {
		return String.valueOf(txtNewPassword.getPassword());
	}
}