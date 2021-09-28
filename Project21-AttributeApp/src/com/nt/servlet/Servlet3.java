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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		PrintWriter pw = null;
		HttpSession ses = null;
		ServletContext sc = null;
		
		//Gerneral Setting
		pw =response.getWriter();
		
		//set content type
		response.setContentType("text/html");
		
		//read and display request attribute value
		pw.println("<br> Servlet3: attr1 attribute value"+request.getAttribute("attr1"));
		
		//read and display session attribute value
		ses=request.getSession();
		pw.println("<br> Servlet3: attr2 attribute value"+request.getAttribute("attr2"));
		
		//read and display ServletContext attribute
		sc=getServletContext();
		pw.println("<br> Servlet3: attr3 attribute value"+request.getAttribute("attr3"));
	
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
