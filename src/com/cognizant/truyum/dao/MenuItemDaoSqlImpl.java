package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao{

	@Override
	public List<MenuItem> getMenuItemListAdmin() throws SQLException {
		List<MenuItem> menuItemList = new ArrayList<>();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="select * from menu_item";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery("select * from menu_item");
			while(rs.next()) {
				MenuItem m=new MenuItem();
				m.setId(rs.getInt(1)); 
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
				menuItemList.add(m);
			}
			}catch(Exception e) { 
				e.printStackTrace();
				
			}finally { 
				con.close();  
			}
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() throws SQLException {
		List<MenuItem> CustList=new ArrayList<>();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="select * from menu_item where  me_active=? AND me_date_of_launch<=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, "Yes");
			ps.setDate(2, new java.sql.Date(System.currentTimeMillis()));
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				MenuItem m=new MenuItem();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
				CustList.add(m);
			}
			}catch(Exception e) {
				e.printStackTrace();
				
			}finally {
				con.close();
			}
		return CustList;
	}

	@Override
	public void ModifyMenuItem(MenuItem menuItem) throws SQLException {
		List<MenuItem> result = new ArrayList<>();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="update menu_item set me_name=?,me_price=?,me_active=?,me_date_of_launch=?,me_category=?,me_free_delivery=? where me_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,menuItem.getName());
			ps.setDouble(2,menuItem.getPrice());
			ps.setString(3, menuItem.isActive()?"Yes":"No");
			ps.setDate(4,new java.sql.Date(menuItem.getDateofLaunch().getTime()));
			ps.setString(5,menuItem.getCategory());
			ps.setString(6, menuItem.isFreeDelivery()?"Yes":"No");
			ps.setLong(7, menuItem.getId());
			int count=ps.executeUpdate();
			
			}catch(Exception e) { 
			e.printStackTrace();
			}finally {
			con.close();
		}
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) throws SQLException {
		MenuItem menuItem=new MenuItem();
		Connection con=ConnectionHandler.getConnection();
		try {
			String sql="select * from menu_item where me_id=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				MenuItem m=new MenuItem();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setPrice(rs.getFloat(3));
				m.setActive(rs.getString(4).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(5));
				m.setCategory(rs.getString(6));
				m.setFreeDelivery(rs.getString(7).equalsIgnoreCase("Yes"));
		}
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			con.close();
		}
		return menuItem;
	}

}
