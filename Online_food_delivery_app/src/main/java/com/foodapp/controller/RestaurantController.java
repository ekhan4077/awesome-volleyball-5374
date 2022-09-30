package com.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Restaurant;
import com.foodapp.service.RestaurantService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	@Autowired
	private RestaurantService rImp;
	
	
	
	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurent(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.addRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Restaurant> updateRestaurent(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.updateRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.OK);
	}
	@DeleteMapping("/remove")
	public ResponseEntity<Restaurant> deleteRestaurent(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.removeRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.OK);
	}
	@GetMapping("/view")
	public ResponseEntity<Restaurant> viewRestaurant(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.viewRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.OK);
	}
	
	@GetMapping("/allbyItem/{itemName}")
	public ResponseEntity<List<Restaurant>> viewRestaurantsByItemName(@PathVariable("itemName") String ItemName) throws RestaurantException{
		List<Restaurant> rest =rImp.viewRestaurantsByItemName(ItemName); 	
		return new ResponseEntity<List<Restaurant>>(rest,HttpStatus.OK);
	}
	
	@GetMapping("/allnearby/{location}")
	public ResponseEntity<List<Restaurant>> viewNearbyRestaurants(@PathVariable("location") String location) throws RestaurantException{
		List<Restaurant> rest =rImp.viewNearbyRestaurants(location);
		return new ResponseEntity<List<Restaurant>>(rest,HttpStatus.OK);
	}
	
}
