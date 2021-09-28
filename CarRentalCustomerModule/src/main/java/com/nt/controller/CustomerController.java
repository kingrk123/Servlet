package com.nt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.CustomerRegDto;
import com.nt.service.CustomerService;
import com.nt.service.CustomerServiceImpl;


@WebServlet("/CustomerController")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CustomerController() {
        
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("CustomerController.doPost()");
	     
	     CustomerRegDto dto=null;
	     dto=new CustomerRegDto();
	     dto.setCustomerName(req.getParameter("customerName"));
	     dto.setLandlineNo(Long.parseLong(req.getParameter("landlineNo")));
	   //  System.out.println("MobileNo: "+req.getParameter("mobileNo"));
	     dto.setMobileNo(Long.parseLong(req.getParameter("mobileNo")));
	    // System.out.println("Address: "+req.getParameter("address"));
	     dto.setAddress(req.getParameter("address"));
	     dto.setPassportNo(req.getParameter("passportNo"));
	     
	     //String sdate=req.getParameter("passportExpiryDate");
	     try {
	    	 Date dt=new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("passportExpiryDate"));
	    	//Date date=fdate.parse(sdate);
	    	dto.setPassportExpirydate(dt);
	  
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	     }
	     
	     dto.setDrivingLicenseNo(req.getParameter("drivingLicenseNo"));
	     dto.setNationality(req.getParameter("nationality"));
	     dto.setRefName(req.getParameter("refName"));
	     dto.setRefPhoneno(Long.parseLong(req.getParameter("refPhoneNo")));
	     dto.setJobDetails(req.getParameter("jobDetails"));
	     dto.setReferBy(req.getParameter("referBy"));
	   //  System.out.println(req.getParameter("val"));
	     dto.setPremiumCustomer(req.getParameter("val"));
	     dto.setPermission(Boolean.parseBoolean(req.getParameter("permission")));
	     dto.setUsername(req.getParameter("username"));
	     dto.setConfirmPassword(req.getParameter("confirmpassword"));
	     CustomerService service=new CustomerServiceImpl();
	     System.out.println(dto.getConfirmPassword()+" controller ");
	     
	     try {
	    	 String result=service.registerCustomer(dto);
	    	 System.out.println(result);
	    	 
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 
	     }
	     
	     
	}//doPost

}//class
