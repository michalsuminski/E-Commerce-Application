package src.com.backend.services;

import java.util.List;

import src.com.backend.enteties.User;

public interface UserManagementService {

	String registerUser(User user);
	
	List<User> getUsers();

	User getUserByEmail(String userEmail);

}
