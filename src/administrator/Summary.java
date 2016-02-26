package administrator;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import entity.Customer;
import entity.CustomerAccount;

public class Summary {

	private ArrayList<Customer>listOfTheCustomers;
	private CustomerAccount acc;
	private JFrame f;
	private Container content;

	public void summary(ArrayList<Customer>listOfTheCustomers) {

		this.listOfTheCustomers=listOfTheCustomers;

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

		for (int a = 0; a < listOfTheCustomers.size(); a++) {
			for (int b = 0; b < listOfTheCustomers.get(a).getAccounts().size(); b++) {
				acc = listOfTheCustomers.get(a).getAccounts().get(b);
				for (int c = 0; c < listOfTheCustomers.get(a).getAccounts().get(b).getTransactionList()
						.size(); c++) {

					textArea.append(acc.getTransactionList().get(c).toString());
				}
			}
		}

		textPanel.add(textArea);

		Container content = f.getContentPane();
		content.setLayout(new GridLayout(1, 1));
		content.add(textPanel);

		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				
			}
		});

	}

}
