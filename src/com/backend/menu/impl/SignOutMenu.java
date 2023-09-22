package src.com.backend.menu.impl;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.menu.Menu;

public class SignOutMenu implements Menu {

	private ApplicationContext context;
	
	{
		context = ApplicationContext.getInstance();
	}
	
	@Override
	public void start() {
		this.printMenuHeader();
		context.setLoggedInUser(null);
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** SIGN OUT *****");
		System.out.println("Have a nice day! Look forward to welcoming back!");
	}

}
