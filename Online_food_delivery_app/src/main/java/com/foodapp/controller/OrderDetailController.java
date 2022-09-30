package com.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.OrderException;
import com.foodapp.model.OrderDetails;
import com.foodapp.service.OrderService;

@RestController
@RequestMapping("/order")

public class OrderDetailController {
	@Autowired
	private OrderService service;
	@PostMapping("/new")
	public ResponseEntity<OrderDetails> AddOrder(@RequestBody OrderDetails order) throws OrderException{
		OrderDetails od=service.addOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.CREATED);
		
		
	}
	@PutMapping("/update")
	public ResponseEntity<OrderDetails>updateOrder(@RequestBody OrderDetails order) throws OrderException{
		OrderDetails od=service.updateOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.CREATED);
		
		
	}
	@DeleteMapping("/remove")
	public ResponseEntity<OrderDetails>DeleteOrder(@RequestBody OrderDetails order) throws OrderException{
		OrderDetails od=service.removeOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.CREATED);
		
		
	}
	@GetMapping("/view")
	public ResponseEntity<OrderDetails>viewOrder(@RequestBody OrderDetails order) throws OrderException{
		OrderDetails od=service.viewOrder(order);
		return new ResponseEntity<OrderDetails>(od,HttpStatus.CREATED);
		
		
	}
}
