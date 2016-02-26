package tests;

import java.util.ArrayList;

import org.junit.Test;

import Menu.Menu;
import entity.AccountTransaction;
import entity.Customer;
import entity.CustomerAccount;

public class Tests {
	private Menu menu;
	private ArrayList<CustomerAccount> accounts;
	private ArrayList<AccountTransaction> AccountTransactionList;

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

		Customer customer = new Customer("123", "McDevitt", "Mark", "1994", "12", "1234567", accounts);

		//assertTrue("Customer creation should return true", menu.addDetails(customer));
	}
}
