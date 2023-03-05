<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Category Page</title>
</head>
<body>
	<h1><c:out value="${category.name}" /></h1>
	<p><a href="/">Home</a></p>
	<hr>
	<h1>Products:</h1>
	<ul>
		<c:choose>
			<c:when test="${fn:length(category.products) eq 0}">
				<li>This category does not have any associated products.</li>
			</c:when>
			<c:otherwise>
				<c:forEach var="product" items="${category.products}">
					<li><c:out value="${product.name}" /></li>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</ul>
	<hr>
	<h1>Add Product:</h1>
	<c:choose>
		<c:when test="${fn:length(productsNotIn) eq 0}">
			<p>All products have been added to this category.</p>
		</c:when>
		<c:otherwise>
			<form action="/categories/${category.id}" method="post">
				<input type="hidden" name="_method" value="put">
				<select name="productId">
					<c:forEach var="product" items="${productsNotIn}">
						<option value="${product.id}"><c:out value="${product.name}" /></option>
					</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</c:otherwise>
	</c:choose>
</body>