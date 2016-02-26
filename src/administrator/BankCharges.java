package administrator;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Customer;
import entity.CustomerAccount;
import entity.CustomerCurrentAccount;
import entity.CustomerDepositAccount;

public class BankCharges {

	private ArrayList<Customer> listOfTheCustomers;
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private JComboBox<String> box;
	private int price;
	private String nameOfAccount;

	public void bankCharges(ArrayList<Customer> listOfTheCustomers) {

		CheckListOfUsers checkListOfUsers = new CheckListOfUsers();
		Customer customer2 = checkListOfUsers.checkList(listOfTheCustomers, f);
		System.out.println(customer2.toString());
		if (customer2 != null) {
			f = new JFrame("Administrator Menu");
			f.setSize(400, 300);
			f.setLocation(200, 200);
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});
			f.setVisible(true);

			JPanel boxPanel = new JPanel();
			box = new JComboBox<String>();
			for (int i = 0; i < customer2.getAccounts().size(); i++) {

				box.addItem(customer2.getAccounts().get(i).getNumber());
			}

			box.getSelectedItem();

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

			if (customer2.getAccounts().isEmpty()) {
				JOptionPane.showMessageDialog(f,
						"This customer has no accounts! \n The admin must add acounts to this customer.", "Oops!",
						JOptionPane.INFORMATION_MESSAGE);
				f.dispose();
			} else {
				for (int i = 0; i < customer2.getAccounts().size(); i++) {
					if (customer2.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
						acc = customer2.getAccounts().get(i);
					}
				}

				continueButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						SpecificBankCharge specificBankCharge = new SpecificBankCharge();
						if (acc instanceof CustomerDepositAccount) {
							price = 25;
							nameOfAccount = "Current";
							specificBankCharge.specificCharge(acc, price, nameOfAccount);

						} else if (acc instanceof CustomerCurrentAccount) {
							price = 15;
							nameOfAccount = "Deposit";
							specificBankCharge.specificCharge(acc, price, nameOfAccount);

						}
						f.dispose();
					}
				});

				returnButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						f.dispose();
					}
				});

			}
		}
	}
}