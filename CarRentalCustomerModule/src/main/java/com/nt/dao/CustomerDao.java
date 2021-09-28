package com.nt.dao;

import com.nt.bo.CustomerRegBo;

public interface CustomerDao {
	
	public int registerCustomer(CustomerRegBo bo)throws Exception;
	public int loginChecking(String username,String password)throws Exception;
	

}
