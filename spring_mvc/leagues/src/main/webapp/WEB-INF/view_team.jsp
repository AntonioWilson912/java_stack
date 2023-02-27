<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><c:out value="${team.name}"/></title>
</head>
<body>
    <h1><c:out value="${team.city}"/> <c:out value="${team.name}"/></h1>
    <div>
    	<c:forEach var="player" items="${team.players}">
    		<p><c:out value="${player.firstName}"/> <c:out value="${player.lastName}"/></p>
    		<p>Age: <c:out value="${player.age}"/></p>
    		<p>Position: <c:out value="${player.position}"/></p>
    		<br>
    	</c:forEach>
    </div>
    <hr>
    <div>
    	<p><a href="/players/new">Create New Player</a></p>
    </div>
</body>
</html>