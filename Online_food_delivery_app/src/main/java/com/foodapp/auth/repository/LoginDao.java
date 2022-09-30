package com.foodapp.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.auth.models.Login;

public interface LoginDao extends JpaRepository<Login,Integer> {

}
