package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubstractionServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext ctxt = getServletContext();
		String isComplexNumber = ctxt.getInitParameter("isComplexNumber");
		if (isComplexNumber.equalsIgnoreCase("false")) {
			int number1 = Integer.parseInt(request.getParameter("num1"));
			int number2 = Integer.parseInt(request.getParameter("num2"));
			int result = number1 - number2;
			System.out.println("result::" + result);
			out.println("Substraction of two number is :" + result);
		} else {
			out.println("We are not supporting complex number substraction");
		}
	}

}
