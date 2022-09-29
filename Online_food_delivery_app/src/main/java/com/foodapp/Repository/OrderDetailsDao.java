package com.foodapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodapp.model.Customer;
import com.foodapp.model.OrderDetails;
import com.foodapp.model.Restaurant;

public interface OrderDetailsDao extends JpaRepository<OrderDetails, Integer> {
	
	
//	List<OrderDetails> viewAllOrders(Restaurant res);
//	
//	List<OrderDetails> viewAllOrders(Customer customer);
	
}
