<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product Page</title>
</head>
<body>
	<h1><c:out value="${product.name}" /></h1>
	<p><a href="/">Home</a></p>
	<hr>
	<h1>Categories:</h1>
	<ul>
		<c:choose>
			<c:when test="${fn:length(product.categories) eq 0}">
				<li>This product is not part of any categories.</li>
			</c:when>
			<c:otherwise>
				<c:forEach var="category" items="${product.categories}">
					<li><c:out value="${category.name}" /></li>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</ul>
	<hr>
	<h1>Add Category:</h1>
	<c:choose>
		<c:when test="${fn:length(notInCategories) eq 0}">
			<p>No available categories to add this product to.</p>
		</c:when>
		<c:otherwise>
			<form action="/products/${product.id}" method="post">
				<input type="hidden" name="_method" value="put">
				<select name="categoryId">
					<c:forEach var="category" items="${notInCategories}">
						<option value="${category.id}"><c:out value="${category.name}" /></option>
					</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</c:otherwise>
	</c:choose>
</body>