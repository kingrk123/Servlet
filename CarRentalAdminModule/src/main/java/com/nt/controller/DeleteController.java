package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.service.CustomerService;
import com.nt.service.CustomerServiceImpl;

import lombok.Data;


@WebServlet("/DeleteController")
@Data
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		RequestDispatcher rd=null;
		
		int sno;
		 
		 sno=Integer.parseInt(req.getParameter("id"));
		 
		 CustomerService service=new CustomerServiceImpl();
		 
		 try {
	    	 String result=service.deleteOperation(sno);
	    	 System.out.println(result);
	    	 req.setAttribute("delete", result);
	
	    	 
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 
	     }
		 
		 
		 
		 	rd=req.getRequestDispatcher("Customer-Master.jsp"); 
	 		rd.forward(req, res);
		
		
		
	}

}
