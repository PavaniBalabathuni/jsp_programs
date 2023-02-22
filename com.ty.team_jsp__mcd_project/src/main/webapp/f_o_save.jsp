<%@page import="org.hibernate.hql.spi.id.inline.IdsClauseBuilder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	int id = 0;
	int count = 0;
	%>
	<%
	List<Integer> id_count = new ArrayList<Integer>();
	%>


	<table border="1px">
		<tr>
			<th>Items id</th>
			<th>Items Name</th>
			<th>Items Description</th>
			<th>Items Price</th>
			<th>Items offer</th>
			<th>Items quantity</th>
			<th>order id</th>
			<th>Delete</th>
			<th>Update</th>


		</tr>
		<%
		List<Items> list = (List) request.getAttribute("list");

		for (Items items2 : list) {
		%>
		<tr>
			<%
			id = items2.getId();
			%>
			<td><%=items2.getId()%></td>
			<td><%=items2.getName()%></td>
			<td><%=items2.getDescrption()%></td>
			<td><%=items2.getPrice()%></td>
			<td><%=items2.getOffer()%></td>
			<td><%=items2.getQuantity()%></td>
			<td><label> order_id : </label> <input type="number"
				name="order_id" value=<%=items2.getId()%>
				placeholder="enter address"></td>
			<%
			id_count.add(id);
			%>
			<td><a href="delete_item?id=<%=items2.getId()%>">Delete</a></td>
			<td><a href="update_item?id=<%=items2.getId()%>">Update</a></td>
		</tr>
		<tr>
		</tr>
		<%count++;%>
		<%
		}
		%>


		<br>
	</table>
	<br>
	<form action="food_order" method="post">
		<table>

			<tr>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter customer name"></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" name="email" placeholder="Enter email"></td>
			</tr>
			<tr>
				<td>Phone :</td>
				<td><input type="tel" name="phone" placeholder="enter phone"></td>
			</tr>

			<tr>
				<td>Address :</td>
				<td><input type="text" name="address"
					placeholder="enter address"></td>
			</tr>
			<tr>
			<td>Number of orders :</td>
			<td><%=count %></td>
			
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Print_Bill"></td>

			</tr>



		</table>
	</form>
	<a href="add_items"><button>Add+</button></a>


</body>
</html>