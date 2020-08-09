package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubstractionServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int result = number1 - number2;
		System.out.println("result::" + result);
		PrintWriter out = response.getWriter();
		out.println("Substraction of two integer number is::" + result);
		printReuestInformation(request);
		
	}

	private void printReuestInformation(HttpServletRequest request) {
		System.out.println("server name:"+request.getServerName());
		System.out.println("server port:"+request.getServerPort());
		System.out.println("servlet path::"+request.getServletPath());
		System.out.println("remote address::"+request.getRemoteAddr());
		
		System.out.println("Context path::"+request.getContextPath());
		System.out.println("query string::"+request.getQueryString());
		
	}
}
