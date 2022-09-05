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
<c:forEach var="ques" items="${queslist}">
<h3>${ques.question_statement}</h3>
<br/>
<h4>${ques.option1}</h4>
<br/>
<h4>${ques.option2}</h4>
<br/>
<h4>${ques.option3}</h4>
<br/>
<h4>${ques.option4}</h4>
<br/>
<form action="/check">
Enter Your Answer:
<input type="text" name="ans">
<input type="hidden" value=${ques.questionId} name="cqid">
<input type="submit">
</form>
<br/><br/>
</c:forEach>
</body>
</html>