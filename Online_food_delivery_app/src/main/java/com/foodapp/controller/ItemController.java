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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Category;
import com.foodapp.model.Item;
import com.foodapp.model.Restaurant;
import com.foodapp.serviceImpl.ItemServiceImpl;

@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemServiceImpl iimpl;
	
	@PostMapping("/add")
	public ResponseEntity<Item> addItem(@RequestBody Item item) throws ItemException{
		Item it = iimpl.addItem(item);
		return new ResponseEntity<Item>(it,HttpStatus.CREATED);
	}
	
	@PutMapping("/delete")
	public ResponseEntity<Item> UpdateItem(@RequestBody Item item) throws ItemException{
		Item it = iimpl.updateItem(item);
		return new ResponseEntity<Item>(it,HttpStatus.OK);
	}
	
	@DeleteMapping("/dalete")
	public ResponseEntity<Item> deleteItem( @RequestBody Item item)throws ItemException{
		Item it = iimpl.removeItem(item);
		return new ResponseEntity<Item>(it,HttpStatus.OK);
	}
	
	@PostMapping("/ByCategory")
	public ResponseEntity<List<Item>> viewAllItem(@RequestBody Category cat) throws ItemException, CategoryException{
		List<Item> list = iimpl.viewAllItems(cat);
		return new ResponseEntity<List<Item>>(list,HttpStatus.FOUND);
	}
	
	@PostMapping("/allItemsOfRestaurant")
	public ResponseEntity<List<Item>> viewAllItems(@RequestBody Restaurant rest) throws ItemException, CategoryException, RestaurantException{
		List<Item> list = iimpl.viewAllItems(rest);
		return new ResponseEntity<List<Item>>(list,HttpStatus.FOUND);
	}
	
	@GetMapping("/ByName/{name}")
	public ResponseEntity<List<Item>> viewAllItemsByName(@PathVariable("name") String name ) throws ItemException, CategoryException, RestaurantException{
		List<Item> list = iimpl.viewAllItemsByName(name);
		return new ResponseEntity<List<Item>>(list,HttpStatus.FOUND);
	}
	
	
}
