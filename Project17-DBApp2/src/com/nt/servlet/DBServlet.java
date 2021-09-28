package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
	private static final String GET_EMP_DETAILS_BY_NO = "SELECT EMPNO, ENAME, JOB, SAL FROM EMP1 WHERE EMPNO=?";
	
	public void init() {
		String driver = null, url = null, dbuser = null, dbpwd = null;
		try {
			//Access ServletContext object
			ServletContext sc = getServletContext();
			driver = sc.getInitParameter("driver");
			url    = sc.getInitParameter("url");
			dbuser = sc.getInitParameter("dbuser");
			dbpwd  = sc.getInitParameter("dbpwd");
			
			//register JDBC driver
			Class.forName(driver);
			//establish the connection
			con = DriverManager.getConnection(url,dbuser,dbpwd);
			//create PreparedStatement object
			ps = con.prepareStatement(GET_EMP_DETAILS_BY_NO);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		}catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	//init()
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw =null;
		int no = 0 ;
		ResultSet rs = null;
		RequestDispatcher rd = null,rd1=null,rd2=null;
		try {
			//include header content
			rd1=request.getRequestDispatcher("headurl");
			rd1.include(request, response);
			//get PrintWriter object
			pw = response.getWriter();
			//set response content type
			response.setContentType("text/html");
			pw.println("<b>Before raising Exception</b>");
			//read form data(request data) 
			no = Integer.parseInt(request.getParameter("teno"));
			
			//set value to PreparedStatement SQL Query Parameter
			ps.setInt(1, no);
			//execute the SQL Query
			rs = ps.executeQuery();
			//process the ResultSet
			if(rs.next()) {
				pw.println("<br> EMP no: "+rs.getInt(1));
				pw.println("<br> Emp Name: "+rs.getString(2));
				pw.println("<br> Emp Job: "+rs.getString(3));
				pw.println("<br> Emp Salary: "+rs.getFloat(4));
			}//if
			else {
				pw.println("<b> RECORD NOT FOUND </b> ");
			}
			//add hyperlink
			pw.println("<br> <br> <a href='input.html'>home</a>");
			
			//get Access to ServletConfig object
			
			//include footer content
			rd2 = request.getRequestDispatcher("/footer.html");
			rd2.include(request, response);
			//close JDBC objects
			rs.close();
			//close stream
			pw.close();
		} catch (Exception e) {
			rd = request.getRequestDispatcher("/eurl");
			rd.forward(request, response);
		}
	}//doGet(-,-)

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void destroy() {
		//close JDBC objects
		try {
			if(ps!=null) {
				ps.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if(con!=null) {
				con.close();
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}//destroy()
}//class
