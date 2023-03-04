<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Read Share</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-between">
			<h1>
				Welcome
				<c:out value="${user.name}" />
			</h1>
			<a href="/logout">logout</a>
		</div>
		<div class="row justify-between mt-20">
			<p>Books from everyone's shelves.</p>
			<a href="/books/new">+ Add a book to my shelf</a>
		</div>
		<div class="row mt-20">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author Name</th>
						<th>Posted By</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="bookCount" value="${fn:length(books)}" />
					<c:choose>
						<c:when test="${bookCount eq 0}">
							<tr>
								<td colspan="4">No books to display.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="thisBook" items="${books}">
								<tr>
									<td><c:out value="${thisBook.id}" /></td>
									<td><a href="/books/${thisBook.id}"><c:out value="${thisBook.title}" /></a></td>
									<td><c:out value="${thisBook.author}" /></td>
									<td><c:out value="${thisBook.user.name}" /></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>

	</div>
</body>