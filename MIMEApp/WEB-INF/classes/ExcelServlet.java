package com.n.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		//getPrintWriter
		PrintWriter pw = res.getWriter();
		//set response content type
		res.setContentType("application/vnd.ms-excel");
		//write logic to generate OutPut
		pw.println("<table border='0'>");
		pw.println("<tr><th>Player</th><th>Role</th></tr>");
		pw.println("<tr><td>Dhoni</td><td>Captain</td></tr>");
		pw.println("<tr><th>Yuvraj</th><th>All Rounder</th></tr>");
		pw.println("</table>");
		//close stream
		pw.close();
	}//service
}//class
