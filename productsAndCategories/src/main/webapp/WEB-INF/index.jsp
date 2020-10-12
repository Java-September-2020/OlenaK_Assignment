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
<table border="1">
	<thead>
		<tr>
			<td>Id</td>
			<td>Name</td>
			<td>Description</td>
			<td>Price</td>
		</tr>
	</thead>
	<c:forEach items="${products}" var="product" >
		<tr>
			<td><c:out value="${product.id}"/></td>
			<td><c:out value="${product.name}"/></td>
			<td><c:out value="${product.description}"/></td>
			<td><c:out value="${product.price}"/></td>
		</tr>
	</c:forEach>
</table>
<table>
	<thead>
		<tr>
			<td>Category id</td>
			<td>Category name</td>
		</tr>
	</thead>
	<c:forEach items="${categories}" var="category">
				<tr>
					<td><c:out value="${category.id}"/></td>
					<td><c:out value="${category.name}"/></td>
				</tr>
			</c:forEach>
</table>
<h1><a href="products/1">show</a></h1>
<br>
<a href="/categories/new">add cat</a>
<a href="/products/new">add prod</a>
</body>
</html>