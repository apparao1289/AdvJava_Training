package com.test.servlet.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String name = request.getParameter("fname") +" "+request.getParameter("lname");
		String age = request.getParameter("age");
		String address= request.getParameter("address");
		
		// Get the session object.
		HttpSession session = request.getSession(true);
		
		// set the attributes.
		session.setAttribute("name", name);
		session.setAttribute("age", age);
		session.setAttribute("address", address);
		//session.setMaxInactiveInterval(60);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Thanks for registration.");
		out.println("<br>");
		String url = "/HttpSessionExample/view";
		out.println("<a href ="+url+">View Your Information</a>");
		
	}

}
