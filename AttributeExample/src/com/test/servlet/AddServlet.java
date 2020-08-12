package com.test.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int number1 = Integer.parseInt(request.getParameter("num1"));
		int number2 = Integer.parseInt(request.getParameter("num2"));
		int result = number1 + number2;
		System.out.println("result" + result);

		//request.setAttribute("result", result);
		
		/*HttpSession session = request.getSession(true);
		session.setAttribute("result", result);*/
		
		ServletContext ctxt = getServletContext();
		ctxt.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("view");
		rd.forward(request, response);

	}

}
