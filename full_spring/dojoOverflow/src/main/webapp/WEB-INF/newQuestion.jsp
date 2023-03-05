<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Question</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<h1>What is your question?</h1>
		<p class="mt-20"><a href="/">Dashboard</a></p>
		<div class="row mt-20">
			<form:form action="/questions/new" method="post"
				modelAttribute="question" cssClass="form col-3">
				<form:errors path="text" cssClass="text-danger" />
				<div class="form-group">
					<form:label path="text" cssClass="col">Question:</form:label>
					<form:textarea path="text" cssClass="col-3" />
				</div>
				<form:errors path="tags" cssClass="text-danger" />
				<div class="form-group">
					<label for="questionTags" class="col">Tags:</label>
					<input type="text" name="questionTags" value="${questionTags}" class="col-3" />
				</div>
				<div class="right">
					<input type="submit" value="Submit" class="btn">
				</div>
			</form:form>
			<div class="col"></div>
		</div>
	</div>
</body>