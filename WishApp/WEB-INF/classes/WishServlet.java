package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException {
	PrintWriter pw = null;
	Calendar calendar = null;
	int hour = 0;
	//General setting
	pw = res.getWriter();
	//set content type
	res.setContentType("text/html");
	//Get System Date
	calendar = Calendar.getInstance();
	hour  = calendar.get(Calendar.HOUR_OF_DAY);
	//generating the wishing
	if(hour<=12)
		pw.println("<h1 style='color:red'><center>Good Morning </center></h1>");
	else if(hour<=17)
		pw.println("<h1 style='color:red'><center>Good AfterNoon </center></h1>");
	else if(hour<=20)
		pw.println("<h1 style='color:orange'><center>Good Evening </center></h1>");
	else
		pw.println("<h1 style='color:black'><center>Good Night </center></h1>");
	//Generating the hyperlink
	pw.println("<br><a href='http://localhost:3030/WishApp/page.html'>home</a>");
	//close Stream
	pw.close();
	}//service
}//class