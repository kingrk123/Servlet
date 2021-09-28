package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//general settings
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		//read form data
		int val = Integer.parseInt(request.getParameter("t1"));
		
		//calc SQUARE value
		int square = val*val;
		
		pw.println("<br>FirstServlet:SQUARE:"+square);
		//include the response of second Servlet component
		
		//get ServletContext object of current web application
		ServletContext sc1 = getServletContext();
		ServletContext sc2 = sc1.getContext("/WATwo");
		
		//get RequestDispatcher object pointing to secondServlet
		RequestDispatcher rd = sc2.getRequestDispatcher("s2url");
		rd.include(request, response);
		
		//close stream 
		pw.close();
	}//doGet(-,-)
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
