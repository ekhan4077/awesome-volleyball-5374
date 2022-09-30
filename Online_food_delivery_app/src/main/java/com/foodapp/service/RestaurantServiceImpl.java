package com.foodapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.exceptions.RestaurantException;
import com.foodapp.model.Item;
import com.foodapp.model.Restaurant;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private com.foodapp.Repository.RestaurantDao rDao;
	
	@Override
	public Restaurant addRestaurant(Restaurant rest) throws RestaurantException {
		Optional<Restaurant> opt = rDao.findById(rest.getRestaurantId());
		if(!opt.isPresent()) {
			return rDao.save(rest);
		}else {
			throw new RestaurantException("Resturant is already exist");
		}
	}

	@Override
	public Restaurant updateRestaurant(Restaurant rest) throws RestaurantException {
		Optional<Restaurant> opt = rDao.findById(rest.getRestaurantId());
		if(opt.isPresent()) {
			return rDao.save(rest);
		}else {
			throw new RestaurantException("Restaurent not found with this data");
		}
	}


	@Override
	public Restaurant removeRestaurant(Restaurant rest) throws RestaurantException {
		Optional<Restaurant> opt = rDao.findById(rest.getRestaurantId());
		if(opt.isPresent()) {
			Restaurant existRest = opt.get();
			rDao.delete(existRest);
			return existRest;
			
		}else {
			throw new RestaurantException("Restaurent not found with this data");
		}
	}

	@Override
	public Restaurant viewRestaurant(Restaurant rest) throws RestaurantException {
		Optional<Restaurant> opt= rDao.findById(rest.getRestaurantId());
		if(opt.isPresent()) {
			Restaurant existRest = opt.get();
			return existRest;
			
		}else {
			throw new RestaurantException("Restaurent not found with this data");
		}
	}

	@Override
	public List<Restaurant> viewNearbyRestaurants(String location) throws RestaurantException {
		List<Restaurant> rests = rDao.findAll();
		if(rests.size()>0) {
			List<Restaurant> restLoc = new ArrayList<Restaurant>();
			for(int i=0; i<rests.size(); i++) {
				if(rests.get(i).getAddress().getCity().equals(location)) {
					restLoc.add(rests.get(i));
				}
			}
			return restLoc;
		}else {
			throw new RestaurantException("Restaurent not found with this data");
		}

	}

	@Override
	public List<Restaurant> viewRestaurantsByItemName(String name) throws RestaurantException {
		List<Restaurant> rests = rDao.findAll();
		if(rests.size()>0) {
			List<Restaurant> restLoc = new ArrayList<Restaurant>();
			for(int i=0; i<rests.size(); i++) {
				List<Item> itemList = rests.get(i).getItemLists();
				for(int j=0; j<itemList.size(); j++) {
					if(itemList.get(j).getItemName().equals(name)) {
						restLoc.add(rests.get(i));
					};
				}
			}
			return restLoc;
		}else {
			throw new RestaurantException("Restaurent not found with this data");
		}
	}

}
