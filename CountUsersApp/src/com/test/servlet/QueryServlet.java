package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QueryServlet
 */
@WebServlet("/postQuery")
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30);
		out.println("<html>");
		out.println("<body>");
		out.println("We are received your query. Thanks for submitting the query.");
		out.println("<br>");
		out.println("Your query is :"+request.getParameter("query"));
		out.println("<br>");
		out.println("<b> Number of active users:"+UserCountListener.getNumberOfUsersOnline()+"</b>");
		out.println("</body>");
		out.println("</html>");
	}

}
