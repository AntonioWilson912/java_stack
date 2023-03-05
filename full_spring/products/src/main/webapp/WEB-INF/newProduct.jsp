<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Product</title>
</head>
<body>
	<h1>New Product</h1>
	<p><a href="/">Home</a></p>
	<form:form action="/products/new" method="post" modelAttribute="product">
		<div>
			<form:label path="name">Name:</form:label>
			<form:input path="name" />
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:input path="description" />
		</div>
		<div>
			<form:label path="price">Price:</form:label>
			<form:input path="price" type="number" step="0.01" />
		</div>
		<input type="submit" value="Submit">
	</form:form>
</body>