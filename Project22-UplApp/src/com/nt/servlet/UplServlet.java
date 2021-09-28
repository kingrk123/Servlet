package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadFile;


/**
 * Servlet implementation class UplServlet
 */
@WebServlet("/UplServlet")
public class UplServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=null;
		MultipartFormDataRequest nreq=null;
		String name=null;
		UploadBean upb=null;
		Enumeration<UploadFile> e=null;
		Hashtable ht=null;
		UploadFile file=null;
		//get PrintWriter 
		pw=response.getWriter();
		response.setContentType("text/html");
		try {
	    //create Special request object
		nreq=new MultipartFormDataRequest(request);
		//perform file uploadings
		name=nreq.getParameter("name");
		upb=new UploadBean();
		upb.setOverwrite(true);
		upb.setFilesizelimit(5*1024);
		upb.setFolderstore("c:/store");
		upb.store(nreq);
		// List of uploaed file names
		ht=nreq.getFiles();
		e=ht.elements();
		pw.println("<b> The uploaded file names are </b> --->customer name::"+name+"<br>");
		while(e.hasMoreElements()) {
			file=e.nextElement();
			pw.println(file.getFileName()+"  "+file.getFileSize()+"  "+file.getContentType()+"<br>");
		}
		}//try
		catch(UploadException ue) {
			pw.println("<br>Problem in file uploading..");
			ue.printStackTrace();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		//add hyperlink
		pw.println("<br><a href='file_upload.html'>home</a>");
		//close stream
		pw.close();
	}//doGet(-,-)


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
