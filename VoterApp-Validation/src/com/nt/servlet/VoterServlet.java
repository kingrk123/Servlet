package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VoterServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw =res.getWriter();
		String name = null, tage = null, vstatus = null;
		int age = 0;
		//get PrintWriter
		pw = res.getWriter();
		//set response content type
		res.setContentType("text/html");
		//read form data from the form comps of form page
		name = req.getParameter("pname");
		tage = req.getParameter("page");
		vstatus = req.getParameter("vflag");
		if(vstatus.equals("no")) {
			if(name.equals("") || name == null || name.length()==0) {
				pw.println("<font color=red>Person name is manadatory</font>");
				return;
			}
			if(tage.equals("") || tage == null || tage.length()==0) {
				pw.println("<font color=red>Person age is manadatory</font>");
				return;
		}else {
			try{
				age = Integer.parseInt(tage);
			}
			catch(NumberFormatException nfe) {
				pw.println("<font color=red>Age must be numeric value</font>");
				return;
			}
			}//else
			System.out.println("Server Side validations Completed");
		}//if
		else {
			//when client side form validation are done
			age = Integer.parseInt(tage);
		}
		//write request processing logic/B.logic
		if(age>=18) 
			pw.println("<h1><font color='green'>" +name + "  u r eligible to vote</font></h1>");
			else
				pw.println("<h1><font color='red'>"+name +" u r not eligible for vote </font></h1>");
			pw.println("<br><br><a href='input.html'><img src='k.jpg' width='100' height='100'></a>");
			//close stream
			pw.close();
		}//doGet
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
		System.out.println("VoterServlet:doPost(-,-)");
		doGet(req, res);
	}
		
	}


