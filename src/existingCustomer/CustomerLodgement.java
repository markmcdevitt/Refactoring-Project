package existingCustomer;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import administrator.NumberCheck;
import entity.AccountTransaction;
import entity.Customer;
import entity.CustomerAccount;

public class CustomerLodgement{

	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;
	
	public void lodgements(Customer customer, CustomerAccount acc,JFrame oldFrame,JFrame chooseAccountFrame) {

		this.customer = customer;
		this.acc=acc;
		
		boolean on = true;
		double balance = 0;
		PinCheck pinCheck = new PinCheck();
		boolean on2=pinCheck.checkAccount(customer, on,acc);
		System.out.println(on2 + " in the lodgement");
		if (on2) {
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to lodge:");
			NumberCheck numberCheck=new NumberCheck();
			if (numberCheck.isNumeric(balanceTest)) {
				balance = Double.parseDouble(balanceTest);

			} else {
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "Oops!",
						JOptionPane.INFORMATION_MESSAGE);
			}

			String euro = "€";
			acc.setBalance(acc.getBalance() + balance);
			Date date = new Date();
			String date2 = date.toString();
			String type = "Lodgement";
			double amount = balance;

			AccountTransaction transaction = new AccountTransaction(date2, type, amount);
			acc.getTransactionList().add(transaction);

			JOptionPane.showMessageDialog(f, balance + euro + " added do you account!", "Lodgement",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro, "Lodgement",
					JOptionPane.INFORMATION_MESSAGE);
		}else{
			oldFrame.dispose();
			chooseAccountFrame.dispose();
		}
	}
}
