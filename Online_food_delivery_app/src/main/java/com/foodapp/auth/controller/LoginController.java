package com.foodapp.auth.controller;

import com.foodapp.auth.models.AdminLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foodapp.auth.models.Login;
import com.foodapp.auth.service.LoginService;

@RestController
@CrossOrigin(origins = "*")
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

	@PostMapping("/adminLogin")
	public String adminLoginHandler(@RequestBody AdminLogin loginData) { return loginService.LogInAccountAdmin(loginData);}

	@PatchMapping("/adminLogout")
	public String adminLogoutFromAccount(@RequestBody String key) {
		return loginService.LogOutFromAccountAdmin(key);
	}
}
