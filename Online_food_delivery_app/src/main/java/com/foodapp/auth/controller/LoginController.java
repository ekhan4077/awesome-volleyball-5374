package com.foodapp.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.auth.models.Login;
import com.foodapp.auth.service.LoginService;

@RestController
public class LoginController {


	@Autowired
	private LoginService loginService;
	
	@PostMapping("/login")
	public String loginHandler(@RequestBody Login loginData) {
		return loginService.logInAccount(loginData);
	}
	
	@PatchMapping("/logout")
	public String logOutFromAccount(@RequestParam String key)
	{
		return loginService.logOutFromAccount(key);
	}

	
}
