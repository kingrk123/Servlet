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


@WebServlet("/EditNewCategoryController")
public class EditNewCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
  

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		System.out.println("EditNewCategoryController.doPost()");
		int srno;
		String categoryname;
		String description;
		 
		 srno=Integer.parseInt(req.getParameter("srNo"));
		 categoryname=req.getParameter("categoryname");
		 description=req.getParameter("description");
		 
		 System.out.println(srno);
		 System.out.println(categoryname);
		 System.out.println(description);
		 
		 CustomerService service=new CustomerServiceImpl();
		 
		 try {
	    	 String result=service.editNewCategoryOperation(srno,categoryname,description);
	    	 System.out.println(result);
	    	 req.setAttribute("edit", result);
	
	    	 
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 
	     }
		 
		 
		 
		 	rd=req.getRequestDispatcher("Car-Category.jsp"); 
	 		rd.forward(req, res);
		
			
			
		
		
	}

}
