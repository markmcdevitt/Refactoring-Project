

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Menu extends JFrame {
	
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
	

	public void menuStart() {

		f = new JFrame("User Type");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		exit();

		JPanel userTypePanel = new JPanel();
		ButtonGroup userType = new ButtonGroup();
		JRadioButton radioButton;
		userTypePanel.add(radioButton = new JRadioButton("Existing Customer"));
		radioButton.setActionCommand("Customer");
		userType.add(radioButton);

		userTypePanel.add(radioButton = new JRadioButton("Administrator"));
		radioButton.setActionCommand("Administrator");
		userType.add(radioButton);

		userTypePanel.add(radioButton = new JRadioButton("New Customer"));
		radioButton.setActionCommand("New Customer");
		userType.add(radioButton);

		JPanel continuePanel = new JPanel();
		JButton continueButton = new JButton("Continue");
		continuePanel.add(continueButton);

		Container content = f.getContentPane();
		content.setLayout(new GridLayout(2, 1));
		content.add(userTypePanel);
		content.add(continuePanel);

		continueButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String user = userType.getSelection().getActionCommand();
				if (user.equals("New Customer")) {
					System.out.println("here?");
					NewCustomer newCustomer= new NewCustomer();
					newCustomer.newCust();
				} else if (user.equals("Administrator")) {
					administrator();
				} else if (user.equals("Customer")) {
					existingCustomer();
				}
			}
		});
		f.setVisible(true);
	}

	public void admin() {
		dispose();

		f = new JFrame("Administrator Menu");
		f.setSize(400, 400);
		f.setLocation(200, 200);
		exit();
		f.setVisible(true);

		JPanel deleteCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteCustomer = new JButton("Delete Customer");
		deleteCustomer.setPreferredSize(new Dimension(250, 20));
		deleteCustomerPanel.add(deleteCustomer);

		JPanel deleteAccountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton deleteAccount = new JButton("Delete Account");
		deleteAccount.setPreferredSize(new Dimension(250, 20));
		deleteAccountPanel.add(deleteAccount);

		JPanel bankChargesPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton bankChargesButton = new JButton("Apply Bank Charges");
		bankChargesButton.setPreferredSize(new Dimension(250, 20));
		bankChargesPanel.add(bankChargesButton);

		JPanel interestPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton interestButton = new JButton("Apply Interest");
		interestPanel.add(interestButton);
		interestButton.setPreferredSize(new Dimension(250, 20));

		JPanel editCustomerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton editCustomerButton = new JButton("Edit existing Customer");
		editCustomerPanel.add(editCustomerButton);
		editCustomerButton.setPreferredSize(new Dimension(250, 20));

		JPanel navigatePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton navigateButton = new JButton("Navigate Customer Collection");
		navigatePanel.add(navigateButton);
		navigateButton.setPreferredSize(new Dimension(250, 20));

		JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton summaryButton = new JButton("Display Summary Of All Accounts");
		summaryPanel.add(summaryButton);
		summaryButton.setPreferredSize(new Dimension(250, 20));

		JPanel accountPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton accountButton = new JButton("Add an Account to a Customer");
		accountPanel.add(accountButton);
		accountButton.setPreferredSize(new Dimension(250, 20));

		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Admin Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");

		content = f.getContentPane();
		content.setLayout(new GridLayout(9, 1));
		content.add(label1);
		content.add(accountPanel);
		content.add(bankChargesPanel);
		content.add(interestPanel);
		content.add(editCustomerPanel);
		content.add(navigatePanel);
		content.add(summaryPanel);
		content.add(deleteCustomerPanel);
		content.add(returnPanel);

		bankChargesButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				bankCharges();
			}
		});

		interestButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				intrestCharges();
			}
		});

		editCustomerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editCustomer();
			}
		});

		summaryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				summary();
			}
		});

		navigateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				navigate();
			}
		});

		accountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				account();
			}
		});

		deleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteCustomer();
			}
		});

		deleteAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteAccount();
			}

		});
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				returnButton();
			}
		});
	}

	public void customer(Customer e1) {
		f = new JFrame("Customer Menu");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		exit();
		f.setVisible(true);
		e = e1;

		if (e1.getAccounts().size() == 0) {
			JOptionPane.showMessageDialog(f,
					"This customer does not have any accounts yet. \n An admin must create an account for this customer \n for them to be able to use customer functionality. ",
					"Oops!", JOptionPane.INFORMATION_MESSAGE);
			f.dispose();
			menuStart();
		} else {
			JPanel buttonPanel = new JPanel();
			JPanel boxPanel = new JPanel();
			JPanel labelPanel = new JPanel();

			JLabel label = new JLabel("Select Account:");
			labelPanel.add(label);

			JButton returnButton = new JButton("Return");
			buttonPanel.add(returnButton);
			JButton continueButton = new JButton("Continue");
			buttonPanel.add(continueButton);

			box = new JComboBox<String>();
			for (int i = 0; i < e1.getAccounts().size(); i++) {
				box.addItem(e1.getAccounts().get(i).getNumber());
			}

			boxPanel.add(box);
			content = f.getContentPane();
			content.setLayout(new GridLayout(3, 1));
			content.add(labelPanel);
			content.add(boxPanel);
			content.add(buttonPanel);

			returnButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					returnButton();
				}
			});

			continueButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					continueButton();
				}
			});
		}
	}

	public static boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void administrator() {

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
					f1.dispose();
					loop = false;
					loop2 = false;
					menuStart();
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
				if (reply == JOptionPane.YES_OPTION) {

				} else if (reply == JOptionPane.NO_OPTION) {
					f1.dispose();
					loop2 = false;
					menuStart();
				}
			} else {
				loop2 = false;
				cont = true;
			}
		}

		if (cont) {
			System.out.println("in here?");
			// f1.dispose(); I did this
			loop = false;
			admin();
		}

	}

	public void existingCustomer() {

		boolean loop = true;
		boolean cont = false;
		boolean found = false;
		Customer customer = null;

		while (loop) {
			Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");
			Object customerPassword = JOptionPane.showInputDialog(f, "Enter Customer Password;");
			for (Customer aCustomer : getCustomerList()) {
				if (aCustomer.getCustomerID().equals(customerID)) {
					customer = aCustomer;
					if (customer.getPassword().equals(customerPassword)) {
						found = true;
					}
				}
			}
			if (found == false) {
				int reply = JOptionPane.showConfirmDialog(null, null, "Details are incorrect. Try again?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.NO_OPTION) {
					f.dispose();
					loop = false;
					menuStart();
				}
			} else {
				loop = false;
				cont = true;
			}
		}
		if (cont) {
			f.dispose();
			loop = false;
			customer(customer);
		}

	}

	public void bankCharges() {

		boolean loop = true;

		boolean found = false;

		if (getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(f, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
			f.dispose();
			admin();

		} else {
			while (loop) {
				Object customerID = JOptionPane.showInputDialog(f,
						"Customer ID of Customer You Wish to Apply Charges to:");

				for (Customer aCustomer : getCustomerList()) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
						loop = false;
					}
				}

				if (found == false) {
					int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						loop = true;
					} else if (reply == JOptionPane.NO_OPTION) {
						f.dispose();
						loop = false;

						admin();
					}
				} else {
					f.dispose();
					f = new JFrame("Administrator Menu");
					f.setSize(400, 300);
					f.setLocation(200, 200);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							System.exit(0);
						}
					});
					f.setVisible(true);

					JComboBox<String> box = new JComboBox<String>();
					for (int i = 0; i < customer.getAccounts().size(); i++) {

						box.addItem(customer.getAccounts().get(i).getNumber());
					}

					box.getSelectedItem();

					JPanel boxPanel = new JPanel();
					boxPanel.add(box);

					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Charge");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = f.getContentPane();
					content.setLayout(new GridLayout(2, 1));

					content.add(boxPanel);
					content.add(buttonPanel);

					if (customer.getAccounts().isEmpty()) {
						JOptionPane.showMessageDialog(f,
								"This customer has no accounts! \n The admin must add acounts to this customer.",
								"Oops!", JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						admin();
					} else {

						for (int i = 0; i < customer.getAccounts().size(); i++) {
							if (customer.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
								acc = customer.getAccounts().get(i);
							}
						}

						continueButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								String euro = "\u20ac";

								if (acc instanceof CustomerDepositAccount) {

									JOptionPane.showMessageDialog(f, "25" + euro + " deposit account fee aplied.", "",
											JOptionPane.INFORMATION_MESSAGE);
									acc.setBalance(acc.getBalance() - 25);
									JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance(), "Success!",
											JOptionPane.INFORMATION_MESSAGE);
								}

								if (acc instanceof CustomerCurrentAccount) {

									JOptionPane.showMessageDialog(f, "15" + euro + " current account fee aplied.", "",
											JOptionPane.INFORMATION_MESSAGE);
									acc.setBalance(acc.getBalance() - 25);
									JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance(), "Success!",
											JOptionPane.INFORMATION_MESSAGE);
								}

								f.dispose();
								admin();
							}
						});

						returnButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								f.dispose();
								menuStart();
							}
						});

					}
				}
			}
		}

	}

	public void intrestCharges() {

		boolean loop = true;

		boolean found = false;

		if (getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(f, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
			f.dispose();
			admin();

		} else {
			while (loop) {
				Object customerID = JOptionPane.showInputDialog(f,
						"Customer ID of Customer You Wish to Apply Interest to:");

				for (Customer aCustomer : getCustomerList()) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
						loop = false;
					}
				}

				if (found == false) {
					int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						loop = true;
					} else if (reply == JOptionPane.NO_OPTION) {
						f.dispose();
						loop = false;

						admin();
					}
				} else {
					f.dispose();
					f = new JFrame("Administrator Menu");
					f.setSize(400, 300);
					f.setLocation(200, 200);
					f.addWindowListener(new WindowAdapter() {
						public void windowClosing(WindowEvent we) {
							System.exit(0);
						}
					});
					f.setVisible(true);

					JComboBox<String> box = new JComboBox<String>();
					for (int i = 0; i < customer.getAccounts().size(); i++) {

						box.addItem(customer.getAccounts().get(i).getNumber());
					}

					box.getSelectedItem();

					JPanel boxPanel = new JPanel();

					JLabel label = new JLabel("Select an account to apply interest to:");
					boxPanel.add(label);
					boxPanel.add(box);
					JPanel buttonPanel = new JPanel();
					JButton continueButton = new JButton("Apply Interest");
					JButton returnButton = new JButton("Return");
					buttonPanel.add(continueButton);
					buttonPanel.add(returnButton);
					Container content = f.getContentPane();
					content.setLayout(new GridLayout(2, 1));

					content.add(boxPanel);
					content.add(buttonPanel);

					if (customer.getAccounts().isEmpty()) {
						JOptionPane.showMessageDialog(f,
								"This customer has no accounts! \n The admin must add acounts to this customer.",
								"Oops!", JOptionPane.INFORMATION_MESSAGE);
						f.dispose();
						admin();
					} else {

						for (int i = 0; i < customer.getAccounts().size(); i++) {
							if (customer.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
								acc = customer.getAccounts().get(i);
							}
						}

						continueButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								String euro = "\u20ac";
								double interest = 0;
								boolean loop = true;

								while (loop) {
									String interestString = JOptionPane.showInputDialog(f,
											"Enter interest percentage you wish to apply: \n NOTE: Please enter a numerical value. (with no percentage sign) \n E.g: If you wish to apply 8% interest, enter '8'");
									if (isNumeric(interestString)) {

										interest = Double.parseDouble(interestString);
										loop = false;

										acc.setBalance(acc.getBalance() + (acc.getBalance() * (interest / 100)));

										JOptionPane
												.showMessageDialog(f,
														interest + "% interest applied. \n new balance = "
																+ acc.getBalance() + euro,
														"Success!", JOptionPane.INFORMATION_MESSAGE);
									}

									else {
										JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "Oops!",
												JOptionPane.INFORMATION_MESSAGE);
									}

								}

								f.dispose();
								admin();
							}
						});

						returnButton.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent ae) {
								f.dispose();
								menuStart();
							}
						});

					}
				}
			}
		}

	}

	public void editCustomer() {

		boolean loop = true;

		boolean found = false;

		if (getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(f, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
			f.dispose();
			admin();

		} else {

			while (loop) {
				Object customerID = JOptionPane.showInputDialog(f, "Enter Customer ID:");

				for (Customer aCustomer : getCustomerList()) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
					}
				}

				if (found == false) {
					int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						loop = true;
					} else if (reply == JOptionPane.NO_OPTION) {
						f.dispose();
						loop = false;

						admin();
					}
				} else {
					loop = false;
				}

			}

			f.dispose();

			f.dispose();
			f = new JFrame("Administrator Menu");
			f.setSize(400, 300);
			f.setLocation(200, 200);
			f.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
					System.exit(0);
				}
			});

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

			JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

			JPanel cancelPanel = new JPanel();

			textPanel.add(firstNameLabel);
			textPanel.add(firstNameTextField);
			textPanel.add(surnameLabel);
			textPanel.add(surnameTextField);
			textPanel.add(pPPSLabel);
			textPanel.add(pPSTextField);
			textPanel.add(dOBLabel);
			textPanel.add(dOBTextField);
			textPanel.add(customerIDLabel);
			textPanel.add(customerIDTextField);
			textPanel.add(passwordLabel);
			textPanel.add(passwordTextField);

			firstNameTextField.setText(customer.getFirstName());
			surnameTextField.setText(customer.getSurname());
			pPSTextField.setText(customer.getPPS());
			dOBTextField.setText(customer.getDOB());
			customerIDTextField.setText(customer.getCustomerID());
			passwordTextField.setText(customer.getPassword());

			// JLabel label1 = new JLabel("Edit customer details below.
			// The save");

			JButton saveButton = new JButton("Save");
			JButton cancelButton = new JButton("Exit");

			cancelPanel.add(cancelButton, BorderLayout.SOUTH);
			cancelPanel.add(saveButton, BorderLayout.SOUTH);
			// content.removeAll();
			Container content = f.getContentPane();
			content.setLayout(new GridLayout(2, 1));
			content.add(textPanel, BorderLayout.NORTH);
			content.add(cancelPanel, BorderLayout.SOUTH);

			f.setContentPane(content);
			f.setSize(340, 350);
			f.setLocation(200, 200);
			f.setVisible(true);
			f.setResizable(false);

			saveButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					customer.setFirstName(firstNameTextField.getText());
					customer.setSurname(surnameTextField.getText());
					customer.setPPS(pPSTextField.getText());
					customer.setDOB(dOBTextField.getText());
					customer.setCustomerID(customerIDTextField.getText());
					customer.setPassword(passwordTextField.getText());

					JOptionPane.showMessageDialog(null, "Changes Saved.");
				}
			});

			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();

					admin();
				}
			});
		}

	}

	public void summary() {

		f.dispose();

		f = new JFrame("Summary of Transactions");
		f.setSize(400, 700);
		f.setLocation(200, 200);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		f.setVisible(true);

		JLabel label1 = new JLabel("Summary of all transactions: ");

		JPanel returnPanel = new JPanel();
		JButton returnButton = new JButton("Return");
		returnPanel.add(returnButton);

		JPanel textPanel = new JPanel();

		textPanel.setLayout(new BorderLayout());
		JTextArea textArea = new JTextArea(40, 20);
		textArea.setEditable(false);
		textPanel.add(label1, BorderLayout.NORTH);
		textPanel.add(textArea, BorderLayout.CENTER);
		textPanel.add(returnButton, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(textArea);
		textPanel.add(scrollPane);

		for (int a = 0; a < getCustomerList().size(); a++)// For each
														// customer, for
														// each account,
														// it displays
														// each
														// transaction.
		{
			for (int b = 0; b < getCustomerList().get(a).getAccounts().size(); b++) {
				acc = getCustomerList().get(a).getAccounts().get(b);
				for (int c = 0; c < getCustomerList().get(a).getAccounts().get(b).getTransactionList().size(); c++) {

					textArea.append(acc.getTransactionList().get(c).toString());
					// Int total =
					// acc.getTransactionList().get(c).getAmount(); //I
					// was going to use this to keep a running total but
					// I couldnt get it working.

				}
			}
		}

		textPanel.add(textArea);
		content.removeAll();

		Container content = f.getContentPane();
		content.setLayout(new GridLayout(1, 1));
		// content.add(label1);
		content.add(textPanel);
		// content.add(returnPanel);

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				admin();
			}
		});

	}

	public void navigate() {

		f.dispose();

		if (getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
			admin();
		} else {

			JButton first, previous, next, last, cancel;
			JPanel gridPanel, buttonPanel, cancelPanel;

			Container content = getContentPane();

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

			firstNameTextField.setText(getCustomerList().get(0).getFirstName());
			surnameTextField.setText(getCustomerList().get(0).getSurname());
			pPSTextField.setText(getCustomerList().get(0).getPPS());
			dOBTextField.setText(getCustomerList().get(0).getDOB());
			customerIDTextField.setText(getCustomerList().get(0).getCustomerID());
			passwordTextField.setText(getCustomerList().get(0).getPassword());

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
					firstNameTextField.setText(getCustomerList().get(0).getFirstName());
					surnameTextField.setText(getCustomerList().get(0).getSurname());
					pPSTextField.setText(getCustomerList().get(0).getPPS());
					dOBTextField.setText(getCustomerList().get(0).getDOB());
					customerIDTextField.setText(getCustomerList().get(0).getCustomerID());
					passwordTextField.setText(getCustomerList().get(0).getPassword());
				}
			});

			previous.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					if (position < 1) {
						// don't do anything
					} else {
						position = position - 1;

						firstNameTextField.setText(getCustomerList().get(position).getFirstName());
						surnameTextField.setText(getCustomerList().get(position).getSurname());
						pPSTextField.setText(getCustomerList().get(position).getPPS());
						dOBTextField.setText(getCustomerList().get(position).getDOB());
						customerIDTextField.setText(getCustomerList().get(position).getCustomerID());
						passwordTextField.setText(getCustomerList().get(position).getPassword());
					}
				}
			});

			next.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					if (position == getCustomerList().size() - 1) {
						// don't do anything
					} else {
						position = position + 1;

						firstNameTextField.setText(getCustomerList().get(position).getFirstName());
						surnameTextField.setText(getCustomerList().get(position).getSurname());
						pPSTextField.setText(getCustomerList().get(position).getPPS());
						dOBTextField.setText(getCustomerList().get(position).getDOB());
						customerIDTextField.setText(getCustomerList().get(position).getCustomerID());
						passwordTextField.setText(getCustomerList().get(position).getPassword());
					}

				}
			});

			last.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {

					position = getCustomerList().size() - 1;

					firstNameTextField.setText(getCustomerList().get(position).getFirstName());
					surnameTextField.setText(getCustomerList().get(position).getSurname());
					pPSTextField.setText(getCustomerList().get(position).getPPS());
					dOBTextField.setText(getCustomerList().get(position).getDOB());
					customerIDTextField.setText(getCustomerList().get(position).getCustomerID());
					passwordTextField.setText(getCustomerList().get(position).getPassword());
				}
			});

			cancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					dispose();
					admin();
				}
			});
			setContentPane(content);
			setSize(400, 300);
			setVisible(true);
		}

	}

	public void account() {

		f.dispose();

		if (getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(f, "There are no customers yet!", "Oops!", JOptionPane.INFORMATION_MESSAGE);
			f.dispose();
			admin();
		} else {
			boolean loop = true;

			boolean found = false;

			while (loop) {
				Object customerID = JOptionPane.showInputDialog(f,
						"Customer ID of Customer You Wish to Add an Account to:");

				for (Customer aCustomer : getCustomerList()) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
					}
				}

				if (found == false) {
					int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						loop = true;
					} else if (reply == JOptionPane.NO_OPTION) {
						f.dispose();
						loop = false;

						admin();
					}
				} else {
					loop = false;
					// a combo box in an dialog box that asks the admin
					// what type of account they wish to create
					// (deposit/current)
					String[] choices = { "Current Account", "Deposit Account" };
					String account = (String) JOptionPane.showInputDialog(null, "Please choose account type",
							"Account Type", JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]);

					if (account.equals("Current Account")) {
						// create current account
						boolean valid = true;
						double balance = 0;
						String number = String.valueOf(
								"C" + (getCustomerList().indexOf(customer) + 1) * 10 + (customer.getAccounts().size() + 1));// this
																														// simple
																														// algorithm
																														// generates
																														// the
																														// account
																														// number
						ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();
						int randomPIN = (int) (Math.random() * 9000) + 1000;
						String pin = String.valueOf(randomPIN);

						ATMCard atm = new ATMCard(randomPIN, valid);

						CustomerCurrentAccount current = new CustomerCurrentAccount(atm, number, balance,
								transactionList);

						customer.getAccounts().add(current);
						JOptionPane.showMessageDialog(f, "Account number = " + number + "\n PIN = " + pin,
								"Account created.", JOptionPane.INFORMATION_MESSAGE);

						f.dispose();
						admin();
					}

					if (account.equals("Deposit Account")) {
						// create deposit account

						double balance = 0, interest = 0;
						String number = String.valueOf(
								"D" + (getCustomerList().indexOf(customer) + 1) * 10 + (customer.getAccounts().size() + 1));// this
																														// simple
																														// algorithm
																														// generates
																														// the
																														// account
																														// number
						ArrayList<AccountTransaction> transactionList = new ArrayList<AccountTransaction>();

						CustomerDepositAccount deposit = new CustomerDepositAccount(interest, number, balance,
								transactionList);

						customer.getAccounts().add(deposit);
						JOptionPane.showMessageDialog(f, "Account number = " + number, "Account created.",
								JOptionPane.INFORMATION_MESSAGE);

						f.dispose();
						admin();
					}

				}
			}
		}

	}

	public void deleteCustomer() {

		boolean found = true, loop = true;

		if (getCustomerList().isEmpty()) {
			JOptionPane.showMessageDialog(null, "There are currently no customers to display. ");
			dispose();
			admin();
		} else {
			{
				Object customerID = JOptionPane.showInputDialog(f, "Customer ID of Customer You Wish to Delete:");

				for (Customer aCustomer : getCustomerList()) {

					if (aCustomer.getCustomerID().equals(customerID)) {
						found = true;
						customer = aCustomer;
						loop = false;
					}
				}

				if (found == false) {
					int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						loop = true;
					} else if (reply == JOptionPane.NO_OPTION) {
						f.dispose();
						loop = false;

						admin();
					}
				} else {
					if (customer.getAccounts().size() > 0) {
						JOptionPane.showMessageDialog(f,
								"This customer has accounts. \n You must delete a customer's accounts before deleting a customer ",
								"Oops!", JOptionPane.INFORMATION_MESSAGE);
					} else {
						getCustomerList().remove(customer);
						JOptionPane.showMessageDialog(f, "Customer Deleted ", "Success.",
								JOptionPane.INFORMATION_MESSAGE);
					}
				}

			}
		}

	}

	public void deleteAccount() {

		boolean found = true, loop = true;

		{
			Object customerID = JOptionPane.showInputDialog(f,
					"Customer ID of Customer from which you wish to delete an account");

			for (Customer aCustomer : getCustomerList()) {

				if (aCustomer.getCustomerID().equals(customerID)) {
					found = true;
					customer = aCustomer;
					loop = false;
				}
			}

			if (found == false) {
				int reply = JOptionPane.showConfirmDialog(null, null, "User not found. Try again?",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					loop = true;
				} else if (reply == JOptionPane.NO_OPTION) {
					f.dispose();
					loop = false;

					admin();
				}
			} else {
				// Here I would make the user select a an account to
				// delete from a combo box. If the account had a balance
				// of 0 then it would be deleted. (I do not have time to
				// do this)
			}

		}

	}

	public void returnButton() {
		f.dispose();
		menuStart();

	}

	public void exit() {
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

	}

	public void continueButton() {

		f.dispose();

		f = new JFrame("Customer Menu");
		f.setSize(400, 300);
		f.setLocation(200, 200);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		f.setVisible(true);

		for (int i = 0; i < e.getAccounts().size(); i++) {
			if (e.getAccounts().get(i).getNumber() == box.getSelectedItem()) {
				acc = e.getAccounts().get(i);
			}
		}

		JPanel statementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton statementButton = new JButton("Display Bank Statement");
		statementButton.setPreferredSize(new Dimension(250, 20));

		statementPanel.add(statementButton);

		JPanel lodgementPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton lodgementButton = new JButton("Lodge money into account");
		lodgementPanel.add(lodgementButton);
		lodgementButton.setPreferredSize(new Dimension(250, 20));

		JPanel withdrawalPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JButton withdrawButton = new JButton("Withdraw money from account");
		withdrawalPanel.add(withdrawButton);
		withdrawButton.setPreferredSize(new Dimension(250, 20));

		JPanel returnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		JButton returnButton = new JButton("Exit Customer Menu");
		returnPanel.add(returnButton);

		JLabel label1 = new JLabel("Please select an option");

		content = f.getContentPane();
		content.setLayout(new GridLayout(5, 1));
		content.add(label1);
		content.add(statementPanel);
		content.add(lodgementPanel);
		content.add(withdrawalPanel);
		content.add(returnPanel);

		statementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				statments();
			}
		});

		lodgementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				lodgements();
			}
		});

		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				withdraw();
			}
		});

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				customer(e);
			}
		});

	}

	public void withdraw() {

		Date date = new Date();
		boolean loop = true;
		boolean on = true;
		double withdraw = 0;
		checkAccount(loop, on);

		if (on) {
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to withdraw (max 500):");
			if (isNumeric(balanceTest)) {
				withdraw = Double.parseDouble(balanceTest);
				loop = false;

			} else {
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "!",
						JOptionPane.INFORMATION_MESSAGE);
			}
			if (withdraw > 500 || withdraw > acc.getBalance()) {
				JOptionPane.showMessageDialog(f, "500 is the maximum you can withdraw at a time or check your balance",
						"Oops!", JOptionPane.INFORMATION_MESSAGE);
				withdraw = 0;
			}
			String euro = "\u20ac";
			acc.setBalance(acc.getBalance() - withdraw);
			String date2 = date.toString();
			String type = "Withdraw";
			double amount = withdraw;

			AccountTransaction transaction = new AccountTransaction(date2, type, amount);
			acc.getTransactionList().add(transaction);

			JOptionPane.showMessageDialog(f, euro + withdraw + " withdrawn.", "Withdraw",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro, "Withdraw",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void checkAccount(boolean loop, boolean on) {

		if (acc instanceof CustomerCurrentAccount) {
			int count = 3;
			int checkPin = ((CustomerCurrentAccount) acc).getAtm().getPin();
			loop = true;

			while (loop) {
				if (count == 0) {
					JOptionPane.showMessageDialog(f, "Pin entered incorrectly 3 times. ATM card locked.", "Pin",
							JOptionPane.INFORMATION_MESSAGE);
					((CustomerCurrentAccount) acc).getAtm().setValid(false);
					customer(e);
					loop = false;
					on = false;
				}
				String pin = JOptionPane.showInputDialog(f, "Enter 4 digit PIN;");
				try {
					int pin2 = Integer.parseInt(pin);
					if (on) {
						if (checkPin == pin2) {
							loop = false;
							JOptionPane.showMessageDialog(f, "Pin entry successful", "Pin",
									JOptionPane.INFORMATION_MESSAGE);
						} else {
							count--;
							JOptionPane.showMessageDialog(f, "Incorrect pin. " + count + " attempts remaining.", "Pin",
									JOptionPane.INFORMATION_MESSAGE);
						}
					}
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}
	}

	public void lodgements() {

		boolean loop = true;
		boolean on = true;
		double balance = 0;
		checkAccount(loop, on);

		if (on == true) {
			String balanceTest = JOptionPane.showInputDialog(f, "Enter amount you wish to lodge:");
			if (isNumeric(balanceTest)) {

				balance = Double.parseDouble(balanceTest);
				loop = false;

			} else {
				JOptionPane.showMessageDialog(f, "You must enter a numerical value!", "Oops!",
						JOptionPane.INFORMATION_MESSAGE);
			}

			String euro = "\u20ac";
			acc.setBalance(acc.getBalance() + balance);
			Date date = new Date();
			String date2 = date.toString();
			String type = "Lodgement";
			double amount = balance;

			AccountTransaction transaction = new AccountTransaction(date2, type, amount);
			acc.getTransactionList().add(transaction);

			JOptionPane.showMessageDialog(f, balance + euro + " added do you account!", "Lodgement",
					JOptionPane.INFORMATION_MESSAGE);
			JOptionPane.showMessageDialog(f, "New balance = " + acc.getBalance() + euro, "Lodgement",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	public void statments() {

		f.dispose();
		f = new JFrame("Customer Menu");
		f.setSize(400, 600);
		f.setLocation(200, 200);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
		f.setVisible(true);

		JLabel label1 = new JLabel("Summary of account transactions: ");

		JPanel returnPanel = new JPanel();
		JButton returnButton = new JButton("Return");
		returnPanel.add(returnButton);

		JPanel textPanel = new JPanel();

		textPanel.setLayout(new BorderLayout());
		JTextArea textArea = new JTextArea(40, 20);
		textArea.setEditable(false);
		textPanel.add(label1, BorderLayout.NORTH);
		textPanel.add(textArea, BorderLayout.CENTER);
		textPanel.add(returnButton, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane(textArea);
		textPanel.add(scrollPane);

		for (int i = 0; i < acc.getTransactionList().size(); i++) {
			textArea.append(acc.getTransactionList().get(i).toString());

		}

		textPanel.add(textArea);
		content.removeAll();

		Container content = f.getContentPane();
		content.setLayout(new GridLayout(1, 1));
		content.add(textPanel);

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				customer(e);
			}
		});

	}

	public ArrayList<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(ArrayList<Customer> customerList) {
		this.customerList = customerList;
	}
}