package com.foodapp.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Customer;

@Repository
public interface SignupDao  extends JpaRepository <Customer,Integer>{

	public Optional<Customer> findByEmail(String email);
	public Optional<Customer> findByCustomerId(Integer id);
}
