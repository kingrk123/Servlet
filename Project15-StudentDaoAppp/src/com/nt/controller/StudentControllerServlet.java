package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.bo.StudentBO;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.vo.StudentVO;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentVO vo = null;
		StudentBO bo =null;
		String no = null,name=null,m1=null,m2=null,m3=null;
		StudentDTO dto = null;
		StudentService service = null;
		String result = null;
		String avg = null;
		
		PrintWriter pw = null;
		ServletOutputStream sos = null;
		
		//read form data 
		no = request.getParameter("no");
		name = request.getParameter("name");
		m1 = request.getParameter("m1");
		m2 = request.getParameter("m2");
		m3 = request.getParameter("m3");
		
		//Create VO class object having form data
		vo = new StudentVO();
		vo.setSno(no);
		vo.setSname(name);
		vo.setM1(m1);
		vo.setM2(m2);
		vo.setM3(m3);
		
		//convert VO class object to DTO class object
		dto = new StudentDTO();
		dto.setSno(Integer.parseInt(vo.getSno()));
		dto.setSname(vo.getSname());
		dto.setM1(Integer.parseInt(vo.getM1()));
		dto.setM2(Integer.parseInt(vo.getM2()));
		dto.setM3(Integer.parseInt(vo.getM3()));
		
		//use Service class
		service = new StudentService();
		try {
			result = service.generateResult(dto);
			//display results
			
			pw = response.getWriter();
			response.setContentType("text/html");
			pw.println("<h1>Result "+result+"</h1>");
			
			//add hyperlink
			pw.println("<a href='form.html'>home</a>");
			sos = response.getOutputStream();
			//close Streams
			pw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
