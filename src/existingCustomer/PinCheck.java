package existingCustomer;
import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Customer;
import entity.CustomerAccount;
import entity.CustomerCurrentAccount;
import entity.CustomerDepositAccount;

public class PinCheck {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private boolean on2;

	public boolean checkAccount(Customer customer,  boolean on, CustomerAccount acc) {
		this.acc = acc;
		if (acc instanceof CustomerCurrentAccount) {
			int count = 3;
			int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
			boolean loop=true;
			while (loop) {
				String pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
				try {
					int pin2 = Integer.parseInt(pin);
					if (on) {
						if (checkPin == pin2) {
							loop = false;
							JOptionPane.showMessageDialog(f, "Pin entry successful", "Pin",
									JOptionPane.INFORMATION_MESSAGE);
							on2= true;
						} else {
							count--;
							JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining.", "Pin",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}

					if (count == 0) {
						JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked.", "Pin",
								JOptionPane.INFORMATION_MESSAGE);
						((CustomerCurrentAccount) acc).getAtm().setValid(false);
						ChooseAccount chooseAccount = new ChooseAccount();
						loop = false;
						on = false;
						on2= false;
						System.out.println("should only be in here if you got it wrong three times");

					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}else if(acc instanceof CustomerDepositAccount){
			on2=true;
		}
		return on2;
	}
}
