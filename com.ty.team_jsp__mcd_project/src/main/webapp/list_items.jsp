<%@page import="com.ty.team_jsp__mcd_project_dto.Items"%>
<%@page import="java.util.List"%>
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
			<th>item ID</th>
			<th>item Name</th>
			<th> Description</th>
			<th>item Price</th>
			<th>item Offer</th>
			<th>Order items</th>
		</tr>
		<%
		List<Items> list = (List) request.getAttribute("list");
		for (Items items : list) {
		%>
		<tr>
			<td><%=items.getId()%></td>
			<td><%=items.getName()%></td>
			<td><%=items.getDescrption()%></td>
			<td><%=items.getPrice()%></td>
			<td><%=items.getOffer()%></td>
			<td><a href="place_order?id=<%=items.getId()%>">place order</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>