package com.nt.connection;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class GetConnectionPool {
	
	
	public static  Connection  getPooledConnection()throws Exception{
		InitialContext ic=null;
		DataSource ds=null;
		Connection con=null;
		//create InitialContext obj
		ic=new InitialContext();
		//get DataSource obj through Lookup operation
		ds=(DataSource) ic.lookup("java:/comp/env/jdbc/DsJndi");
		//get PooledConnection obj
		con=(Connection) ds.getConnection();
		return con;
	}

}
