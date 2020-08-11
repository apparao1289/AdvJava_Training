package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Cookie [] cookieArray = request.getCookies();
		out.println("Please find the below details.");
		out.print("<br>");
		for(Cookie c: cookieArray) {
			if("name".equals(c.getName())) {
				out.println("Name:"+c.getValue());
				out.println("<br>");
			}else {
				out.println("Address:"+c.getValue());
				out.println("<br>");
			}
		}
		
	}

}
