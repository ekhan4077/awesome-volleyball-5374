package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Restaurant;

public interface RestaurantService {
	

	
	public Restaurant addRestaurant(Restaurant rest) throws RestaurantException;
	
	public Restaurant updateRestaurant(Restaurant rest) throws RestaurantException;
	
	public Restaurant removeRestaurant(Restaurant rest) throws RestaurantException;
	
	public Restaurant viewRestaurant(Restaurant rest) throws RestaurantException;
	
	public List<Restaurant> viewNearbyRestaurants(String location) throws RestaurantException;
	
	public List<Restaurant> viewRestaurantsByItemName(String name) throws RestaurantException;
	


}
