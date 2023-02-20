<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Show Expense</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    	<div class="row align-center justify-between">
    		<h1 class="text-blue">Expense Details</h1>
    		<a href="/expenses">Go back</a>
    	</div>
    	<div class="row">
    		<div class="col">Expense Name:</div>
    		<div class="col"><c:out value="${expense.name}" /></div>
    	</div>
    	<div class="row">
    		<div class="col">Expense Description:</div>
    		<div class="col"><c:out value="${expense.description}" /></div>
    	</div>
    	<div class="row">
    		<div class="col">Vendor:</div>
    		<div class="col"><c:out value="${expense.vendor}" /></div>
    	</div>
    	<div class="row">
    		<div class="col">Amount Spent:</div>
    		<div class="col">
    			<fmt:setLocale value="en_US" />
    			<fmt:formatNumber type="currency" value="${expense.amount}" />
    		</div>
    	</div>
    </div>
</body>
</html>