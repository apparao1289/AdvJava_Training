package com.test.servlet.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<form action=\"/HiddenFormFields/confirmation\">");
		out.println("<input type=\"hidden\" name=\"fname\" value="+firstName+">");
		out.println("<input type=\"hidden\" name=\"lname\" value="+lastName+">");
		out.println("Enter your Age:");
		out.println("<input type=\"text\" name=\"age\" id=\"age\">");
		out.println("<br>");
		out.println("Enter your Address:");
		out.println("<input type=\"text\" name=\"address\" id=\"address\">");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
	}

}
