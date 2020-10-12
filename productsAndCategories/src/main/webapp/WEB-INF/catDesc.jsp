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
<h1><c:out value="${category.name}"/></h1>
<h4>Products:</h4>
<table>
<c:forEach items="${category.products}" var="product" >
		<div>
			<p>- <c:out value="${product.name}"/></p>
		</div>
</c:forEach>
</table>
<form:form method="post" action="/categories/${category.id}" modelAttribute="category">
 	     <form:select path="products" multiple="false">  
 	    	 <c:forEach items="${products }" var="product">
				<option value="${product.id }">${product.name }</option>
			 </c:forEach>
        </form:select>  
        <input type="submit" value="Add"/>
</form:form>
</body>
</html>