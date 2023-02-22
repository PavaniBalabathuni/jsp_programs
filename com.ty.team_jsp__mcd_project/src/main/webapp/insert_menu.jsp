<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="menusave" method="post">
		<table>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" placeholder="Enter name"></td>
			</tr>

			<tr>
				<td>Description :</td>
				<td><input type="text" name="desc"
					placeholder="Enter Desription"></td>
			</tr>
			<tr>
				<td>Price :</td>

				<td><input type="number" name="price" placeholder="enter price"></td>
			</tr>
			<tr>
				<td>Offer :</td>

				<td><input type="number" name="offer" placeholder="enter offer"></td>
			</tr>
			<tr>
				<td></td>

				<td><input type="submit" value="Submit"></td>

			</tr>
		</table>
	</form>

</body>
</html>