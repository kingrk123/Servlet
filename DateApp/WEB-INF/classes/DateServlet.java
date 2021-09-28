package com.nt.servlet;

import javax.servlet.*;
import java.io.*;
import java.util.*;

public class DateServlet extends GenericServlet  
{
	public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException 
	{
		//set response content type
		res.setContentType("text/html");
		//get PrintWriter object
		PrintWriter pw = res.getWriter();
		//write response
		Date d = new Date();
		pw.println("<h1 style=color:red;text-align:center'>Date and Time :: "+d+"</h1>");
		//close stream
		pw.close();
	}//service
}//class
