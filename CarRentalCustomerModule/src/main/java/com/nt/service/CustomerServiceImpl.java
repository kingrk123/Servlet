package com.nt.service;

import java.text.SimpleDateFormat;

import com.nt.bo.CustomerRegBo;
import com.nt.dao.CustomerDao;
import com.nt.dao.CustomerDaoImpl;
import com.nt.dto.CustomerRegDto;
import com.nt.security.EncryptionOfPassword;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao;
	
	public String registerCustomer(CustomerRegDto dto) throws Exception {
		CustomerRegBo bo=null;
		int count=0;
		dao=new CustomerDaoImpl();
		//prepare CustomerRegBO class obj having persistable data..
        bo=new CustomerRegBo();
        bo.setCustomerName(dto.getCustomerName());
        bo.setLandlineNo(dto.getLandlineNo());
        bo.setMobileNo(dto.getMobileNo());
        bo.setAddress(dto.getAddress());
        bo.setPassportNo(dto.getPassportNo());
        
        
        
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String stringDate=dateFormat.format(dto.getPassportExpirydate());
        java.sql.Date sqlDate= java.sql.Date.valueOf(stringDate);
        
        
        
        bo.setPassportExpirydate(sqlDate);
        bo.setDrivingLicenseNo(dto.getDrivingLicenseNo());
        bo.setNationality(dto.getNationality());
        bo.setRefName(dto.getRefName());
        bo.setRefPhoneno(dto.getRefPhoneno());
        bo.setJobDetails(dto.getJobDetails());
        bo.setReferBy(dto.getReferBy());
        bo.setPremiumCustomer(dto.getPremiumCustomer());
        bo.setPermission(dto.getPermission());
        bo.setUsername(dto.getUsername());
        bo.setConfirmPassword(dto.getConfirmPassword());
        //use DAO 
        count=dao.registerCustomer(bo);
        //process the Results
        if(count==0)
        	 return "Customer Registration Failed---> ";
        else
        	 return "Customer Registration Succeded--->";
		
		
		
	}//method

	public int loginChecking(String username,String password) throws Exception {
		
	CustomerRegBo bo=null;
	int count=0;
	dao=new CustomerDaoImpl();
	
	
	EncryptionOfPassword.getMd5(password);
	System.out.println(EncryptionOfPassword.getMd5(password));
	count=dao.loginChecking(username, password);

		return count;
		
	}
}//class
