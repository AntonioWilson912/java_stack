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
    	<div class="row align-center justify-between">
    		<h1>Edit Burger</h1>
    		<a href="/">Go back</a>
    	</div>
    	<form:form action="/burgers/${burger.id}" method="post" modelAttribute="burger">
    		<input type="hidden" name="_method" value="put">
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
    			<input type="submit" class="btn btn-blue" value="Submit">
    		</div>
    	</form:form>
    </div>
</body>
</html>