package administrator;
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

public class Navigate {

	private ArrayList<Customer> listOfTheCustomers;
	private int position = 0;
	private JFrame f;
	private JLabel firstNameLabel, surnameLabel, pPPSLabel, dOBLabel, customerIDLabel, passwordLabel;
	private JTextField firstNameTextField, surnameTextField, pPSTextField, dOBTextField, customerIDTextField,
			passwordTextField;
	private Container content;

	public void navigate(ArrayList<Customer> listOfTheCustomers) {
		this.listOfTheCustomers = listOfTheCustomers;

		if (listOfTheCustomers.isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
		} else {
			JButton first, previous, next, last, cancel;
			JPanel gridPanel, buttonPanel, cancelPanel;
			f = new JFrame("Navigate Menu");

			content = f.getContentPane();
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

			positionInList(position);

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
					positionInList(position);
				}
			});
			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					position = position - 1;
					if (!positionInList(position)) {
						position = position + 1;
					}
				}
			});
			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					position = position + 1;
					if (!positionInList(position)) {
						position = position - 1;
					}
				}
			});
			last.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					position = listOfTheCustomers.size() - 1;
					positionInList(position);
				}
			});
			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					position = 0;
					f.dispose();
				}
			});
			f.setContentPane(content);
			f.setSize(400, 300);
			f.setVisible(true);
		}
	}

	public boolean positionInList(int position) {
		try {
			firstNameTextField.setText(listOfTheCustomers.get(position).getFirstName());
			surnameTextField.setText(listOfTheCustomers.get(position).getSurname());
			pPSTextField.setText(listOfTheCustomers.get(position).getPps());
			dOBTextField.setText(listOfTheCustomers.get(position).getDateOfBirth());
			customerIDTextField.setText(listOfTheCustomers.get(position).getCustomerID());
			passwordTextField.setText(listOfTheCustomers.get(position).getPassword());
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, "There are no more users", "No more users",
					JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
}