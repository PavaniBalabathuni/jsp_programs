<%@page import="com.ty.team_jsp__mcd_project_dto.Items"%>
<%@page import="java.util.List"%>
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
	<table border="1px">
	<tr>
			<th>order id</th>
			<th>Item_name</th>
			<th>Item_Descrption</th>
			<th>Item_price</th>
			<th>Items_offer</th>
			<th>Quantity</th>
			<th>Total</th>
		</tr>
		<%
		FoodOrder list = (FoodOrder) request.getAttribute("list");

		for (Items items1 : list.getList()) {
		%>

		




		<tr>

			<td><%=items1.getId()%></td>



			<td><%=items1.getName()%></td>



			<td><%=items1.getDescrption()%></td>



			<td><%=items1.getPrice()%></td>




			<td><%=items1.getOffer()%></td>



			<td><%=items1.getQuantity()%></td>


			<td><%=(items1.getPrice() * items1.getQuantity())
		- ((items1.getPrice() * items1.getQuantity()) * (items1.getOffer() / 100))%></td>

		</tr>








		<%
		}
		%>

	</table>


	<br>
	<br>
	<a href="login.jsp"><button>logout</button></a>

</body>
</html>