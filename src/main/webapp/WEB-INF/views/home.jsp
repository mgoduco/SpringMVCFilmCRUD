<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC Film Site</title>
</head>
<body>

	<h1>Welcome to the Film Site!</h1>

	<div>
		<h3>Enter a film id:</h3>
		<form action="filmInfo.do" method="get">
			<label for="filmId">Film id: </label> <input type="text"
				name="filmId"> <input type="submit" value="Search">
		</form>

	</div>

</body>
</html>