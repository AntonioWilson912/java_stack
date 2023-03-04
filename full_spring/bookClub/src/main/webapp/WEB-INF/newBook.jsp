<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book Share</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<div class="row justify-between">
			<h1>Add a Book to Your Shelf!</h1>
			<a href="/books">back to the shelves</a>
		</div>
		<div class="row mt-20">
				<form:form action="/books/new" method="post" modelAttribute="book" cssClass="form col-3">
					<form:errors path="title" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="title" cssClass="col">Title</form:label>
						<form:input path="title" cssClass="col-3" />
					</div>
					<form:errors path="author" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="author" cssClass="col">Author</form:label>
						<form:input path="author" cssClass="col-3"/>
					</div>
					<div class="form-group">
						<form:label path="thoughts" cssClass="col">Thoughts</form:label>
						<form:textarea path="thoughts" cssClass="col-3"/>
					</div>
					<div class="right">
						<input type="submit" value="Submit" class="btn">
					</div>
				</form:form>
				<div class="col-2"></div>
			</div>
	</div>
</body>