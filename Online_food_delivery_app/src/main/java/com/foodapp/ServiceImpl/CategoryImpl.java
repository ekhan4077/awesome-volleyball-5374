package com.foodapp.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.Repository.CategoryDao;
import com.foodapp.exceptions.CategoryException;
import com.foodapp.model.Category;
import com.foodapp.service.CategoryService;

@Service
public class CategoryImpl implements CategoryService {
	@Autowired
	private CategoryDao catService;

	@Override
	public Category addCategory(Category cat) throws CategoryException {
		Optional<Category> opt = catService.findById(cat.getCatId());
		if (opt.isPresent()) {
			throw new CategoryException("Category already Exist");
		}
		return catService.save(cat);

	}

	@Override
	public Category updateCatrgory(Category cat) throws CategoryException {
		Optional<Category> opt = catService.findById(cat.getCatId());
		if (!opt.isPresent()) {
			throw new CategoryException("Category Not Exist");
		}
		return catService.save(cat);
	}

	@Override
	public Category removeCatrgory(Category cat) throws CategoryException {
		Optional<Category> opt = catService.findById(cat.getCatId());
		if (!opt.isPresent()) {
			throw new CategoryException("Category Not Exist");
		}
		catService.delete(cat);
		return opt.get();
	}

	@Override
	public Category viewCatrgory(Category cat) throws CategoryException {
		Optional<Category> opt = catService.findById(cat.getCatId());
		if (!opt.isPresent()) {
			throw new CategoryException("Category Not Exist");
		}
		return opt.get();
	}

	@Override
	public List<Category> viewAllCategory() throws CategoryException {
		List<Category> li = catService.findAll();
		if (li.size() == 0) {
			throw new CategoryException("Categorys are Empty");
		}
		return li;
	}

}
