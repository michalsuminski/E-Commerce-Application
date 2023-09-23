package src.com.backend.enteties.impl;

import javax.imageio.metadata.IIOMetadataFormatImpl;

import src.com.backend.enteties.Cart;
import src.com.backend.enteties.Product;

public class DefaultCart implements Cart {
	
	private static final int DEFAULT_CART_CAPACITY = 10;

	private Product[] products;
	private int indexOfProduct = 0;
	
	{
		products = new Product[DEFAULT_CART_CAPACITY];
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
				this.products[this.indexOfProduct++] = product;  // add new product to the cart
			}
		}
	}

	@Override
	public Product[] getProducts() {
		Product[] res = new Product[DEFAULT_CART_CAPACITY];
		int counter = 0;
		boolean isEmpty = true;
		for(Product p : this.products) {
			if(p != null) {
				res[counter++] = p;
				isEmpty = false;
			}
		}
		if(!isEmpty){
			Product[] finalRes = new Product[counter];
			for(int i=0; i<counter; i++) {
				finalRes[i] = res[i];
			}
			return finalRes;
		}else {
			return null;	
		}
	}

	@Override
	public void clear() {
		// <write your code here>
	}

}
