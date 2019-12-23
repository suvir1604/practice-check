package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImPlTest {
	public static void main(String args[]) {
		try {
			System.out.println("Admin menu List");
			testGetmenuItemAdmin();
			System.out.println("Customer menu Item List");
			testgetMenuItemListCustomer();
			System.out.println("Modified menu Item List");
			testModifyMenuItem();
			testGetmenuItemAdmin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void testModifyMenuItem() throws ParseException {
		MenuItem m = new MenuItem(1, "Aloo paratha", 59.00f, true, DateUtil.converttoDate("14/05/2016"), "main course",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImPl();
		menuItemDao.ModifyMenuItem(m);
	}

	public static void testGetmenuItemAdmin() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImPl();
		List<MenuItem> menuitemList = menuItemDao.getMenuItemListAdmin();
		for (MenuItem x : menuitemList) {
			System.out.println(x);
		}
	}

	public static void testgetMenuItemListCustomer() throws ParseException {
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImPl();
		List<MenuItem> menuitemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : menuitemList) {
			System.out.println(x);
		}
	}

}
