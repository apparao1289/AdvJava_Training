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
 	int number1 = Integer.parseInt(request.getParameter("num1"));
    int number2 = Integer.parseInt(request.getParameter("num2"));
    int result = number1 + number2;
    request.setAttribute("result", result);
    RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
    rd.forward(request, response);
 %>
</body>
</html>