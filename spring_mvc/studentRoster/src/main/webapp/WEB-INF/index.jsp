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
    <title>Dorms</title>
    <style type="text/css">
    	input[type=submit] {
    		background-color: transparent;
    		border: none;
    		color: #3485D6;
    		cursor: pointer;
    		text-decoration: underline;
    	}
    </style>
</head>
<body>
    <h1>Dorms</h1>
    <p><a href="/dorms/new">Add a new dorm</a></p>
    <p><a href="/students/new">Add a new student</a></p>
    <table>
    	<thead>
    		<tr>
    			<th>Dorm</th>
    			<th>Action</th>
    		</tr>
    	</thead>
    	<tbody>
    		<c:set var="dormCount" value="${fn:length(dorms)}" />
    		<c:choose>
    			<c:when test="${dormCount > 0}">
    				<c:forEach var="thisDorm" items="${dorms}">
    					<tr>
    						<form:form action="/dorms/${thisDorm.id}" method="post">
    							<input type="hidden" name="_method" value="delete">
    							<td><c:out value="${thisDorm.name}" /></td>
    							<td><a href="/dorms/${thisDorm.id}">See Students</a> | <input type="submit" value="Delete"></td>
    						</form:form>
    					</tr>
    				</c:forEach>
    			</c:when>
    			<c:otherwise>
    				<tr>
    					<td colspan="2">No dorms exist at this time.</td>
    				</tr>
    			</c:otherwise>
    		</c:choose>
    	</tbody>
    </table>
</body>
</html>