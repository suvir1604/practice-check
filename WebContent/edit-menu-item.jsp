<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu item list admin</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
<script src="./js/script1.js" type="text/javascript"></script>
</head>
<body>
	<header> <span id="title">truYum</span> <img
		src="./images/truyum-logo-light.png" alt="logo" id="logo"> <nav>
	<a class="nav" href="ShowMenuItemListAdmin">menu</a> </nav> </header>
	<div>
		<h1>Edit Menu item</h1>
		<form name="Form" method="post" action="EditMenuItem?menuItemId=${menuItem.id}"
			onsubmit="return validate()">
			<table>
				<tr>
					<th>Name</th>
				</tr>
				<tr>
					<td><input type="text" name="txt" value="${menuItem.name}" />
					</td>
				</tr>
				<tr>
					<th>price</th>
					<th>Active</th>
					<th>Date of launch</th>
					<th>category</th>
				</tr>
				<tr>
					<td><input type="text" name="price" value="${menuItem.price}" />
					</td>
					<td><input type="radio" name="rb" id="yes"
						value="${menuItem.active}" checked /><label for="yes">yes</label>
						<input type="radio" name="rb"><label for="no">no</label></td>
					<td><input type="text" name="date"
						value="<fmt:formatDate pattern="dd/MM/yyyy" value="${menuItem.dateofLaunch}"></fmt:formatDate>" />
					</td>
					<td><select type="text" id="main Course"
						value="${menuItem.category}">
							<option>Starters</option>
							<option selected>Main course</option>
							<option>Dessert</option>
							<option>Drinks</option>
					</select></td>
				<tr>
					<td><input type="checkbox" name="free"
						value="${menuItem.freeDelivery}" checked />free delivery
				</tr>
				<tr>
					<td><input type="submit" id="sub" name="save" value="save" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<footer> copyright &copy 2019 </footer>
</body>
</html>