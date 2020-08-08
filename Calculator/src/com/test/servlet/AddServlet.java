package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AddServlet extends GenericServlet {

	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method invoked..");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Invoking the service method..");
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int result = number1 + number2;
		System.out.println("result:" + result);
		
		PrintWriter pw = response.getWriter();
		pw.println("Addition of two number is : "+result);
	}

	public void destroy() {
		System.out.println("Invoking destroy method..");
	}

}
