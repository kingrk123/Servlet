package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VoterServlet
 */
@WebServlet("/VoterServlet")
public class VoterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =null;
		String name=null,tage=null,vstatus=null;
		int age=0;
		//get Printwriter
		pw=response.getWriter();
		//set Content type
		response.setContentType("text/html");
		//read the data from the form componenet
		name = request.getParameter("pname");
		tage = request.getParameter("page");
		vstatus = request.getParameter("vflag");//get client side validation status
		//if client side validations are not done 
		if(vstatus.equals("no")) {
			//server form validation logic
			if(name.equals("")|| name ==null || name.length()==0)//required rule
			{
				pw.println("<font color=red> Person name is manadatory </font> ");
				return;
			}
			if(tage.equals("")|| tage ==null || tage.length()==0)//required rule
			{
				pw.println("<font color=red> Person age is manadatory </font> ");
				return;
			}else //check wheather age is numeric value or not
			{
				try {
					//convert given age value to numeric value.
					age = Integer.parseInt(tage);
				} catch (NumberFormatException nfe) {
					pw.println("<font color=red> Age must be numeric value </font>");
					return;
				}
			}//else
			System.out.println("Server side validation complited");
		}//if
		else {//when client side form validation are done
			age = Integer.parseInt(tage);
		}
		//write request processing logic B.logic
		if(age>=18)
			pw.println("<h1><font color='green'>"+name+" u r eligible to vote </font></h1>");
		else {
			pw.println("<h1></h1><font color='red'>"+name+ " u r eligible not to vote</font></h1>");
			//add graphical hyperlink
			pw.println("<br><br>< href='input.html'></a>");
			//close stream
			pw.close();
		}//doGet(-,-)
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VoterServlet:doPost(-,-)");
		doGet(request, response);
	}
}//class
