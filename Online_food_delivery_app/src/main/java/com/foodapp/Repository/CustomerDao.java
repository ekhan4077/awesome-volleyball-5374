package com.foodapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodapp.model.Customer;
import com.foodapp.model.Restaurant;
@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>{
	
//	public List<Customer> viewAllCategory(Restaurant res);
	
}
