package newCustomer;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Customer;
import entity.CustomerAccount;

public class AddCustomerDetails {

	private JFrame f;

	public Customer addDetails(String pPS, String firstName, String surname, String dateOfBirth, JFrame oldFrame) {
		Customer customer = new Customer();
		oldFrame.dispose();
		String CustomerID = "ID" + pPS;
		boolean loop = true;
		while (loop) {
			String password = JOptionPane.showInputDialog(f, "Enter 7 character Password;");
			if (password.length() != 7) {
				JOptionPane.showMessageDialog(null, null, "Password must be 7 charatcers long", JOptionPane.OK_OPTION);
			} else {
				ArrayList<CustomerAccount> accounts = new ArrayList<CustomerAccount>();
				customer = new Customer(pPS, surname, firstName, dateOfBirth, CustomerID, password, accounts);
				loop = false;
			}
		}
		return customer;
	}
}
