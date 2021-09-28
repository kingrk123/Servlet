package com.nt.service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

public class StudentService {


	public String generateResult(StudentDTO dto) throws Exception {
		int total = 0;
		int avg = 0;
		String result = null;
		StudentBO bo = null;
		StudentDAO dao = null;
		int cnt = 0;
		
		//USE b.logic to calculate total,avg, results
		total =  dto.getM1()+dto.getM2()+dto.getM3();
		avg = total/3;
		if(avg<35) {
			result="FAIL";}
		else {
			result="PASS";
		}
		
		//Prapare BO Class Object having persistable data
		bo = new StudentBO();
		bo.setSno(dto.getSno());
		bo.setSname(dto.getSname());
		bo.setTotal(total);
		bo.setAvg(avg);
		bo.setResult(result);
		//use DAO
		dao = new StudentDAO();
		cnt = dao.insert(bo);
		if(cnt==0)
			return "Registration Failed";
		else
			return "Registration Succeded and result "+result+"<br>"
					+ "AVERAGE "+avg;
	}//generateResult(-)
}//class

