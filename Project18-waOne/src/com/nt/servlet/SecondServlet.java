package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//General setting
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		//read form data
		int val = Integer.parseInt(request.getParameter("t1"));
		
		//cal cube value
		int cube = val*val*val;
		//display
		pw.println("SecondServlet:Cube value "+cube);
		//do not close stream
	}//doGet(-,-)

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
