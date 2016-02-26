package administrator;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import entity.Customer;

public class AdministratorLogin {

	private ArrayList<Customer> listOfTheCustomers;
	private JFrame f, f1;

	public void administratorLogin(ArrayList<Customer> listOfTheCustomers) {
		Administrator administrator = new Administrator();
		this.listOfTheCustomers=listOfTheCustomers;

		boolean loop = true, loop2 = true;
		boolean cont = false;
		while (loop) {
			Object adminUsername = JOptionPane.showInputDialog(f, "Enter Administrator Username:");

			if (!adminUsername.equals("admin")) {
				int reply = JOptionPane.showConfirmDialog(null, null, "Incorrect Username. Try again?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					loop = true;
				} else if (reply == JOptionPane.NO_OPTION) {
					loop = false;
					loop2 = false;
				}
			} else {
				loop = false;
			}
		}

		while (loop2) {
			Object adminPassword = JOptionPane.showInputDialog(f, "Enter Administrator Password;");
			if (!adminPassword.equals("admin11")) {
				int reply = JOptionPane.showConfirmDialog(null, null, "Incorrect Password. Try again?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.NO_OPTION) {
					loop2 = false;
				}
			} else {
				loop2 = false;
				cont = true;
			}
		}

		if (cont) {
			System.out.println("in here?");
			loop = false;
			administrator.admin(listOfTheCustomers);
		}

	}

	public ArrayList<Customer> getListOfTheCustomers() {
		return listOfTheCustomers;
	}

	public void setListOfTheCustomers(ArrayList<Customer> listOfTheCustomers) {
		this.listOfTheCustomers = listOfTheCustomers;
	}

}
