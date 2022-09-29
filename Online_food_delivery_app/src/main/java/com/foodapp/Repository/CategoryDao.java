package com.foodapp.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.foodapp.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer> {
	
	
}
