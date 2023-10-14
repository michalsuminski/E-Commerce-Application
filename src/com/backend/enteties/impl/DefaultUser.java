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
	
	// kiedy User jest tworzony z poziomu programu
	public DefaultUser(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password; 
	}

	// kiedy User jest wczytywany z pliku
	public DefaultUser(int id, String firstName, String lastName, String email, String password) {
		super();
		userCounter = id; // po to, że gdy np wczytamy 3 userów z pliku, a zrobimy nowego to żeby jego id było 4 a nie znowu 0 jak, któregoś z wczytanych (tu mniejszy problem bo nie uwzględniamy usuwania konta)
		this.id = id;
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
