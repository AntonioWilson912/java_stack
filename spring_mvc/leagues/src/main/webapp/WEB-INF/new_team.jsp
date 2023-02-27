<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Team</title>
</head>
<body>
    <h1>New Team</h1>
    <form:form action="/teams/new" method="post" modelAttribute="team">
    	<div>
    		<form:label path="name">Team Name:</form:label>
    		<form:input path="name" />
    	</div>
    	<div>
    		<form:label path="city">City:</form:label>
    		<form:input path="city" />
    	</div>
    	<input type="submit" value="Create">
    </form:form>
</body>
</html>