<%@page import="com.ty.team_jsp__mcd_project_dto.Items"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
	Items menu = (Items) request.getAttribute("items");
	%>

	<form action="items_editor" method="post">
		<table>
			<tr>
				<td>Item id:</td>
				<td><input type="number" name="id" value=<%=menu.getId()%>
					readonly="true"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter the  item name" value=<%=menu.getName()%> readonly="true"></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><input type="text" name="desc" readonly="true"
					placeholder="Enter description" value=<%=menu.getDescrption()%>></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><input type="number" name="price"
					placeholder="Enter the price" value=<%=menu.getPrice()%> readonly="true"></td>
			</tr>
			<tr>
				<td>Offer :</td>
				<td><input type="number" name="offer"
					placeholder="Enter the offer" value=<%=menu.getOffer()%> readonly="true"></td>
			</tr>
			<tr>
				<td>Quantity :</td>
				<td><input type="number" name="quantity"
					placeholder="Enter the quantity"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Order"></td>
			</tr>
		</table>
	</form>

</body>
</html>