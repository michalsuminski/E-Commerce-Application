package src.com.backend.enteties.impl;

import src.com.backend.enteties.Product;

public class DefaultProduct implements Product {
	
	private int id;
	private String productName;
	private String categoryName;
	private double price;

	public DefaultProduct() {
	}
	

	public DefaultProduct(int id, String productName, String categoryName, double price) {
		super();
		this.id = id;
		this.productName = productName;
		this.categoryName = categoryName;
		this.price = price;
	}


	@Override
	public String toString() {
		return "DefaultProduct [id=" + id + ", productName=" + productName + ", categoryName=" + categoryName
				+ ", price=" + price + "]";
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getProductName() {
		return productName;
	}


	@Override
	public String getCategoryName() {
		return categoryName;
	}


	@Override
	public double getPrice() {
		return price;
	}


	@Override
	public void setPrice(double price) {
		this.price = price;
	}

}
