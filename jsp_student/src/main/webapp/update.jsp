<%@page import="com_ty_jsp_student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Student student=(Student)request.getAttribute("id"); %>
	<form action="editor" method="post">
	Id: <input type="number" name="id" value=<%=student.getId() %> readonly="true">
	Name: <input type="text" name="name" value="<%=student.getName() %>"> <br>
	FatherName: <input type="text" name="fname" value="<%=student.getFname() %>"> <br>
	Email: <input type="email" name="email" value="<%=student.getEmail() %>"> <br>
	Password: <input type="password" name="password" value="<%=student.getPassword()%>"> <br>
	Phone: <input type="tel" name="phone" value="<%=student.getPhone() %>"> <br>
	<input type="submit" value="Update">
	</form>

</body>
</html>