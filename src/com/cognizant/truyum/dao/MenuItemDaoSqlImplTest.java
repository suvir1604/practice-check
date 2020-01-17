package com.cognizant.truyum.dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String[] args) {
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

	private static void testModifyMenuItem() throws ParseException, SQLException {
		MenuItem m = new MenuItem(1, "Aloo Paratha", 50.00f, true, DateUtil.converttoDate("17/05/2016"), "main course",
				true);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.ModifyMenuItem(m);  
	}

	public static void testGetmenuItemAdmin() throws ParseException, SQLException { 

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl(); 
		List<MenuItem> menuitemList = menuItemDao.getMenuItemListAdmin(); 
		for (MenuItem x : menuitemList) {
			System.out.println(x);    
		}
	}
  
	public static void testgetMenuItemListCustomer() throws ParseException, SQLException {
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		List<MenuItem> menuitemList = menuItemDao.getMenuItemListCustomer();
		for (MenuItem x : menuitemList) {
			System.out.println(x);
		}
	}
// TODO Auto-generated method stub

	}


