package existingCustomer;

import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import entity.AccountTransaction;
import entity.CustomerAccount;

public class BalanceUpdate {

	private String type;
	private CustomerAccount acc;
	private Date date2 = new Date();
	private JFrame f;
	private double amount;

	public void theBalance(String type, double amount, CustomerAccount acc) {
		this.type = type;
		this.acc = acc;
		this.amount = amount;

		String euro = " € ";
		if (type.equals("withdraw")) {
			acc.setBalance(acc.getBalance() - amount);
		} else if (type.equals("lodgement")) {
			acc.setBalance(acc.getBalance() + amount);
		}
		String date = date2.toString();
		AccountTransaction transaction = new AccountTransaction(date, type, amount);
		acc.getTransactionList().add(transaction);

		JOptionPane.showMessageDialog(f, euro + amount + type, type, JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro, type,
				JOptionPane.INFORMATION_MESSAGE);
	}
}
