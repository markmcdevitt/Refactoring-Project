package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.junit.Assert;
import org.junit.Test;

import Menu.Menu;
import entity.AccountTransaction;
import entity.Customer;
import entity.CustomerAccount;
import frames.JFrameClass;
import newCustomer.AddCustomerDetails;

public class Tests {
	private Menu menu;
	private ArrayList<CustomerAccount> accounts;
	private ArrayList<AccountTransaction> AccountTransactionList;
	private JFrame f1;

	@Test
	public void createAccountTransaction() {
		AccountTransactionList = new ArrayList<AccountTransaction>();
		AccountTransaction accountTransaction = new AccountTransaction("12/08/2005", "Withdrew", 120.04);
		AccountTransactionList.add(accountTransaction);
	}

	@Test
	public void createCustomerAccount() {

		CustomerAccount CA = new CustomerAccount("1", 30.20, AccountTransactionList);
		accounts = new ArrayList<CustomerAccount>();
		accounts.add(CA);
	}

	@Test
	public void createNewCustomer() {
		JFrameClass jFrameClass = new JFrameClass();
		f1 = jFrameClass.createJFrame("Create New Customer", 400, 300, 200, 200);
		
		AddCustomerDetails addCustomerDetails = new AddCustomerDetails();
		Customer customer = new Customer("123", "McDevitt", "Mark", "1994", "12", "1234567", accounts);

		
		Assert.assertNotNull(customer);
		//assert.assertTrue("Customer creation should return true", addCustomerDetails.addDetails("123", "McDevitt", "Mark", "1994", f1));
	}
	@Test
	public void addUserToList(){
		ArrayList<Customer> list = new ArrayList<Customer>();
		Customer customer = new Customer("123", "McDevitt", "Mark", "1994", "12", "1234567", accounts);
		Customer customer1 = new Customer("111", "McBob", "Bob", "1989", "10", "11111", accounts);
		Customer customer2 = new Customer("444", "McSteve", "Steve", "2000", "08", "222222", accounts);
		list.add(customer);
		list.add(customer1);
		list.add(customer2);
		assertEquals("Customer list should be three",3, list.size());
	}
}
