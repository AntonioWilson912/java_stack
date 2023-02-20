<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Save Travels</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    	<h1 class="text-blue">Save Travels</h1>
    	<table class="table table-striped">
    		<thead>
    			<tr>
    				<th>Expense</th>
    				<th>Vendor</th>
    				<th>Amount</th>
    				<th>Actions</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:set var="expenseCount" value="${fn:length(expenses)}"/>
    			<c:if test="${expenseCount > 0}">
    				<c:forEach var="thisExpense" items="${expenses}">
    					<tr>
    						<td><a href="/expenses/${thisExpense.id}"><c:out value="${thisExpense.name}" /></a></td>
    						<td><c:out value="${thisExpense.vendor}" /></td>
    						<td>
    							<fmt:setLocale value="en_US" />
    							<fmt:formatNumber value="${thisExpense.amount}" type="currency"/>
    						</td>
    						<td class="row align-center">
    							<a href="/expenses/edit/${thisExpense.id}">edit</a>
    							<form action="/expenses/${thisExpense.id}" method="post">
    								<input type="hidden" name="_method" value="delete">
    								<input type="submit" value="delete" class="btn btn-danger">
    							</form>
    						</td>
    					</tr>
    				</c:forEach>
    			</c:if>
    			<c:if test="${expenseCount == 0}">
    				<tr>
    					<td colspan="4">You currently have no expenses.</td>
    				</tr>
    			</c:if>
    		</tbody>
    	</table>
    	
    	<h2 class="text-blue">Add an expense:</h2>
    	<form:form action="/expenses" method="post" modelAttribute="expense" class="form">
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
    			<form:input path="amount" class="col" type="number" step="0.01" />
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