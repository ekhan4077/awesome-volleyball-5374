package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Customer;
import com.foodapp.model.Restaurant;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Customer customer) throws CustomerException;
	
	public List<Customer> viewAllCustomers(Restaurant rest) throws CustomerException,RestaurantException;
	


}
