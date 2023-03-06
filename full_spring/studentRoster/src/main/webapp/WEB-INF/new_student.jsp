<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Student</title>
</head>
<body>    
    <h1>New Student</h1>
    <p><a href="/">Dashboard</a></p>
    <form:form action="/students/new" method="post" modelAttribute="student">
    	<table>
    		<tr>
    			<td><form:label path="name">Name:</form:label>
    			<td><form:input path="name" /></td>
    		</tr>
    		<tr>
    			<td><form:label path="dorm">Select Dorm:</form:label></td>
    			<td>
    				<form:select path="dorm">
    					<c:forEach var="dorm" items="${dorms}">
    						<option value="${dorm.id}"><c:out value="${dorm.name}"/></option>
    					</c:forEach>
    				</form:select>
    			</td>
    		</tr>
    		<tr>
    			<td colspan="2"><input type="submit" value="Add"></td>
    		</tr>
    	</table>
    </form:form>
</body>
</html>