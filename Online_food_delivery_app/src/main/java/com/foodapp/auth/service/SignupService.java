package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.model.Customer;

public interface SignupService {

	public Customer createNewSignUp(Customer signUp) throws LoginException;
	
	public Customer updateSignUpDetails(Customer signUp,String key) throws LoginException;
}
