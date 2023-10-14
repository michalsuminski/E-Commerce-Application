package src.com.backend.enteties.impl;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.metadata.IIOMetadataFormatImpl;

import src.com.backend.enteties.Cart;
import src.com.backend.enteties.Product;

public class DefaultCart implements Cart {
	
	private static final int DEFAULT_CART_CAPACITY = 10;

	private List<Product> products;
	private int indexOfProduct = 0;
	
	{
		products = new ArrayList<Product>();
	}
	
	@Override
	public boolean isEmpty() {
		// <write your code here>
		
		return true;
	}

	@Override
	public void addProduct(Product product) {
		if(product == null) {
			System.out.println("Product is null!!!");
			return;
		}else {
			if(this.indexOfProduct > DefaultCart.DEFAULT_CART_CAPACITY) {
				System.out.println("Max cart capacity exceeded! Please create new order.");
				return;
			}else {
				this.products.add(product);
				this.indexOfProduct++;
			}
		}
	}

	@Override
	public List<Product> getProducts() {
		return this.products;
	}

	@Override
	public void clear() {
		products = new ArrayList<Product>();
		this.indexOfProduct = 0;
	}

}
