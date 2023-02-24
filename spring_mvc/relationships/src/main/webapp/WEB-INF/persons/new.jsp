<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Person</title>
</head>
<body>
    <h1>New Person</h1>
    <form:form action="/persons" method="post" modelAttribute="person">
    	<form:label path="firstName">First Name:</form:label>
    	<form:input path="firstName" />
    	
    	<form:label path="lastName">Last Name:</form:label>
    	<form:input path="lastName" />
    	<input type="submit" value="Create">
    </form:form>
</body>
</html>