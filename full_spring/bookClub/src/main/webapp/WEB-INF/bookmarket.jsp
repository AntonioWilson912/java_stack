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
<title>Book Lender Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-between">
			<p>
				Hello,
				<c:out value="${user.name}" />
				. Welcome to..
			</p>
			<a href="/books">back to the shelves</a>
		</div>
		<h1>The Book Broker!</h1>
		<p class="mt-20">Available Books to Borrow</p>
		<div class="row mt-20">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(availableBooks) eq 0 }">
							<tr>
								<td colspan="5">No books available for borrowing.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="availableBook" items="${availableBooks}">
								<tr>
									<td><c:out value="${availableBook.id}" /></td>
									<td><a href="/books/${availableBook.id}"><c:out
												value="${availableBook.title}" /></a></td>
									<td><c:out value="${availableBook.author}" /></td>
									<td><c:out value="${availableBook.owner.name}" /></td>
									<td><c:if test="${availableBook.owner.id eq user.id}">
											<p>
												<a href="/books/${availableBook.id}/edit">edit</a> <a
													href="/books/${availableBook.id}/delete">delete</a>
											</p>
										</c:if> <c:if test="${availableBook.owner.id ne user.id}">
											<a href="/bookmarket/borrow/${availableBook.id}">borrow</a>
										</c:if></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
		<p class="mt-20">Books I'm Borrowing</p>
		<div class="row mt-20">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>ID</th>
						<th>Title</th>
						<th>Author</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${fn:length(user.borrowedBooks) eq 0 }">
							<tr>
								<td colspan="5">You haven't borrowed any books.</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="borrowedBook" items="${user.borrowedBooks}">
								<tr>
									<td><c:out value="${borrowedBook.id}" /></td>
									<td><a href="/books/${borrowedBook.id}"><c:out
												value="${borrowedBook.title}" /></a></td>
									<td><c:out value="${borrowedBook.author}" /></td>
									<td><c:out value="${borrowedBook.owner.name}" /></td>
									<td><a href="/bookmarket/return/${borrowedBook.id}">return</a></td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</div>
	</div>
</body>