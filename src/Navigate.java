import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Navigate {
	
	private ArrayList<Customer> listOfTheCustomers;
	private ArrayList<Customer> customerList = new ArrayList<Customer>();
	private int position = 0;
	private Customer customer, e;
	private CustomerAccount acc;
	private JFrame f, f1;
	private JLabel firstNameLabel, surnameLabel, pPPSLabel, dOBLabel, customerIDLabel, passwordLabel;
	private JTextField firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField,
			passwordTextField;
	private Container content;
	private JComboBox<String> box;
	

	Menu menu = new Menu();
	Administrator administrator = new Administrator();
	
	public void navigate(ArrayList<Customer> listOfTheCustomers) {

		f.dispose();

		this.listOfTheCustomers=listOfTheCustomers;
		
		if (menu.getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
			administrator.admin(listOfTheCustomers);
		} else {

			JButton first, previous, next, last, cancel;
			JPanel gridPanel, buttonPanel, cancelPanel;

			Container content = menu.getContentPane();

			content.setLayout(new BorderLayout());

			buttonPanel = new JPanel();
			gridPanel = new JPanel(new GridLayout(8, 2));
			cancelPanel = new JPanel();

			firstNameLabel = new JLabel("First Name:", SwingConstants.LEFT);
			surnameLabel = new JLabel("Surname:", SwingConstants.LEFT);
			pPPSLabel = new JLabel("PPS Number:", SwingConstants.LEFT);
			dOBLabel = new JLabel("Date of birth", SwingConstants.LEFT);
			customerIDLabel = new JLabel("CustomerID:", SwingConstants.LEFT);
			passwordLabel = new JLabel("Password:", SwingConstants.LEFT);

			firstNameTextField = new JTextField(20);
			surnameTextField = new JTextField(20);
			pPSTextField = new JTextField(20);
			dOBTextField = new JTextField(20);
			customerIDTextField = new JTextField(20);
			passwordTextField = new JTextField(20);

			first = new JButton("First");
			previous = new JButton("Previous");
			next = new JButton("Next");
			last = new JButton("Last");
			cancel = new JButton("Cancel");

			firstNameTextField.setText(menu.getCustomerList().get(0).getFirstName());
			surnameTextField.setText(menu.getCustomerList().get(0).getSurname());
			pPSTextField.setText(menu.getCustomerList().get(0).getPPS());
			dOBTextField.setText(menu.getCustomerList().get(0).getDOB());
			customerIDTextField.setText(menu.getCustomerList().get(0).getCustomerID());
			passwordTextField.setText(menu.getCustomerList().get(0).getPassword());

			firstNameTextField.setEditable(false);
			surnameTextField.setEditable(false);
			pPSTextField.setEditable(false);
			dOBTextField.setEditable(false);
			customerIDTextField.setEditable(false);
			passwordTextField.setEditable(false);

			gridPanel.add(firstNameLabel);
			gridPanel.add(firstNameTextField);
			gridPanel.add(surnameLabel);
			gridPanel.add(surnameTextField);
			gridPanel.add(pPPSLabel);
			gridPanel.add(pPSTextField);
			gridPanel.add(dOBLabel);
			gridPanel.add(dOBTextField);
			gridPanel.add(customerIDLabel);
			gridPanel.add(customerIDTextField);
			gridPanel.add(passwordLabel);
			gridPanel.add(passwordTextField);

			buttonPanel.add(first);
			buttonPanel.add(previous);
			buttonPanel.add(next);
			buttonPanel.add(last);

			cancelPanel.add(cancel);

			content.add(gridPanel, BorderLayout.NORTH);
			content.add(buttonPanel, BorderLayout.CENTER);
			content.add(cancelPanel, BorderLayout.AFTER_LAST_LINE);
			first.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					position = 0;
					firstNameTextField.setText(menu.getCustomerList().get(0).getFirstName());
					surnameTextField.setText(menu.getCustomerList().get(0).getSurname());
					pPSTextField.setText(menu.getCustomerList().get(0).getPPS());
					dOBTextField.setText(menu.getCustomerList().get(0).getDOB());
					customerIDTextField.setText(menu.getCustomerList().get(0).getCustomerID());
					passwordTextField.setText(menu.getCustomerList().get(0).getPassword());
				}
			});

			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					if (position < 1) {
						// don't do anything
					} else {
						position = position - 1;

						firstNameTextField.setText(menu.getCustomerList().get(position).getFirstName());
						surnameTextField.setText(menu.getCustomerList().get(position).getSurname());
						pPSTextField.setText(menu.getCustomerList().get(position).getPPS());
						dOBTextField.setText(menu.getCustomerList().get(position).getDOB());
						customerIDTextField.setText(menu.getCustomerList().get(position).getCustomerID());
						passwordTextField.setText(menu.getCustomerList().get(position).getPassword());
					}
				}
			});

			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					if (position == menu.getCustomerList().size() - 1) {
						// don't do anything
					} else {
						position = position + 1;

						firstNameTextField.setText(menu.getCustomerList().get(position).getFirstName());
						surnameTextField.setText(menu.getCustomerList().get(position).getSurname());
						pPSTextField.setText(menu.getCustomerList().get(position).getPPS());
						dOBTextField.setText(menu.getCustomerList().get(position).getDOB());
						customerIDTextField.setText(menu.getCustomerList().get(position).getCustomerID());
						passwordTextField.setText(menu.getCustomerList().get(position).getPassword());
					}

				}
			});

			last.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					position = menu.getCustomerList().size() - 1;
					
					firstNameTextField.setText(menu.getCustomerList().get(position).getFirstName());
					surnameTextField.setText(menu.getCustomerList().get(position).getSurname());
					pPSTextField.setText(menu.getCustomerList().get(position).getPPS());
					dOBTextField.setText(menu.getCustomerList().get(position).getDOB());
					customerIDTextField.setText(menu.getCustomerList().get(position).getCustomerID());
					passwordTextField.setText(menu.getCustomerList().get(position).getPassword());
				}
			});

			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					menu.dispose();
					administrator.admin(listOfTheCustomers);
				}
			});
			menu.setContentPane(content);
			menu.setSize(400, 300);
			menu.setVisible(true);
		}

	}

}
