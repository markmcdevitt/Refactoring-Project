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

public class ChooseAccount{

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;
	
	public void customer(Customer customer) {

		f = new JFrame("Customer Menu");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.setVisible(true);
		this.customer = customer;

		if (customer.getAccounts().size() == 0) {
			JOptionPane.showMessageDialog(f,
					"This customer does not have any accounts yet. \n An admin must create an account for this customer \n for them to be able to use customer functionality. ",
					"Oops!", JOptionPane.INFORMATION_MESSAGE);

			f.dispose();
		} else {
			JPanel buttonPanel = new JPanel();
			JPanel boxPanel = new JPanel();
			JPanel labelPanel = new JPanel();

			JLabel label = new JLabel("Select Account:");
			labelPanel.add(label);

			JButton returnButton = new JButton("Return");
			buttonPanel.add(returnButton);
			JButton continueButton = new JButton("Continue");
			buttonPanel.add(continueButton);

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
					Return returnClass = new Return();
					returnClass.returnButton(f);
				}
			});
			System.out.println("in the choose account");
			continueButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					UserAccount userAccount=new UserAccount();
					userAccount.continueButton(customer,box,f);
				}
			});
		}
	}

}
