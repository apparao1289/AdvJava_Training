package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
		//Integer result = (Integer)request.getAttribute("result");
		
		/*HttpSession session = request.getSession();
		Integer result = (Integer)session.getAttribute("result");*/
		
		ServletContext ctxt = getServletContext();
		Integer result = (Integer)ctxt.getAttribute("result");
		PrintWriter out = response.getWriter();
		out.println("Addition of "+request.getParameter("num1")+","+request.getParameter("num2")+" is :"+result);
	}

	
}
