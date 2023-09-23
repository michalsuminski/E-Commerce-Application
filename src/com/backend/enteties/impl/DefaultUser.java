package src.com.backend.enteties.impl;

import src.com.backend.enteties.User;

public class DefaultUser implements User {
	
	private static int userCounter = 0;

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	
	{
		id = ++userCounter;  // automatic increment after new user is created;
	}
	
	public DefaultUser() {
	}
	

	public DefaultUser(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password; 
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getEmail() {
		return this.email;
	}
	
	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	@Override
	public int getId() {
		return this.id;
	}
	
	void clearState() {
		userCounter = 0;
	}
}
