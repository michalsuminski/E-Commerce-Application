package src.com.backend.services.impl;

import java.util.ArrayList;
import java.util.List;

import src.com.backend.enteties.Order;
import src.com.backend.enteties.User;
import src.com.backend.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

	private static final int DEFAULT_ORDER_CAPACITY = 10;

	private static DefaultOrderManagementService instance;

	private List<Order> listOfOrders;
	private int indexOfLastOrder = 0;
	{
		listOfOrders = new ArrayList<Order>();
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
				listOfOrders.add(order);
				this.indexOfLastOrder++;
			}
		}
	}

	@Override
	public List<Order> getOrdersByUserId(int userId) {
		return listOfOrders.stream().filter(order -> order.getCustomerId() == userId).toList();
	}

	@Override
	public List<Order> getOrders() {
		return this.listOfOrders;
	}

	void clearServiceState() {
		// <write your code here>
	}

}
