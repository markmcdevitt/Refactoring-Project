package administrator;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Customer;

public class CheckListOfUsers {

	private Customer customer;
	private JFrame f, f1;

	public Customer checkList(ArrayList<Customer> listOfTheCustomers, JFrame oldFrame) {
		if (listOfTheCustomers.isEmpty()) {
			JOptionPane.showMessageDialog(f1, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
			f.dispose();
		} else {
			try {
				Object customerID = JOptionPane.showInputDialog(null, "Customer ID");
				for (Customer aCustomer : listOfTheCustomers) {
					if (aCustomer.getCustomerID().equals(customerID)) {
						customer = aCustomer;
					}
				}
			} catch (Exception e) {
			}
		}
		if (customer != null) {
			return customer;
		} else {
			return null;
		}

	}
}
