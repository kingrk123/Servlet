package com.nt.imagehandling;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
                 maxFileSize=1024*1024*10,      // 10MB
                 maxRequestSize=1024*1024*50)
public class FileUploadServlet {
   

	    private static final String SAVE_DIR="car";
	   
	    public static String getImage(Part file)
	           {
	            String savePath = "E:\\SSP\\CarRentalAdminModule\\WebContent\\images" + File.separator + SAVE_DIR;
	                File fileSaveDir=new File(savePath);
	                if(!fileSaveDir.exists()){
	                    fileSaveDir.mkdir();
	                }
	            Part part=file;
	            String fileName=extractFileName(part);
	            System.out.println(fileName);
	            /*if you may have more than one files with same name then you can calculate some random characters and append that characters in fileName so that it will  make your each image name identical.*/
	           try {
	            part.write(savePath + File.separator + fileName);
	           }catch(Exception e) {
	        	   e.printStackTrace();
	           }
	           /* 
	            //You need this loop if you submitted more than one file
	            for (Part part : request.getParts()) {
	            String fileName = extractFileName(part);
	            part.write(savePath + File.separator + fileName);
	        }*/
	                String filePath= "images/car/" + fileName ;
	                return filePath;
	   }
	    // file name of the upload file is included in content-disposition header like this:
	    //form-data; name="dataFile"; filename="PHOTO.JPG"
	    public static String extractFileName(Part part) {
	        String contentDisp = part.getHeader("content-disposition");
	        String[] items = contentDisp.split(";");
	        for (String s : items) {
	            if (s.trim().startsWith("filename")) {
	                return s.substring(s.indexOf("=") + 2, s.length()-1);
	            }
	        }
	        return "";
	    }
}
