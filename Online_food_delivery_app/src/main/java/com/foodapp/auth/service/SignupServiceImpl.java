package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.repository.SignupAdminDao;
import com.foodapp.auth.repository.SignupDao;
import com.foodapp.model.Customer;


import java.util.Optional;

import com.foodapp.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignupServiceImpl implements SignupService {


	@Autowired
	private SignupDao signUpDAO;

	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;

	@Autowired
	private CurrentAdminSessionService getCurrentAdminUserSession;

	@Autowired
	private SignupAdminDao signUpAdminDao;
	
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


	@Override
	public Restaurant createNewResSignUp(Restaurant signUp) throws LoginException {
		Optional<Restaurant> opt = signUpAdminDao.findByRestaurantName(signUp.getRestaurantName());
		if(opt.isPresent())
		{
			throw new LoginException("User Already Exist!");
		}
		return signUpAdminDao.save(signUp);
	}

	@Override
	public Restaurant updateResSignUpDetails(Restaurant signUp, String key) throws LoginException {
		Restaurant signUpDetails = getCurrentAdminUserSession.getSignUpDetails(key);

		if(signUpDetails == null)
		{
			throw new LoginException("UnAuthorized!!! No User Found....Try To login first!");
		}

		if(signUpDetails.getRestaurantName() == signUp.getRestaurantName())
		{
			signUpAdminDao.save(signUp);
			return signUp;
		}
		else
			throw new LoginException("Can't change UserId!!");

	}
}


