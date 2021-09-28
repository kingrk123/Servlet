package com.nt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EditCarDto;
import com.nt.imagehandling.FileUploadServlet;
import com.nt.service.CustomerService;
import com.nt.service.CustomerServiceImpl;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
@WebServlet("/EditNewCarController")
public class EditNewCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	

	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		RequestDispatcher rd=null;
		EditCarDto dto=null;
		dto=new EditCarDto();
		CustomerService service=null;
		int count=0;
		int sno=0;
		
		
		System.out.println("EditCarController.doPost()");
		
		 sno=Integer.parseInt(req.getParameter("srNo"));
		dto.setSelectcat(req.getParameter("selectcategory"));
							//		System.out.println(req.getParameter("selectcategory"));
		dto.setBrand(req.getParameter("brand"));
		dto.setModel(req.getParameter("model"));
		dto.setCarname(req.getParameter("carname"));
		dto.setSelecttype(req.getParameter("selecttype"));
								System.out.println(req.getParameter("selecttype"));
		dto.setSeatingcap(req.getParameter("seatingcapacity"));
		dto.setPlatenum(req.getParameter("platenumber"));
		dto.setFueltype(req.getParameter("fueltype"));
							//	System.out.println(req.getParameter("fueltype"));
		dto.setFuelcapacity(req.getParameter("fuelcapacity"));
		dto.setYearofmanu(req.getParameter("yearofmanufacturing"));
		dto.setColour(req.getParameter("colour"));
		dto.setHourlycharge(req.getParameter("hourlycharge"));
		dto.setFreekminhourcharge(req.getParameter("freekminhourlycharge"));
		dto.setDailycharge(req.getParameter("dailycharge"));
		dto.setFreekmindailycharge(req.getParameter("freekmindailycharge"));
		dto.setWeeklycharge(req.getParameter("weeklycharge"));
		dto.setFreekminweeklycharge(req.getParameter("freekminweeklycharge"));
		dto.setMonthlycharge(req.getParameter("monthlycharge"));
		 dto.setInsurancechargeperday(req.getParameter("insurancechargeperday"));
		 dto.setFreekminmonthlycharge(req.getParameter("freekminmonthlycharge"));
		 dto.setDetails(req.getParameter("details"));
		 dto.setBranch(req.getParameter("branch"));
		 System.out.println("After");
		 					//		System.out.println(req.getParameter("branch"));
		 try {
		 dto.setFrontviewimage(FileUploadServlet.getImage(req.getPart("frontviewimage")));
		 					//		System.out.println(req.getParameter("frontviewimage"));
		 dto.setRearviewimage(FileUploadServlet.getImage(req.getPart("rearviewimage")));
		 					//		System.out.println(req.getParameter("rearviewimage"));
		 dto.setLeftsideviewimage(FileUploadServlet.getImage(req.getPart("leftsideviewimage")));
		 					//		System.out.println(req.getParameter("leftsideviewimage"));
		 dto.setRightsideviewimage(FileUploadServlet.getImage(req.getPart("rightviewimage")));
		 					//		System.out.println(req.getParameter("rightviewimage"));
		 dto.setInteriorviewimage(FileUploadServlet.getImage(req.getPart("interiorviewimage")));
		 					//		System.out.println(req.getParameter("interiorviewimage"));
		 System.out.println("After");
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
		 
		 System.out.println(dto);
		service=new CustomerServiceImpl();
		
	try {
		String result=service.editCar(dto,sno);
		System.out.println(result);
		 req.setAttribute("editcar", result);
	}
	catch(Exception e) {
		
		e.printStackTrace();
	}
		
		
		  rd=req.getRequestDispatcher("Car-Setup.jsp"); 
		  rd.forward(req, res);
		 
		
		
		
		
		
	}//doPost

}//class
