package entity;
import java.util.ArrayList;

public class Customer {

	private String pps;
	private String surname;
	private String firstName;
	private String dateOfBirth;
	private String customerID;
	private String password;

	private ArrayList<CustomerAccount> accounts;

	// Blank constructor
	public Customer() {
	}

	// Constructor with details
	public Customer(String pps, String surname, String firstName, String dateOfBirth, String customerID, String password,
			ArrayList<CustomerAccount> accounts) {
		this.pps = pps;
		this.surname = surname;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.customerID = customerID;
		this.password = password;
		this.accounts = accounts;
	}

	// Accessor methods
	public String getPps() {
		return this.pps;
	}

	public String getSurname() {
		return this.surname;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
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
	public void setPps(String pps) {
		this.pps = pps;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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
		return "Customer [PPS=" + pps + ", surname=" + surname + ", firstName=" + firstName + ", DOB=" + dateOfBirth
				+ ", customerID=" + customerID + ", password=" + password + ", accounts=" + accounts + "]";
	}



}
