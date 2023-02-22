<%@page import="com.ty.team_jsp__mcd_project_dto.Menu"%>
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
	Menu menu = (Menu) request.getAttribute("menu");
	%>


	<form action="editor" method="post">
		<table>
			<tr>
				<td>Id :</td>
				<td><input type="number" name="id" placeholder="enter id"
					value=<%=menu.getId()%> readonly="true"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" placeholder="Enter name"
					value=<%=menu.getName()%>></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><input type="text" name="desc"
					placeholder="Enter Desription" value=<%=menu.getDescription()%>></td>
			</tr>
			<tr>
				<td>Price :</td>
				<td><input type="number" name="price" placeholder="enter price"
					value=<%=menu.getPrice()%>></td>
			</tr>
			<tr>
				<td>Offer :</td>
				<td><input type="number" name="offer" placeholder="enter offer"
					value=<%=menu.getOffer()%>></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>