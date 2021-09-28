package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
		
		Calendar calendar =null;
		int hour = 0;
		
		//1.get PrintWriter
		PrintWriter pw =res.getWriter();
		
		//2.set content type
		res.setContentType("text/html");
		
		//3.Write Logic 
		calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		
		//generate Wish Message
		if(hour<=12) {
			pw.println("<h1 style='color:red'>Good Morning</h1>");}
		else if(hour<=17) {
			pw.println("<h1 style='color:red'>Good AfterNoon</h1>");}
		else if(hour<=20) {
			pw.println("<h1 style='color:red'>Good Evening</h1>");}
		else {
			pw.println("<h1 style='color:black'>Good Night</h1>");}
		
		//generate hyperlink
		pw.println("<br><a href='http://localhost:7777/Project03-WishApp/page.html'>home</a>");
		
		//close Stream
		pw.close();
	}
}
