package existingCustomer;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Customer;
import entity.CustomerAccount;

public class ExistingCustomer {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;

	public void existingCustomer(ArrayList<Customer>customerList) {

		boolean loop = true;
		boolean cont = false;
		boolean found = false;
		Customer customer = null;

		while (loop) {
			Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");
			Object customerPassword = JOptionPane.showInputDialog(f, "Enter Customer Password;");
			for (Customer aCustomer : customerList) {
				if (aCustomer.getCustomerID().equals(customerID)) {
					customer = aCustomer;
					if (customer.getPassword().equals(customerPassword)) {
						found = true;
					}
				}
			}
			if (!found) {
				int reply = JOptionPane.showConfirmDialog(null, null, "Details are incorrect. Try again?",JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.NO_OPTION) {
					loop = false;
					f.dispose();
				}
			} else {
				loop = false;
				cont = true;
			}
		}
		if (cont) {
			loop = false;
			ChooseAccount chooseAccount = new ChooseAccount();
			chooseAccount.customer(customer);
		}
	}
}
