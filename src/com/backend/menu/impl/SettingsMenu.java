package src.com.backend.menu.impl;

import java.util.Scanner;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.menu.Menu;

public class SettingsMenu implements Menu {

	private static final String SETTINGS = "1. Change Password" + System.lineSeparator()
			+ "2. Change Email";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		while(true) {
			this.printMenuHeader();
			Scanner sc = new Scanner(System.in);
			System.out.print("Please, enter option or type 'menu' to navigate back to the main menu: ");
			String option = sc.nextLine();
			Menu menuToNavigate = null;
			switch (option) {
			case "1":
				menuToNavigate = new ChangePasswordMenu();
				break;
			case "2":
				menuToNavigate = new ChangeEmailMenu();
				break;
			case "menu":
				menuToNavigate = context.getMainMenu();
				break;
			default:
				System.out.println("Only 1, 2, menu is allowed. Try one more time");
				continue;
			}
			menuToNavigate.start();
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SETTINGS *****");	
		System.out.println("1. Change Password");
		System.out.println("2. Change Email");
	}

}
