package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LinkServlet
 */
@WebServlet("/LinkServlet")
public class LinkServlet extends HttpServlet {
	 public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = null;
		String link =null;
		
		//get PrintWriter
		pw =response.getWriter();
		
		//set content type
		response.setContentType("text/html");
		
		//read "s1" req param value to know the hyperlink that is clicked
		link = request.getParameter("s1");
		if(link.equalsIgnoreCase("link1")) {//all languages
			//get all available locales
			Locale[] locales = Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayLanguage()+"<br>");
			}
		}//if
		else if(link.equalsIgnoreCase("link2")) {
			//get all available locales
			Locale[] locales= Locale.getAvailableLocales();
			for(Locale lc:locales) {
				pw.println(lc.getDisplayCountry()+"<br>");
			}//for
		}//else
		else {
			pw.println("Date and Time "+new Date());
		}
		//add hyperlink
		pw.println("<a href='page.html'>home</a>");
	 }//doGet(-,-)
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
