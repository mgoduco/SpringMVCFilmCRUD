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
	<p>
	<h4>Film By ID Results</h4>
	<c:if test="${! empty film.filmId }">
		<li>Film Id: ${film.filmId }</li>
		<c:choose>
			<c:when test="${empty film.filmId }">
				No film with that id
			</c:when>
		</c:choose>
		<ul>
			<li>Title: ${ film.title}</li>
			<li>Description: ${ film.desc}</li>
			<li>Release year: ${ film.releaseYear }</li>
			<li>Rating: ${ film.rating }</li>
			<li>Language: ${ film.lang }</li>
		</ul>
	</c:if>
	</p>
	<a href="home.do">Return to Main Menu</a>

</body>
</html>