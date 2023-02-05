<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>JSTL Capabilities</title>
</head>
<body>
	<h1>Dojo Locations</h1>
	<c:forEach var="oneDojo" items="${dojosFromMyController}">
		<p><c:out value="${oneDojo}" /></p>
	</c:forEach>
	
	<p>Random Stuff</p>
	<c:set var="now" value="<%= new java.util.Date() %>" />
	<p><fmt:formatDate type="date" value="${now}"/></p>
	<p><fmt:formatDate type="time" value="${now}" /></p>
	<p><fmt:formatDate pattern="EEEE, MMM dd, yyyy" value="${now}" /></p>
</body>
</html>