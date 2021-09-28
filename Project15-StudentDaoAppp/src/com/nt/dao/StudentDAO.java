package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.nt.bo.StudentBO;


public class StudentDAO {

	private static final String STUDENT_INSERT_QUERY="INSERT INTO SP_STUDENT VALUES(?,?,?,?,?)";

	public int insert(StudentBO bo) throws Exception {
		InitialContext ic = null;
		DataSource ds = null;
		Connection con = null;
		PreparedStatement ps = null;
		//StudentVO vo=null;
		//StudentDTO dto =null;
		int result = 0;
		try {
			//create InitialContext
			ic = new InitialContext();
			//get DataSource Object through lookup operation
			
			ds = (DataSource)ic.lookup("java:/comp/env/DsJndi");
			//get connection from JDBC con pool
			con = ds.getConnection();
			//create PreparedStatement object
			
			ps = con.prepareStatement(STUDENT_INSERT_QUERY);
			
			//set values to query params
			ps.setInt(1, bo.getSno());
			ps.setString(2, bo.getSname());
			ps.setInt(3, bo.getTotal());
			ps.setInt(4, bo.getAvg());
			ps.setString(5, bo.getResult());
			
			//System.out.println(vo.toString());
			//System.out.println(dto.toString());
			System.out.println(bo.toString());
			
			result = ps.executeUpdate();
		} catch (SQLException se) {
			se.printStackTrace();
		}finally {
			try {
				if(ps!=null)
					ps.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}try {
				if(con!=null)
					con.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}//finally
		return result;
	}//method
}//class
