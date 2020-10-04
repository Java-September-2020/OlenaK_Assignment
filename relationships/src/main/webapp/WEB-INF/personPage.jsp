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
<h1>New Person</h1>
<form:form action="/" method="post" modelAttribute="person">
	<div>
	<form:label name="firstName">First Name</form:label>
	<form:errors name="firstName"/>
	<form:input name="firstName"/>
	</div>
	<div>
	<form:label name="lastName">Last Name</form:label>
	<form:errors name="lastName"/>
	<form:input name="lastName"/>
	</div>
	<input type="submit" value="Create"/>
</form:form>
</body>
</html>