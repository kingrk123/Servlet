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


@WebServlet("/AddNewCategoryController")
public class AddNewCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		CustomerService service=null;
		int count=0;
		RequestDispatcher rd=null;
		
		System.out.println("AddNewCategoryController.doPost()");
		String addCategory=req.getParameter("categoryname");
		String description=req.getParameter("description");
		
	
		service=new CustomerServiceImpl();
		
		try {
			String res1=service.addCarCategory(addCategory, description);
			System.out.println(res1);
			
			rd=req.getRequestDispatcher("Car-Category.jsp");
			rd.forward(req, res);
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}//doPost

}//doGet
