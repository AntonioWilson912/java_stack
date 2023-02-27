<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New Player</title>
</head>
<body>
    <h1>New Player</h1>
    <form:form action="/players/new" method="post" modelAttribute="player">
    	<div>
    		<form:label path="firstName">First Name:</form:label>
    		<form:input path="firstName" />
    	</div>
    	<div>
    		<form:label path="lastName">Last Name:</form:label>
    		<form:input path="lastName" />
    	</div>
    	<div>
    		<form:label path="age">Age:</form:label>
    		<form:input path="age" type="number" />
    	</div>
    	<div>
    		<form:label path="position">Position:</form:label>
    		<form:input path="position" />
    	</div>
    	<div>
    		<form:label path="team">Team:</form:label>
    		<form:select path="team">
    			<c:forEach var="team" items="${teams}">
    				<option value="${team.id}"><c:out value="${team.name}"/></option>
    			</c:forEach>
    		</form:select>
    	</div>
    	<input type="submit" value="Create">
    </form:form>
</body>
</html>