package com.cognizant.truyum.servlet;

import java.text.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImPl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet({ "/EditMenuItemServlet", "/EditMenuItem" })
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try { 
			long id = Long.parseLong(request.getParameter("menuItemId"));
			String name = request.getParameter("txt");
			float price = Float.parseFloat(request.getParameter("price"));
			boolean active = Boolean.parseBoolean(request.getParameter("active"));
			String launch = request.getParameter("date");
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
			Date result;
			result = f.parse(launch);
			
			
			String category = request.getParameter("main Course");
			boolean freeDelivery = Boolean.parseBoolean(request.getParameter("freeDelivery"));
           
			MenuItem m = new MenuItem(id, name, price, active, result, category, freeDelivery);
			MenuItemDao menuItemDao = new MenuItemDaoCollectionImPl();
			
			menuItemDao.ModifyMenuItem(m);
			request.setAttribute("msg", "menu Items Added succesfully");
			RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
			rd.forward(request, response);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}
	}

