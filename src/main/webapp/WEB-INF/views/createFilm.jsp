<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>CREATE NEW FILM:</h3>

	<form action="createFilm.do" method="POST">
		
		<input type="text" hidden="false" name="id" value="${film.filmId }">
		
		<label for="title">Title of Film:</label> 
		<input type="text"
			name="title" value="your film name"> <br> 
			<label
			for="description">Description of Film:</label>
			 <input type="text"
			name="description" value="describe your film"> <br> 
			<label
			for="release_year">Release year:</label> 
			<input type="text"
			name="release_year" value="2022"> <br>
			 <label
			for="language_id">language_id:</label> 
			<input type="text"
			name="language_id" value="1"> <br> 
			<label
			for="rental_duration">rental_duration:</label>
			 <input type="text"
			name="rental_duration" value="3"> <br> 
			<label
			for="rental_rate">rental_rate:</label> 
			<input type="text"
			name="rental_rate" value="4.99"> <br> 
			<label
			for="length">length:</label>
			 <input type="text" name="length"
			value="50"> <br> 
			<label for="replacement_cost">replacement_cost:</label>
		<input type="text" name="replacement_cost" value="18.99">
		 <br>
		<label for="rating">rating:</label>
		 <input type="text" name="rating"
			value="R"> <br> 
			<label for="special_features">special_features:</label>
		<input type="text" name="special_features" value="Trailers">
		<br> <input type="submit" value="Create new film">

	</form>
	
<%-- 	<ul>
	<li>Title: ${ film.title}</li>
	<li>Description: ${ film.desc}</li>
	<li>Release year: ${ film.releaseYear }</li>
	<li>Rating: ${ film.rating }</li>
	<li>Rental Duration: ${ film.rentDur }</li>
	<li>Rental Rate: ${ film.rate }</li>
	<li>Length: ${ film.length }</li>
	<li>Replacement Cost: ${ film.repCost }</li>
	<li>Rating: ${ film.rating }</li>
	<li>Features: ${ film.features }</li>
	</ul> --%>
	
	<a href="home.do">Return to Main Menu</a>

</body>
</html>