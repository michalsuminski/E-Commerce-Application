package src.com.backend.menu.impl;

import java.util.Scanner;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.enteties.User;
import src.com.backend.menu.Menu;
import src.com.backend.services.UserManagementService;
import src.com.backend.services.impl.DefaultUserManagementService;

public class SignInMenu implements Menu {

	private ApplicationContext context;
	private UserManagementService userManagementService;

	{
		context = ApplicationContext.getInstance();
		userManagementService = DefaultUserManagementService.getInstance();
	}

	@Override
	public void start() {
		this.printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your email: ");
		String email = sc.nextLine();
		System.out.print("Please, enter your password: ");
		String password = sc.nextLine();
		User user = userManagementService.getUserByEmail(email);
		if(user != null) {
			context.setLoggedInUser(user);
		}else {
			System.out.println("Unfortunately, such login and password doesn't exist");
		}		
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN IN *****");	
	}

}
