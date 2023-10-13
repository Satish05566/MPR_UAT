package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_LIST_GST_DIV_Result {
	String DIV_CODE ;
	 String DIV_NAME ;

	public void setDIV_CODE(String DIV_CODE) {
		this.DIV_CODE=DIV_CODE;
	}

	public String getDIV_CODE() {
		return DIV_CODE;
	}


	public void setDIV_NAME(String DIV_NAME) {
		this.DIV_NAME=DIV_NAME;
	}

	public String getDIV_NAME() {
		return DIV_NAME;
	}

	public  List<SP_LIST_GST_DIV_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_LIST_GST_DIV_Result> list =  new ArrayList<SP_LIST_GST_DIV_Result>();
		for(Object [] objArray : listObjectArray) { 
		SP_LIST_GST_DIV_Result temp = new SP_LIST_GST_DIV_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_LIST_GST_DIV_Result generateResultBean(Object [] objectArray) {
		SP_LIST_GST_DIV_Result temp =  new SP_LIST_GST_DIV_Result();
		temp.setDIV_CODE((String)( objectArray[0]));
		temp.setDIV_NAME((String)( objectArray[1]));
		return temp;
	}

	public  List<String>  generateResultBeanLabels() {
		List <String> listLabels =  new ArrayList<String>();
		listLabels.add("DIV_CODE");
		listLabels.add("DIV_NAME");
		return listLabels;
	}

	}
