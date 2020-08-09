package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Registration process is stating..");
		String ageStr = request.getParameter("age");
		int age = Integer.parseInt(ageStr);
		if (age >= 18) {
			RequestDispatcher rd = request.getRequestDispatcher("confirmation");
			//rd.forward(request, response);
			rd.include(request, response);

		} else {
			PrintWriter out = response.getWriter();
			out.println("You are not eligible for vote card because your age is less than 18 years.. ");
		}
		PrintWriter out = response.getWriter();
		out.println("Keep Registration number for future purpose.");
		System.out.println("Registration process is completed.");
	}
}
