package com.foodapp.service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;
import com.foodapp.model.Item;

public interface CartService {

	
	public FoodCart saveFoodCart(FoodCart cart)throws CartException;
	
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws CartException,ItemException;
	
	public FoodCart viewCartById(Integer cartId)throws CartException;
	
	public FoodCart clearCart(Integer cartId) throws CartException;
	
//	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) throws CartException,ItemException;
//	
//	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) throws CartException,ItemException;
//	
//	public FoodCart removeItem(FoodCart cart, Item item) throws CartException,ItemException;
//	

	

}
