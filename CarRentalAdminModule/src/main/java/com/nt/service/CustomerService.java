package com.nt.service;

import com.nt.dto.AddNewCarDto;
import com.nt.dto.CustomerDto;
import com.nt.dto.EditCarDto;


public interface CustomerService {
	
	public   String   givePermission(CustomerDto dto)throws Exception;
	public String deleteOperation(int b)throws Exception;
	public String addCarCategory(String categoryname,String description)throws Exception;
	public String deleteCategoryOperation(int srno)throws Exception;
	public String editNewCategoryOperation(int srno,String categoryname,String description)throws Exception;
	public String addNewCar(AddNewCarDto dto)throws Exception;
	public String deleteCarOperation(int srno)throws Exception;
	public String editCar(EditCarDto dto,int srno)throws Exception;
}
