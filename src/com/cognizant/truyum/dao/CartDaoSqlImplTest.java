package com.cognizant.truyum.dao;

	import java.sql.SQLException;
	import java.util.List;

	import com.cognizant.truyum.model.MenuItem;

	public class CartDaoSqlImplTest {

		public static void main(String[] args) throws CartEmptyException, SQLException {
			testgetallCartItems();
			// testaddCartItem();
			//testgetallCartItems();
			//testRemoveCartItem(); 
			//testgetallCartItems();

		}

		private static void testaddCartItem() throws CartEmptyException, SQLException {
			CartDao cartDao = new CartDaoSqlImpl();
			System.out.println("Item List added in cart");
			cartDao.addCartItem(1,1);
			cartDao.addCartItem(1,3); 
			List<MenuItem> menuItemListCustomer = cartDao.getallCartItems(1);
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);  
			}

		}

		private static void testgetallCartItems() throws CartEmptyException, SQLException {
			CartDao cartDao = new CartDaoSqlImpl();
			System.out.println("All cart list"); 
			List<MenuItem> menuItemListCustomer = cartDao.getallCartItems(1);    
			for (MenuItem menuItem : menuItemListCustomer) {
				System.out.println(menuItem);
			}

		}

		public static void testRemoveCartItem() throws CartEmptyException, SQLException {
			CartDao cartDao = new CartDaoSqlImpl();
			System.out.println("Item List for customer after remove");
			try {
				cartDao.removeCartItem(1,1);
				cartDao.removeCartItem(2,4);
				List<MenuItem> menuItemListCustomer = cartDao.getallCartItems(1);
				for (MenuItem menuItem : menuItemListCustomer) {
					System.out.println(menuItem);
				}
			} catch (CartEmptyException e) {
				System.out.println(e.getMessage());
			}

		}

	}

