package com.foodapp.auth.service;

import java.time.LocalDateTime;
import java.util.Optional;

import com.foodapp.auth.models.AdminLogin;
import com.foodapp.auth.models.AdminSessionTrack;
import com.foodapp.auth.repository.*;
import com.foodapp.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.models.Login;
import com.foodapp.auth.models.UserSessionTrack;
import com.foodapp.model.Customer;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private SignupDao signUpDAO;

	@Autowired
	private UserSessionDao currentUserSessionDAO;

	@Autowired
	private AdminSessionDao currentAdminSessionDao;

	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;

	@Autowired
	private CurrentAdminSessionService getCurrentLoginAdminSession;

	@Autowired
	private LoginDao loginDataDAO;

	@Autowired
	private LoginAdminDao loginAdminDao;

	@Autowired
	private SignupAdminDao signupAdminDao;
	
	@Override
	public String logInAccount(Login loginData) throws LoginException {
		Optional<Customer> opt = signUpDAO.findByEmail(loginData.getEmail());
		
		if(!opt.isPresent())
		{
			throw new LoginException("Invalid login mail");
		}
		
		Customer newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getCustomerId();
		Optional<UserSessionTrack> currentUserOptional = currentUserSessionDAO.findByCustomerId(newSignUpId);
		
		if(currentUserOptional.isPresent()) {
			throw new LoginException("User Already login with this UserId");
		}
		
		if((newSignUp.getCustomerId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomStr.getRandomNumberString();
			
			UserSessionTrack currentUserSession = new UserSessionTrack(newSignUp.getCustomerId(),key,LocalDateTime.now());
			currentUserSessionDAO.save(currentUserSession);
			loginDataDAO.save(loginData);
			
			return currentUserSession.toString();
			
		}
		else
			throw new LoginException("Invalid UserName or Password!");
			
			
		
	}

	@Override
	public String logOutFromAccount(String key) throws LoginException {
		Optional<UserSessionTrack> currentUserOptional = currentUserSessionDAO.findByUuid(key);
		if(!currentUserOptional.isPresent())
		{
			throw new LoginException("User has not logged in with this UserId");
		}
		UserSessionTrack currentUserSession = getCurrentLoginUserSession.getCurrentUserSession(key);
		
		currentUserSessionDAO.delete(currentUserSession);
		
		Optional<Login> loginData = loginDataDAO.findById(currentUserOptional.get().getCustomerId());
		System.out.println(loginData);
		loginDataDAO.delete(loginData.get());
		
		
		return "Logged Out......";
	}

	@Override
	public String LogInAccountAdmin(AdminLogin loginData) throws LoginException {
		Optional<Restaurant> opt = signupAdminDao.findByRestaurantName(loginData.getName());

		if(!opt.isPresent())
		{
			throw new LoginException("Invalid login mail");
		}

		Restaurant newSignUp = opt.get();

		Integer newSignUpId = newSignUp.getRestaurantId();
		Optional<AdminSessionTrack> currentUserOptional = currentAdminSessionDao.findByRestaurantId(newSignUpId);

		if(currentUserOptional.isPresent()) {
			throw new LoginException("User Already login with this UserId");
		}

		if((newSignUp.getRestaurantId() == loginData.getUserId()) && (newSignUp.getPassword().equals(loginData.getPassword())))
		{
			String key = RandomStr.getRandomNumberString();

			AdminSessionTrack currentUserSession = new AdminSessionTrack(newSignUp.getRestaurantId(),key,LocalDateTime.now());
			currentAdminSessionDao.save(currentUserSession);
			loginAdminDao.save(loginData);

			return currentUserSession.toString();

		}
		else
			throw new LoginException("Invalid UserName or Password!");

	}

	@Override
	public String LogOutFromAccountAdmin(String key) throws LoginException {
		Optional<AdminSessionTrack> currentUserOptional = currentAdminSessionDao.findByUuid(key);
		if(!currentUserOptional.isPresent())
		{
			throw new LoginException("User has not logged in with this UserId");
		}
		AdminSessionTrack currentUserSession = getCurrentLoginAdminSession.getCurrentAdminSession(key);

		currentAdminSessionDao.delete(currentUserSession);

		Optional<AdminLogin> loginData = loginAdminDao.findById(currentUserOptional.get().getRestaurantId());
		System.out.println(loginData);
		loginAdminDao.delete(loginData.get());


		return "Logged Out......";
	}
}
