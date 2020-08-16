<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/WEB-INF/mytag.tld" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	This is example of custom tag with body content. <br>
	<mytag:caps>
	  Welcome to client
	</mytag:caps>
	<br>
	Printing content after the custom tag
</body>
</html>