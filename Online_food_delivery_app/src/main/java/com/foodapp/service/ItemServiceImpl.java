package com.foodapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.CategoryException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Category;
import com.foodapp.model.Item;
import com.foodapp.model.Restaurant;
import com.foodapp.Repository.*;


@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemDao iDao;
	@Autowired
	private CategoryDao cDao;
	@Autowired
	private RestaurantDao rDao;
	

	@Override
	public Item addItem(Item item) throws ItemException {
		Optional<Item> opt = iDao.findById(item.getItemId());
		if(!opt.isPresent()) {
			return iDao.save(item);
		}else {
			throw new ItemException("Item is already exist itemId : "+item.getItemId());
		}
	}

	@Override
	public Item updateItem(Item item) throws ItemException {
		Optional<Item> opt = iDao.findById(item.getItemId());
		if(opt.isPresent()) {
			
			return iDao.save(item);
		}else {
			throw new ItemException("Item is already exist itemId : "+item.getItemId());
		}
	}

	@Override
	public Item viewItem(Item item) throws ItemException {
		Optional<Item> opt = iDao.findById(item.getItemId());
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new ItemException("Item is already exist itemId : "+item.getItemId());
		}
	}

	@Override
	public Item removeItem(Item item) throws ItemException {
		Optional<Item> opt = iDao.findById(item.getItemId());
		if(opt.isPresent()) {
			Item it = opt.get();
			iDao.delete(it);
			return it;
		}else {
			throw new ItemException("No item exist with this data");
		}
		
	}

	@Override
	public List<Item> viewAllItems(Category cat) throws ItemException, CategoryException {
	
			List<Category> items = cDao.findAll();
			if(items.size()>0) {
				List<Item> catitem =new ArrayList<>();
				
				for(Category it:items) {

					if(cat.getCatId()== it.getCatId()) {
						catitem=it.getIt();
					}
				}
				if(catitem.size()>0) {
					return catitem;
				}else {
					throw new ItemException("No item exist in this category");
				}
			}else {
				throw new ItemException("No category esixt with this category id");
			}
		
	}

	@Override
	public List<Item> viewAllItems(Restaurant rest) throws ItemException, RestaurantException {
		Optional<Restaurant> opt = rDao.findById(rest.getRestaurantId());
		if(opt.isPresent()) {
			List<Item> items = iDao.findAll();
			
			if(items.size()>0) {
				List<Item> restItem= new ArrayList<>();
				for(Item it: items) {
					List<Restaurant> restList = it.getRestaurant(); 
					
					for(Restaurant itb: restList) {
						if(itb.getRestaurantId()==rest.getRestaurantId()) {
							restItem.add(it);
						}
					}
					
					
				}
				return restItem;
			}else {
				throw new RestaurantException("No Resturesnt exist with this resturant Id "+ rest.getRestaurantId());
			}
		}else{
			throw new RestaurantException("No Resturesnt exist with this resturant Id "+ rest.getRestaurantId());
		}
	}

	@Override
	public List<Item> viewAllItemsByName(String name) throws ItemException {
		List<Item> list = iDao.findAll();
		if(list.size()>0) {
			return list;
		}else {
			throw new ItemException("No item exist with this name "+name);
		}
			
	}

	
}
