package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_LIST_REGION_Result {
	
	String REGION_NAME ;
	String REGION_CODE ;

	public void setREGION_NAME(String REGION_NAME) {
		this.REGION_NAME=REGION_NAME;
	}

	public String getREGION_NAME() {
		return REGION_NAME;
	}


	public void setREGION_CODE(String REGION_CODE) {
		this.REGION_CODE=REGION_CODE;
	}

	public String getREGION_CODE() {
		return REGION_CODE;
	}

	public  List<SP_LIST_REGION_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_LIST_REGION_Result> list =  new ArrayList<SP_LIST_REGION_Result>();
		for(Object [] objArray : listObjectArray) { 
		SP_LIST_REGION_Result temp = new SP_LIST_REGION_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_LIST_REGION_Result generateResultBean(Object [] objectArray) {
		SP_LIST_REGION_Result temp =  new SP_LIST_REGION_Result();
		temp.setREGION_NAME((String)( objectArray[1]));
		temp.setREGION_CODE((String)( objectArray[0]));
		return temp;
	}

	
}
