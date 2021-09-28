package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DateServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		//1.set response content type
		res.setContentType("text/html");
		
		//2.Get PrintWriter Object
		PrintWriter pw = res.getWriter();
		
		//3.Write a Response
		Date d = new Date();
		pw.println("<b><i>Date and Time is "+d+"</i></b>");
		
		//4.close the stream
		pw.close();
	}//service

}//class
