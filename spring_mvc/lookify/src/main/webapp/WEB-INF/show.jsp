<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Details</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container-fluid left">
    	<h1>Song Details</h1>
    	<div class="container-fluid left">
    		<p>Title: <c:out value="${song.title}"/></p>
    		<p>Artist: <c:out value="${song.artist}"/></p>
    		<p>Rating: <c:out value="${song.rating}"/></p>
    	</div>
    	<a href="/dashboard">Dashboard</a>
    </div>
</body>
</html>