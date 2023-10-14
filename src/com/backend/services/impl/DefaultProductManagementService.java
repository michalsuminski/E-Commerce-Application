package src.com.backend.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import src.com.backend.enteties.Product;
import src.com.backend.enteties.User;
import src.com.backend.enteties.impl.DefaultProduct;
import src.com.backend.services.ProductManagementService;
import src.com.backend.storage.ProductStoringService;
import src.com.backend.storage.impl.DefaultProductStoringService;

public class DefaultProductManagementService implements ProductManagementService {
	
	private static DefaultProductManagementService instance;
	
	private static List<Product> products;
	
	private static ProductStoringService productStoringService;
	
	static {
		productStoringService = new DefaultProductStoringService();
		loadProductsFromStorage();
	}

	public static void loadProductsFromStorage() {
		products = productStoringService.loadProducts();
	}
	
	private DefaultProductManagementService() {
		
	}

	public static ProductManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultProductManagementService();
		}
		return instance;
	}

	@Override
	public List<Product> getProducts() {
		return products;
	}

	@Override
	public Product getProductById(int productIdToAddToCart) {
		for(Product p: products) {
			if(p != null) {
				if(p.getId() == productIdToAddToCart) { 
					return p;
				}
			}
		}
		return null;  
	}

}
