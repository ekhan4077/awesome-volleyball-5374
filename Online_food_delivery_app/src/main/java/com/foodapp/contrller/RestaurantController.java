package com.foodapp.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Restaurant;
import com.foodapp.serviceImpl.RestaurantServiceImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class RestaurantController {
	@Autowired
	private RestaurantServiceImpl rImp;
	
	
	
	@PostMapping("/restaurant")
	public ResponseEntity<Restaurant> addRestaurent(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.addRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.CREATED);
	}
	@PutMapping("/restaurant")
	public ResponseEntity<Restaurant> updateRestaurent(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.updateRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.OK);
	}
	@DeleteMapping("/restaurant")
	public ResponseEntity<Restaurant> deleteRestaurent(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.removeRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.OK);
	}
	@GetMapping("/restaurant")
	public ResponseEntity<Restaurant> viewRestaurant(@RequestBody Restaurant rest) throws RestaurantException{
		Restaurant getRest = rImp.viewRestaurant(rest);
		return new ResponseEntity<Restaurant>(getRest,HttpStatus.OK);
	}
	
	@GetMapping("/restaurents/{itemName}")
	public ResponseEntity<List<Restaurant>> viewRestaurantsByItemName(@PathVariable("itemName") String ItemName) throws RestaurantException{
		List<Restaurant> rest =rImp.viewRestaurantsByItemName(ItemName); 	
		return new ResponseEntity<List<Restaurant>>(rest,HttpStatus.OK);
	}
	
	@GetMapping("/restaurentsbyLocation/{location}")
	public ResponseEntity<List<Restaurant>> viewNearbyRestaurants(@PathVariable("location") String location) throws RestaurantException{
		List<Restaurant> rest =rImp.viewNearbyRestaurants(location);
		return new ResponseEntity<List<Restaurant>>(rest,HttpStatus.OK);
	}
	
}
