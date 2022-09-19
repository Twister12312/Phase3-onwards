<html>
<body>
<h2>Ecommerce-page</h2>
<form>
Enter Id:<input type="text" name="User" required> 
<input type="submit">
</form>
<%
String us=request.getParameter("User");
if(us!=null){
	try{int user = Integer.parseInt(us);
	session.setAttribute("Id",user);
	getServletContext().getRequestDispatcher("/index2.jsp").forward(request,response);
	}
	catch(Exception e){
		out.println("Please try again");
		
	}
	
}

%>
<br>
<br>
<a href="viewemp"> show records</a>
<a href="empform"> Add New Record</a>
</body>
</html>
</body>
</html>
