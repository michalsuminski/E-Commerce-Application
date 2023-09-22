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
		this.printMenuHeader();
		Product[] products = productManagementService.getProducts();
		for(Product p : products) {
			System.out.println(p);
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Product ID to add to cart: ");
		String productID = sc.next();
		if(productID.equals("menu")) {
			context.getMainMenu().start();
		}else {
			Product product = productManagementService.getProductById(Integer.valueOf(productID));
			System.out.println("Product " + product.getProductName() + " has been added to your cart. If you want to add a new product - enter the product id. "
					+ "If you want to proceed with checkout - enter word 'checkout' to console");
			context.getSessionCart().addProduct(product);
		}
	}

	@Override
	public void printMenuHeader() {
		System.out.println("***** PRODUCT CATALOG *****");	
		System.out.println("Enter product id to add it to the cart or 'menu' if you want to navigate back to the main menu");
	}

}
