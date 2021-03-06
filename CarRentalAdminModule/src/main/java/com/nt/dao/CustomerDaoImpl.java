package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nt.bo.AddNewCarBo;
import com.nt.bo.CustomerBo;
import com.nt.bo.EditCarBo;
import com.nt.connection.GetConnectionPool;
import com.nt.controller.DeleteController;

public class CustomerDaoImpl implements CustomerDao {

	final static String  UPDATE_QUERY="UPDATE CUSTOMERREG SET PERMISSION=? WHERE SNO=?";
	final static String  DELETE_QUERY="DELETE FROM CUSTOMERREG WHERE SNO=?";
	final static String ADD_CAR_CATEGORY_QUERY="INSERT INTO CARCATEGORY VALUES(SEQUENCE_4.NEXTVAL,?,?)";
	final static String  DELETE_CAR_CATEGORY_QUERY="DELETE FROM CARCATEGORY WHERE SRNO=?";
	final static String  UPDATE_CAR_CATEGORY_QUERY="UPDATE CARCATEGORY SET CATEGORYNAME=?,DESCRIPTION=? WHERE SRNO=?";
	final static String ADD_NEW_CAR_QUERY="INSERT INTO CAR VALUES(SEQUENCE_5.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	final static String  DELETE_CAR_QUERY="DELETE FROM CAR WHERE SRNO=?";
	final static String UPDATE_CAR_QUERY="UPDATE CAR SET SELECTCAT=?,BRAND=?,MODEL=?,CARNAME=?,SELECTTYPE=?,"
			+ "SEATINGCAP=?,PLATENUM=?,FUELTYPE=?,FUELCAPACITY=?,YEAROFMANU=?,COLOUR=?,HOURLYCHARGE=?,"
			+ "FREEKMINHOURCHARGE=?,DAILYCHARGE=?,FREEKMINDAILYCHARGE=?,WEEKLYCHARGE=?,FREEKMINWEEKLYCHARGE=?,"
			+ "MONTHLYCHARGE=?,INSURANCECHARGEPERDAY=?,FREEKMINMONTHLYCHARGE=?,DETAILS=?,"
			+ "BRANCH=?,FRONTVIEWIMAGE=?,REARVIEWIMAGE=?,LEFTSIDEVIEWIMAGE=?,"
			+ "RIGHTSIDEVIEWIMAGE=?,INTERIORVIEWIMAGE=? WHERE SRNO=?";


	public int givePermission(CustomerBo bo) throws Exception {	
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(UPDATE_QUERY);
		//set values to Query params

		ps.setInt(1, bo.getPermission());
		ps.setInt(2, bo.getCid());


		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

	public int deleteOperation(int sno) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(DELETE_QUERY);
		//set values to Query params

		ps.setInt(1,sno);

		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

	public int addCarCategory(String categoryname, String description) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(ADD_CAR_CATEGORY_QUERY);
		//set values to Query params

		ps.setString(1, categoryname);
		ps.setString(2, description);


		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

	
	public int deleteCategoryOperation(int srno) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(DELETE_CAR_CATEGORY_QUERY);
		//set values to Query params

		ps.setInt(1,srno);


		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

	public int editNewCategoryOperation(int srno, String categoryname, String description) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(UPDATE_CAR_CATEGORY_QUERY);
		//set values to Query params

		ps.setString(1,categoryname);
		ps.setString(2, description);
		ps.setInt(3, srno);

		//execute theQuery
		count=ps.executeUpdate();
		System.out.println(count);
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

	public int addNewCar(AddNewCarBo bo) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(ADD_NEW_CAR_QUERY);
		//set values to Query params


		ps.setString(1,bo.getSelectcat());
		ps.setString(2,bo.getBrand() );
		ps.setString(3,bo.getModel());
		ps.setString(4,bo.getCarname());
		ps.setString(5,bo.getSelecttype());
		ps.setString(6,bo.getSeatingcap());
		ps.setString(7,bo.getPlatenum());
		ps.setString(8,bo.getFueltype());
		ps.setString(9,bo.getFuelcapacity());
		ps.setString(10,bo.getYearofmanu() );
		ps.setString(11,bo.getColour() );
		ps.setString(12,bo.getHourlycharge() );
		ps.setString(13,bo.getFreekminhourcharge() );
		ps.setString(14,bo.getDailycharge() );
		ps.setString(15,bo.getFreekmindailycharge() );
		ps.setString(16,bo.getWeeklycharge() );
		ps.setString(17,bo.getWeeklycharge() );
		ps.setString(18,bo.getMonthlycharge());
		ps.setString(19,bo.getInsurancechargeperday() );
		ps.setString(20,bo.getFreekminmonthlycharge() );
		ps.setString(21,bo.getDetails());
		ps.setString(22,bo.getBranch() );


		ps.setString(23,bo.getFrontviewimage() );
		ps.setString(24,bo.getRearviewimage());
		ps.setString(25,bo.getLeftsideviewimage() );
		ps.setString(26,bo.getRightsideviewimage() );
		ps.setString(27,bo.getInteriorviewimage() );





		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;

	}

	public int deleteCarOperation(int srno) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(DELETE_CAR_QUERY);
		//set values to Query params

		ps.setInt(1,srno);


		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}

	
	public int editCar(EditCarBo bo,int srno) throws Exception {
		Connection con=null;
		PreparedStatement ps=null;
		int count=0;
		//get Pooled Connection
		con=GetConnectionPool.getPooledConnection();
		//create PreparedStatement obj
		ps=con.prepareStatement(UPDATE_CAR_QUERY);
		//set values to Query params


		ps.setString(1,bo.getSelectcat());
		ps.setString(2,bo.getBrand() );
		ps.setString(3,bo.getModel());
		ps.setString(4,bo.getCarname());
		ps.setString(5,bo.getSelecttype());
		ps.setString(6,bo.getSeatingcap());
		ps.setString(7,bo.getPlatenum());
		ps.setString(8,bo.getFueltype());
		ps.setString(9,bo.getFuelcapacity());
		ps.setString(10,bo.getYearofmanu() );
		ps.setString(11,bo.getColour() );
		ps.setString(12,bo.getHourlycharge() );
		ps.setString(13,bo.getFreekminhourcharge() );
		ps.setString(14,bo.getDailycharge() );
		ps.setString(15,bo.getFreekmindailycharge() );
		ps.setString(16,bo.getWeeklycharge() );
		ps.setString(17,bo.getWeeklycharge() );
		ps.setString(18,bo.getMonthlycharge());
		ps.setString(19,bo.getInsurancechargeperday() );
		ps.setString(20,bo.getFreekminmonthlycharge() );
		ps.setString(21,bo.getDetails());
		ps.setString(22,bo.getBranch() );


		ps.setString(23,bo.getFrontviewimage() );
		ps.setString(24,bo.getRearviewimage());
		ps.setString(25,bo.getLeftsideviewimage() );
		ps.setString(26,bo.getRightsideviewimage() );
		ps.setString(27,bo.getInteriorviewimage() );	

		ps.setInt(28,srno);
		//execute theQuery
		count=ps.executeUpdate();
		//close jdbc objs
		ps.close();
		con.close();
		return count;
	}



}
