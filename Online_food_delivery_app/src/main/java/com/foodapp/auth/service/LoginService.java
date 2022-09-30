package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.models.Login;

public interface LoginService {

	public String logInAccount(Login loginData) throws LoginException;
	public String logOutFromAccount(String key) throws LoginException;
}
