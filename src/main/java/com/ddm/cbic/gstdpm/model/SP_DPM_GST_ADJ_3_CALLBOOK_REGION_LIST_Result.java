package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result {
	 
	
	String ID, REGION_NAME,ADC_OPENING_NO,ADC_OPENING_AMT,DC_OPENING_NO,DC_OPENING_AMT;
    String SUP_OPENING_NO,SUP_OPENING_AMT,ISEXISTDATA;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getREGION_NAME() {
		return REGION_NAME;
	}

	public void setREGION_NAME(String rEGION_NAME) {
		REGION_NAME = rEGION_NAME;
	}

	public String getADC_OPENING_NO() {
		return ADC_OPENING_NO;
	}

	public void setADC_OPENING_NO(String aDC_OPENING_NO) {
		ADC_OPENING_NO = aDC_OPENING_NO;
	}

	public String getADC_OPENING_AMT() {
		return ADC_OPENING_AMT;
	}

	public void setADC_OPENING_AMT(String aDC_OPENING_AMT) {
		ADC_OPENING_AMT = aDC_OPENING_AMT;
	}

	public String getDC_OPENING_NO() {
		return DC_OPENING_NO;
	}

	public void setDC_OPENING_NO(String dC_OPENING_NO) {
		DC_OPENING_NO = dC_OPENING_NO;
	}

	public String getDC_OPENING_AMT() {
		return DC_OPENING_AMT;
	}

	public void setDC_OPENING_AMT(String dC_OPENING_AMT) {
		DC_OPENING_AMT = dC_OPENING_AMT;
	}

	public String getSUP_OPENING_NO() {
		return SUP_OPENING_NO;
	}

	public void setSUP_OPENING_NO(String sUP_OPENING_NO) {
		SUP_OPENING_NO = sUP_OPENING_NO;
	}

	public String getSUP_OPENING_AMT() {
		return SUP_OPENING_AMT;
	}

	public void setSUP_OPENING_AMT(String sUP_OPENING_AMT) {
		SUP_OPENING_AMT = sUP_OPENING_AMT;
	}

	public  List<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result> list =  new ArrayList<SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result>();
		for(Object [] objArray : listObjectArray) { 
			SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result temp = new SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result generateResultBean(Object [] objectArray) {
		SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result temp =  new SP_DPM_GST_ADJ_3_CALLBOOK_REGION_LIST_Result();
		
		
		temp.setID(String.valueOf(objectArray[0]));
		temp.setREGION_NAME(String.valueOf(objectArray[1]));
		temp.setADC_OPENING_NO(String.valueOf(objectArray[2]));
		temp.setADC_OPENING_AMT(String.valueOf(objectArray[3]));
		temp.setDC_OPENING_NO(String.valueOf(objectArray[4]));
		temp.setDC_OPENING_AMT(String.valueOf(objectArray[5]));
		temp.setSUP_OPENING_NO(String.valueOf(objectArray[6]));
		temp.setSUP_OPENING_AMT(String.valueOf(objectArray[7]));
		temp.setISEXISTDATA(String.valueOf(objectArray[8]));
		return temp;
	}

	public String getISEXISTDATA() {
		return ISEXISTDATA;
	}

	public void setISEXISTDATA(String iSEXISTDATA) {
		ISEXISTDATA = iSEXISTDATA;
	}	

}
