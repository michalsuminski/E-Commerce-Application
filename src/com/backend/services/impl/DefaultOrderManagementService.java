package src.com.backend.services.impl;

import src.com.backend.enteties.Order;
import src.com.backend.enteties.User;
import src.com.backend.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private Order[] listOfOrders;
	private int indexOfLastOrder = 0;
	{
		listOfOrders = new Order[DEFAULT_ORDER_CAPACITY];
	}

	public static OrderManagementService getInstance() {
		if (instance == null) {
			instance = new DefaultOrderManagementService();
		}
		return instance;
	}

	@Override
	public void addOrder(Order order) {
		if (order == null) {
			return;
		} else {
			if (this.indexOfLastOrder > DEFAULT_ORDER_CAPACITY) {
				System.out.println("Max users capacity exceeded!!!");
			} else {
				this.listOfOrders[this.indexOfLastOrder++] = order; // add new order
			}
		}
	}

	@Override
	public Order[] getOrdersByUserId(int userId) {
		// <write your code here>
		return null;
	}

	@Override
	public Order[] getOrders() {
		// <write your code here>
		return null;
	}

	void clearServiceState() {
		// <write your code here>
	}

}
