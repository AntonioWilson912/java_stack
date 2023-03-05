<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home</title>
</head>
<body>
	<h1>Home Page</h1>
	<p><a href="/products/new">New Product</a></p>
	<p><a href="/categories/new">New Category</a></p>
	<table>
		<thead>
			<tr>
				<th>Products</th>
				<th>Categories</th>
			</tr>
		<tbody>
			<tr>
				<td>
					<c:choose>
						<c:when test="${fn:length(products) eq 0}">
							<p>No products available.</p>
						</c:when>
						<c:otherwise>
							<ul>
								<c:forEach var="product" items="${products}">
									<li><a href="/products/${product.id}"><c:out value="${product.name}" /></a></li>
								</c:forEach>
							</ul>
						</c:otherwise>
					</c:choose>
				</td>
				<td>
					<c:choose>
						<c:when test="${fn:length(categories) eq 0}">
							<p>No categories available.</p>
						</c:when>
						<c:otherwise>
							<ul>
								<c:forEach var="category" items="${categories}">
									<li><a href="/categories/${category.id}"><c:out value="${category.name}" /></a></li>
								</c:forEach>
							</ul>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</tbody>
	</table>
</body>