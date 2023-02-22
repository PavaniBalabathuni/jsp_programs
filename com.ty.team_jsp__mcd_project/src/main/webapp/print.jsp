<%@page
	import="org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item"%>
<%@page import="com.ty.team_jsp__mcd_project_dto.Items"%>
<%@page import="com.ty.team_jsp__mcd_project_dto.FoodOrder"%>
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
	FoodOrder foodOrder = (FoodOrder) request.getAttribute("food");
	double total = 0;
	%>
	<table>
		<tr>
			<th>Name :</th>
			<td><%=foodOrder.getCustomer_name()%></td>
		</tr>
		<tr>
			<th>Email :</th>
			<td><%=foodOrder.getEmail()%></td>
		</tr>
		<tr>
			<th>Address :</th>
			<td><%=foodOrder.getAddress()%></td>
		</tr>
		<tr>
			<th>Phone :</th>
			<td><%=foodOrder.getPhone()%></td>
		</tr>
	</table>
	<table border="1px">
		<tr>
			<th>Items _id</th>
			<th>Items _Name</th>
			<th>Items _Description</th>
			<th>Items _Price</th>
			<th>Items _offer</th>
			<th>Items _Quantity</th>
			<th>Total</th>
		</tr>
		<%
		for (Items items : foodOrder.getList()) {
		%>
		<tr>
			<td><%=items.getId() %></td>
			<td><%=items.getName() %></td>
			<td><%=items.getDescrption() %></td>
			<td><%=items.getPrice() %></td>
			<td><%=items.getOffer() %></td>
			<td><%=items.getQuantity() %></td>
			<% double a=(items.getPrice() * items.getQuantity())-(((items.getPrice() * items.getQuantity()))*(items.getOffer()/100));%>
			<td><%=a%></td>
			<% total=total+a;%>


		</tr>

		<%
		}
		%>

	</table>

	<h3>
		Total amount :
		<%=total%></h3>
<a href="login.jsp"><button> Logout</button></a>
<a href="order_page"><button>Order_Page</button></a>


</body>
</html>