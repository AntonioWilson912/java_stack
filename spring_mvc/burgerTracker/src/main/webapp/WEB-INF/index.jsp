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
    <title>Burger Tracker</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    	<h1>Burger Tracker</h1>
    	<table class="table table-striped">
    		<thead>
    			<tr>
    				<th>Burger Name</th>
    				<th>Restaurant Name</th>
    				<th>Rating (out of 5)</th>
    				<th>Action</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:set var="burgerCount" value="${fn:length(burgers)}"/>
    			<c:if test="${burgerCount > 0 }">
    				<c:forEach var="thisBurger" items="${burgers}">
    					<tr>
    						<td><c:out value="${thisBurger.burgerName}" /></td>
    						<td><c:out value="${thisBurger.restaurantName}" /></td>
    						<td><c:out value="${thisBurger.rating}" /></td>
    						<td><a href="/burgers/edit/${thisBurger.id}">edit</a></td>
    					</tr>
    				</c:forEach>
    			</c:if>
    			<c:if test="${burgerCount == 0}">
    				<tr>
    					<td colspan="3" class="text-center">There are no available burgers.</td>
    				</tr>
    			</c:if>
    		</tbody>
    	</table>
    	<h2>Add a Burger:</h2>
    	<form:form action="/" method="post" modelAttribute="burger">
    		<form:errors path="burgerName" class="block text-danger"/>
    		<form:errors path="restaurantName" class="block text-danger" />
    		<form:errors path="rating" class="block text-danger" />
    		<form:errors path="notes" class="block text-danger" />
    		<div class="row">
    			<form:label path="burgerName" class="col">Burger Name</form:label>
    			<form:input path="burgerName" class="col-3" type="text" />
    		</div>
    		<div class="row">
    			<form:label path="restaurantName" class="col">Restaurant Name</form:label>
    			<form:input path="restaurantName" class="col-3" type="text" />
    		</div>
    		<div class="row">
    			<form:label path="rating" class="col">Rating</form:label>
    			<form:input path="rating" class="col-3" type="number" />
    		</div>
    		<div class="row">
    			<form:label path="notes" class="col">Notes</form:label>
    			<form:textarea path="notes" class="col-3" />
    		</div>
    		<div class="right">
    			<input type="submit" value="Submit" class="btn btn-blue" >
    		</div>
    	</form:form>
    </div>
</body>
</html>