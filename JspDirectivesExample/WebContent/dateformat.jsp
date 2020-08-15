<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%
	Date d = new Date();  
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    String date = sdf.format(d);
    out.println("Current date is:"+date);
%>
</body>
</html>