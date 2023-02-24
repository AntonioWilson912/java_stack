<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Top Songs</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body class="bg-lavender">
    <div class="container-fluid">
    	<h1>Top Songs</h1>
    	<c:set var="songCount" value="${fn:length(top10Songs)}" />
    	<c:choose>
    	<c:when test="${songCount > 0}">
    		<c:forEach var="thisSong" items="${top10Songs}">
    			<p><c:out value="${thisSong.rating}"/> - <a href="/songs/${thisSong.id}"><c:out value="${thisSong.title}"/></a> - <c:out value="${thisSong.artist}"/></p>
    		</c:forEach>
    	</c:when>
    	<c:otherwise>
    		<p>There appears to be no songs of any sort in Lookify's records...</p>
    	</c:otherwise>
    	</c:choose>
    	
    	<a href="/dashboard">Dashboard</a>
    </div>
</body>
</html>