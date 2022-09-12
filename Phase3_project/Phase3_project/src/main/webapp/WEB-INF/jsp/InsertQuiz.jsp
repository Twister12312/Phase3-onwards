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
<h2>Add a new quiz on this page</h2>
 <fm:form method="post" action="api/Quiz" modelAttribute="quiz">  
      	<table >
       
         <tr>  
          <td>Name : </td> 
          <td><fm:input path="name"  /></td>
         </tr>  
  
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </fm:form>  
</body>
</html>