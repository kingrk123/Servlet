package com.nt.service;

import com.nt.dto.CustomerRegDto;


public interface CustomerService {
	
	public   String   registerCustomer(CustomerRegDto dto)throws Exception;
	public int loginChecking(String username,String password)throws Exception;
	


}
