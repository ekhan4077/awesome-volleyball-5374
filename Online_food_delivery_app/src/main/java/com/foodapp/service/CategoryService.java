package com.foodapp.service;

import java.util.List;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.model.Category;

public interface CategoryService {
	
	
	public Category addCategory(Category cat) throws CategoryException;
	
	public Category updateCategory(Category cat) throws CategoryException;
	
	public Category removeCatrgory(Category cat) throws CategoryException;
	
	public Category viewCatrgory(Category cat) throws CategoryException;
	
	public List<Category> viewAllCategory() throws CategoryException;
	


}
