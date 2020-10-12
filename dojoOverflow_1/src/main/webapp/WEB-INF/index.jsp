<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Questions Dashboard</h1>
<table>
	<thead>
		<tr>
			<th>Questions</th>
			<th>Tags</th>
		</tr>
	</thead>
	<tbody>	
		<c:forEach items="${allQuestions}" var="question">
			<tr>
				<td><a href="/questions/${question.id}">${question.question }</a></td>
				<td>
					<c:choose>
						<c:when test="${tag.subject != null}">
						${tag.subject}
						</c:when>
						<c:otherwise>
						Does Not Have Tag
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</c:forEach>			
		</tbody>
	</table>
<a href="/questions/new">New Question</a>
</body>
</html>