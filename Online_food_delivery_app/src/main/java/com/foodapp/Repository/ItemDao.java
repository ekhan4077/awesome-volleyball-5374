package com.foodapp.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodapp.model.Category;
import com.foodapp.model.Item;
import com.foodapp.model.Restaurant;
@Repository
public interface ItemDao extends JpaRepository<Item, Integer> {
//	public List<Item> viewAllItems(Category cat);
//	
//	public List<Item> viewAllItems(Restaurant res) ;
//	
//	public List<Item> viewAllItemByName(String name);
}
