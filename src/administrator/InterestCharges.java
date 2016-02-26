package administrator;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import entity.Customer;
import entity.CustomerAccount;
import frames.JFrameClass;

public class InterestCharges {

	private ArrayList<Customer> listOfTheCustomers;
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;

	public void interestCharges(ArrayList<Customer> listOfTheCustomers) {

		this.listOfTheCustomers = listOfTheCustomers;
		boolean loop = true;
		boolean found = false;

		CheckListOfUsers checkListOfUsers = new CheckListOfUsers();
		Customer customer2 = checkListOfUsers.checkList(listOfTheCustomers, f);
		if (customer2 != null) {
			JFrameClass jFrameClass = new JFrameClass();
			f = jFrameClass.createJFrame("Administrator Menu",400,300,200,200);

			JComboBox<String> box = new JComboBox<String>();
			for (int i = 0; i < customer2.getAccounts().size(); i++) {

				box.addItem(customer2.getAccounts().get(i).getNumber());
			}

			box.getSelectedItem();

			JPanel boxPanel = new JPanel();

			JLabel label = new JLabel("Select an account to apply interest to:");
			boxPanel.add(label);
			boxPanel.add(box);
			JPanel buttonPanel = new JPanel();
			JButton continueButton = new JButton("Apply Interest");
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
						String euro = "€";
						double interest = 0;
						boolean loop = true;
						while (loop) {
							String interestString = JOptionPane.showInputDialog(f,
									"Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");
							NumberCheck numberCheck = new NumberCheck();
							if (numberCheck.isNumeric(interestString)) {

								interest = Double.parseDouble(interestString);
								loop = false;
								acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest / 100)));
								JOptionPane.showMessageDialog(f,
										interest + "% interest applied. \n new balance = " + acc.getBalance() + euro,
										"Success!", JOptionPane.INFORMATION_MESSAGE);
							}

							else {
								JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "Oops!",
										JOptionPane.INFORMATION_MESSAGE);
							}

						}
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