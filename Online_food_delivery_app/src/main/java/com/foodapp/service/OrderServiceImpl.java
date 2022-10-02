package com.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.OrderException;

import com.foodapp.model.OrderDetails;

import com.foodapp.Repository.*;

@Service

public class OrderServiceImpl implements OrderService {
   @Autowired
   private OrderDetailsDao orderdao;
   
   @Autowired
   private CustomerDao customerdao;
   
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


//	@Override
//	public List<OrderDetails> viewAllOrders(Integer customerId) throws OrderException, CustomerException {
//		Optional<Customer> cusOpt = customerdao.findById(customerId);
//		if(cusOpt.isPresent()) {
//			Customer customer = cusOpt.get();
//			
//		}else {
//			throw new CustomerException("No Customer exists with Customer Id: "+customerId);
//		}
//	}

}
