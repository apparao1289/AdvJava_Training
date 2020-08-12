package com.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.business.StudentBusiness;
import com.test.business.StudentBusinessImpl;
import com.test.exception.ApplicationException;
import com.test.model.Student;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String age = request.getParameter("age");
		String address = request.getParameter("address");
		String stand = request.getParameter("stand");

		Student student = new Student();
		student.setName(fname + " " + lname);
		student.setAge(Integer.parseInt(age));
		student.setAddress(address);
		student.setStand(stand);

		StudentBusiness studentBusiness = new StudentBusinessImpl();
		try {
			boolean status = studentBusiness.createStudent(student);
			if (status) {
				response.sendRedirect("success.html");
			} else {
				response.sendRedirect("error.html");
			}
		} catch (ApplicationException e) {
			response.sendRedirect("error.html");
		}

	}

}
