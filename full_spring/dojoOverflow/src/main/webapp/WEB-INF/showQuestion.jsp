<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Question</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<h1><c:out value="${question.text}" /></h1>
		<p class="mt-20"><a href="/">Dashboard</a></p>
		<div class="row justify-start align-center mt-40">
			<h2>Tags:</h2>
				<c:forEach var="tag" items="${question.tags}">
					<button class="btn"><c:out value="${tag.subject}" /></button>
				</c:forEach>
		</div>
		<div class="row mt-40">
			<div class="col">
				<h2>Answers:</h2>
				<ul>
					<c:choose>
						<c:when test="${fn:length(question.answers) eq 0}">
							<li>No answers currently.</li>
						</c:when>
						<c:otherwise>
							<c:forEach var="answer" items="${question.answers}">
								<li><c:out value="${answer.text}" /></li>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="col">
				<h2>Add your answer:</h2>
				<form:form action="/questions/${question.id}" method="post" modelAttribute="answer" cssClass="form">
					<form:errors path="text" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="text" cssClass="col">Answer:</form:label>
						<form:textarea path="text" cssClass="col-2" rows="5" />
					</div>
					<div class="right">
						<input type="submit" value="Answer it!" class="btn">
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>