package com.foodapp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.auth.service.SignupService;
import com.foodapp.model.Customer;

@RestController
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
}
