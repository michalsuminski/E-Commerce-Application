package src.com.backend.storage;

import java.util.List;

import src.com.backend.enteties.Product;

public interface ProductStoringService {

	List<Product> loadProducts();
}
