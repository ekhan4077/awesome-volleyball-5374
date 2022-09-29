package com.foodapp.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.Repository.OrderDetailsDao;
import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.OrderException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Customer;
import com.foodapp.model.OrderDetails;
import com.foodapp.model.Restaurant;
import com.foodapp.service.OrderService;

@Service

public class OrderDetailsImpl implements OrderService {
   @Autowired
   private OrderDetailsDao orderdao;
	@Override
	public OrderDetails addOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt=orderdao.findById(order.getOrderId());
		if(opt.isPresent()) {
			throw new OrderException("this order is already placed");
		}
		return orderdao.save(order);
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt=orderdao.findById(order.getOrderId());
		if(!opt.isPresent()) {
			throw new OrderException("Order not Exists");
		}
		return orderdao.save(order);
	}

	@Override
	public OrderDetails removeOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt=orderdao.findById(order.getOrderId());
		if(!opt.isPresent()) {
			throw new OrderException("Order not Exists");
		}
	orderdao.delete(order);
	return opt.get();
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) throws OrderException {
		Optional<OrderDetails> opt=orderdao.findById(order.getOrderId());
		if(!opt.isPresent()) {
			throw new OrderException("Order not Exists");
		}
	   
	   return opt.get();
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant rest) throws OrderException, RestaurantException {
		
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) throws OrderException, CustomerException {
		// TODO Auto-generated method stub
		return null;
	}

}
