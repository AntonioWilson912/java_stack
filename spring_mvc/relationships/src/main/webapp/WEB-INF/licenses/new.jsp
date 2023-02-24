<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>New License</title>
</head>
<body>
    <h1>New License</h1>
    <form:form action="/licenses" method="post" modelAttribute="license">
    	<form:label path="person">Person:</form:label>
    	<form:select path="person">
    		<c:forEach var="onePerson" items="${persons}">
    			<form:option value="${onePerson.id}" path="person">
    				<c:out value="${onePerson.firstName}"/> <c:out value="${onePerson.lastName}"/>
    			</form:option>
    		</c:forEach>
    	</form:select>
    	<form:label path="number">Number:</form:label>
    	<form:input path="number"/>
    	<form:label path="state">State:</form:label>
    	<form:input path="state"/>
    	<form:errors path="expirationDate"/>
    	<form:label path="expirationDate">Expiration Date:</form:label>
    	<form:input path="expirationDate" type="date"/>
    	<input type="submit" value="Create">
    </form:form>
</body>
</html>