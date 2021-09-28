package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CountryServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		String sIndia[] = {"AP", "TS", "MH", "MP", "UP"};
		String sUs[] = {"CA", "LA", "NY", "CR", "AZ"};
		String sau[] = {"TMS", "BB", "CBR"};
		
		String country =null;
		//read form data
		country =req.getParameter("country");
		
		//get PrintWriter
		PrintWriter pw = res.getWriter();
		//set Content type
		res.setContentType("text/html");
		
		//get state based on the country that is selected
		if (country.equals("India")) {
			pw.println("states= "+Arrays.toString(sIndia));
		}else if (country.equals("us")) {
			pw.println("states= "+Arrays.toString(sUs));
		}
		else {
			pw.println("state= "+Arrays.toString(sau));
			}
		//close Stream
		pw.close();
		}
	public void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException,IOException{
		doGet(req, res);
	}
	
	}

