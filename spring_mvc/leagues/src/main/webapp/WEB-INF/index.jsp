<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All Teams</title>
</head>
<body>
    <h1>League Teams:</h1>
    <div>
    	<c:forEach var="team" items="${teams}">
    		<p><a href="/teams/${team.id}"><c:out value="${team.name}"/></a></p>
    	</c:forEach>
    </div>
    <hr>
    <div>
    	<p><a href="/teams/new">Create New Team</a></p>
    	<p><a href="/players/new">Create New Player</a>
    </div>
</body>
</html>