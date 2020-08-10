package com.test.servlet;

import java.io.IOException;
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
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// invoke the DB and do the registration process.
		String firstName = request.getParameter("fname");
		System.out.println("First name:"+firstName);
		if(firstName.endsWith("rao")) {
			response.sendRedirect("confirmation"); //SendReDirectExample/confirmation
		} else{
			response.sendRedirect("/SendReDirectExample/index.html");  //SendReDirectExample/index.html
		}
		
	}

}
