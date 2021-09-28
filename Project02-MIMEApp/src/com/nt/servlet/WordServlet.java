package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WordServlet extends HttpServlet{

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
	
		//1.getPrintWriter
		PrintWriter pw =res.getWriter();
		//2.setContent type
		res.setContentType("application/msword");
		//3.write logic to generate output
		pw.println("<table border='1'>");
		pw.println("<tr><th>PLAYER</th><th>ROLE</th></tr>");
		pw.println("<tr><td>Dhoni</th><th>Captain</td></tr>");
		pw.println("<tr><td>ROHIT</th><th>Bats-man</td></tr>");
		pw.println("<tr><td>Bhuvi</th><th>Baller</td></tr>");		
		pw.println("</table>");
		
		//close Stream
		pw.close();
	}//service

}//class
