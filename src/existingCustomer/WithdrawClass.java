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
		
		double withdraw = 0;
		String type = "withdraw";
		PinCheck pinCheck = new PinCheck();
		boolean on2=pinCheck.checkAccount(customer,acc);

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
			BalanceUpdate balanceUpdate =new BalanceUpdate();
			balanceUpdate.theBalance(type,withdraw,acc);
			
		}else{
			oldFrame.dispose();
			chooseAccountFrame.dispose();
		}

	}

}
