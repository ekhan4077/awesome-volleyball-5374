package com.foodapp.service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;
import com.foodapp.model.Item;

public interface CartService {

	
	public FoodCart addItemToCart(FoodCart cart, Item item) throws CartException;
	
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) throws CartException,ItemException;
	
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) throws CartException,ItemException;
	
	public FoodCart removeItem(FoodCart cart, Item item) throws CartException,ItemException;
	
	public FoodCart clearCart(FoodCart cart) throws CartException;
	

}
