<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><c:out value="${course.name}" /></title>
</head>
<body>
	<h1>Students taking <c:out value="${course.name}" /></h1>
	<p><a href="/">Dashboard</a>
	<table>
		<thead>
			<tr>
				<th>Name</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(course.students) eq 0}">
					<tr>
						<td>No students are taking this class.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="student" items="${course.students}">
						<tr>
							<td><a href="/students/${student.id}"><c:out value="${student.name}" /></a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>