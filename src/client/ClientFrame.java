package client;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Hashtable;

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
import javax.swing.JSeparator;
import javax.swing.JSlider;

public class ClientFrame implements Serializable {
	private static final long serialVersionUID = 1L;

	private JFrame frame;
	private JPanel panel;
	private JScrollPane scrollPane, scrollPane2;
	private JTable table, table2;
	private DefaultTableModel model, model2;
	private JButton searchBtn, loginBtn, deleteFromCartBtn, showAllProducts, addToCartBtn, buyBtn;
	private JTextField txtSearch, txtUsername;
	private JPasswordField txtPassword;
	private JLabel shopLabel, loginLabel, passwordLabel, cartLabel;
	private JSeparator separator;
	private JSlider slider;

	public ClientFrame() {
		initialize();
	}

	public void initialize() {
		createAllComponents();
		frameSettings();
		labelSettings();
		buttonsSettings();
		radioButtonsSettings();
		txtSettings();
		tableSettings();
		sliderSettings();
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
		cartLabel.setBounds(10, 326, 76, 15);
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
		table.setRowSelectionAllowed(true);
		// table.setEnabled(false);
		scrollPane.setBounds(10, 35, 615, 165);
		scrollPane.setViewportView(table);

		model2.addColumn("Id");
		model2.addColumn("Nazwa");
		model2.addColumn("Cena");
		model2.addColumn("Producent");
		model2.addColumn("Ilosc");
		table.setRowSelectionAllowed(true);
		scrollPane2.setBounds(10, 352, 615, 165);
		scrollPane2.setViewportView(table2);
	}

	private void buttonsSettings() {
		searchBtn = new JButton("Szukaj");
		searchBtn.setBounds(365, 211, 110, 25);
		panel.add(searchBtn);

		loginBtn = new JButton("Zaloguj");
		loginBtn.setBounds(536, 6, 89, 25);
		panel.add(loginBtn);

		deleteFromCartBtn = new JButton("Wyczyœæ koszyk");
		deleteFromCartBtn.setBounds(10, 527, 134, 23);
		panel.add(deleteFromCartBtn);

		showAllProducts = new JButton("Poka¿ wszystkie");
		showAllProducts.setBounds(485, 211, 140, 25);
		panel.add(showAllProducts);

		addToCartBtn = new JButton("Dodaj do koszyka");
		addToCartBtn.setBounds(485, 279, 140, 25);
		panel.add(addToCartBtn);

		buyBtn = new JButton("Kup");
		buyBtn.setBounds(536, 527, 89, 23);
		panel.add(buyBtn);
	}

	private void radioButtonsSettings() {
	}

	private void txtSettings() {
		txtSearch = new JTextField();
		txtSearch.setText("Szukany produkt");
		txtSearch.setBounds(245, 211, 110, 25);
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

		separator = new JSeparator();
		separator.setBounds(10, 315, 615, 15);
		panel.add(separator);
	}

	private void sliderSettings() {
		slider = new JSlider();
		slider.setValue(1);
		slider.setBounds(10, 209, 225, 53);
		slider.setMaximum(4);
		slider.setMinimum(0);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true); // dopasowuje do najblizszego pktu
		panel.add(slider);

		Hashtable<Object, Object> labelTable = new Hashtable<>();
		labelTable.put(0, new JLabel("Id"));
		labelTable.put(1, new JLabel("Nazwa"));
		labelTable.put(2, new JLabel("Cena"));
		labelTable.put(3, new JLabel("Prod."));
		labelTable.put(4, new JLabel("Ilosc"));

		slider.setLabelTable(labelTable);
		slider.setPaintLabels(true);
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
		deleteFromCartBtn.addActionListener(actionListener);
	}

	public void addToCartBtnActionListener(ActionListener actionListener) {
		addToCartBtn.addActionListener(actionListener);
	}

	public void deleteFromCartBtnActionListener(ActionListener actionListener) {
		deleteFromCartBtn.addActionListener(actionListener);
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

	public String getTxtSearch() {
		return txtSearch.getText();
	}

	public String getTxtUsername() {
		return txtUsername.getText();
	}

	public String getPwdPassword() {
		return String.valueOf(txtPassword.getPassword());
	}

	public int getSliderValue() {
		return slider.getValue();
	}

	public void setLoginTxtOff() {
		txtUsername.setEditable(false);
		txtPassword.setEditable(false);
	}

	public void setEmptySearchField() {
		txtSearch.setText("");
	}
}