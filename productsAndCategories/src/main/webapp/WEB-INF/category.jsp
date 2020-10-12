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
<h1>New Category</h1>
<form:form action="/categories/new" modelAttribute="category" method="post">
	<form:label path="name"></form:label>
	<form:input path="name"/>
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>