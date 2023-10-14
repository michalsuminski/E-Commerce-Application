package src.com.backend.menu.impl;

import java.util.List;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.enteties.User;
import src.com.backend.menu.Menu;
import src.com.backend.services.UserManagementService;
import src.com.backend.services.impl.DefaultUserManagementService;

public class CustomerListMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;
	
	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		this.printMenuHeader();
		List<User> usersList = userManagementService.getUsers();
		if(usersList == null) {
			System.out.println("Customer list is empty.");
		}else {
			for(User u : usersList) {
				if(u != null) {
					System.out.println(u);
				}
			}
		}
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CUSTOMER LIST *****");	
	}

}
