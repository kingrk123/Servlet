package com.nt.service;

import com.nt.bo.AddNewCarBo;
import com.nt.bo.CustomerBo;
import com.nt.bo.EditCarBo;
import com.nt.dao.CustomerDao;
import com.nt.dao.CustomerDaoImpl;
import com.nt.dto.AddNewCarDto;
import com.nt.dto.CustomerDto;
import com.nt.dto.EditCarDto;
import com.nt.imagehandling.imaging;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDao dao;
	
	public String givePermission(CustomerDto dto) throws Exception {
		
		CustomerBo bo=null;
		int count=0;
		dao=new CustomerDaoImpl();
        bo=new CustomerBo();
        
        bo.setPermission(dto.getPermission());
        bo.setCid(dto.getCid());
        
      //use DAO 
        count=dao.givePermission(bo);
        //process the Reuslts
        if(count==0)
        	 return "Permission Failed---> ";
        else
        	 return "Successfully Given Permission--->";
		
	}


	public String deleteOperation(int sno) throws Exception {
		int count=0;
		dao=new CustomerDaoImpl();
		
		//use DAO 
        count=dao.deleteOperation(sno);
        //process the Reuslts
        if(count==0)
        	 return "Customer deleting Failed---> ";
        else
        	 return "Customer deleting Succeded--->";	
        }


	public String addCarCategory(String categoryname, String description) throws Exception {
		
		int count=0;
		dao=new CustomerDaoImpl();
		
		count=dao.addCarCategory(categoryname, description);
		if(count==0)
			return "Add New Car Category into Database Failed---> ";
        else
        	 return "Add New Car Category into Database Succeded--->";
		
	}


	public String deleteCategoryOperation(int srno) throws Exception {
		int count=0;
		dao=new CustomerDaoImpl();
		
		
		//use DAO 
        count=dao.deleteCategoryOperation(srno);
        //process the Result
        if(count==0)
        	 return "Deleting car category is Failed---> ";
        else
        	 return "Deleting car category is Succeded--->";	
	}


	public String editNewCategoryOperation(int srno, String categoryname, String description) throws Exception {
		int count=0;
		dao=new CustomerDaoImpl();
		
		
		//use DAO 
        count=dao.editNewCategoryOperation(srno,categoryname,description);
        System.out.println(count);
        //process the Result
        if(count==0)
        	 return "Updating car category is Failed---> ";
        else
        	 return "Upadating car category is Succeded--->";	
	}

	public String addNewCar(AddNewCarDto dto) throws Exception {
		AddNewCarBo bo=null;
		int count=0;
		dao=new CustomerDaoImpl();
        bo=new AddNewCarBo();
        imaging img=null;
        
       bo.setSelectcat(dto.getSelectcat());
       bo.setBrand(dto.getBrand());
       bo.setModel(dto.getModel());
       bo.setCarname(dto.getCarname());
       bo.setSelecttype(dto.getSelecttype());
       bo.setSeatingcap(dto.getSeatingcap());
       bo.setPlatenum(dto.getPlatenum());
       bo.setFueltype(dto.getFueltype());
       bo.setFuelcapacity(dto.getFuelcapacity());
       bo.setYearofmanu(dto.getYearofmanu());
       bo.setColour(dto.getColour());
       bo.setHourlycharge(dto.getHourlycharge());
       bo.setFreekminhourcharge(dto.getFreekminhourcharge());
       bo.setDailycharge(dto.getDailycharge());
       bo.setFreekmindailycharge(dto.getFreekmindailycharge());
       bo.setWeeklycharge(dto.getWeeklycharge());
       bo.setFreekminweeklycharge(dto.getFreekminweeklycharge());
       bo.setMonthlycharge(dto.getMonthlycharge());
       bo.setInsurancechargeperday(dto.getInsurancechargeperday());
       bo.setFreekminmonthlycharge(dto.getFreekminmonthlycharge());
       bo.setDetails(dto.getDetails());
       bo.setBranch(dto.getBranch());
       bo.setFrontviewimage(dto.getFrontviewimage());
       
       
       bo.setRearviewimage(dto.getRearviewimage());
       bo.setLeftsideviewimage(dto.getLeftsideviewimage());
       bo.setRightsideviewimage(dto.getRightsideviewimage());
       bo.setInteriorviewimage(dto.getInteriorviewimage());
        
        
        //use DAO 
        count=dao.addNewCar(bo);
        //process the Reuslts
        if(count==0)
        	 return "New Car adding is failed---> ";
        else
        	 return "New Car adding is done--->";
	}

	public String deleteCarOperation(int srno) throws Exception {
		int count=0;
		dao=new CustomerDaoImpl();
		
		
		//use DAO 
        count=dao.deleteCarOperation(srno);
        //process the Result
        if(count==0)
        	 return "Deleting car is Failed---> ";
        else
        	 return "Deleting car is Succeded--->";	
	}

	public String editCar(EditCarDto dto,int srno) throws Exception {
		EditCarBo bo=null;
		int count=0;
		dao=new CustomerDaoImpl();
        bo=new EditCarBo();
        imaging img=null;
        
       bo.setSelectcat(dto.getSelectcat());
       bo.setBrand(dto.getBrand());
       bo.setModel(dto.getModel());
       bo.setCarname(dto.getCarname());
       bo.setSelecttype(dto.getSelecttype());
       bo.setSeatingcap(dto.getSeatingcap());
       bo.setPlatenum(dto.getPlatenum());
       bo.setFueltype(dto.getFueltype());
       bo.setFuelcapacity(dto.getFuelcapacity());
       bo.setYearofmanu(dto.getYearofmanu());
       bo.setColour(dto.getColour());
       bo.setHourlycharge(dto.getHourlycharge());
       bo.setFreekminhourcharge(dto.getFreekminhourcharge());
       bo.setDailycharge(dto.getDailycharge());
       bo.setFreekmindailycharge(dto.getFreekmindailycharge());
       bo.setWeeklycharge(dto.getWeeklycharge());
       bo.setFreekminweeklycharge(dto.getFreekminweeklycharge());
       bo.setMonthlycharge(dto.getMonthlycharge());
       bo.setInsurancechargeperday(dto.getInsurancechargeperday());
       bo.setFreekminmonthlycharge(dto.getFreekminmonthlycharge());
       bo.setDetails(dto.getDetails());
       bo.setBranch(dto.getBranch());
       bo.setFrontviewimage(dto.getFrontviewimage());
       
       
       bo.setRearviewimage(dto.getRearviewimage());
       bo.setLeftsideviewimage(dto.getLeftsideviewimage());
       bo.setRightsideviewimage(dto.getRightsideviewimage());
       bo.setInteriorviewimage(dto.getInteriorviewimage());
        
        
        //use DAO 
        count=dao.editCar(bo,srno);
        //process the Reuslts
        if(count==0)
        	 return "Edit Car adding is failed---> ";
        else
        	 return "Edit Car adding is done--->";
	}
}//class
