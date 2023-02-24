<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Search</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <div class="container">
    	<h1>Songs by: <c:out value="${artist}" /></h1>
    	<table class="table table-striped">
    		<thead>
    			<tr>
    				<th>Name</th>
    				<th>Rating</th>
    				<th>Actions</th>
    			</tr>
    		</thead>
    		<tbody>
    			<c:set var="songCount" value="${fn:length(songsByArtist)}" />
    			<c:if test="${songCount > 0}">
    				<c:forEach var="thisSong" items="${songsByArtist}">
    					<tr>
    						<td><a href="/songs/${thisSong.id}"><c:out value="${thisSong.title}"/></a></td>
    						<td><c:out value="${thisSong.rating}"/></td>
    						<td>
    							<form action="/songs/${thisSong.id}" method="post">
    								<input type="hidden" name="_method" value="delete">
    								<input type="submit" value="delete" class="link">
    							</form>
    						</td>
    					</tr>
    				</c:forEach>
    			</c:if>
    			<c:if test="${songCount == 0}">
    				<tr>
    					<td colspan="3">No songs by this artist.</td>
    				</tr>
    			</c:if>
    		</tbody>
    	</table>
    	<a href="/dashboard">Dashboard</a>
    </div>
</body>
</html>