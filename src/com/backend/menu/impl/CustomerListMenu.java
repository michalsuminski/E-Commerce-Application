package src.com.backend.menu.impl;

import src.com.backend.configs.ApplicationContext;
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
		// <write your code here>
	}

	@Override
	public void printMenuHeader() {
		// <write your code here>	
	}

}
