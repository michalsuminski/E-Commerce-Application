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
		String firstName = sc.nextLine();
		System.out.print("Please, enter your last name: ");
		String lastName = sc.nextLine();
		System.out.print("Please, enter your password: ");
		String password = sc.nextLine();
		System.out.print("Please, enter your email: ");
		String email = sc.nextLine();
		if(email.isBlank()) {
			System.out.println("You have to input email to register. Please, try one more time");
			return;
		}
		if(userManagementService.getUserByEmail(email) != null) {
			System.out.println("This email is already used by another user. Please, use another email");
			return;
		}
		DefaultUser user = new DefaultUser(firstName, lastName, email, password);
		String response = userManagementService.registerUser(user);
		System.out.println(response);
		if(response != null) {
			context.setLoggedInUser(user);
		}
		return;
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN UP *****");	
	}

}
