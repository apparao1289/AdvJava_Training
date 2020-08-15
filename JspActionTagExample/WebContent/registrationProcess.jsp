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
	int age = Integer.parseInt(request.getParameter("age"));
    if(age>18) {
%>
<jsp:include page="confirmation.jsp">
	<jsp:param name="message" value="Thanks for registration" />
</jsp:include>
<%
    } else {
    	
%>
<jsp:include page="error.jsp">
	<jsp:param name="message" value="Your are not eligible for fashion show because you age is less than 18." />
</jsp:include>
<%
    }
%>

</body>
</html>