<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>What Is Your Question?</h1>
<form:form action="/question" method="post" modelAttribute="question">
        <form:label path="question">Question</form:label>
        <form:errors path="question"/>
        <form:input path="question"/>

        <form:label path="subject">Tags</form:label>
        <form:errors path="subject"/>
        <form:input path="subject"/>
        <input type="submit" value="Careate"/>
</form:form>
</body>
</html>