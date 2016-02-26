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

public class WithdrawClass {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;
	
	public void withdraw(Customer customer,CustomerAccount acc,JFrame oldFrame,JFrame chooseAccountFrame) {

		this.acc=acc;
		this.customer=customer;
		Date date = new Date();
		boolean on = true;
		double withdraw = 0;
		
		PinCheck pinCheck = new PinCheck();
		boolean on2=pinCheck.checkAccount(customer, on,acc);

		if (on2) {
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to withdraw (max 500):");
			NumberCheck numberCheck=new NumberCheck();
			if (numberCheck.isNumeric(balanceTest)) {
				withdraw = Double.parseDouble(balanceTest);

			} else {
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "!",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (withdraw > 500 || withdraw > acc.getBalance()) {
				JOptionPane.showMessageDialog(f, "500 is the maximum you can withdraw at a time or check your balance",
						"Oops!", JOptionPane.INFORMATION_MESSAGE);
				withdraw = 0;
			}
			String euro = "\u20ac";
			acc.setBalance(acc.getBalance() - withdraw);
			String date2 = date.toString();
			String type = "Withdraw";
			double amount = withdraw;

			AccountTransaction transaction = new AccountTransaction(date2, type, amount);
			acc.getTransactionList().add(transaction);

			JOptionPane.showMessageDialog(f, euro + withdraw + " withdrawn.", "Withdraw",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro, "Withdraw",
					JOptionPane.INFORMATION_MESSAGE);
		}else{
			oldFrame.dispose();
			chooseAccountFrame.dispose();
		}

	}

}
