import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Account {

	private ArrayList<Customer> listOfTheCustomers;
	private Customer customer;
	private JFrame f;

	Menu menu = new Menu();
	public void account(ArrayList<Customer>listOfTheCustomers) {

		this.setListOfTheCustomers(listOfTheCustomers);
		
		System.out.println(listOfTheCustomers);
		if (listOfTheCustomers.isEmpty()) {
			JOptionPane.showMessageDialog(f, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
		} else {
			boolean loop = true;

			boolean found = false;

			while (loop) {
				Object customerID = JOptionPane.showInputDialog(f,
						"Customer ID of Customer You Wish to Add an Account to:");

				for (Customer aCustomer : listOfTheCustomers) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
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
					loop = false;
				
					String[] choices = { "Current Account", "Deposit Account" };
					String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
							"Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

					if (account.equals("Current Account")) {
						
						boolean valid = true;
						double balance = 0;
						String number = String.valueOf("C" + (menu.getCustomerList().indexOf(customer) + 1) * 10
								+ (customer.getAccounts().size() + 1));
						ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
						int randomPIN = (int) (Math.random() * 9000) + 1000;
						String pin = String.valueOf(randomPIN);

						ATMCard atm = new ATMCard(randomPIN, valid);

						CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance,
								transactionList);

						System.out.println("Current account "+current);
						customer.getAccounts().add(current);
						JOptionPane.showMessageDialog(f, "Account number = " + number + "\n PIN = " + pin,
								"Account created.", JOptionPane.INFORMATION_MESSAGE);

						
					}

					if (account.equals("Deposit Account")) {

						double balance = 0, interest = 0;
						String number = String.valueOf("D" + (menu.getCustomerList().indexOf(customer) + 1) * 10
								+ (customer.getAccounts().size() + 1));
						ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();

						CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance,
								transactionList);

						System.out.println("The deposit "+deposit);
						customer.getAccounts().add(deposit);
						JOptionPane.showMessageDialog(f, "Account number = " + number, "Account created.",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		}

	}
	public ArrayList<Customer> getListOfTheCustomers() {
		return listOfTheCustomers;
	}
	public void setListOfTheCustomers(ArrayList<Customer> listOfTheCustomers) {
		this.listOfTheCustomers = listOfTheCustomers;
	}

}
