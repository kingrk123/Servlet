package com.nt.imagehandling;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.nt.bo.AddNewCarBo;
import com.nt.bo.CustomerBo;
import com.nt.service.CustomerService;
@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
maxFileSize=1024*1024*10,      // 10MB
maxRequestSize=1024*1024*50)
public class imaging {
	 private static final String SAVE_DIR="cars";
	
	public static String getImage(AddNewCarBo bo)throws Exception{
		HttpServletResponse response=null;
		System.out.println("imaging.getImage()");
		HttpServletRequest request=null;
		PrintWriter out = response.getWriter();
		System.out.println("imaging.getImage()");
        String savePath = "E:\\SSP\\CarRentalAdminModule\\WebContent\\src" + File.separator + SAVE_DIR;
            File fileSaveDir=new File(savePath);
            if(!fileSaveDir.exists()){
                fileSaveDir.mkdir();
            }
            System.out.println("imaging.getImage()");
            String fileName="";
           // Part part=request.getPart("file");
            for (Part part1 : request.getParts()) {
            	  fileName= extractFileName(part1);
                part1.write(savePath + File.separator + fileName);
	
            }
            System.out.println(fileName);
            return "src/car/"+fileName;
	}
	
	public static String extractFileName(Part part)throws Exception{
		String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
		
	}//method

}//class
