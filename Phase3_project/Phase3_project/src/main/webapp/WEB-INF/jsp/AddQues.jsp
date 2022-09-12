<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="2">
<tr>
<th>Id</th>
<th>Name</th>  
<th>Designation</th>
<th>Salary</th>
</tr>
<c:forEach var="emp" items="${empList}">
<tr>
<td>${emp.Qid}</td>
<td>${emp.description}</td>
<td>${emp.answer}</td>
<td><a href="api/Quiz/${id}/${emp.eid}">Add</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>