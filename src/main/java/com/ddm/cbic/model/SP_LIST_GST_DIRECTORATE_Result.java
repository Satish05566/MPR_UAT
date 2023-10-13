package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_LIST_GST_DIRECTORATE_Result {
	String ID ;
	 String DIR_CODE ;
	 String DIR_NAME ;
	 
	 
	
	 
	 
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDIR_CODE() {
		return DIR_CODE;
	}

	public void setDIR_CODE(String dIR_CODE) {
		DIR_CODE = dIR_CODE;
	}

	public String getDIR_NAME() {
		return DIR_NAME;
	}

	public void setDIR_NAME(String dIR_NAME) {
		DIR_NAME = dIR_NAME;
	}

	public  List<SP_LIST_GST_DIRECTORATE_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_LIST_GST_DIRECTORATE_Result> list =  new ArrayList<SP_LIST_GST_DIRECTORATE_Result>();
		for(Object [] objArray : listObjectArray) { 
		SP_LIST_GST_DIRECTORATE_Result temp = new SP_LIST_GST_DIRECTORATE_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_LIST_GST_DIRECTORATE_Result generateResultBean(Object [] objectArray) {
		SP_LIST_GST_DIRECTORATE_Result temp =  new SP_LIST_GST_DIRECTORATE_Result();
		temp.setID((String)( objectArray[0]));
		temp.setDIR_CODE((String)( objectArray[1]));
		temp.setDIR_NAME((String)( objectArray[2]));
		return temp;
	}

	
	}

