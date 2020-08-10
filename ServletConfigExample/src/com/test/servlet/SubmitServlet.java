package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletConfig config = getServletConfig();
		String value= config.getInitParameter("name");
		String query = request.getParameter("query");
		System.out.println("query:"+query);
		System.out.println("value:"+value);
		PrintWriter out =response.getWriter();
		out.println("Thanks for submitting the query "+value);
	}

}
