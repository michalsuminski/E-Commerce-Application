package src.com.backend.storage;

import java.util.List;

import src.com.backend.enteties.User;

public interface UserStoringService {
	
	void saveUser(User user);
	
	List<User> loadUsers();
}
