package com.foodapp.auth.service;

import com.foodapp.auth.exception.LoginException;
import com.foodapp.auth.models.AdminSessionTrack;
import com.foodapp.auth.models.UserSessionTrack;
import com.foodapp.model.Customer;
import com.foodapp.model.Restaurant;

public interface CurrentAdminSessionService {

    public AdminSessionTrack getCurrentAdminSession(String key) throws LoginException;
    public Integer getCurrentAdminSessionId(String key) throws LoginException;

    public Restaurant getSignUpDetails(String key) throws LoginException;

}
