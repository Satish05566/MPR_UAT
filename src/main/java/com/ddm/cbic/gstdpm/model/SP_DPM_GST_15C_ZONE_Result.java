package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_15C_ZONE_Result {
	
	private String AMND;
	private String TOTAL_COMM;
	private String COMPLETE_COMM;
	private String ZONE_CODE;
	private String PERSONAL_HEARING_GRANTED_NO_GSTIN;
	private String NOTIME_LEFT_FOR_REJECTION_NO_GSTIN;
	private String TAXES_OR_DUES_UNPAID_NO_GSTIN;
	private String TECHNICAL_ISSUES_NO_GSTIN;
	private String OTHERS_SPECIFY;
	private String OTHERS_NO_GSTIN;

	


	public String getAMND() {
		return AMND;
	}


	public void setAMND(String aMND) {
		AMND = aMND;
	}


	public String getTOTAL_COMM() {
		return TOTAL_COMM;
	}


	public void setTOTAL_COMM(String tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}


	public String getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}


	public void setCOMPLETE_COMM(String cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
	}


	public String getZONE_CODE() {
		return ZONE_CODE;
	}


	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}


	public String getPERSONAL_HEARING_GRANTED_NO_GSTIN() {
		return PERSONAL_HEARING_GRANTED_NO_GSTIN;
	}


	public void setPERSONAL_HEARING_GRANTED_NO_GSTIN(String pERSONAL_HEARING_GRANTED_NO_GSTIN) {
		PERSONAL_HEARING_GRANTED_NO_GSTIN = pERSONAL_HEARING_GRANTED_NO_GSTIN;
	}


	public String getNOTIME_LEFT_FOR_REJECTION_NO_GSTIN() {
		return NOTIME_LEFT_FOR_REJECTION_NO_GSTIN;
	}


	public void setNOTIME_LEFT_FOR_REJECTION_NO_GSTIN(String nOTIME_LEFT_FOR_REJECTION_NO_GSTIN) {
		NOTIME_LEFT_FOR_REJECTION_NO_GSTIN = nOTIME_LEFT_FOR_REJECTION_NO_GSTIN;
	}


	public String getTAXES_OR_DUES_UNPAID_NO_GSTIN() {
		return TAXES_OR_DUES_UNPAID_NO_GSTIN;
	}


	public void setTAXES_OR_DUES_UNPAID_NO_GSTIN(String tAXES_OR_DUES_UNPAID_NO_GSTIN) {
		TAXES_OR_DUES_UNPAID_NO_GSTIN = tAXES_OR_DUES_UNPAID_NO_GSTIN;
	}


	public String getTECHNICAL_ISSUES_NO_GSTIN() {
		return TECHNICAL_ISSUES_NO_GSTIN;
	}


	public void setTECHNICAL_ISSUES_NO_GSTIN(String tECHNICAL_ISSUES_NO_GSTIN) {
		TECHNICAL_ISSUES_NO_GSTIN = tECHNICAL_ISSUES_NO_GSTIN;
	}

	
	public String getOTHERS_SPECIFY() {
		return OTHERS_SPECIFY;
	}


	public void setOTHERS_SPECIFY(String oTHERS_SPECIFY) {
		OTHERS_SPECIFY = oTHERS_SPECIFY;
	}


	public String getOTHERS_NO_GSTIN() {
		return OTHERS_NO_GSTIN;
	}


	public void setOTHERS_NO_GSTIN(String oTHERS_NO_GSTIN) {
		OTHERS_NO_GSTIN = oTHERS_NO_GSTIN;
	}


	public SP_DPM_GST_15C_ZONE_Result generateZoneResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_15C_ZONE_Result> list =  new ArrayList<SP_DPM_GST_15C_ZONE_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_15C_ZONE_Result temp = new SP_DPM_GST_15C_ZONE_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_15C_ZONE_Result generateReportBean(Object[] objectArray) {

		 SP_DPM_GST_15C_ZONE_Result temp =  new SP_DPM_GST_15C_ZONE_Result();	
			
			if(null != objectArray[0]){temp.setTOTAL_COMM(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setAMND(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setCOMPLETE_COMM(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setZONE_CODE(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setPERSONAL_HEARING_GRANTED_NO_GSTIN(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setNOTIME_LEFT_FOR_REJECTION_NO_GSTIN(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setTAXES_OR_DUES_UNPAID_NO_GSTIN(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]){temp.setTECHNICAL_ISSUES_NO_GSTIN(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setOTHERS_NO_GSTIN(String.valueOf(objectArray[8]));}
			temp.setOTHERS_SPECIFY("");
			
			
	return temp;
	

	
	 }
	 

}
