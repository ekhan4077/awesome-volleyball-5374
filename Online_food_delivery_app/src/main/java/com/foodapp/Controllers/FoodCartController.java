package com.foodapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.ServiceImpl.CartServiceImpl;
import com.foodapp.model.FoodCart;
import com.foodapp.model.Item;
import com.foodapp.service.CartService;

@RestController
@RequestMapping("foodCart")
public class FoodCartController {
	@Autowired
	private CartServiceImpl service;
	@PostMapping(" /add")
	public FoodCart AddItemToCart(@RequestBody FoodCart fc,@RequestBody Item item){
		

     return fc;
		
	}
	

}
