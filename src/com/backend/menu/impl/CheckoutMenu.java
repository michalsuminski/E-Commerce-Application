package src.com.backend.menu.impl;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.menu.Menu;
import src.com.backend.services.OrderManagementService;
import src.com.backend.services.impl.DefaultOrderManagementService;

public class CheckoutMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
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
