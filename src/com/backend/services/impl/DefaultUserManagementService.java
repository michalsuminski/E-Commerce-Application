package src.com.backend.services.impl;

import src.com.backend.enteties.User;
import src.com.backend.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;

	private static DefaultUserManagementService instance; // CO TO JEST??????????

	private User[] listOfUsers;
	private int indexOfLastUser = 0;
	{
		listOfUsers = new User[DEFAULT_USERS_CAPACITY];
	}

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		if (user == null) {
			return "Provide valid user";
		} else {
			for (User u : this.listOfUsers) {
					if(this.indexOfLastUser > DEFAULT_USERS_CAPACITY) {
						System.out.println("Max users capacity exceeded!!!");
						return null;
					}else {
					this.listOfUsers[this.indexOfLastUser++] = user; // sign up new user
					return "New user is created";
					}
				}
			}
		return null; // it will never reach this but need to compile
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public User[] getUsers() {  // To think about it: should this method return an array that contains null values???
		return this.listOfUsers;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		for (User u : this.listOfUsers) {
			if (u != null) {
				if (u.getEmail().equals(userEmail)) { // NIE MOZE BYC if(u.getEmail() == userEmail)
					return u;
				}
			}
		}
		return null; // in case of user with given email not found
	}

	void clearServiceState() {
		// <write your code here>
	}
}
