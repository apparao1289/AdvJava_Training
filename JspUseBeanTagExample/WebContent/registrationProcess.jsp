<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="student" scope="session" class="com.test.bean.Student" />
	<jsp:setProperty name="student" property="name" param="name" />
	<jsp:setProperty property="age" name="student" param="age" />
	<jsp:setProperty property="address" name="student" param="address" />
	<jsp:setProperty property="stand" name="student" param="stand" />
	<a href="/JspUseBeanTagExample/view.jsp">Show My Details</a>
</body>
</html>