<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Login & Registration</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div class="container">
		<h1 class="text-purple">Welcome!</h1>
		<p class="subtitle">Join our growing community.</p>
	</div>
	<div class="container-fluid">
		<div class="row">
			<div class="col">
				<h1>Register</h1>
				<form:form action="/register" method="post" modelAttribute="newUser" cssClass="form">
					<form:errors path="userName" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="userName" cssClass="col">User Name</form:label>
						<form:input path="userName" cssClass="col" />
					</div>
					<form:errors path="email" class="text-danger" />
					<div class="form-group">
						<form:label path="email" cssClass="col">Email</form:label>
						<form:input path="email" cssClass="col" />
					</div>
					<form:errors path="password" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="password" cssClass="col">Password</form:label>
						<form:input path="password" type="password" cssClass="col" />
					</div>
					<form:errors path="confirm" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="confirm" cssClass="col">Confirm PW:</form:label>
						<form:input path="confirm" cssClass="col" type="password" />
					</div>
					<div class="right">
						<input type="submit" value="Submit" class="btn">					
					</div>
				</form:form>
			</div>
			<div class="col">
				<h1>Log in</h1>
				<form:form action="/login" method="post" modelAttribute="newLogin" cssClass="form">
					<form:errors path="email" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="email" cssClass="col">Email</form:label>
						<form:input path="email" cssClass="col"/>
					</div>
					<form:errors path="password" cssClass="text-danger" />
					<div class="form-group">
						<form:label path="password" cssClass="col">Password</form:label>
						<form:input path="password" cssClass="col" type="password" />
					</div>
					<div class="right">
						<input type="submit" value="Submit" class="btn">					
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>