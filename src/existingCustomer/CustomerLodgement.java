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
		
		double balance = 0;
		String type = "lodgement";
		PinCheck pinCheck = new PinCheck();
		boolean on2=pinCheck.checkAccount(customer,acc);
		if (on2) {
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to lodge:");
			NumberCheck numberCheck=new NumberCheck();
			if (numberCheck.isNumeric(balanceTest)) {
				balance = Double.parseDouble(balanceTest);

			} else {
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "Oops!",
						JOptionPane.INFORMATION_MESSAGE);
			}

			BalanceUpdate balanceUpdate =new BalanceUpdate();
			balanceUpdate.theBalance(type,balance,acc);
		}else{
			oldFrame.dispose();
			chooseAccountFrame.dispose();
		}
	}
}