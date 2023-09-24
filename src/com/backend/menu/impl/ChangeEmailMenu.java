package src.com.backend.menu.impl;

import java.util.Scanner;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.menu.Menu;

public class ChangeEmailMenu implements Menu {

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		this.printMenuHeader();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter new password: ");
		String newEmail = sc.nextLine();
		context.getLoggedInUser().setEmail(newEmail);
		System.out.println("Your email has been successfully changed");
		context.getMainMenu().start();
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHANGE EMAIL *****");
	}

}
