package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {

   public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	   PrintWriter pw = null;
	   String name = null, tage = null;
	   int age = 0;
	   //general settings
	   pw = res.getWriter();
	   res.setContentType("text/html");
	   
	   //get request parameter values(from data)
	   name = req.getParameter("name");
	   tage = req.getParameter("age");
	   age  = Integer.parseInt(tage);
	   
	   //write request processing logic
	   if(age>=18)
	   {
		   pw.println("<h1 style='color:green'>"+name +" you are Eligible For Vote</h1>");
	   }
	   else {
		   pw.println("<h1 style='color:red'>"+name +" you are not Eligible For Vote</h1>");
	   }
	   //add hyperlink
	   pw.println("<a href='input.html'><img src ='j.jpg'></a>");
	   //close stream
	   pw.close();
   }
}//class
