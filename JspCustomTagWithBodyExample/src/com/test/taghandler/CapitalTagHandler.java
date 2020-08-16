package com.test.taghandler;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class CapitalTagHandler extends BodyTagSupport {
	
	public int doStartTag() throws JspException {
		System.out.println("Executing doStartTag method..");
		JspWriter out = pageContext.getOut();
		try {
			out.println("Hello client");
			out.println("<br>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EVAL_PAGE;
	}

	public int doAfterBody() {
		System.out.println("Executing doAfterBody method..");
		BodyContent body = getBodyContent();
		String text = body.getString();
		JspWriter out = body.getEnclosingWriter();
		try {
			out.println(text.toUpperCase());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public int doEngTag() throws JspException {
		System.out.println("Executing doEngTag method..");
		return EVAL_PAGE;
	}
}
