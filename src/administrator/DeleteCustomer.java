package administrator;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Customer;

public class DeleteCustomer{

	private ArrayList<Customer> listOfTheCustomers;
	private Customer customer;
	private JFrame f;
	
	public void deleteCustomer(ArrayList<Customer> listOfTheCustomers) {
		this.listOfTheCustomers=listOfTheCustomers;

		boolean found = true;
		boolean loop = true;

		if (listOfTheCustomers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
		} else {
			{
				Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Delete:");

				for (Customer aCustomer :listOfTheCustomers) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
						loop = false;
					}
				}

				if (found == false) {
					int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						loop = true;
					} else if (reply == JOptionPane.NO_OPTION) {
						f.dispose();
						loop = false;
					}
				} else {
					if (customer.getAccounts().size() > 0) {
						JOptionPane.showMessageDialog(f,
								"This customer has accounts. \n You must delete a customer's accounts before deleting a customer ",
								"Oops!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						listOfTheCustomers.remove(customer);
						JOptionPane.showMessageDialog(f, "Customer Deleted ", "Success.",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		}

	}
}