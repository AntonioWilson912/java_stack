<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Category</title>
</head>
<body>
	<h1>New Category</h1>
	<p><a href="/">Home</a></p>
	<form:form action="/categories/new" method="post" modelAttribute="category">
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name" />
		</div>
		<input type="submit" value="Submit">
	</form:form>
</body>