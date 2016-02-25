import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Administrator {

	private JFrame f;
	private Container content;
	private ArrayList<Customer> listOfTheCustomers;

	public void admin(ArrayList<Customer> listOfTheCustomers) {

		Menu menu = new Menu();
		this.listOfTheCustomers =listOfTheCustomers;
		
		InterestCharges interestCharges = new InterestCharges();
		BankCharges bankCharges = new BankCharges();
		EditCustomerDetails editCustomerDetails = new EditCustomerDetails();
		Summary summaryClass = new Summary();
		Navigate navigateClass = new Navigate();
		Account accountClass = new Account();
		DeleteCustomer deleteCust = new DeleteCustomer();
		DeleteAccount deleteAccountClass = new DeleteAccount();
		Return returnClass = new Return();

		f = new JFrame("Administrator Menu");
		f.setSize(400, 400);
		f.setLocation(200, 200);
		f.setVisible(true);

		JPanel deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteCustomer = new JButton("Delete Customer");
		deleteCustomer.setPreferredSize(new Dimension(250, 20));
		deleteCustomerPanel.add(deleteCustomer);

		JPanel deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.setPreferredSize(new Dimension(250, 20));
		deleteAccountPanel.add(deleteAccount);

		JPanel bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton bankChargesButton = new JButton("Apply Bank Charges");
		bankChargesButton.setPreferredSize(new Dimension(250, 20));
		bankChargesPanel.add(bankChargesButton);

		JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton interestButton = new JButton("Apply Interest");
		interestPanel.add(interestButton);
		interestButton.setPreferredSize(new Dimension(250, 20));

		JPanel editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton editCustomerButton = new JButton("Edit existing Customer");
		editCustomerPanel.add(editCustomerButton);
		editCustomerButton.setPreferredSize(new Dimension(250, 20));

		JPanel navigatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton navigateButton = new JButton("Navigate Customer Collection");
		navigatePanel.add(navigateButton);
		navigateButton.setPreferredSize(new Dimension(250, 20));

		JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton summaryButton = new JButton("Display Summary Of All Accounts");
		summaryPanel.add(summaryButton);
		summaryButton.setPreferredSize(new Dimension(250, 20));

		JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton accountButton = new JButton("Add an Account to a Customer");
		accountPanel.add(accountButton);
		accountButton.setPreferredSize(new Dimension(250, 20));

		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Admin Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");

		content = f.getContentPane();
		content.setLayout(new GridLayout(9, 1));
		content.add(label1);
		content.add(accountPanel);
		content.add(bankChargesPanel);
		content.add(interestPanel);
		content.add(editCustomerPanel);
		content.add(navigatePanel);
		content.add(summaryPanel);
		content.add(deleteCustomerPanel);
		content.add(returnPanel);

		for (int i = 0; i < menu.getCustomerList().size(); i++) {
			System.out.println("in here   " + menu.getCustomerList().get(i));
		}
		

		bankChargesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				bankCharges.bankCharges(listOfTheCustomers);
			}
		});
//
//		interestButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				interestCharges.interestCharges();
//			}
//		});
//
//		editCustomerButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				editCustomerDetails.editCustomer(listOfTheCustomers);
//			}
//		});
//
//		summaryButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				summaryClass.summary();
//			}
//		});
//
//		navigateButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				navigateClass.navigate(listOfTheCustomers);
//			}
//		});

		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				accountClass.account(listOfTheCustomers);
			}
		});

//		deleteCustomer.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				deleteCust.deleteCustomer(listOfTheCustomers);
//			}
//		});
//
//		deleteAccount.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent ae) {
//				deleteAccountClass.deleteAccount();
//			}
//
//		});
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				returnClass.returnButton(f);
			}
		});
	}

	public ArrayList<Customer> getListOfTheCustomers() {
		return listOfTheCustomers;
	}

	public void setListOfTheCustomers(ArrayList<Customer> listOfTheCustomers) {
		this.listOfTheCustomers = listOfTheCustomers;
	}
}
