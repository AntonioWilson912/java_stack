<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title><c:out value="${dorm.name}"/></title>
</head>
<body>
    <h1><c:out value="${dorm.name}"/> Students</h1>
    <p><a href="/">Dashboard</a></p>
    <table>
    	<form:form action="/dorms/${dorm.id}" method="post">
    		<input type="hidden" name="_method" value="put">
    		<tr>
    			<td>
    				<p>Students:</p>
    				<select name="addStudent">
    					<c:forEach var="thisStudent" items="${students}">
    						<option value="${thisStudent.id}"><c:out value="${thisStudent.name}"/>(<c:out value="${thisStudent.dorm.name}"/>)</option>
    					</c:forEach>
    				</select>
    			</td>
    			<td><input type="submit" value="Add"></td>
    		</tr>
    	</form:form>
    </table>
    <table>
    	<thead>
    		<tr>
    			<th>Student</th>
    			<th>Action</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:set var="studentCount" value="${fn:length(dorm.students)}"/>
    		<c:if test="${studentCount > 0}">
    			<c:forEach var="student" items="${dorm.students}">
    				<tr>
    					<form:form action="/students/${student.id}" method="post">
    						<input type="hidden" name="_method" value="delete">
    						<td><c:out value="${student.name}"/></td>
    						<td><input type="submit" value="Remove"></td>
    					</form:form>
    				</tr>
    			</c:forEach>
    		</c:if>
    		<c:if test="${studentCount == 0}">
    			<tr>
    				<td>No students live in this dorm.</td>
    			</tr>
    		</c:if>
    	</tbody>
    </table>
</body>
</html>