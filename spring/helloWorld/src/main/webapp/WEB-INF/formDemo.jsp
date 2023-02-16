<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Demo JSP Form</title>
	<style type="text/css">
	body {
		background-color: black;
		color: white;
	}
	
	.error {
		color: red;
	}
	</style>
</head>
<body>
	<form method="post" action="/login">
		<p class="error">
			<c:out value="${emailError}" />
		</p>
		<label>Email:</label>
		<input type="email" name="email" placeholder="someone@example.com">
		<p class="error">
			<c:out value="${passwordError}" />
		</p>
		<label>Password:</label>
		<input type="password" name="password">
		<input type="submit" value="Login">
	</form>
</body>
</html>