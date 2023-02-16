<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold Game - Prison</title>
	<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
	<div class="container">
		<div class="row start">
			<p>Your Gold: <span id="gold"><c:out value="${gold}"/></span> <a href="/reset" class="btn btn-reset">Reset</a></p>
		</div>
		<div class="row start">
			<h1>Unfortunately, you became too indebted and have been sent to debtor's prison! You lose!</h1>
		</div>
	</div>
</body>
</html>