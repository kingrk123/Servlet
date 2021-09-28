package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String link = null;
		Locale locales[] = null;
		PrintWriter pw = null;
		pw = res.getWriter();
		res.setContentType("text/html");
		link = req.getParameter("s1");
		if(link.equalsIgnoreCase("link1")) {
			locales = Locale.getAvailableLocales();
			for(Locale Ic:locales) {
				pw.println(Ic.getDisplayLanguage()+"<br>");
			}
		}
		else if (link.equalsIgnoreCase("link2")) {
			locales = Locale.getAvailableLocales();
			for(Locale Ic:locales) {
				pw.println(Ic.getDisplayCountry()+"<br>");
		}//for
	}//else
		else {
		pw.println("Date and Time"+ new Date());	
		}
		pw.println("<a href='page.html'>home</a>");
		}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		doGet(req, res);
	}
}
