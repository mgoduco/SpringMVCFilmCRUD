<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find film by keyword</title>
</head>
<body>
	<h1>List of films found:</h1>

	<c:forEach var="s" items="${films}">
		<tr>
			<td>${s.filmId}</td>
			<td>${s.title}</td>
			<td style="word-wrap: break-word" width=200px;>${s.desc}</td>
			<td><c:forEach var="actor" items="${s.actorList}">
                        ${actor.firstName} &nbsp ${actor.lastName}<br>
				</c:forEach></td>
			<td>${s.features}</td>
			<td>
				<form action="deleteFilm.do" method="post">
					<input type="submit" value="Delete"> <input type="hidden"
						name="filmId" value="${s.filmId}">
				</form>
				<br>
				<form action="updateFilmForm.do" method="get">
					<input type="submit" value="Edit"> <input type="hidden"
						name="filmId" value="${s.filmId}">
				</form>
				<br>
			</td>

		</tr>
	</c:forEach>
	<a href="home.do">Return to Main Menu</a>


</body>
</html>