package com.foodapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Restaurant;
@Repository
public interface RestaurantDao extends JpaRepository<Restaurant, Integer> {
//	public List<Restaurant> viewBearByRestaurant(String location);
//	
//	public List<Restaurant> viewRestaurantsByItemName(String name);
	
	
}
