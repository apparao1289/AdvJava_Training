package com.test.servlet.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("Invoking destroy method");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String userName = request.getParameter("username");
		if (userName.endsWith("rao")) {
			out.println("Sorry you are not valid user.");
			out.println("<br><br>");
			out.println("<a href='/FilterExample/login.html'>Login</a>");
			return;
		}
		filterChain.doFilter(request, response);
		out.println("<br><br>");
		out.println("Have a nice day");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Invoking init method");

	}

}
