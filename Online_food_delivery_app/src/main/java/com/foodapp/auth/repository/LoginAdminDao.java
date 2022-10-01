package com.foodapp.auth.repository;

import com.foodapp.auth.models.AdminLogin;
import com.foodapp.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginAdminDao extends JpaRepository<AdminLogin,Integer> {


}
