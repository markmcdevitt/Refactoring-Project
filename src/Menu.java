
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Menu extends JFrame {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private JFrame f;

	public void menuStart() {

		f = new JFrame("User Type");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		exit();

		JPanel userTypePanel = new JPanel();
		ButtonGroup userType = new ButtonGroup();
		JRadioButton radioButton;
		userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
		radioButton.setActionCommand("Customer");
		userType.add(radioButton);

		userTypePanel.add(radioButton = new JRadioButton("Administrator"));
		radioButton.setActionCommand("Administrator");
		userType.add(radioButton);

		userTypePanel.add(radioButton = new JRadioButton("New Customer"));
		radioButton.setActionCommand("New Customer");
		userType.add(radioButton);

		JPanel continuePanel = new JPanel();
		JButton continueButton = new JButton("Continue");
		continuePanel.add(continueButton);

		Container content = f.getContentPane();
		content.setLayout(new GridLayout(2, 1));
		content.add(userTypePanel);
		content.add(continuePanel);

		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String user = userType.getSelection().getActionCommand();
				if (user.equals("New Customer")) {
					NewCustomer newCustomer = new NewCustomer();
					newCustomer.newCust(customerList);
					setCustomerList(newCustomer.getListOfTheCustomers());
				} else if (user.equals("Administrator")) {
					AdministratorLogin admin = new AdministratorLogin();
					admin.administratorLogin(customerList);
				} else if (user.equals("Customer")) {
					ExistingCustomer exitingCustomerClass = new ExistingCustomer();
					exitingCustomerClass.existingCustomer(customerList);
				}
			}
		});
		f.setVisible(true);
	}

	public void exit() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	public ArrayList<Customer> getCustomerList() {
		System.out.println("In the get");
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}