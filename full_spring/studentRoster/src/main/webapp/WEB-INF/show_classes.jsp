<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>All Classes</title>
</head>
<body>
	<h1>All Classes</h1>
	<p><a href="/">Dashboard</a></p>
	<table>
		<thead>
			<tr>
				<th>Class</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(classes) eq 0}">
					<tr>
						<td>No classes exist.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="course" items="${classes}">
						<tr>
							<td><a href="/classes/${course.id}"><c:out value="${course.name}" /></a>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>