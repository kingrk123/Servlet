package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.CustomerRegDto;
import com.nt.service.CustomerService;
import com.nt.service.CustomerServiceImpl;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("LoginController.doPost()");
		
		CustomerRegDto dto=null;
	     dto=new CustomerRegDto();
	     RequestDispatcher rd=null;
	     
	     
	     String us=req.getParameter("username");
	     String pas=req.getParameter("password");
	     
	     CustomerService service=new CustomerServiceImpl();
	     
	     try {
	    	int res1=service.loginChecking(us,pas);
	    	 System.out.println(res1);
	    	 if(res1!=1) {
	    		 rd=req.getRequestDispatcher("login.html"); 
	    		 rd.forward(req, res);
	    	 }
	    	 else {
	    	 rd=req.getRequestDispatcher("index.html");
	    	 rd.forward(req, res);
	    	 }
	    	
	    	 
	    	 
	    	 
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 
	     }
	     
	     
		
		
	}//doPost

}//class
