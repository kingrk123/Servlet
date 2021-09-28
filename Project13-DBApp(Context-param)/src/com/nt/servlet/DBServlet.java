package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBServlet
 */
@WebServlet("/DBServlet")
public class DBServlet extends HttpServlet {
	
	Connection con;
	PreparedStatement ps;
	private static final String GET_EMP_DETAILS="SELECT EMPNO, ENAME, JOB, SAL FROM EMP1 WHERE EMPNO=?";
	public void init() {
		try {
			//get Access to ServletConfig Object
			ServletContext sc = getServletContext();
			//read Context param values from web.xml
			String s1 = sc.getInitParameter("driver");
			String s2 = sc.getInitParameter("durl");
			String s3 = sc.getInitParameter("duser");
			String s4 = sc.getInitParameter("dpwd");
			
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s3);
			System.out.println(s4);
			
			//register JDBC driver
			Class.forName(s1);
			//Establish the connection
			con = DriverManager.getConnection(s2,s3,s4);
			//create JDBC PreparedStatement Object
			ps=con.prepareStatement(GET_EMP_DETAILS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//init()
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//General setting
			PrintWriter pw = response.getWriter();
			response.setContentType("text/html");
			//read form data
			int no = Integer.parseInt(request.getParameter("teno"));
			//set param value to SQL Query
			ps.setInt(1, no);
			
			//execute the SQL Query
			ResultSet rs = ps.executeQuery();
			
			//process the Resultset
			if(rs.next()) {
				pw.println("<br>EMPLOYEE NO:"+rs.getInt(1));
				pw.println("<br>EMPLOYEE NAME:"+rs.getString(2));
				pw.println("<br>EMPLOYEE DESG:"+rs.getString(3));
				pw.println("<br>EMPLOYEE SALARY:"+rs.getInt(4));
			}//if
			//close Resultset object
			rs.close();
			//close stream object
			pw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//doGet(-,-)
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}//doPost(-,-)
	
	public void destory() {
		//close JDBC Objects
		try {
			if (ps!=null) {
				ps.close();
			}//try
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			if (con!=null) {
				con.close();
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}//destroy()
}//class
