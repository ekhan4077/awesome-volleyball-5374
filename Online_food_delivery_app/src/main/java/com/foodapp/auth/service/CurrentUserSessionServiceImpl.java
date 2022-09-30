package com.foodapp.auth.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.models.UserSessionTrack;
import com.foodapp.auth.repository.SignupDao;
import com.foodapp.auth.repository.UserSessionDao;
import com.foodapp.model.Customer;

@Service
public class CurrentUserSessionServiceImpl implements CurrentUserSessionService {

	@Autowired
	private UserSessionDao currentUserSessionDAO;
	
	@Autowired
	private SignupDao signUpDAO;
	
	@Override
	public UserSessionTrack getCurrentUserSession(String key) throws LoginException {
		Optional<UserSessionTrack> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			throw new LoginException("UnAuthorized!!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws LoginException {

		Optional<UserSessionTrack> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			throw new LoginException("UnAuthorized!!!");
		}
		return currentUser.get().getId();
		
	}

	@Override
	public Customer getSignUpDetails(String key) throws LoginException {
		Optional<UserSessionTrack> currentUser = currentUserSessionDAO.findByUuid(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getCustomerId();
		System.out.println(SignUpUserId );
		
		return (signUpDAO.findById(SignUpUserId)).get();
	}

}
