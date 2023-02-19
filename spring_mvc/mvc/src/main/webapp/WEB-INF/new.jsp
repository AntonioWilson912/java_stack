<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Title</title>
</head>
<body>
    <h1>New Book</h1>
    <form action="/books" method="post">
    	<div>
    		<label for="title">Title</label>
    		<input type="text" name="title">
    	</div>
    	<div>
    		<label for="description">Description</label>
    		<textarea name="description"></textarea>
    	</div>
    	<div>
    		<label for="language">Language</label>
    		<input type="text" name="language">
    	</div>
    	<div>
    		<label for="title">Page Count</label>
    		<input type="number" name="numberOfPages" min="1">
    	</div>
    </form>
</body>
</html>