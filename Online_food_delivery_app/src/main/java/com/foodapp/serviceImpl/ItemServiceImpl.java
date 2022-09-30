package com.foodapp.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.Repository.CategoryDao;
import com.foodapp.Repository.ItemDao;
import com.foodapp.Repository.RestaurantDao;
import com.foodapp.exceptions.CategoryException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Category;
import com.foodapp.model.Item;
import com.foodapp.model.Restaurant;
import com.foodapp.service.ItemService;

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
		Item existingItem = iDao.findById(item.getItemId()).orElseThrow(()->(new ItemException("Item does not exist with ItemId : "+item.getItemId())));
		iDao.delete(existingItem);
		return existingItem;
		
	}

	@Override
	public List<Item> viewAllItems(Category cat) throws ItemException, CategoryException {
		Optional<Category> cat1 = cDao.findById(cat.getCatId());
		if(cat1.isPresent()) {
		
			List<Item> items = iDao.findAll();
			if(items.size()>0) {
				List<Item> catitem = new ArrayList<>();

				for(Item it:items) {
					if(cat.getCatId()== it.getCategory().getCatId()) {
						catitem.add(it);
					}
				}

				return catitem;
			}else {
				throw new ItemException();
			}
		}else {
			throw new CategoryException();
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
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public List<Item> viewAllItemsByName(String name) throws ItemException {
//		List<Item> items = iDao.findbyName(name);
//		if(items.size()>0) {
//			return items;
//		}else {
//			throw new ItemException("No Item available with this itemName "+ name);
//		}
//		
//	}
//	
	
}
