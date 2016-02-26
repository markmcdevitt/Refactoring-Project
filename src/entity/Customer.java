package entity;
import java.util.ArrayList;

public class Customer {

	private String PPS;
	private String surname;
	private String firstName;
	private String DOB;
	private String customerID;
	private String password;

	private ArrayList<CustomerAccount> accounts;

	// Blank constructor
	public Customer() {
	}

	// Constructor with details
	public Customer(String PPS, String surname, String firstName, String DOB, String customerID, String password,
			ArrayList<CustomerAccount> accounts) {
		this.PPS = PPS;
		this.surname = surname;
		this.firstName = firstName;
		this.DOB = DOB;
		this.customerID = customerID;
		this.password = password;
		this.accounts = accounts;
	}

	// Accessor methods
	public String getPPS() {
		return this.PPS;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getDOB() {
		return this.DOB;
	}

	public String getCustomerID() {
		return this.customerID;
	}

	public String getPassword() {
		return this.password;
	}

	public ArrayList<CustomerAccount> getAccounts() {
		return this.accounts;
	}

	// mutator methods
	public void setPPS(String PPS) {
		this.PPS = PPS;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setDOB(String DOB) {
		this.DOB = DOB;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAccounts(ArrayList<CustomerAccount> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		return "Customer [PPS=" + PPS + ", surname=" + surname + ", firstName=" + firstName + ", DOB=" + DOB
				+ ", customerID=" + customerID + ", password=" + password + ", accounts=" + accounts + "]";
	}



}
