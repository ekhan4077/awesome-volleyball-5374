package com.foodapp.auth.controller;

import com.foodapp.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.foodapp.auth.service.SignupService;
import com.foodapp.model.Customer;

@RestController
@CrossOrigin(origins = "*")
public class SignupController {

	@Autowired
	private SignupService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<Customer> createNewSignUpHandler(@RequestBody Customer newSignUp) {
		
		Customer newSignedUp =signUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<Customer>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<Customer> updateSignUpDetailsHandler(@RequestBody Customer signUp, @RequestParam String key)
	{
		Customer newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<Customer>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}

	@PostMapping("/adminSignUp")
	public ResponseEntity<Restaurant> createNewSignUpHandlerAdmin(@RequestBody Restaurant newSignUp) {

		Restaurant newSignedUp =signUpService.createNewResSignUp(newSignUp);
		return new ResponseEntity<Restaurant>(newSignedUp,HttpStatus.CREATED);

	}

	@PutMapping("/adminUpdateSignUp")
	public ResponseEntity<Restaurant> updateSignUpDetailsHandlerAdmin(@RequestBody Restaurant signUp, @RequestParam String key)
	{
		Restaurant newUpdatedSignUp = signUpService.updateResSignUpDetails(signUp,key);

		return new ResponseEntity<Restaurant>(newUpdatedSignUp,HttpStatus.ACCEPTED);

	}


}
