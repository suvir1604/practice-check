package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) throws CartEmptyException {
		testaddCartItem();
		testgetallCartItems();
		testRemoveCartItem();

	}

	private static void testaddCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.addCartItem(1,2l);
		cartDao.addCartItem(1,4l);
		cartDao.addCartItem(1,1l);
		cartDao.addCartItem(2,3l);

		List<MenuItem> menuItemListCustomer = cartDao.getallCartItems(1);
		System.out.println("User Added Cart List for CheckOut");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}

	}

	private static void testgetallCartItems() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		List<MenuItem> menuItemListCustomer = cartDao.getallCartItems(1);
		System.out.println("getAllCartItems");
		for (MenuItem menuItem : menuItemListCustomer) {
			System.out.println(menuItem);
		}

	}

	public static void testRemoveCartItem() throws CartEmptyException {
		CartDao cartDao = new CartDaoCollectionImpl();
		System.out.println("Item List for customer after remove");
		try {
			cartDao.removeCartItem(1,5l);
			cartDao.removeCartItem(1,4l);
			cartDao.removeCartItem(2,4l);
			List<MenuItem> menuItemListCustomer = cartDao.getallCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

}
