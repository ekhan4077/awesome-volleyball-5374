package com.foodapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;
import com.foodapp.service.CartService;

@RestController
@RequestMapping("/cart")
public class FoodCartController {
	
	
	@Autowired
	private CartService service;
	
	@PostMapping("/add")
	public ResponseEntity<FoodCart> addNewCart(@RequestBody FoodCart cart) throws CartException{
		FoodCart newCart = service.saveFoodCart(cart);
		return new ResponseEntity<FoodCart>(newCart, HttpStatus.CREATED);
	}
	
	
	@PutMapping("/add/{cartId}/{itemId}")
	public ResponseEntity<FoodCart> addItemsToCart(@PathVariable("cartId") Integer cartId, @PathVariable("itemId") Integer itemId) throws CartException, ItemException{
		FoodCart updatedCart = service.addItemToCart(cartId, itemId);
		
		return new ResponseEntity<FoodCart>(updatedCart,HttpStatus.OK);
	}
	
	
	
	
	@GetMapping("/view/{cartId}")
	public ResponseEntity<FoodCart> viewById(@PathVariable("cartId") Integer cartId) throws CartException{
		FoodCart cart = service.viewCartById(cartId);
		
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<FoodCart> removeCart(@PathVariable("cartId") Integer cartId) throws CartException{
		FoodCart removedCart = service.clearCart(cartId);
		
		return new ResponseEntity<FoodCart>(removedCart, HttpStatus.OK);
	}
	

}
