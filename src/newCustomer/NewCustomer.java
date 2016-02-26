package newCustomer;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import entity.Customer;
import frames.JFrameClass;

public class NewCustomer {

	private ArrayList<Customer> listOfTheCustomers;
	private JFrame f1, f;
	private JLabel firstNameLabel, surnameLabel, pPPSLabel, dOBLabel;
	private JTextField firstNameTextField, surnameTextField, pPSTextField, dOBTextField;
	private JPanel panel, panel2;
	private JButton add;
	private String PPS, firstName, surname, dateOfBirth;

	public void newCust(ArrayList<Customer> listOfTheCustomers) {

		JFrameClass jFrameClass = new JFrameClass();
		f1 = jFrameClass.createJFrame("Create New Customer", 400, 300, 200, 200);
		this.listOfTheCustomers = listOfTheCustomers;

		Container content = f1.getContentPane();
		content.setLayout(new BorderLayout());

		firstNameLabel = new JLabel("First Name:", SwingConstants.RIGHT);
		surnameLabel = new JLabel("Surname:", SwingConstants.RIGHT);
		pPPSLabel = new JLabel("PPS Number:", SwingConstants.RIGHT);
		dOBLabel = new JLabel("Date of birth", SwingConstants.RIGHT);
		firstNameTextField = new JTextField(20);
		surnameTextField = new JTextField(20);
		pPSTextField = new JTextField(20);
		dOBTextField = new JTextField(20);

		panel = new JPanel(new GridLayout(6, 2));
		panel.add(firstNameLabel);
		panel.add(firstNameTextField);
		panel.add(surnameLabel);
		panel.add(surnameTextField);
		panel.add(pPPSLabel);
		panel.add(pPSTextField);
		panel.add(dOBLabel);
		panel.add(dOBTextField);

		panel2 = new JPanel();
		add = new JButton("Add");

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerDetails addCustomerDetails = new AddCustomerDetails();

				PPS = pPSTextField.getText();
				firstName = firstNameTextField.getText();
				surname = surnameTextField.getText();
				dateOfBirth = dOBTextField.getText();

				Customer c = addCustomerDetails.addDetails(PPS, firstName, surname, dateOfBirth, f1);
				listOfTheCustomers.add(c);
				JOptionPane.showMessageDialog(f,
						"CustomerID = " + c.getCustomerID() + "\n Password = " + c.getPassword(), "Customer created.",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f1.dispose();
			}
		});

		panel2.add(add);
		panel2.add(cancel);

		content.add(panel, BorderLayout.CENTER);
		content.add(panel2, BorderLayout.SOUTH);
		f1.setVisible(true);
	}

	public ArrayList<Customer> getListOfTheCustomers() {
		return listOfTheCustomers;
	}

	public void setListOfTheCustomers(ArrayList<Customer> listOfTheCustomers) {
		this.listOfTheCustomers = listOfTheCustomers;
	}

}
