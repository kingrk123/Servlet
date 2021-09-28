package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorServlet
 */
@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ErrorServlet:doGet(-,-)");
		//include header content
		//RequestDispatcher rd1 = request.getRequestDispatcher("/headurl");
		//rd1.include(request,response);
		
		//general settings
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		//Display Error page
		pw.println("<h1><center>Internal Problem</center></h1>");
		pw.println("<a href='input.html'>Try Again </a>");

		//include footer content
				//RequestDispatcher rd2 = request.getRequestDispatcher("/footer.html");
				//rd1.include(request,response);
				
		//close Stream
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ErrorServlet:doPost(-,-)");
		doGet(request, response);
	}
}//class
