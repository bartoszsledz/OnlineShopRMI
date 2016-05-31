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
import javax.swing.JSeparator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AdminFrame implements Serializable {
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane, scrollPane2;
	private JTable table, table2;
	private DefaultTableModel model, model2;
	private JButton showProductsBtn, addProductBtn, loginBtn, addUserBtn, showUsersBtn;
	private JTextField txtId, txtName, txtManufacturer, txtPrice, txtQuantity, txtUsername, txtNewUsername;
	private JPasswordField txtPassword, txtNewPassword;
	private JLabel shopLabel, loginLabel, passwordLabel, newLoginLabel, newPasswordLabel, nameLabel, priceLabel,
			idLabel, manufacturerLabel, iloscLabel;
	private JSeparator separator, separator_1;

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
		frame = new JFrame("Online Shop Admin Console");
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
		loginLabel.setBounds(122, 11, 46, 15);
		panel.add(loginLabel);

		passwordLabel = new JLabel("Has³o:");
		passwordLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		passwordLabel.setBounds(274, 11, 46, 15);
		panel.add(passwordLabel);

		newLoginLabel = new JLabel("Login:");
		newLoginLabel.setBounds(505, 336, 76, 15);
		panel.add(newLoginLabel);

		newPasswordLabel = new JLabel("Password:");
		newPasswordLabel.setBounds(505, 398, 76, 15);
		panel.add(newPasswordLabel);

		idLabel = new JLabel("ID:");
		idLabel.setBounds(10, 59, 46, 14);
		panel.add(idLabel);

		priceLabel = new JLabel("Cena:");
		priceLabel.setBounds(66, 59, 46, 14);
		panel.add(priceLabel);

		nameLabel = new JLabel("Nazwa:");
		nameLabel.setBounds(122, 59, 86, 14);
		panel.add(nameLabel);

		manufacturerLabel = new JLabel("Producent:");
		manufacturerLabel.setBounds(218, 59, 86, 14);
		panel.add(manufacturerLabel);

		iloscLabel = new JLabel("Ilo\u015B\u0107:");
		iloscLabel.setBounds(314, 59, 46, 14);
		panel.add(iloscLabel);

		separator = new JSeparator();
		separator.setBounds(10, 296, 614, 15);
		panel.add(separator);

		separator_1 = new JSeparator();
		separator_1.setBounds(10, 46, 614, 2);
		panel.add(separator_1);

	}

	private void tableSettings() {
		model.addColumn("Id");
		model.addColumn("Nazwa");
		model.addColumn("Cena");
		model.addColumn("Producent");
		model.addColumn("Ilosc");
		table.setRowSelectionAllowed(true);
		scrollPane.setBounds(10, 120, 615, 165);
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
		showProductsBtn.setBounds(515, 84, 110, 25);
		panel.add(showProductsBtn);

		addProductBtn = new JButton("Dodaj produkt");
		addProductBtn.setBounds(385, 84, 120, 25);
		panel.add(addProductBtn);

		loginBtn = new JButton("Zaloguj");
		loginBtn.setBounds(426, 6, 89, 25);
		panel.add(loginBtn);

		addUserBtn = new JButton("Dodaj usera");
		addUserBtn.setBounds(505, 460, 120, 23);
		panel.add(addUserBtn);

		showUsersBtn = new JButton("Przegl¹daj");
		showUsersBtn.setBounds(505, 494, 120, 23);
		panel.add(showUsersBtn);
	}

	private void txtSettings() {
		txtId = new JTextField();
		txtId.setToolTipText("Only numbers!!!");
		initializeTxtSettings(txtId);
		txtId.setBounds(10, 84, 46, 25);
		panel.add(txtId);
		txtId.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(122, 84, 86, 25);
		panel.add(txtName);
		txtName.setColumns(10);

		txtManufacturer = new JTextField();
		txtManufacturer.setBounds(218, 84, 86, 25);
		panel.add(txtManufacturer);
		txtManufacturer.setColumns(10);

		txtPrice = new JTextField();
		txtPrice.setToolTipText("Only numbers!!!");
		initializeTxtSettings(txtPrice);
		txtPrice.setBounds(66, 84, 46, 25);
		panel.add(txtPrice);
		txtPrice.setColumns(10);

		txtQuantity = new JTextField();
		txtQuantity.setToolTipText("Only numbers!!!");
		initializeTxtSettings(txtQuantity);
		txtQuantity.setBounds(314, 84, 46, 25);
		panel.add(txtQuantity);
		txtQuantity.setColumns(10);

		txtUsername = new JTextField();
		txtUsername.setText("admin");
		txtUsername.setBounds(178, 6, 86, 25);
		panel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JPasswordField();
		txtPassword.setText("admin123");
		txtPassword.setBounds(330, 6, 86, 25);
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

	private void initializeTxtSettings(JTextField txt) {
		txt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char vChar = arg0.getKeyChar();
				if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE) || (vChar == KeyEvent.VK_DELETE))) {
					arg0.consume();
				}
			}
		});
	}

	public void addShowProductsBtnActionListener(ActionListener actionListener) {
		showProductsBtn.addActionListener(actionListener);
	}

	public void loginBtnActionListener(ActionListener actionListener) {
		loginBtn.addActionListener(actionListener);
	}

	public void addDodajProduktBtnActionListener(ActionListener actionListener) {
		addProductBtn.addActionListener(actionListener);
	}

	public void addUserBtnActionListener(ActionListener actionListener) {
		addUserBtn.addActionListener(actionListener);
	}

	public void refreshBtnActionListener(ActionListener actionListener) {
		showUsersBtn.addActionListener(actionListener);
	}

	public void showAdminFrame() {
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

	public void setLoginTxtOff() {
		txtUsername.setEditable(false);
		txtPassword.setEditable(false);
	}
	
	public void setEmptyFields(){
		txtId.setText("");
		txtName.setText("");
		txtPrice.setText("");
		txtManufacturer.setText("");
		txtQuantity.setText("");
	}
}