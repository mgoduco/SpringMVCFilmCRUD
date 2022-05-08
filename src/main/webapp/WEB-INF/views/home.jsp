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
		<h3>Search a film by id:</h3>
		<form action="getFilm.do" method="get">
			<label for="filmId">Film id: </label> <input type="text"
				name="filmId"> <input type="submit" value="Search">
		</form>
		
		<h3>Update a film by id:</h3>
		<form action="updateFilmForm.do" method="get">
			<label for="filmId">Film id: </label> <input type="number"
				name="filmId"> <input type="submit" value="Search">
		</form>
	<br>
	<br>
		<h3>Find a list of films by keyword</h3>


	<form action="getFilmByKeyword.do" method="get">
	<label for="keyword">Enter search term: </label>
	<input type="text" name="keyword" placeholder="Search term...">
	<input type="submit" value="Search term">
	</form>
	
	<br>	
	<br>	
		<br> <br> <a href="createFilmForm.do">Create New Film</a>
	</div>

</body>
</html>