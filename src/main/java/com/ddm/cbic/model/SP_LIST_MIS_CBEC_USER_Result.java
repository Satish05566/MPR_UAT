package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_LIST_MIS_CBEC_USER_Result {
	String ID ;
	 String NAME ;
	 
	 
	
	 
	 
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public  List<SP_LIST_MIS_CBEC_USER_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_LIST_MIS_CBEC_USER_Result> list =  new ArrayList<SP_LIST_MIS_CBEC_USER_Result>();
		for(Object [] objArray : listObjectArray) { 
			SP_LIST_MIS_CBEC_USER_Result temp = new SP_LIST_MIS_CBEC_USER_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_LIST_MIS_CBEC_USER_Result generateResultBean(Object [] objectArray) {
		SP_LIST_MIS_CBEC_USER_Result temp =  new SP_LIST_MIS_CBEC_USER_Result();
		temp.setID((String)( objectArray[0]));
		temp.setNAME((String)( objectArray[1]));		
		return temp;
	}

	
	}

