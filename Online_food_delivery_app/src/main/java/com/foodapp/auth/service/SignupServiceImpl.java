package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.repository.SignupDao;
import com.foodapp.model.Customer;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {

	@Autowired
	private SignupDao signUpDAO;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;
	
	@Override
	public Customer createNewSignUp(Customer signUp) throws LoginException {
		Optional<Customer> opt = signUpDAO.findByEmail(signUp.getEmail());
		if(opt.isPresent())
		{
			throw new LoginException("User Already Exist!");
		}
		return signUpDAO.save(signUp);
	}

	@Override
	public Customer updateSignUpDetails(Customer signUp, String key) throws LoginException {
		Customer signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LoginException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getEmail() == signUp.getEmail())
			{
			signUpDAO.save(signUp);
			return signUp;
			}
		else
			throw new LoginException("Can't change UserId!!");
	}
}


