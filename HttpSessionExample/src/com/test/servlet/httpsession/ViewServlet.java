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
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// get session information.
		HttpSession session = request.getSession(false);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Your Information :");
		out.println("<br>");
		out.println("Name:"+session.getAttribute("name"));
		out.println("<br>");
		out.println("Age:"+session.getAttribute("age"));
		out.println("<br>");
		out.println("Address:"+session.getAttribute("address"));
		
	}

}
