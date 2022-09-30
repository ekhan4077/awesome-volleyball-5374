package com.foodapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.model.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {
	
}
