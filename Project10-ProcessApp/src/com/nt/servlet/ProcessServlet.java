package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessServlet
 */
@WebServlet("/ProcessServlet")
public class ProcessServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =null;
		String comp=null;
		int val1=0,val2=0;
		
		//get Printwriter Object
		pw=response.getWriter();
		
		//set response content type
		response.setContentType("text/html");
		
		//read s1 req param value to know the component that
		//is used to send the request
		comp = request.getParameter("s1");
		
		//write logic
		if(comp.equals("link1")) {
			//System date
			pw.println("Date and Time "+new Date());
		}
		else if(comp.equals("link2")) {
			//system Properties
			pw.println("System properties "+System.getProperties());
		}
		else if (comp.equals("add")) {//for add button
			//read form data
			val1= Integer.parseInt(request.getParameter("t1"));
			val2= Integer.parseInt(request.getParameter("t2"));
			pw.println("Addition "+(val1+val2));
		}else if (comp.equals("sub")){
			//read form data
			val1= Integer.parseInt(request.getParameter("t1"));
			val2= Integer.parseInt(request.getParameter("t2"));
			pw.println("Substration "+(val1-val2));
		}else {
			//read form data
			val1= Integer.parseInt(request.getParameter("t1"));
			val2= Integer.parseInt(request.getParameter("t2"));
			pw.println("Multiplication "+(val1*val2));
		}
		//add hyperlink
		pw.println("<a href='form.html'>home</a>");
	}//doGet(-,-)
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost(-,-)
}//class
