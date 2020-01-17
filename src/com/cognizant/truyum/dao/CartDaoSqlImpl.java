package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.mysql.cj.protocol.Resultset;

public class CartDaoSqlImpl implements CartDao {

	@Override
	public void addCartItem(long userId, long menuItemId){
		Connection con=ConnectionHandler.getConnection();
        try {
             String sql="INSERT INTO cart(ct_us_id,ct_pr_id) VALUES (?,?)";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setLong(1, userId);
             ps.setLong(2, menuItemId);
                   int count = ps.executeUpdate(); 
			}catch(Exception e) { 
				e.printStackTrace(); 
				
			}finally { 
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}

	@Override 
	public List<MenuItem> getallCartItems(long userId) throws CartEmptyException, SQLException{
		List<MenuItem> cartItemList=new ArrayList<>();
		Connection con=ConnectionHandler.getConnection();
		Cart cart=new Cart();
			String sql="SELECT me_name,me_price,me_active,me_date_of_launch,me_category,me_free_delivery FROM menu_item inner join cart on ct_pr_id=me_id where ct_us_id=?"; 
			try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setLong(1, userId);
			ResultSet rs=ps.executeQuery();  
			while(rs.next()) {  
				MenuItem m=new MenuItem();
				m.setName(rs.getString(1));
				m.setPrice(rs.getFloat(2));
				m.setActive(rs.getString(3).equalsIgnoreCase("Yes"));
				m.setDateofLaunch(rs.getDate(4));
				m.setCategory(rs.getString(5));   
				m.setFreeDelivery(rs.getString(6).equalsIgnoreCase("Yes"));
				cart.getMenuItemList().add(m);
			}
			String query="SELECT sum(me_price) as TotalPrice\r\n" + 
					"FROM menu_item\r\n" + 
					"inner join cart \r\n" + 
					"on ct_pr_id=me_id\r\n" + 
					"where cart.ct_us_id=?;"; 
			PreparedStatement pstatement=con.prepareStatement(query);
			/*pstatement.setLong(1, 1);*/
			}catch(Exception e) { 
				e.printStackTrace(); 
				
			}finally { 
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return cart.getMenuItemList(); 
		
	}

	@Override
	public void removeCartItem(long userId, long menuItemId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
        try {
             String sql="DELETE FROM cart" + 
                           "WHERE ct_us_id=? AND ct_pr_id=?";
             PreparedStatement ps=con.prepareStatement(sql);
             ps.setLong(1, userId);
             ps.setLong(2, menuItemId);
             int count = ps.executeUpdate();
        } catch (SQLException e) { 
               e.printStackTrace();
        } finally {
               try {
                     con.close();
               } catch (SQLException e) {
                     e.printStackTrace();

               }
        }
	}
}
