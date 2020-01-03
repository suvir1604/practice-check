package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {
	private static HashMap<Long, Cart> userCarts;

	public CartDaoCollectionImpl() {
		super();
		if (userCarts == null) {
			userCarts = new HashMap<>();
			userCarts.put(1l, new Cart());
		}
	}

	@Override
	public void addCartItem(long userId, long menuItemId) {
		try {
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImPl();
			MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
			if (userCarts.containsKey(userId)) {
				Cart cart = userCarts.get(userId);
				cart.getMenuItemList().add(menuItem);
			} else {
				Cart cart = new Cart();
				cart.getMenuItemList().add(menuItem);
				userCarts.put(userId, cart);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<MenuItem> getallCartItems(long userId) throws CartEmptyException {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		Cart cart = userCarts.get(userId);
		double total = 0.0;
		if ((cart == null) || (menuItemList.isEmpty())) {
			try {
			throw new CartEmptyException();
		}catch (CartEmptyException e) {
			e.printStackTrace();
		}}
	 else {
			for (MenuItem x : menuItemList) {
				total = total + x.getPrice();
			}
		}
		cart.setTotal(total);
		return menuItemList;

	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		if (menuItemList == null || (menuItemList.isEmpty())) {
			throw new CartEmptyException();
		}
		for (MenuItem S : menuItemList) {
			if (S.getId() == menuItemId) {
				menuItemList.remove(S);
			}
		}
	}
	}

