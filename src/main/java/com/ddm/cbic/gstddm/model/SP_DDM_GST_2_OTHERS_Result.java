package com.ddm.cbic.gstddm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DDM_GST_2_OTHERS_Result {
	
	private String OTHERS;
	private String OTHERS_VALUE;
	public String getOTHERS() {
		return OTHERS;
	}
	public void setOTHERS(String oTHERS) {
		OTHERS = oTHERS;
	}
	public String getOTHERS_VALUE() {
		return OTHERS_VALUE;
	}
	public void setOTHERS_VALUE(String oTHERS_VALUE) {
		OTHERS_VALUE = oTHERS_VALUE;
	}
	
	
	
	public List<SP_DDM_GST_2_OTHERS_Result> generateOthersResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DDM_GST_2_OTHERS_Result> list =  new ArrayList<SP_DDM_GST_2_OTHERS_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DDM_GST_2_OTHERS_Result temp = new SP_DDM_GST_2_OTHERS_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list;
		}
	}
	
	
	 private SP_DDM_GST_2_OTHERS_Result generateReportBean(Object[] objectArray) {

			SP_DDM_GST_2_OTHERS_Result temp =  new SP_DDM_GST_2_OTHERS_Result();	
			
			if(null != objectArray[0]){temp.setOTHERS(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setOTHERS_VALUE(String.valueOf(objectArray[1]));}
			
			
	return temp;
	
	 }
	

}
