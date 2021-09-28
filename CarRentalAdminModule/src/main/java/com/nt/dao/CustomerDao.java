package com.nt.dao;

import com.nt.bo.AddNewCarBo;
import com.nt.bo.CustomerBo;
import com.nt.bo.EditCarBo;

public interface CustomerDao {
	
	public int givePermission(CustomerBo bo)throws Exception;
	public int deleteOperation(int sno)throws Exception;
	public int addCarCategory(String categoryname,String description)throws Exception;
	public int deleteCategoryOperation(int srno)throws Exception;
	public int editNewCategoryOperation(int srno,String categoryname,String description)throws Exception;
	public int addNewCar(AddNewCarBo bo) throws Exception;
	public int deleteCarOperation(int srno)throws Exception;
	public int editCar(EditCarBo bo,int srno) throws Exception;
	
	

}
