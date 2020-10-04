<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Dojos and Ninjas</h1>
		<h3><a href="/dojos">Dojos</a></h3>
		<a href="/ninjas/new">Add Ninja</a>
		<hr />
		<h2>All Ninjas</h2>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Age</th>
					<th>Dojo</th>	
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${ ninjas }" var="ninja">
				<tr>
					<td>${ ninja.firstName } ${ ninja.lastName }</td>
					<td>${ ninja.age }</td>
					<td>${ ninja.dojo.name }</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
</body>
</html>