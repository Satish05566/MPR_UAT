package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

public class SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result {
	
	String HSN_SAC_CODE;
    String HSN_SAC_CODE_DESCRIPTION;
    String TYPE;
	

	public String getHSN_SAC_CODE() {
		return HSN_SAC_CODE;
	}

	public void setHSN_SAC_CODE(String hSN_SAC_CODE) {
		HSN_SAC_CODE = hSN_SAC_CODE;
	}

	public String getHSN_SAC_CODE_DESCRIPTION() {
		return HSN_SAC_CODE_DESCRIPTION;
	}

	public void setHSN_SAC_CODE_DESCRIPTION(String hSN_SAC_CODE_DESCRIPTION) {
		HSN_SAC_CODE_DESCRIPTION = hSN_SAC_CODE_DESCRIPTION;
	}

	public String getTYPE() {
		return TYPE;
	}

	public void setTYPE(String tYPE) {
		TYPE = tYPE;
	}

	public  List<SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result> list =  new ArrayList<SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result>();
		for(Object [] objArray : listObjectArray) { 
			SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result temp = new SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result generateResultBean(Object [] objectArray) {
		SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result temp =  new SP_GI_GST_6_HSN_SAC_MASTER_LIST_Result();
		
		
		temp.setHSN_SAC_CODE(String.valueOf(objectArray[0]));
		temp.setHSN_SAC_CODE_DESCRIPTION(String.valueOf(objectArray[1]));
		temp.setTYPE(String.valueOf(objectArray[2]));
		return temp;
	}	

}
