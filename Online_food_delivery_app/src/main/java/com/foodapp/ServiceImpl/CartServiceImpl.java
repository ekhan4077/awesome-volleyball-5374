package com.foodapp.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.Repository.FoodCartDao;
import com.foodapp.exceptions.CartException;
import com.foodapp.exceptions.ItemException;
import com.foodapp.model.FoodCart;
import com.foodapp.model.Item;
import com.foodapp.service.CartService;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private FoodCartDao myCart;

	@Override
	public FoodCart addItemToCart(FoodCart cart, Item item) throws CartException {
		Optional<FoodCart> opt=myCart.findById(cart.getCartId());
		if(!opt.isPresent()) {
			throw new CartException("Cart not Found");
		}
		opt.get().getItemList().add(item);
		myCart.save(cart);
		return myCart.save(cart);
	}

	@Override
	public FoodCart increaseQuantity(FoodCart cart, Item item, int quantity) throws CartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart reduceQuantity(FoodCart cart, Item item, int quantity) throws CartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart removeItem(FoodCart cart, Item item) throws CartException, ItemException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FoodCart clearCart(FoodCart cart) throws CartException {
		// TODO Auto-generated method stub
		return null;
	}

}
