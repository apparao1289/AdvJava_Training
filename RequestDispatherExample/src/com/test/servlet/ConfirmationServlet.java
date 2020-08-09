package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConfirmationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Registration pricess is progress");
		PrintWriter out = response.getWriter();
		out.println("Your resgistration is sucessful and beloware the information for future reference.");
		out.println("Name:" + request.getParameter("fname") + " " + request.getParameter("lname"));
		out.println("Age:" + request.getParameter("age"));
		out.println("Address:" + request.getParameter("address"));
		out.println("Reference Number" + new Random().nextInt());
	}

}
