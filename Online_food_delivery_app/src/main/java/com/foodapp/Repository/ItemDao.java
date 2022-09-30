package com.foodapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.foodapp.model.Item;


@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
//	public List<Item> findAll(Category cat);
//	
//	public List<Item> viewAllItems(Restaurant res) ;
//	
//	@Query("select i from Item i where i.itemName=?1")
	 public List<Item> findByitemName(String name);
}
