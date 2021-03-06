<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Film By ID results</title>
</head>
<body>
	<h4>Film By ID Results</h4>
	<c:if test="${! empty film }">

		<c:choose>
			<c:when test="${empty film }">
				<li>No film with that id</li>
			</c:when>
		</c:choose>

		<ul>
			<li>Film Id: ${film.filmId }</li>
			<li>Title: ${ film.title}</li>
			<li>Description: ${ film.desc}</li>
			<li>Release year: ${ film.releaseYear }</li>
			<li>Rating: ${ film.rating }</li>
			<li>Rental Duration: ${ film.rentDur }</li>
			<li>Rental Rate: ${ film.rate }</li>
			<li>Length: ${ film.length }</li>
			<li>Replacement Cost: ${ film.repCost }</li>
			<br>
			<li>ACTORS:</li>
			<ul>
			
				<c:forEach var="actor" items="${film.actorList}">
					<li>${actor.firstName}&nbsp ${actor.lastName}</li>
				</c:forEach>
			</ul>
			<%-- 	<li>Features: ${ film.features }</li> --%>
		</ul>
	</c:if>
	<br>

	<form action="deleteFilm.do" method="POST">
		<label for="filmId">Enter film ID to delete: </label> <input
			type="number" name="filmId" placeholder="Film to delete"> <input
			type="submit" value="Delete film">
	</form>

	<br>

	<a href="home.do">Return to Main Menu</a>

</body>
</html>