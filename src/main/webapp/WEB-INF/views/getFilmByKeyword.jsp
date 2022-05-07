<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find film by keyword</title>
</head>
<body>
<h1>List of films found: </h1>

	<c:if test="${! empty film }">

	<table>
		<tr>
		
		<c:forEach var="film" items="${films }">
			<ul>
			<li>Title: ${ films.title}</li>
			<li>Description: ${ films.desc}</li>
			<li>Release year: ${ films.releaseYear }</li>
			<li>Rating: ${ films.rating }</li>
			<li>Rental Duration: ${ films.rentDur }</li>
			<li>Rental Rate: ${ films.rate }</li>
			<li>Length: ${ films.length }</li>
			<li>Replacement Cost: ${ films.repCost }</li>
			</ul>
			
		</c:forEach>
			</tr>
	</table>
	
	</c:if>

</body>
</html>