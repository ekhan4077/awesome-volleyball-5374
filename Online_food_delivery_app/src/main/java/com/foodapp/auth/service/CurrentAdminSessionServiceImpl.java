package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.models.AdminSessionTrack;
import com.foodapp.auth.repository.AdminSessionDao;
import com.foodapp.auth.repository.SignupDao;
import com.foodapp.model.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrentAdminSessionServiceImpl implements CurrentAdminSessionService{

    @Autowired
    private AdminSessionDao currentAdminSessionDAO;

    @Autowired
    private SignupDao signUpDAO;

    @Override
    public AdminSessionTrack getCurrentAdminSession(String key) throws LoginException {
        Optional<AdminSessionTrack> currentAdmin = currentAdminSessionDAO.findByUuid(key);
        if(!currentAdmin.isPresent())
        {
            throw new LoginException("UnAuthorized!!!");
        }
        return currentAdmin.get();
    }

    @Override
    public Integer getCurrentAdminSessionId(String key) throws LoginException {
        return null;
    }

    @Override
    public Restaurant getSignUpDetails(String key) throws LoginException {
        return null;
    }
}
