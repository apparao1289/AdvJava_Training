package com.test.servlet.hiddenfields;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ConfirmationServlet
 */
@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Your information is :");
		out.println("<br>");
		System.out.println("name:"+request.getParameter("fname"));
		out.println("Name:"+request.getParameter("fname") +" "+request.getParameter("lname"));
		out.println("<br>");
		out.println("Age:"+request.getParameter("age"));
		out.println("<br>");
		out.println("Address:"+request.getParameter("address"));
		out.println("</body>");
		out.println("</html>");
	}

}
