<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
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
			<h1 class="italic"><c:out value="${book.title}" /></h1>
			<a href="/books">back to the shelves</a>
		</div>
		<div class="row mt-20">
			<div class="col-3">
				<c:choose>
					<c:when test="${book.user.id eq user.id}">
						<h4><span class="text-danger">You</span> read <span class="text-purple"><c:out value="${book.title}" /></span> by <span class="text-green"><c:out value="${book.author}" /></span>.</h4>
						<h4 class="mt-20">Here are your thoughts:</h4>
					</c:when>
					<c:otherwise>
						<h4><span class="text-danger"><c:out value="${book.user.name}" /></span> read <span class="text-purple"><c:out value="${book.title}" /></span> by <span class="text-green"><c:out value="${book.author}" /></span>.</h4>
						<h4 class="mt-20">Here are <c:out value="${book.user.name}" />'s thoughts:</h4>
					</c:otherwise>
				</c:choose>
				<blockquote class="mt-20">
					<c:choose>
						<c:when test="${fn:length(book.thoughts) eq 0}">
							There are no thoughts about this book.
						</c:when>
						<c:otherwise>
							<c:out value="${book.thoughts}" />
						</c:otherwise>
					</c:choose>
				</blockquote>
				<c:if test="${book.user.id eq user.id}">
					<div class="right mt-20">
						<a href="/books/${book.id}/edit" class="btn btn-green mr-10 pointer">edit</a>
						<form action="/books/${book.id}" method="post">
							<input type="hidden" name="_method" value="delete">
							<input type="submit" value="delete" class="btn btn-danger pointer">
						</form>
					</div>
				</c:if>
			</div>
			<div class="col"></div>
		</div>
	</div>
</body>