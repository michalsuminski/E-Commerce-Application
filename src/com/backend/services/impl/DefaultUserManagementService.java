package src.com.backend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import src.com.backend.enteties.User;
import src.com.backend.services.UserManagementService;

public class DefaultUserManagementService implements UserManagementService {

	private static final String NOT_UNIQUE_EMAIL_ERROR_MESSAGE = "This email is already used by another user. Please, use another email";
	private static final String EMPTY_EMAIL_ERROR_MESSAGE = "You have to input email to register. Please, try one more time";
	private static final String NO_ERROR_MESSAGE = "";

	private static final int DEFAULT_USERS_CAPACITY = 10;

	private static DefaultUserManagementService instance; // CO TO JEST??????????

	private List<User> listOfUsers;
	private int indexOfLastUser = 0;
	{
		listOfUsers = new ArrayList<User>();
	}

	private DefaultUserManagementService() {
	}

	@Override
	public String registerUser(User user) {
		if (user == null) {
			return "Provide valid user";
		} else {
				if(this.indexOfLastUser > DEFAULT_USERS_CAPACITY) {
					System.out.println("Max users capacity exceeded!!!");
					return null;
				}else {
				this.listOfUsers.add(user);
				this.indexOfLastUser++;
				return "New user is created";
				}
			}
	}

	public static UserManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultUserManagementService();
		}
		return instance;
	}

	@Override
	public List<User> getUsers() {  // To think about it: should this method return an array that contains null values???
		return this.listOfUsers;
	}

	@Override
	public User getUserByEmail(String userEmail) {
		Optional<User> result = this.listOfUsers.stream().filter(user -> user.getEmail().equals(userEmail)).findFirst();
		return result.orElse(null);
	}

	void clearServiceState() {
		// <write your code here>
	}
}
