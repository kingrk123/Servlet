package com.nt.servlet1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException {
		String name = null,tage=null;
		int age =0;
		
		//1.get PrintWriter
		PrintWriter pw =res.getWriter();
		//2.set Content type
		res.setContentType("text/html");
		//3.get request parameter
		name = req.getParameter("name");
		tage = req.getParameter("age");
		System.out.println();
		age  = Integer.parseInt(tage);
		
		//4.write request processing logic
		if(age>=18) {
			pw.println("<center><h1 style='color:green'>"+name+" you are Eligible for Vote</h1></center>");
		}else {
			pw.println("<center><h1 style='color:red'>"+name+" you are not Eligible for Vote</h1></center>");
		}
		//add hyperlink
		pw.println("<a href='input.html'><img src='j.png'></a>");
		//close Stream
		pw.close();
	}
}
