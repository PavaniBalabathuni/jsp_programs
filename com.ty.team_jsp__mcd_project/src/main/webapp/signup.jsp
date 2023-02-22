<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="save" method="post">
		 Name : <input type="text" name="name"
			placeholder="Enter user name"><br>
		<br> Email : <input type="email" name="email"
			placeholder="Enter email"><br>
		<br> Password : <input type="password" name="pwd"
			placeholder="enter password"><br>
		<br> Phone : <input type="tel" name="phone"
			placeholder="enter phone"><br>
			<br> Address : <input type="text" name="address"
			placeholder="enter address"><br>
			<label for="role">Role :</label>
			<input type="radio" name="role" value="Manager">manager 
				<input type="radio" name="role" value="Staff">staff 
					<input type="radio" name="role" value="Customer">customer
		<br> <br> <input type="submit" value="Submit">

	</form>

</body>
</html>