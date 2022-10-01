package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.model.Customer;
import com.foodapp.model.Restaurant;

public interface SignupService {

	public Customer createNewSignUp(Customer signUp) throws LoginException;
	
	public Customer updateSignUpDetails(Customer signUp,String key) throws LoginException;

	public Restaurant createNewResSignUp(Restaurant signUp) throws LoginException;

	public Restaurant updateResSignUpDetails(Restaurant signUp, String key) throws LoginException;
}
