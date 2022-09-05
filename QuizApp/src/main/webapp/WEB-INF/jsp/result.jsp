<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Results:</h2>
<table border="2">
<tr>
<th>Username</th>
<th>Quizname</th>  
<th>Score</th>
</tr>
<c:forEach var="result" items="${results}">
<tr>
<td>${result.username}</td>
<td>${result.quizname}</td>
<td>${result.score}</td>
</tr>
</c:forEach>
</table>
</body>
</html>