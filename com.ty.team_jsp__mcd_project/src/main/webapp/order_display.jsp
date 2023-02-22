<%@page import="java.util.List"%>
<%@page import="com.ty.team_jsp__mcd_project_dto.Items"%>
<%@page
	import="org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item"%>
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
	<th>Items id</th>
	<th>Items Name</th>
	<th>Items Description</th>
	<th>Items Price</th>
	<th>Items offer</th>
	<th>Items quantity</th>
	
	
	</tr>
	<%
	List<Items> items = (List) request.getAttribute("items2");
	for (Items items2 : items) {
	%>
	<tr>
	<td><%=items2.getId() %></td>
	<td><%=items2.getName() %></td>
	<td><%=items2.getDescrption() %></td>
	<td><%=items2.getPrice() %></td>
	<td><%=items2.getOffer() %></td>
	<td><%=items2.getQuantity() %></td>
	
	
	</tr>




	</table>
	<%
	}
	%>
	
	
	
</body>
</html>