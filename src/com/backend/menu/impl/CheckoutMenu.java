package src.com.backend.menu.impl;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.menu.Menu;
import src.com.backend.enteties.Order;
import src.com.backend.enteties.impl.DefaultOrder;
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
		while(true) {
			this.printMenuHeader();
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter your credit card number without spaces and press enter if you confirm purchase: ");
			String cardNumber = sc.nextLine();		
			//VALIDATING CARD NUMBER - only 16 digits
			if(this.createOrder(cardNumber)) {
				System.out.println("Thanks a lot for your purchase. Details about order delivery are sent to your email");
				context.getSessionCart().clear();
				context.getMainMenu().start(); // back to main menu
			} else {
				System.out.println("You entered invalid credit card number. Valid credit card should contain 16 digits. Please, try one more time.");
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** CHECKOUT *****");
	}
	
	private boolean createOrder(String creditCardNumber) {
		Order order = new DefaultOrder();
		if (!order.isCreditCardNumberValid(creditCardNumber)) {
			return false;
		}
		
		order.setCreditCardNumber(creditCardNumber);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);
		return true;
	}

}
