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
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = null;
		PrintWriter pw = null;
		HttpSession ses = null;
		ServletContext sc = null;
		
		//Gerneral Setting
		pw = response.getWriter();
		
		//set content type
		response.setContentType("text/html");
		
		//create request attribute
		request.setAttribute("attr1", "val1");
		
		ses=request.getSession();
		ses.setAttribute("attr2", "val2");
		
		//create ServletContext attribute
		sc=getServletContext();
		sc.setAttribute("attr3", "val3");
		
		//Forward the request to servlet 2 component
		rd = request.getRequestDispatcher("/s2url");
		rd.forward(request, response);
		//close stream
		pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
