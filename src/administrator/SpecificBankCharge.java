package administrator;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.AccountTransaction;
import entity.CustomerAccount;

public class SpecificBankCharge {

	private CustomerAccount acc;
	private JFrame f;
	private String euro = "€";
	public void specificCharge(CustomerAccount acc,int price,String nameOfAccount){
		this.acc=acc;
		JOptionPane.showMessageDialog(f,  euro +price + " deposit account fee applied.", "",
				JOptionPane.INFORMATION_MESSAGE);
		acc.setBalance(acc.getBalance() - price);
		JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance(), "Success!",JOptionPane.INFORMATION_MESSAGE);

		Date date = new Date();
		String date2 = date.toString();
		String type = "Bank Charge on "+nameOfAccount+" Account";
		double amount = acc.getBalance();

		AccountTransaction transaction = new AccountTransaction(date2, type, amount);
		acc.getTransactionList().add(transaction);
	}
}