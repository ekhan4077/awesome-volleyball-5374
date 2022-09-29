package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Category;
import com.foodapp.model.Item;
import com.foodapp.model.Restaurant;

public interface ItemService {
	

	
	public Item addItem(Item item) throws ItemException;
	
	public Item updateItem(Item item) throws ItemException;
	
	public Item viewItem(Item item) throws ItemException;
	
	public Item removeItem(Item item) throws ItemException;
	
	public List<Item> viewAllItems(Category cat) throws ItemException,CategoryException;
	
	public List<Item> viewAllItems(Restaurant rest) throws ItemException,RestaurantException;
	
	public List<Item> viewAllItemsByName(String name) throws ItemException;
	


}
