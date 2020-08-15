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
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String address= request.getParameter("address");
		
		session.setAttribute("name",name);
		session.setAttribute("age",age);
		session.setAttribute("address",address);
		String url = "/JspSessionTrackingExample/confirmation.jsp";
		out.println("<a href="+url+">View Details</a>");
	%>
</body>
</html>