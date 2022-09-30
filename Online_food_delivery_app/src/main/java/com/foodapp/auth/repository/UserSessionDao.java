package com.foodapp.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.auth.models.UserSessionTrack;

public interface UserSessionDao extends JpaRepository<UserSessionTrack,Integer>{


	public Optional<UserSessionTrack> findByCustomerId(Integer userId);
	
	public Optional<UserSessionTrack> findByUuid(String uuid);
}
