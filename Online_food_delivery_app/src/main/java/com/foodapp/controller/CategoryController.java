package com.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.model.Category;
import com.foodapp.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategoryService service;

	@PostMapping("/add")
	public ResponseEntity<Category> addCategory(@RequestBody Category cat) throws CategoryException {
		Category category = service.addCategory(cat);
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);

	}

	@PutMapping("/update")
	public ResponseEntity<Category> updateCategory(@RequestBody Category cat) throws CategoryException {
		Category category = service.updateCategory(cat);
		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}

	@DeleteMapping("/remove")
	public ResponseEntity<Category> deleteCategory(@RequestBody Category cat) throws CategoryException {
		Category category = service.removeCatrgory(cat);
		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}

	@PostMapping("/view")
	public ResponseEntity<Category> viewCategory(@RequestBody Category cat) throws CategoryException {
		Category category = service.viewCatrgory(cat);
		return new ResponseEntity<Category>(category, HttpStatus.OK);

	}

	@GetMapping("/viewAll")
	public ResponseEntity<List<Category>> viewAllCategory() throws CategoryException {
		List<Category> category = service.viewAllCategory();
		return new ResponseEntity<List<Category>>(category, HttpStatus.OK);

	}
}
