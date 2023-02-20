<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Expense</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    	<div class="row justify-between align-center">
    		<h1 class="text-green">Edit Expense</h1>
    		<a href="/expenses">Go back</a>
    	</div>
    	<form:form action="/expenses/${expense.id}" method="post" modelAttribute="expense">
    		<input type="hidden" name="_method" value="put">
    		<form:errors path="name" class="text-danger" />
    		<div class="row">
    			<form:label path="name" class="col">Expense Name:</form:label>
    			<form:input path="name" class="col" />
    		</div>
    		<form:errors path="vendor" class="text-danger" />
    		<div class="row">
    			<form:label path="vendor" class="col">Vendor Name:</form:label>
    			<form:input path="vendor" class="col" />
    		</div>
    		<form:errors path="amount" class="text-danger" />
    		<div class="row">
    			<form:label path="amount" class="col">Amount:</form:label>
    			<form:input path="amount" class="col" type="number" step="0.01"/>
    		</div>
    		<form:errors path="description" class="text-danger" />
    		<div class="row">
    			<form:label path="description" class="col">Description:</form:label>
    			<form:textarea path="description" class="col" />
    		</div>
    		<div class="right">
    			<input type="submit" value="Submit" class="btn btn-blue">
    		</div>
    	</form:form>
    </div>
</body>
</html>