package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.CustomerDto;
import com.nt.service.CustomerService;
import com.nt.service.CustomerServiceImpl;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
 

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("CustomerController.doPost()");
	     
	     CustomerDto dto=null;
	     dto=new CustomerDto();
	     RequestDispatcher rd=null;
	     dto.setPermission(Integer.parseInt(req.getParameter("permission")));
	     dto.setCid(Integer.parseInt(req.getParameter("cid")));
	     
	        
	  
	     CustomerService service=new CustomerServiceImpl();
	     
	     try {
	    	 String result=service.givePermission(dto);
	    	 System.out.println(result);
	    	 
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 
	     }
	     
	     rd=req.getRequestDispatcher("Customer-Master.jsp"); 
	 		rd.forward(req, res);
	    
	     
	     
	}//doPost

}//class
