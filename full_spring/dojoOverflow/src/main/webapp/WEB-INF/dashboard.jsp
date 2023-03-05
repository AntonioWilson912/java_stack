<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Questions Dashboard</title>
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div class="container-fluid">
		<h1>Questions Dashboard</h1>
		<table class="table table-striped mt-20">
			<thead>
				<tr>
					<th>Question</th>
					<th>Tags</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${fn:length(questions) eq 0}">
						<tr>
							<td colspan="2">No questions available.</td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="question" items="${questions}">
							<tr>
								<td><a href="/questions/${question.id}"><c:out value="${question.text}" /></a></td>
								<td>
									<c:forEach var="tag" items="${question.tags}" varStatus="loop">
										<c:out value="${tag.subject}" />${loop.last ? '' : ','}
									</c:forEach>
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		<div class="right mt-20">
			<a href="/questions/new">New Question</a>
		</div>
	</div>
</body>