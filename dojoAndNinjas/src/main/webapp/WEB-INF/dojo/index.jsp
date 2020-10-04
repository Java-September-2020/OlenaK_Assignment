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
		<h3><a href="/ninjas">Ninjas</a></h3>
		<a href="/dojos/new">Add Dojo</a>
		<hr />
		<h2>All Dojos</h2>
		<ul>
		<c:forEach items="${ dojos }" var="dojo">
			<li><a href="/dojos/${ dojo.id }">${ dojo.name }</a></li>
		</c:forEach>
		</ul>	
</body>
</html>