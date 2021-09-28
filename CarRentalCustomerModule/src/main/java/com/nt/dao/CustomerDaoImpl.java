package com.nt.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.bo.CustomerRegBo;
import com.nt.connection.GetConnectionPool;

public class CustomerDaoImpl implements CustomerDao {

	private static  final String  INSERT_CUSTOMER_QUERY="INSERT INTO CUSTOMERREG VALUES(SEQUENCE_1.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	final static String LOGIN_QUERY="SELECT COUNT (*) FROM CUSTOMERREG WHERE USERNAME=? AND PASSWORD=?";

	public int registerCustomer(CustomerRegBo bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(INSERT_CUSTOMER_QUERY);
		//set values to Query params

		ps.setString(1, bo.getCustomerName());
		ps.setLong(2, bo.getLandlineNo());
		ps.setLong(3,bo.getMobileNo());
		ps.setString(4,bo.getAddress());
		ps.setString(5,bo.getPassportNo());
		ps.setDate(6,(Date) bo.getPassportExpirydate());
		ps.setString(7,bo.getDrivingLicenseNo());
		ps.setString(8,bo.getNationality());
		ps.setString(9,bo.getRefName());
		ps.setLong(10,bo.getRefPhoneno());
		ps.setString(11,bo.getJobDetails());
		ps.setString(12,bo.getReferBy());
		ps.setString(13,bo.getPremiumCustomer());
		ps.setBoolean(14, bo.getPermission());
		ps.setString(15,bo.getUsername());
		ps.setString(16,bo.getConfirmPassword());

		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}
	
	public int loginChecking(String user, String pass) throws Exception {
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(LOGIN_QUERY);
		//set values to Query params
		
		ps.setString(1,user);
		ps.setString(2,pass);
		
		//execute theQuery
				rs=ps.executeQuery();
				//close jdbc objs
				if(rs.next()) {
					count=rs.getInt(1);
				}
				System.out.println(count);
				rs.close();
				ps.close();
				con.close();
				
				return count;
	}

}
