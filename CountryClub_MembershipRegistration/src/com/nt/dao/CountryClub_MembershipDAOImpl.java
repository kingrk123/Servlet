package com.nt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.CountryClub_MembershipBO;

public class CountryClub_MembershipDAOImpl implements CountryClub_MembershipDAO{

	private static final String INSERT_COUNTRYCLUB_MEMBERSHIP="INSERT INTO COUNTRY_CLUB_MEMBERSHIP VALUES(MEMBERSHIPSEQUENCE.NEXTVAL,?,?,?,?,?,?)";
	
			private Connection getPooledConnection()throws Exception{
				Connection con=null;
			 	InitialContext ic=null;
			 	DataSource ds=null;
			 	//create initialcontextObject
			 	ic= new InitialContext();
			 	//get DataSource Resource Object through lookup operation
			 	ds=(DataSource) ic.lookup("DsJndi");
			 	//create coonection
			 	con=ds.getConnection();
			 	return con;
			 	}
	@Override
	public int insert(CountryClub_MembershipBO bo) throws Exception {
		 Connection con =null;
		 PreparedStatement ps=null;
		 int count=0;
		 //create connection 
		 con=getPooledConnection();
		 //create preraed statement
		 ps=con.prepareStatement(INSERT_COUNTRYCLUB_MEMBERSHIP);
		 //set value to query param
		 	ps.setString(1, bo.getMname());
		 	ps.setString(2, bo.getMadd());
		 	ps.setString(3,bo.getCpackage());
		 	ps.setString(4,bo.getCountry());
		 	ps.setFloat(5, bo.getNet_amount());
		 	ps.setFloat(6, bo.getDiscount_amount());
		 	
		 	count=ps.executeUpdate();
		 	//close objects
			ps.close();
			con.close();
		 	return count;
		}
		
}
