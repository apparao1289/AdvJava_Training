<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		String name = (String)session.getAttribute("name");
   		String age = (String)session.getAttribute("age");
   		String address = (String)session.getAttribute("address");
	    out.println("Thanks for registration.");
		out.println("Your details are:");
		out.println("<br>");
		out.println("Name:"+name);
		out.println("<br>");
		out.println("Age:"+age);
		out.println("<br>");
		out.println("Address:"+address);
		
		%>
</body>
</html>