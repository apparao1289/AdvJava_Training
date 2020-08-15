<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Your details are : <br>
<jsp:useBean id="student" scope="session" class="com.test.bean.Student"></jsp:useBean>
 Name : <jsp:getProperty property="name" name="student"/> <br>
 Age: <jsp:getProperty property="age" name="student"/> <br>
 Address: <jsp:getProperty property="address" name="student"/> <br>
 Stand: <jsp:getProperty property="stand" name="student"/>
</body>
</html>