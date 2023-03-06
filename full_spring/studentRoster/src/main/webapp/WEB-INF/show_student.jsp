<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><c:out value="${student.name}" /></title>
</head>
<body>
	<h1><c:out value="${student.name}" />'s classes</h1>
	<p><a href="/">Dashboard</a></p>
	<c:choose>
		<c:when test="${fn:length(classesNotIn) ne 0}">
			<form action="/students/${student.id}" method="post">
				<input type="hidden" name="_method" value="put">
				<label for="newClass">Classes</label>
				<select name="newClass">
					<c:forEach var="course" items="${classesNotIn}">
						<option value="${course.id}"><c:out value="${course.name}" /></option>
					</c:forEach>
				</select>
				<input type="submit" value="Add">
			</form>
		</c:when>
	</c:choose>
	<table>
		<thead>
			<tr>
				<th>Class Name</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${fn:length(student.classes) eq 0}">
					<tr>
						<td><c:out value="${student.name}" /> is currently not taking any classes.</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="course" items="${student.classes}">
						<tr>
							<td><a href="/classes/${course.id}"><c:out value="${course.name}" /></a></td>
							<td><a href="/students/${student.id}/drop/${course.id}">Drop</a></td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>