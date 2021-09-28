package com.nt.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nt.dto.CountryClub_MembershipDTO;
import com.nt.service.CountryClub_MembershipService;
import com.nt.service.CountryClub_MembershipServiceImpl;
import com.nt.vo.CountryClub_MembershipVO;
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	private CountryClub_MembershipService service;
	public void init() {
		service=new CountryClub_MembershipServiceImpl();
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  String mname=null, age=null,madd=null, cpackage=null,country=null;
		  CountryClub_MembershipVO vo=null;
		  CountryClub_MembershipDTO dto=null;
		  String resultMsg=null;
		  PrintWriter pw=null;
		//get printWriter
		pw=res.getWriter();
		//set content type
		res.setContentType("text/html");
		//read form data
		mname=req.getParameter("mname");
		age=req.getParameter("age");
		madd=req.getParameter("tadd");
		cpackage=req.getParameter("pkg");
		country=req.getParameter("country");
		//store form data into vo class object
		vo = new CountryClub_MembershipVO();
		vo.setMname(mname);
		vo.setAge(age);
		vo.setMadd(madd);
		vo.setCpackage(cpackage);
		vo.setCountry(country);
		//Convert Vo Class object into DTO class Object
		dto=new CountryClub_MembershipDTO();
		dto.setMname(vo.getMname());
		dto.setAge(Integer.parseInt(vo.getAge()));
		dto.setMadd(madd);
		dto.setCpackage(vo.getCpackage());
		dto.setCountry(vo.getCountry());
		//use Service class
		 try {
	        	resultMsg=service.registerMembership(dto);
	        	pw.println("<h1 style='color:red;text-align:center'>"+resultMsg+"</h1>");
	        }
	        catch(Exception e) {
	        	e.printStackTrace();
	        	pw.println("<h1 style='color:red;text-align:center'>Internal Problem--Try Again</h1>");
	        }
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
