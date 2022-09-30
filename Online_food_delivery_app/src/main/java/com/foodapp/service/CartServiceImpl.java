package com.foodapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;
import com.foodapp.model.Item;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	private com.foodapp.Repository.FoodCartDao cartDao;
	
	@Autowired
	private com.foodapp.Repository.ItemDao itemDao;
	
	
	@Override
	public FoodCart saveFoodCart(FoodCart cart) throws CartException {
		if(cart!=null) {
			return cartDao.save(cart);
		}else {
			throw new CartException("Enter valid Cart details...");
		}
		
	}
	
	
	
	@Override
	public FoodCart addItemToCart(Integer cartId, Integer itemId) throws CartException,ItemException {
		Optional<FoodCart> opt=cartDao.findById(cartId);
		if(opt.isPresent()) {
			
			FoodCart cart = opt.get();
			
			Optional<Item> itopt = itemDao.findById(itemId);
			Item item = itopt.get();
			if(item!=null) {
				
				List<Item> items = new ArrayList<>();
				items.addAll(cart.getItemList());
				items.add(item);
				
				cart.setItemList(items);
				
				return cart;
				
			}else {
				throw new ItemException("No Item exists with ID: "+itemId);
			}
			
		}else {
			throw new CartException("No Cart exist with ID: "+cartId);
		}
		
	}



	@Override
	public FoodCart viewCartById(Integer cartId) throws CartException {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			return cart;
		}else {
			throw new CartException("No Cart found with ID: "+cartId);
		}
	}



	@Override
	public FoodCart clearCart(Integer cartId) throws CartException {
		Optional<FoodCart> opt = cartDao.findById(cartId);
		if(opt.isPresent()) {
			FoodCart cart = opt.get();
			cartDao.delete(cart);
			
			return cart;
		}else {
			throw new CartException("No cart exists with ID: "+cartId);
		}
	}

	

	

}
