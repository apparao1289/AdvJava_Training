<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ page import="com.test.business.StudentBusiness" %>
<%@ page import="com.test.business.StudentBusinessImpl" %>
<jsp:useBean id="student" class="com.test.model.Student"></jsp:useBean>
<jsp:setProperty property="*" name="student"/>
<%
	StudentBusiness studentBusiness = new StudentBusinessImpl();
   try {
	    boolean status = studentBusiness.createStudent(student);
	    if(status) {
	    	response.sendRedirect("success.jsp");
	    } else {
	    	response.sendRedirect("error.jsp");
	    }
   }catch(Exception e ) {
	   response.sendRedirect("error.jsp");
   }
%>
</body>
</html>