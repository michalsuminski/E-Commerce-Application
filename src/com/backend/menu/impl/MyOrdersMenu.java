package src.com.backend.menu.impl;

import java.util.List;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.enteties.Order;
import src.com.backend.enteties.Product;
import src.com.backend.menu.Menu;
import src.com.backend.services.OrderManagementService;
import src.com.backend.services.impl.DefaultOrderManagementService;

public class MyOrdersMenu implements Menu {

	private ApplicationContext context;
	private OrderManagementService orderManagementService;

	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}

	@Override
	public void start() {
		this.printMenuHeader();
		List<Order> orders = orderManagementService.getOrders();
		if(orders == null) {
			System.out.println("Unfortunately, you don’t have any orders yet. Navigate back to main menu to place a new order");
			context.getMainMenu().start();
		}else {
			orders.stream().forEach(order -> System.out.println(order));
			context.getMainMenu().start();
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** MY ORDERS *****");			
	}

}
