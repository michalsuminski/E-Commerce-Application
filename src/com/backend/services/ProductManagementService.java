package src.com.backend.services;

import java.util.List;

import src.com.backend.enteties.Product;

public interface ProductManagementService {

	List<Product> getProducts();

	Product getProductById(int productIdToAddToCart);

}
