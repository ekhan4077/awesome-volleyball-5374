package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.models.UserSessionTrack;
import com.foodapp.model.Customer;

public interface CurrentUserSessionService {

	public UserSessionTrack getCurrentUserSession(String key) throws LoginException;
	public Integer getCurrentUserSessionId(String key) throws LoginException;
	
	public Customer getSignUpDetails(String key) throws LoginException;
}

