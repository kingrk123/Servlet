package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BillServlet
 */
@WebServlet("/BillServlet")
public class BillServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//General setting
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		//read form data
		String name = request.getParameter("t1");
		float price = Float.parseFloat(request.getParameter("t2"));
		float qty = Float.parseFloat(request.getParameter("t3"));
		
		//calc Bill Amt
		float bamt = price*qty;
		
		if (bamt>=50000) {
			System.out.println("Before response.sendRD(-)in BillServlet");
			response.sendRedirect("http://localhost:7777/Project20-TestApp/discounturl?bill="+bamt+"&iname="+name);
			System.out.println("after resonse.sendRD(-) in BillServlet");
		}//if
		else {
			pw.println("<br>From BillServlet component<br>");
			pw.println("<br>Item name:"+name+"price:"+price+"Qty:"+qty+"Bill Amt:"+bamt);
		}//else
		//close stream
		pw.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
