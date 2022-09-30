package com.foodapp.service;


import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Customer;

public interface CustomerService {
	
	public Customer addCustomer(Customer customer) throws CustomerException;
	
	public Customer updateCustomer(Customer customer) throws CustomerException;
	
	public Customer removeCustomer(Customer customer) throws CustomerException;
	
	public Customer viewCustomer(Customer customer) throws CustomerException;
	
//	public List<Customer> viewAllCustomers(Restaurant rest) throws CustomerException,RestaurantException;
	


}
