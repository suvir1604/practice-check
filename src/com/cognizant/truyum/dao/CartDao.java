package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public interface CartDao {
	public void addCartItem(long userId, long menuItemId);

	public List<MenuItem> getallCartItems(long userId) throws CartEmptyException;

	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException;

}
