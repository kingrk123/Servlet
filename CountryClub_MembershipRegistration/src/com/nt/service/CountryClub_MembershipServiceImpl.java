package com.nt.service;
import com.nt.bo.CountryClub_MembershipBO;
import com.nt.dao.CountryClub_MembershipDAO;
import com.nt.dao.CountryClub_MembershipDAOImpl;
import com.nt.dto.CountryClub_MembershipDTO;

public class CountryClub_MembershipServiceImpl implements CountryClub_MembershipService {
	private CountryClub_MembershipDAO dao;
	
	  public CountryClub_MembershipServiceImpl() {
		dao=new CountryClub_MembershipDAOImpl();
		}
	@Override
	public String registerMembership(CountryClub_MembershipDTO dto) throws Exception {
		
		CountryClub_MembershipBO bo=null;
		int count=0;		
		float net_amount=0;
		float discount_amount=0;
		switch (dto.getCpackage()) {
	      case "Silver":
	    	  net_amount=200000.0f;
	    	  discount_amount=net_amount-(net_amount*0.1f);
	        break;
	      case "Gold":
	    	  net_amount=300000.0f;
	    	  discount_amount=net_amount-(net_amount*0.1f);
	        break;
	      case "Platinum":
	    	  net_amount=400000.0f;
	    	  discount_amount=net_amount-(net_amount*0.1f);
	        break;
	      case "Dimond":
	    	  net_amount=500000.0f;
	    	  discount_amount=net_amount-(net_amount*0.1f);
	    	  break;
		}
				//prepare BO Class object having persistence logic
				bo=new CountryClub_MembershipBO();
				bo.setMname(dto.getMname());
				bo.setMadd(dto.getMadd());
				bo.setCpackage(dto.getCpackage());
				bo.setCountry(dto.getCountry());
				bo.setNet_amount(net_amount);
				bo.setDiscount_amount(discount_amount);
				
				count=dao.insert(bo);
				if(count==0)
					return "Registration Failed";
				else
					return "Country Club Membership Registration Succeded";
	}
}
