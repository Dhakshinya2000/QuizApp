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
<h2>Quizzes Available:</h2>
<br/><br/>
<c:forEach var="quiz" items="${qlist}">
<h3>${quiz.quizId} - ${quiz.quizname}</h3>
<br/>
</c:forEach>
<form action = "/quizchoice">
<h3>Enter QuizID to Start Quiz:</h3>
<input type="text" name="qchoice">
<br/><br/>
<input type="submit" value="Start Quiz">
</form>
</body>
</html>