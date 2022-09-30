package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.OrderException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Customer;
import com.foodapp.model.OrderDetails;
import com.foodapp.model.Restaurant;

public interface OrderService {
	
	
	public OrderDetails addOrder(OrderDetails order) throws OrderException;
	
	public OrderDetails updateOrder(OrderDetails order) throws OrderException;
	
	public OrderDetails removeOrder(OrderDetails order) throws OrderException;
	
	public OrderDetails viewOrder(OrderDetails order) throws OrderException;
	
	//public List<OrderDetails> viewAllOrders(Restaurant rest) throws OrderException,RestaurantException;
	
	//public List<OrderDetails> viewAllOrders(Integer customerId) throws OrderException,CustomerException;
	
	
	

}
