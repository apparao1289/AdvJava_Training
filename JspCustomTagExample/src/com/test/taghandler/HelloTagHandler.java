package com.test.taghandler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class HelloTagHandler extends TagSupport {

	public int doStartTag() throws JspException {
		System.out.println("doStartTag method executing...");
		JspWriter out = pageContext.getOut();
		try {
			out.println("<br>");
			out.println("Hello how are you");
			out.println("<br>");
			out.println("what are you doing");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEndTag() throws JspException {
		System.out.println("doEngTag method executing...");
		JspWriter out = pageContext.getOut();
		try {
			out.println("<br>");
			out.println("***************");
			out.println("Bye Bye");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return EVAL_PAGE;
	}
}
