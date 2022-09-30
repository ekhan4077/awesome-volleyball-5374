package com.foodapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CustomerException;
import com.foodapp.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private com.foodapp.Repository.CustomerDao cDao;
	
	@Autowired
	private com.foodapp.Repository.RestaurantDao rDao;
	
	@Override
	public Customer addCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cDao.findById(customer.getCustomerId());
		
		if(!opt.isPresent()) {
			return cDao.save(customer);
		}else {
			throw new CustomerException("Customer is already Exist");
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return cDao.save(customer);
		}else {
			throw new CustomerException("Customer is not present with this Data");
		}
	}

	@Override
	public Customer removeCustomer(Customer customer) throws CustomerException {
		Customer cust = cDao.findById(customer.getCustomerId()).orElseThrow(()-> new CustomerException("No customer is available with this data of customer") );
		cDao.delete(cust);
		return cust;
		
	}

	@Override
	public Customer viewCustomer(Customer customer) throws CustomerException {
		Optional<Customer> opt = cDao.findById(customer.getCustomerId());
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new CustomerException("Custmer is not available with this Data");
		}
		
	}

//	@Override
//	public List<Customer> viewAllCustomers(Restaurant rest) throws CustomerException, RestaurantException {
//			List<Customer> list =cDao.findAll();
//			//Restaurant restu =rDao.getById(rest.getRestaurantId()) we can get it from food cart;
//	
//			List<Customer> anslist = new ArrayList<>();
////			for(int i=0; i<list.size(); i++) {
////				if(list.get(i).getRestaurant().equals(rest)) {
////					anslist.add(list.get(i));
////				}
////			}
//			return anslist;
//			
//	}
		
}
