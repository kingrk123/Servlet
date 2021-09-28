package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = null, gender = null, ms = null, addrs = null, qlfy = null, crs[] = null, hb[]=null;
		int age = 0;
		PrintWriter pw = null;
		pw = response.getWriter();
		response.setContentType("Text/html");
		
		name = request.getParameter("tname");
		age = Integer.parseInt(request.getParameter("tage"));
		gender = request.getParameter("gen");
		ms = request.getParameter("ms");
		addrs = request.getParameter("taddress");
		qlfy = request.getParameter("qlfy");
		crs = request.getParameterValues("crs");
		hb = request.getParameterValues("hb"); 
		
		if(gender.equalsIgnoreCase("M")) {
			if (age<=5)
				pw.println(name+" u r baby boy");
			else if (age<=12)
				pw.println(name+" u r small boy");
			else if (age<=19)
				pw.println(name+" u r teenage boy");
			else if (age<=35)
				pw.println(name+" u r young man");
			else if (age<=50)
				pw.println(name+" u r middle age man");
			else 
				pw.println(name+" u r Budda");
		}//if
		else if(gender.equalsIgnoreCase("F")) {
			if (age<=5)
				pw.println(name+" u r baby girl");
			else if (age<=12)
				pw.println(name+" u r small girl");
			else if (age<=19)
				pw.println(name+" u r teenage girl");
			else if (age<=35)
				pw.println(name+" u r young woman");
			else if (age<=50)
				pw.println(name+" u r middle age woman");
			else 
				pw.println(name+" u r old woman");
		}
		pw.println("<br>name=			"+name);
		pw.println("<br>age=			"+age);
		pw.println("<br>Gender=			"+gender);
		pw.println("<br>Martial Status=	"+ms);
		pw.println("<br>Address=		"+addrs);
		pw.println("<br>Qualification=	"+qlfy);
		pw.println("<br>Courses=		"+Arrays.toString(crs));
		pw.println("<br>Courses=		"+Arrays.toString(hb));
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		doGet(request, response);
	}
}
