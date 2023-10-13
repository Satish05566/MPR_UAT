package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_14A_REGION_Result {

	public SP_DPM_GST_14A_REGION_Result generateRegionResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_14A_REGION_Result> list =  new ArrayList<SP_DPM_GST_14A_REGION_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_14A_REGION_Result temp = new SP_DPM_GST_14A_REGION_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_14A_REGION_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_14A_REGION_Result temp =  new SP_DPM_GST_14A_REGION_Result();	
			
		
			
	return temp;
	
	 }
	 
}
