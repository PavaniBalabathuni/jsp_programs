<%@page import="com.ty.team_jsp__mcd_project_dto.Menu"%>
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



	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
	%>
	<h2><%=msg%></h2>


	<%
	}
	%>

	<table border="1px">
		<tr>
			<th>Menu ID</th>
			<th>Menu Name</th>
			<th>Menu Description</th>
			<th>Menu Price</th>
			<th>Menu Offer</th>
			
		</tr>
		<%
		List<Menu> list = (List) request.getAttribute("list");
		for (Menu menu : list) {
		%>
		<tr>
			<td><%=menu.getId()%></td>
			<td><%=menu.getName()%></td>
			<td><%=menu.getDescription()%></td>
			<td><%=menu.getPrice()%></td>
			<td><%=menu.getOffer()%></td>
			
		</tr>
		<%
		}
		%>
	</table>
  <a href="previous_orders.jsp">Previous Orders</a>
  <a href="home.jsp">Logout</a>






</body>
</html>