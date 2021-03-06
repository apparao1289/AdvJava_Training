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
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		// some business logic i.e save values to Database.
		System.out.println("Name:"+name +"  Address:"+address);
		
		// Create Cookies.
		Cookie nameCookie = new Cookie("name", name);
		response.addCookie(nameCookie);
		
		Cookie addressCookie = new Cookie("address", address);
		response.addCookie(addressCookie);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Thanks for visting the application");
		out.println("<br>");
		String url = "/CookiesExample/view";
		out.println("<a href="+url+">Click here to see your information</a>");
		
	}

}
