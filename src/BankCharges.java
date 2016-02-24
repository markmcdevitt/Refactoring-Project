import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BankCharges {

	private ArrayList<Customer> listOfTheCustomers;
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;

	public void bankCharges( ArrayList<Customer> listOfTheCustomers) {

		
		Return returnClass = new Return();
		Menu menu = new Menu();
		Administrator administrator = new Administrator();
		
		boolean loop = true;

		boolean found = false;

		if (menu.getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(f, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
			administrator.admin(listOfTheCustomers);

		} else {
			while (loop) {
				Object customerID = JOptionPane.showInputDialog(f,
						"Customer ID of Customer You Wish to Apply Charges to:");

				for (Customer aCustomer : menu.getCustomerList()) {

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

						administrator.admin(listOfTheCustomers);
					}
				} else {
					f.dispose();
					f = new JFrame("Administrator Menu");
					f.setSize(400, 300);
					f.setLocation(200, 200);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							System.exit(0);
						}
					});
					f.setVisible(true);

					JComboBox<String> box = new JComboBox<String>();
					for (int i = 0; i < customer.getAccounts().size(); i++) {

						box.addItem(customer.getAccounts().get(i).getNumber());
					}

					box.getSelectedItem();

					JPanel boxPanel = new JPanel();
					boxPanel.add(box);

					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Charge");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = f.getContentPane();
					content.setLayout(new GridLayout(2, 1));

					content.add(boxPanel);
					content.add(buttonPanel);

					if (customer.getAccounts().isEmpty()) {
						JOptionPane.showMessageDialog(f,
								"This customer has no accounts! \n The admin must add acounts to this customer.",
								"Oops!", JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						administrator.admin(listOfTheCustomers);
					} else {

						for (int i = 0; i < customer.getAccounts().size(); i++) {
							if (customer.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
								acc = customer.getAccounts().get(i);
							}
						}

						continueButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								String euro = "\u20ac";

								if (acc instanceof CustomerDepositAccount) {

									JOptionPane.showMessageDialog(f, "25" + euro + " deposit account fee aplied.", "",
											JOptionPane.INFORMATION_MESSAGE);
									acc.setBalance(acc.getBalance() - 25);
									JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance(), "Success!",
											JOptionPane.INFORMATION_MESSAGE);
								}

								if (acc instanceof CustomerCurrentAccount) {

									JOptionPane.showMessageDialog(f, "15" + euro + " current account fee aplied.", "",
											JOptionPane.INFORMATION_MESSAGE);
									acc.setBalance(acc.getBalance() - 25);
									JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance(), "Success!",
											JOptionPane.INFORMATION_MESSAGE);
								}

								f.dispose();
								administrator.admin(listOfTheCustomers);
							}
						});

						returnButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								returnClass.returnButton(f);
							}
						});

					}
				}
			}
		}

	}
}
