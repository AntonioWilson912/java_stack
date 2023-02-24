<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Song</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container left">
    	<h1>Add Song</h1>
    	<form:form action="/dashboard" method="post" modelAttribute="song">
    		<div class="row left">
    			<form:errors path="title" class="text-danger" />
    		</div>
    		<div class="row">
    			<form:label path="title" class="col">Title</form:label>
    			<form:input path="title" class="col-3" />
    		</div>
    		<div class="row left">
    			<form:errors path="artist" class="text-danger" />
    		</div>
    		<div class="row">
    			<form:label path="artist" class="col">Artist</form:label>
    			<form:input path="artist" class="col-3" />
    		</div>
    		<div class="row left">
    			<form:errors path="rating" class="text-danger" />
    		</div>
    		<div class="row">
    			<form:label path="rating" class="col">Rating</form:label>
    			<form:input path="rating" class="col-3" type="number" />
    		</div>
    		<div class="right">
    			<input type="submit" value="Add" class="btn btn-blue">
    		</div>
    	</form:form>
    	<div class="row left">
    		<a href="/dashboard">Dashboard</a>
    	</div>
    </div>
</body>
</html>