<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold Game</title>
	<link rel="stylesheet" type="text/css" href="/style.css">
</head>
<body>
	<div class="container">
		<div class="row start">
			<p>Your Gold: <span id="gold"><c:out value="${gold}"/></span> <a href="/reset" class="btn btn-reset">Reset</a></p>
		</div>
		<div class="row">
			<form class="col" action="/process" method="post">
				<h2>Farm</h2>
				<p>(earns 10-20 gold)</p>
				<input type="hidden" name="location" value="farm" >
				<input type="submit" class="btn btn-gold" value="Find Gold!" >
			</form>
			<form class="col" action="/process" method="post">
				<h2>Cave</h2>
				<p>(earns 5-10 gold)</p>
				<input type="hidden" name="location" value="cave" >
				<input type="submit" class="btn btn-gold" value="Find Gold!" >
			</form>
			<form class="col" action="/process" method="post">
				<h2>House</h2>
				<p>(earns 2-5 gold)</p>
				<input type="hidden" name="location" value="house" >
				<input type="submit" class="btn btn-gold" value="Find Gold!" >
			</form>
			<form class="col" action="/process" method="post">
				<h2>Quest</h2>
				<p>(earns/takes 0-50 gold)</p>
				<input type="hidden" name="location" value="quest" >
				<input type="submit" class="btn btn-gold" value="Find Gold!" >
			</form>
			<form class="col" action="/process" method="post">
				<h2>Spa</h2>
				<p>(earns/takes ? gold)</p>
				<input type="hidden" name="location" value="spa" >
				<input type="submit" class="btn btn-gold" value="Find Gold!" >
			</form>
		</div>
		<div class="row start">
			<h3>Activities:</h3>
		</div>
		<ul id="activity-log">
			<c:set var="activityLogLength" value="${fn:length(activityLog)}" />
			<c:if test="${activityLogLength > 0}">
				<c:forEach var="activity" items="${activityLog}">
					<li class="${activity.textClass}"><c:out value="${activity}" /></li>
				</c:forEach>
			</c:if>
			<c:if test="${activityLogLength == 0}">
				<li>No activity has been recorded at this time.</li>
			</c:if>
		</ul>
	</div>
</body>
</html>