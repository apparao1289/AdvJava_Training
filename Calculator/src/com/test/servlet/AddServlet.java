package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
		
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int result = number1 + number2;
		System.out.println("result:" + result);
		
		//System.out.println("result:" +getRequestParameterMap(request));
		PrintWriter pw = response.getWriter();
		pw.println("Addition of two number is : "+result);
	}

	private int getRequestParameterMap(ServletRequest request) {
		
		Map<String,String[]> parameterMap = request.getParameterMap();
		String [] value1 = parameterMap.get("num1");
		int number1 = Integer.parseInt(value1[0]);
		String [] value2 = parameterMap.get("num2");
		int number2 = Integer.parseInt(value2[0]);
		
		int result = number1 + number2;
		System.out.println("result:" + result);
		return result;
	}

	public void destroy() {
		System.out.println("Invoking destroy method..");
	}

}
