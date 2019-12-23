package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImPl implements MenuItemDao {
	private static List<MenuItem> menuItemList;

	public MenuItemDaoCollectionImPl() throws ParseException {
		super();
		if (menuItemList == null) {
			menuItemList = new ArrayList<>();
			menuItemList.add(new MenuItem(1, "sandwich", 99.0f, true, DateUtil.converttoDate("15/03/2017"),
					"main course", true));
			menuItemList.add(new MenuItem(2, "Burger", 129.0f, true, DateUtil.converttoDate("23/12/2017"),
					"main Course", false));
			menuItemList.add(
					new MenuItem(3, "Pizza", 149.0f, true, DateUtil.converttoDate("21/08/2018"), "main Course", false));
			menuItemList.add(new MenuItem(4, "French Fries", 57.0f, false, DateUtil.converttoDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5,"Chocolate Brownie", 32.0f, true, DateUtil.converttoDate("02/11/2022"),
					"Dessert", true));

		}
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> CustList = new ArrayList();
		Date today = new Date();

		for (MenuItem x : menuItemList) {
			if ((x.isActive()) && (x.getDateofLaunch().before(today))) {
				CustList.add(x);
			}
		}
		return CustList;
	}

	@Override
	public void ModifyMenuItem(MenuItem menuItem) {
		MenuItem x = getMenuItem(menuItem.getId());
		x.setName(menuItem.getName());
		x.setPrice(menuItem.getPrice());
		x.setActive(true);
		x.setDateofLaunch(menuItem.getDateofLaunch());
		x.setCategory(menuItem.getCategory());
		x.setFreeDelivery(true);
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		MenuItem m = null;
		for (MenuItem x : menuItemList) {
			if (x.getId() == menuItemId) {
				m = x;
				break;
			}
		}
		return m;
	}
}
