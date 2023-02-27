<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All Dojos</title>
</head>
<body>
    <h1>All Dojos:</h1>
    <div>
    	<c:forEach var="dojo" items="${dojos}">
    		<p><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></p>
    	</c:forEach>
    </div>
    <hr>
    <div>
    	<p><a href="/dojos/new">Create New Dojo</a></p>
    	<p><a href="/ninjas/new">Create New Ninja</a>
    </div>
</body>
</html>