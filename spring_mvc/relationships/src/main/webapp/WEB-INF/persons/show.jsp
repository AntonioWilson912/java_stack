<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Person Details</title>
</head>
<body>
    <h1>Person Details:</h1>
    <table>
    	<thead>
    		<tr>
    			<th>Name</th>
    			<th>License Number</th>
    			<th>State</th>
    			<th>Exp Date</th>
    		</tr>
    	</thead>
    	<tbody>
    		<tr>
    			<td><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></td>
    			<td><c:out value="${person.license.number}"/></td>
    			<td><c:out value="${person.license.state}"/></td>
    			<td><fmt:formatDate value="${person.license.expirationDate}"/></td>
    		</tr>
    	</tbody>
    </table>
</body>
</html>