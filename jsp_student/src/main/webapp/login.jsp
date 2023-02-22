<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		Email: <input type="email" name="email" placeholder="Enter your email"> <br>
		Password: <input type="password" name="password" placeholder="Enter your password"> <br>
		<input type="submit" value="Login">
		
	</form>
	<% String msg=(String) request.getAttribute("msg");
	if(msg!= null){%>
	<h4 style="color: red"><%= msg %></h4>
	<%} %>
</body>
</html>