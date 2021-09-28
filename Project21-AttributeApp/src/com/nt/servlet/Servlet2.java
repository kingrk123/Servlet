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
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	
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
			pw.println("<br> Servlet2: attr1 attribute value"+request.getAttribute("attr1"));
			
			//read and display session attribute value
			ses=request.getSession();
			pw.println("<br> Servlet2: attr2 attribute value"+request.getAttribute("attr2"));
			
			//read and display ServletContext attribute
			sc=getServletContext();
			pw.println("<br> Servlet2: attr3 attribute value"+request.getAttribute("attr3"));
			
			//Forward the request to Third Servlet
			rd = request.getRequestDispatcher("/s3url");
			rd.forward(request, response);
			//close stream
			pw.close();
		}

		public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
		}

	}
