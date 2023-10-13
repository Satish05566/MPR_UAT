package com.ddm.cbic.validation;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;



public class CommonValidation {
	
	private static final Logger logger = LoggerFactory.getLogger(CommonValidation.class);
	
	public String emptyString(String fieldValue, String label) {
		
		String str ="";
		if(fieldValue.length() <= 0 ) {
			
			str = label;
		}
		 return str;
	}
	
	
	public String checkNumericValueLessThan(int fieldValue, int comparisonValue,String label) {
		
		String str ="";
		if( fieldValue > comparisonValue ) {
			
			str = label;
		}
		 return str;
	}
	
	public String getFileExtension(String fileName) {
        
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(fileName.lastIndexOf("."));
        else return "";
    }
	
	public  String getFileNameWithoutExtension(String fileName) {
        
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        return fileName.substring(0,fileName.lastIndexOf(".")-1);
        else return "";
    }
	
	public boolean isExecutable(MultipartFile file) {
		  byte[] firstBytes = new byte[4];
		  boolean value = false;
		  try {
			  InputStream inputStream =  new BufferedInputStream(file.getInputStream());
			  inputStream.read(firstBytes);

		    // Check for Windows executable
		    if (firstBytes[0] == 0x4d && firstBytes[1] == 0x5a) {
		    	
		      value =  true;
		    } else {
		    value =  false;
		  }
		  }
		  catch (Exception e) {
		    e.printStackTrace();
		  }
		return value;
		
	
	}
	
	public boolean isSizeGreaterthanOneMB(MultipartFile file) {
		  
		  boolean value = false;
		  try {
			  
			  if(file.getSize() > 1000000) {
				  
				  value=true;
			  }
		  }
		  catch (Exception e) {
		    e.printStackTrace();
		  }
		return value;
		
	
	}
	
	public boolean isInValidFileFormat(MultipartFile file) {
		  
		  boolean value = true;
		  String fileName = file.getOriginalFilename();
		  String fileExtn = getFileExtension(fileName.trim());
		  
		  try {
			  
			  logger.info("file.getContentType()-->" + file.getContentType());
			  logger.info("fileExtn -->" + fileExtn);
			  
			  //allowed formats gif', 'png','txt' ,'jpg', 'jpeg', 'pdf', 'xlsx', 'xls', 'docx', 'doc'
			  
			  if((fileExtn.equalsIgnoreCase(".gif") )||(fileExtn.equalsIgnoreCase(".png") )
			   ||(fileExtn.equalsIgnoreCase(".txt") )||(fileExtn.equalsIgnoreCase(".jpg") )
			   ||(fileExtn.equalsIgnoreCase(".jpeg") )||(fileExtn.equalsIgnoreCase(".pdf") )
			   ||(fileExtn.equalsIgnoreCase(".xlsx") )||(fileExtn.equalsIgnoreCase(".xls") )
			   ||(fileExtn.equalsIgnoreCase(".docx") )||(fileExtn.equalsIgnoreCase(".doc") )
			   ){
				  
				  value=false;
			  }
		  }
		  catch (Exception e) {
		    e.printStackTrace();
		  }
		return value;
		
	
	}
	
	
	public boolean isFileNameContainsSpecialCharacters(String fileName) {
		  
		  boolean value = false;
		  try {
			  
			  logger.info("fileName-->" + fileName);
			  String specialCharacters = "!`@#$%^&*+=[]\\\';{}|\":<>?~";
			  for(int cnt=0;cnt<fileName.length();cnt++) {
			  
				  if(specialCharacters.contains(Character.toString(fileName.charAt(cnt)))){
					  
					  value=true;
				  }
			  
			  }
		  }
		  catch (Exception e) {
		    e.printStackTrace();
		  }
		return value;
		
	
	}
	
	public boolean isFieldValidDoubleQuotes(String fieldData) {
		  
		  boolean value = true;
		  try {
			  
			  logger.info("fieldData-->" + fieldData);
			  String specialCharacters = "<>\"";
			  for(int cnt=0;cnt<fieldData.length();cnt++) {
			  
				  if(specialCharacters.contains(Character.toString(fieldData.charAt(cnt)))){
					  
					  value=false;
				  }
			  
			  }
		  }
		  catch (Exception e) {
		    e.printStackTrace();
		  }
		return value;
		
	
	}
	
	public Date addMonthInDate(Date inputDate, int months) {		
		
		Calendar cal = Calendar.getInstance();
    	cal.setTime(inputDate);
    	cal.add(Calendar.MONTH, months);
    	Date outputDate = cal.getTime();
		return outputDate;
	}	

}
