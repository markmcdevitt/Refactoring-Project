import java.awt.Container;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PinCheck {

	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private Customer customer;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;
	private JComboBox<String> box;
	private boolean on2;

	public boolean checkAccount(Customer customer,  boolean on, CustomerAccount acc) {
		this.acc = acc;
		System.out.println("In the current Account" + acc.toString());
		if (acc instanceof CustomerCurrentAccount) {
			System.out.println("in the if");
			int count = 3;
			int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
			boolean loop=true;
			while (loop) {
				String pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
				System.out.println("at the pin");
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
