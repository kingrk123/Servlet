package com.nt.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ss = null;
		String engine = null;
		String url = null;
		
		//read form data
		ss = request.getParameter("ss");
		engine = request.getParameter("engine");
		
		System.out.println(ss);
		System.out.println();
		//prepare url with query String for send redirection
		
		if(engine.equals("google")) {
			url = "https://www.google.co.in/search?q="+ss;
		}
		else if (engine.equals("bing")) {
			url = "https://www.bing.com/search?q="+ss;
		}else if (engine.equals("yahoo")) {
			url = "https://www.yahoo.com/search?q="+ss;
		}
		System.out.println("Before SearchServlet:sendRedirect(-)");
		response.sendRedirect(url);
		
		RequestDispatcher rd = request.getRequestDispatcher("input.html");
		rd.include(request, response);
		System.out.println("After SearchServlet:SendRedirect(-)");
	}//doGet(-,-)

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
