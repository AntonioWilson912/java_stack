<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Omikuji Form</title>
	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1>Send an Omikuji!</h1>
		<form class="form" action="/omikuji/process" method="post">
			<div class="form-group">
				<label for="number">Pick any number from 5 to 25</label>
				<input type="number" name="number" min="5" max="25" value="5">
			</div>
			<div class="form-group">
				<label for="city">Enter the name of any city</label>
				<input type="text" name="city">
			</div>
			<div class="form-group">
				<label for="person">Enter the name of any real person</label>
				<input type="text" name="person">
			</div>
			<div class="form-group">
				<label for="hobby">Enter professional endeavor or hobby</label>
				<input type="text" name="hobby">
			</div>
			<div class="form-group">
				<label for="livingThing">Enter any type of living thing</label>
				<input type="text" name="livingThing">
			</div>
			<div class="form-group">
				<label for="niceMessage">Say something nice to someone</label>
				<textarea name="niceMessage"></textarea>
			</div>
			<p><em>Send and show a friend</em>
			<div class="container-right">
				<input type="submit" class="btn" value="Send">
			</div>
		</form>
	</div>
</body>
</html>