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
<h1><c:out value="${product.name}"/></h1>
<h4>Categories:</h4>
<table>
<c:forEach items="${product.categories}" var="category" >
		<div>
			<p>- <c:out value="${category.name}"/></p>
		</div>
</c:forEach>
</table>
<p>Add Category</p>
<form:form method="post" action="/products/${product.id}" modelAttribute="product">
 	     <form:select path="categories" multiple="false">  
 	    	 <c:forEach items="${categories }" var="category">
				<option value="${ category.id }">${ category.name }</option>
			 </c:forEach>
        </form:select>  
        <input type="submit" value="Add"/>
</form:form>
</body>
</html>