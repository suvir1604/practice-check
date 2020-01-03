<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>menu item list admin</title>
<link href="./style/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<header> <span id="title">truYum</span> <img
		src="./images/truyum-logo-light.png" alt="logo" id="logo"> <a
		class="nav" href="ShowMenuItemListAdmin">menu</a> </header>
	<div>
		<h1>Menu items</h1>
		<table>
			<tr>
				<th class="al.left">Name</th>
				<th class="al.right">price</th>
				<th class="al.mid">Active</th>
				<th class="al.mid">Date of launch</th>
				<th class="al.mid">Category</th>
				<th class="al.mid">Free Delivery</th>
				<th class="al.mid">Action</th>
			</tr>
			<c:forEach items="${menuItemList}" var="menu">
				<tr>
					<td class="al.left">${menu.name}</td>
					<td class="al.right">${menu.price}</td>
					<td class="al.mid">${menu.active?'Yes' : 'No'}</td>
					<td class="al.mid"><fmt:formatDate pattern="dd/MM/yyyy"
							value="${menu.dateofLaunch}"></fmt:formatDate></td>
					<td class="al.mid">${menu.category}</td>
					<td class="al.mid">${menu.freeDelivery?'Yes' : 'No'}</td>
					<td class="al.mid"><a
						href="ShowEditMenuItem?menuItemId=${menu.id}" target="_plan">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<footer> copyright@2019 </footer>
</body>
</html>