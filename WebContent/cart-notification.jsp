<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu item list Admin</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="title">truYum</span> <img
		src="./images/truyum-logo-light.png" alt="logo" id="logo" /> <nav>
	<a class="nav" href="ShowCart">cart</a> <a class="nav"
		href="ShowMenuItemListCustomer">menu</a> </nav> </header>
	<div>
		<h1>Cart</h1>
		<h3>${msg}</h3>
		<table>
			<tr>
				<th class="al.left">Name</th>
				<th class="al.right">Free Delivery</th>
				<th class="al.mid">price</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td class="al.left">${menu.name}</td>
					<td class="al.right">${menu.price}</td>
					<td class="al.mid">${menu.freeDelivery}</td>
					<td><a href="RemoveCart?menuItemId=${menu.id}">Delete</a></td>
				</tr>
			</c:forEach>
			<tr>
				<th class="al.left"></th>
				<th class="al.right">Total</th>
				<th class="al.mid">RS.278</th>
			</tr>
		</table>
	</div>
	<footer> copyright@2019 </footer>
</body>
</html>