<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
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
<c:set var = "empl" scope = "session" value = "${emp1}"/>
<tr>
<td>${empl.eid}</td>
<td>${empl.name}</td>
<td>${empl.designation}</td>
<td>${empl.salary}</td>
<td><a href="../editemp/${empl.eid}">Edit</a></td>

</tr>

</table>
</body>
</html>