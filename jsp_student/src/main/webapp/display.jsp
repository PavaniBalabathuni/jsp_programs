<%@page import="com_ty_jsp_student.dto.Student"%>
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
	<% List<Student> list= (List)request.getAttribute("list");%>
 <table border="1px">
 	<thead>
 		<tr>
 			<th>Id</th>
 			<th>Name</th>
 			<th>FatherName</th>
 			<th>Email</th>
 			<th>Password</th>
 			<th>Phone</th>
 			<th>Fee</th>
 			<th>Delete</th>
 			<th>Update</th>
 		</tr>
 	</thead>
 	
 	<tbody>
 	<%for(Student std:list) {%>
 		<tr>
 			<td><%=std.getId() %></td>
 			<td><%=std.getName() %></td>
 			<td><%=std.getFname() %></td>
 			<td><%=std.getEmail() %></td>
 			<td><%=std.getPassword() %></td>
 			<td><%=std.getPhone() %></td>
 			<td><%=std.getFee() %></td>
 			<td><a href="delete?id=<%=std.getId() %>"> <button>Delete</button> </a></td>
 			<td> <a href="update?id=<%=std.getId() %>"> <button>Update</button> </a> </td>
 		</tr>
 		<% } %>
 	</tbody>
 	
 </table>
	
</body>
</html>