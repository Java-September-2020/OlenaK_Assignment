<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>New Product</h1>
<form:form action="/products/new" modelAttribute="product" method="post">
	<form:label path="name">Name:</form:label>
	<form:input path="name"/>
	<form:label path="description">Description:</form:label>
	<form:input path="description"/>
	<form:label path="price">Price:</form:label>
	<form:input path="price"/>
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>