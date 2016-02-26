package existingCustomer;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;

import entity.Customer;
import entity.CustomerAccount;
import frames.JFrameClass;

public class UserAccount {
	
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;

	public void continueButton(Customer customer,JComboBox<String> box,JFrame chooseAccountFrame) {
		JFrameClass jFrameClass = new JFrameClass();
		f = jFrameClass.createJFrame("Customer Menu",400,300,200,200);
		
		this.box=box;
		this.customer=customer;
		
		for (int i = 0; i < customer.getAccounts().size(); i++) {
			if (customer.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
				acc = customer.getAccounts().get(i);
			}
		}

		JPanel statementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton statementButton = new JButton("Display Bank Statement");
		statementButton.setPreferredSize(new Dimension(250, 20));

		statementPanel.add(statementButton);

		JPanel lodgementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton lodgementButton = new JButton("Lodge money into account");
		lodgementPanel.add(lodgementButton);
		lodgementButton.setPreferredSize(new Dimension(250, 20));

		JPanel withdrawalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton withdrawButton = new JButton("Withdraw money from account");
		withdrawalPanel.add(withdrawButton);
		withdrawButton.setPreferredSize(new Dimension(250, 20));

		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Customer Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");

		content = f.getContentPane();
		content.setLayout(new GridLayout(5, 1));
		content.add(label1);
		content.add(statementPanel);
		content.add(lodgementPanel);
		content.add(withdrawalPanel);
		content.add(returnPanel);

		statementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				CustomerStatment customerStatment = new CustomerStatment();
				customerStatment.statments(customer,acc);
			}
		});

		lodgementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				CustomerLodgement customerLodgement = new CustomerLodgement(); 
				customerLodgement.lodgements(customer,acc,f,chooseAccountFrame);
			}
		});

		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				WithdrawClass withdrawClass = new WithdrawClass();
				withdrawClass.withdraw(customer,acc,f,chooseAccountFrame);
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
			}
		});
	}
}
