package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext ctxt = getServletContext();
		String isComplexNumber = ctxt.getInitParameter("isComplexNumber");
		if (isComplexNumber.equalsIgnoreCase("false")) {
			int number1 = Integer.parseInt(request.getParameter("num1"));
			int number2 = Integer.parseInt(request.getParameter("num2"));
			int result = number1 + number2;
			System.out.println("result::" + result);
			out.println("Addition of two number is :" + result);
			
			StringBuilder url = new StringBuilder("/ServletContextExample/sub?"); 
			url.append("num1=").append(number1).append("&").append("num2=").append(number2);
			String finalUrl = url.toString();
			System.out.println("finalUrl:"+finalUrl);
			
			out.println("<br>");
			out.println("<a href="+finalUrl+">Substraction of two number click here</a>");
		} else {
			out.println("We are not supporting complex number addition");
		}

	}

}
