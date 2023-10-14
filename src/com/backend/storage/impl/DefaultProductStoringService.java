package src.com.backend.storage.impl;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import src.com.backend.enteties.Product;
import src.com.backend.enteties.impl.DefaultProduct;
import src.com.backend.storage.ProductStoringService;

public class DefaultProductStoringService implements ProductStoringService{

	@Override
	public List<Product> loadProducts(){
		String currentDirectory = System.getProperty("user.dir") + File.separator + "resources" + File.separator + "finaltask";
		Path filePath = Paths.get(currentDirectory, "products.txt");
		System.out.println(filePath);
		if (!Files.exists(filePath)) {
			return null;
		}
		try {
			List<String[]> listOfProductsString = Files.readAllLines(filePath).stream().map(line -> line.split(",")).toList(); // tworze sobie z linii tablice id,nazwa,typ,cena
			List<Product> listOfProducts = new ArrayList<Product>();
			for(String[] productInStringArray : listOfProductsString) {
				listOfProducts.add(new DefaultProduct(Integer.parseInt(productInStringArray[0]), productInStringArray[1], productInStringArray[2], Double.parseDouble(productInStringArray[3])));
			}
			return listOfProducts;
		} catch (IOException e) {
            e.printStackTrace();
        }
		return null;  // musiałem dodać bo inaczej krzyczy, że missing return statement
	}
}
