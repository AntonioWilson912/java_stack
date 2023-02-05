<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hello World</title>
	<!-- for Bootstrap CSS -->
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" type="text/css" href="/css/style.css">
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
	
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="jumbotron">Hello</div>
	<h1 class="blockquote">Hello World!</h1>
	
	<% for (int i = 0; i < 5; i++) { %>
		<h1><%= i %></h1>
	<% } %>
	
	<h3>The time is <%= new Date() %></h3>
	
	
	<h1>Fruit of the Day:</h1>
	<p><c:out value="${fruit}" /></p>
	
	<h1>Special Concoction:</h1>
	<p><c:out value="${special}" /></p>
	
	<h1>Fruit Instance Test:</h1>
	<p>
		<c:out value="${objFruit}"/>
	</p>
</body>
</html>