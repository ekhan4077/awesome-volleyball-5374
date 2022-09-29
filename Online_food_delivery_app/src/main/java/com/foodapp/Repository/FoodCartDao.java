package com.foodapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.FoodCart;
@Repository
public interface FoodCartDao extends JpaRepository<FoodCart, Integer> {
	

	
}
