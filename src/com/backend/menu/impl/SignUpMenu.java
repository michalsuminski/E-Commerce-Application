package src.com.backend.menu.impl;

import java.util.Scanner;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.enteties.impl.DefaultUser;
import src.com.backend.menu.Menu;
import src.com.backend.services.UserManagementService;
import src.com.backend.services.impl.DefaultUserManagementService;

public class SignUpMenu implements Menu {

	private UserManagementService userManagementService;
	private ApplicationContext context;

	{
		userManagementService = DefaultUserManagementService.getInstance();
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		this.printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Please, enter your first name: ");
		String firstName = sc.next();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.next();
		System.out.print("Please, enter your password: ");
		String password = sc.next();
		System.out.print("Please, enter your email: ");
		String email = sc.next();
		DefaultUser user = new DefaultUser(firstName, lastName, password, email);
		System.out.println(userManagementService.registerUser(user));
//		System.out.println(userManagementService.getUsers()[0]);
//		System.out.println(userManagementService.getUsers()[1]);
//		System.out.println(userManagementService.getUsers()[2]);
//		System.out.println(userManagementService.getUsers()[3]);
		context.setLoggedInUser(user);
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN UP *****");	
	}

}
