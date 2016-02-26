import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeleteAccount {

	private ArrayList<Customer> listOfTheCustomers;
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;

	public void deleteAccount(ArrayList<Customer> listOfTheCustomers) {

		boolean found = true;
		boolean loop = true;
		
		

		this.listOfTheCustomers = listOfTheCustomers;
		{
			Object customerID = JOptionPane.showInputDialog(f,
					"Customer ID of Customer from which you wish to delete an account");

			for (Customer aCustomer : listOfTheCustomers) {

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
				} else {
					f.dispose();
					loop = false;
				}
			} else {
				f = new JFrame("Delete Account");
				f.setSize(400, 300);
				f.setLocation(200, 200);
				f.setVisible(true);
				
				JPanel buttonPanel = new JPanel();
				JPanel boxPanel = new JPanel();
				JPanel labelPanel = new JPanel();

				JLabel label = new JLabel("Select Account:");
				labelPanel.add(label);

				JButton returnButton = new JButton("Return");
				buttonPanel.add(returnButton);
				JButton deleteButton = new JButton("Continue");
				buttonPanel.add(deleteButton);

				box = new JComboBox<String>();
				for (int i = 0; i < customer.getAccounts().size(); i++) {
					box.addItem(customer.getAccounts().get(i).getNumber());
				}
				boxPanel.add(box);
				content = f.getContentPane();
				content.setLayout(new GridLayout(3, 1));
				content.add(labelPanel);
				content.add(boxPanel);
				content.add(buttonPanel);

				returnButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						f.dispose();
					}
				});
				
				deleteButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {

						delete(customer, box);
						f.dispose();
					}
				});
			}
		}
	}

	public void delete(Customer customer, JComboBox<String> box) {

		for (int i = 0; i < customer.getAccounts().size(); i++) {
			if (customer.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
				System.out.println("in the delete "+customer.getAccounts().get(i));
				customer.getAccounts().remove(i);
				JOptionPane.showMessageDialog(f, "This account is deleted", "Delete Account", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}

}
