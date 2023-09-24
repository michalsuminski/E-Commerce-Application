package src.com.backend.menu.impl;

import java.util.Scanner;

import src.com.backend.configs.ApplicationContext;
import src.com.backend.enteties.Product;
import src.com.backend.menu.Menu;
import src.com.backend.services.ProductManagementService;
import src.com.backend.services.impl.DefaultProductManagementService;

public class ProductCatalogMenu implements Menu {

	private static final String CHECKOUT_COMMAND = "checkout";
	private ApplicationContext context;
	private ProductManagementService productManagementService;

	{
		context = ApplicationContext.getInstance();
		productManagementService = DefaultProductManagementService.getInstance();
	}

	@Override
	public void start() {
		while(true) {
			this.printMenuHeader();
			Product[] products = productManagementService.getProducts();
			for(Product p : products) {
				System.out.println(p);
			}
			Scanner sc = new Scanner(System.in);
			System.out.print("Product ID to add to cart: ");
			String productID = sc.nextLine();
			if(productID.equals("menu")) {
				context.getMainMenu().start();
			}else if(productID.equals("checkout")) {
				if(context.getSessionCart().getProducts() != null) {
					if(context.getLoggedInUser() != null) {  // checking if user is logged in
						Menu checkoutMenu = new CheckoutMenu();
						checkoutMenu.start();	
					}else {
						System.out.println("You are not logged in. Please, sign in or create new account");
						return;
					}
				}else {
					System.out.println("Your cart is empty. Please, add product to cart first and then proceed with checkout");
				}
			}else {
				Product product = productManagementService.getProductById(Integer.valueOf(productID));
				if(product == null) {
					System.out.println("Please, enter product ID if you want to add product to cart. Or enter ‘checkout’ if you want to proceed with checkout. "
							+ "Or enter ‘menu’ if you want to navigate back to the main menu");
				}else {
					System.out.println("Product " + product.getProductName() + " has been added to your cart. If you want to add a new product - enter the product id. "
							+ "If you want to proceed with checkout - enter word 'checkout' to console");
					context.getSessionCart().addProduct(product);
				}
			}
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** PRODUCT CATALOG *****");	
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
	}

}
