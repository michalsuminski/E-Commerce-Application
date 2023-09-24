package src.com.backend.menu.impl;

import java.util.Scanner;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.menu.Menu;

public class MainMenu implements Menu {

	public static final String MENU_COMMAND = "menu";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign In" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer List";

	private static final String MAIN_MENU_TEXT_FOR_LOGGED_IN_USER = "Please, enter number in console to proceed."
			+ System.lineSeparator() + "1. Sign Up" + System.lineSeparator() + "2. Sign Out" + System.lineSeparator()
			+ "3. Product Catalog" + System.lineSeparator() + "4. My Orders" + System.lineSeparator() + "5. Settings"
			+ System.lineSeparator() + "6. Customer List";

	private ApplicationContext context;

	{
		context = ApplicationContext.getInstance();
	}

	@Override
	public void start() {
		context.setMainMenu(this);
		while (true) {
			this.printMenuHeader();
			Scanner sc = new Scanner(System.in);
			System.out.print("User input: ");
			String option = sc.nextLine();
			Menu menuToNavigate = null;
			switch (option) {
			case "1":
				menuToNavigate = new SignUpMenu();
				break;
			case "2":
				if (context.getLoggedInUser() == null) {
					menuToNavigate = new SignInMenu();
				} else {
					menuToNavigate = new SignOutMenu();
				}
				break;
			case "3":
				menuToNavigate = new ProductCatalogMenu();
				break;
			case "4":
				if(context.getLoggedInUser() == null) {
					System.out.println("Please, log in or create new account to see list of your orders");
					continue;
				}else {
					menuToNavigate = new MyOrdersMenu();
					break;
				}
			case "5":
				System.out.println("5");
				break;
			case "6":
				System.out.println("6");
				System.out.println(context.getLoggedInUser());
				continue;
//					break;
			case "exit":
				System.exit(0);
				break;
			default:
				System.out.println("Only 1, 2, 3, 4, 5 is allowed. Try one more time.");
			}
			menuToNavigate.start();
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MAIN MENU *****");
		if (context.getLoggedInUser() == null) {
			System.out.print(MAIN_MENU_TEXT_FOR_LOGGED_OUT_USER + '\n');
		} else {
			System.out.print(MAIN_MENU_TEXT_FOR_LOGGED_IN_USER + '\n');
		}
	}

}
