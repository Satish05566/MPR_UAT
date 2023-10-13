package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_15A_ZONE_Result {
	
	private int AMND;
	private int TOTAL_COMM;
	private int COMPLETE_COMM;
	private String ZONE_CODE;
	private String SUO_MOTO_OPENING_BALANCE;
	private String SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION;
	private String SUO_MOTO_GSTIN_CANCELLED;
	private String SUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION;
	private String CANCELLATION_OPENING_BALANCE;
	private String CANCELLATION_NO_APPLICATION_RECEIVED;
	private String CANCELLATION_GSTIN_CANCELLED;
	private String CANCELLATION_GSTIN_PENDING_FOR_CANCELLATION;
	private String TOTAL_PENDENCY;
	private String REVOCATION_OPENING_BALANCE;
	private String REVOCATION_ARN_RECEIVED;
	private String REVOCATION_GSTIN_REVOKED;
	private String REVOCATION_APPLICATION_REJECTED;
	private String REVOCATION_NO_ARN_PENDING;

	public int getAMND() {
		return AMND;
	}


	public void setAMND(int aMND) {
		AMND = aMND;
	}


	public int getTOTAL_COMM() {
		return TOTAL_COMM;
	}


	public void setTOTAL_COMM(int tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}


	public int getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}


	public void setCOMPLETE_COMM(int cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
	}


	public String getZONE_CODE() {
		return ZONE_CODE;
	}


	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}


	public String getSUO_MOTO_OPENING_BALANCE() {
		return SUO_MOTO_OPENING_BALANCE;
	}


	public void setSUO_MOTO_OPENING_BALANCE(String sUO_MOTO_OPENING_BALANCE) {
		SUO_MOTO_OPENING_BALANCE = sUO_MOTO_OPENING_BALANCE;
	}


	public String getSUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION() {
		return SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION;
	}


	public void setSUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION(String sUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION) {
		SUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION = sUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION;
	}


	public String getSUO_MOTO_GSTIN_CANCELLED() {
		return SUO_MOTO_GSTIN_CANCELLED;
	}


	public void setSUO_MOTO_GSTIN_CANCELLED(String sUO_MOTO_GSTIN_CANCELLED) {
		SUO_MOTO_GSTIN_CANCELLED = sUO_MOTO_GSTIN_CANCELLED;
	}


	public String getSUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION() {
		return SUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION;
	}


	public void setSUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION(String sUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION) {
		SUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION = sUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION;
	}


	public String getCANCELLATION_OPENING_BALANCE() {
		return CANCELLATION_OPENING_BALANCE;
	}


	public void setCANCELLATION_OPENING_BALANCE(String cANCELLATION_OPENING_BALANCE) {
		CANCELLATION_OPENING_BALANCE = cANCELLATION_OPENING_BALANCE;
	}


	public String getCANCELLATION_NO_APPLICATION_RECEIVED() {
		return CANCELLATION_NO_APPLICATION_RECEIVED;
	}


	public void setCANCELLATION_NO_APPLICATION_RECEIVED(String cANCELLATION_NO_APPLICATION_RECEIVED) {
		CANCELLATION_NO_APPLICATION_RECEIVED = cANCELLATION_NO_APPLICATION_RECEIVED;
	}


	public String getCANCELLATION_GSTIN_CANCELLED() {
		return CANCELLATION_GSTIN_CANCELLED;
	}


	public void setCANCELLATION_GSTIN_CANCELLED(String cANCELLATION_GSTIN_CANCELLED) {
		CANCELLATION_GSTIN_CANCELLED = cANCELLATION_GSTIN_CANCELLED;
	}


	public String getCANCELLATION_GSTIN_PENDING_FOR_CANCELLATION() {
		return CANCELLATION_GSTIN_PENDING_FOR_CANCELLATION;
	}


	public void setCANCELLATION_GSTIN_PENDING_FOR_CANCELLATION(String cANCELLATION_GSTIN_PENDING_FOR_CANCELLATION) {
		CANCELLATION_GSTIN_PENDING_FOR_CANCELLATION = cANCELLATION_GSTIN_PENDING_FOR_CANCELLATION;
	}


	public String getTOTAL_PENDENCY() {
		return TOTAL_PENDENCY;
	}


	public void setTOTAL_PENDENCY(String tOTAL_PENDENCY) {
		TOTAL_PENDENCY = tOTAL_PENDENCY;
	}


	public String getREVOCATION_OPENING_BALANCE() {
		return REVOCATION_OPENING_BALANCE;
	}


	public void setREVOCATION_OPENING_BALANCE(String rEVOCATION_OPENING_BALANCE) {
		REVOCATION_OPENING_BALANCE = rEVOCATION_OPENING_BALANCE;
	}


	public String getREVOCATION_ARN_RECEIVED() {
		return REVOCATION_ARN_RECEIVED;
	}


	public void setREVOCATION_ARN_RECEIVED(String rEVOCATION_ARN_RECEIVED) {
		REVOCATION_ARN_RECEIVED = rEVOCATION_ARN_RECEIVED;
	}


	public String getREVOCATION_GSTIN_REVOKED() {
		return REVOCATION_GSTIN_REVOKED;
	}


	public void setREVOCATION_GSTIN_REVOKED(String rEVOCATION_GSTIN_REVOKED) {
		REVOCATION_GSTIN_REVOKED = rEVOCATION_GSTIN_REVOKED;
	}


	public String getREVOCATION_APPLICATION_REJECTED() {
		return REVOCATION_APPLICATION_REJECTED;
	}


	public void setREVOCATION_APPLICATION_REJECTED(String rEVOCATION_APPLICATION_REJECTED) {
		REVOCATION_APPLICATION_REJECTED = rEVOCATION_APPLICATION_REJECTED;
	}


	public String getREVOCATION_NO_ARN_PENDING() {
		return REVOCATION_NO_ARN_PENDING;
	}


	public void setREVOCATION_NO_ARN_PENDING(String rEVOCATION_NO_ARN_PENDING) {
		REVOCATION_NO_ARN_PENDING = rEVOCATION_NO_ARN_PENDING;
	}


	public SP_DPM_GST_15A_ZONE_Result generateZoneResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_15A_ZONE_Result> list =  new ArrayList<SP_DPM_GST_15A_ZONE_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_15A_ZONE_Result temp = new SP_DPM_GST_15A_ZONE_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_15A_ZONE_Result generateReportBean(Object[] objectArray) {

		 SP_DPM_GST_15A_ZONE_Result temp =  new SP_DPM_GST_15A_ZONE_Result();	
			
		    if(null != objectArray[0]){temp.setAMND((int)objectArray[0]);}
			if(null != objectArray[1]){temp.setTOTAL_COMM((int)objectArray[1]);}			
			if(null != objectArray[2]){temp.setCOMPLETE_COMM((int)objectArray[2]);}
			if(null != objectArray[3]){temp.setZONE_CODE(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setSUO_MOTO_OPENING_BALANCE(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setSUO_MOTO_GSTIN_LIABLE_FOR_CANCELLATION(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setSUO_MOTO_GSTIN_CANCELLED(String.valueOf(objectArray[6]));}
			
			if(null != objectArray[7]){temp.setSUO_MOTO_GSTIN_PENDING_FOR_CANCELLATION(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setCANCELLATION_OPENING_BALANCE(String.valueOf(objectArray[8]));}
			if(null != objectArray[9]){temp.setCANCELLATION_NO_APPLICATION_RECEIVED(String.valueOf(objectArray[9]));}
			if(null != objectArray[10]){temp.setCANCELLATION_GSTIN_CANCELLED(String.valueOf(objectArray[10]));}
			if(null != objectArray[11]){temp.setCANCELLATION_GSTIN_PENDING_FOR_CANCELLATION(String.valueOf(objectArray[11]));}
			if(null != objectArray[12]){temp.setTOTAL_PENDENCY(String.valueOf(objectArray[12]));}
			if(null != objectArray[13]){temp.setREVOCATION_OPENING_BALANCE(String.valueOf(objectArray[13]));}
			
			if(null != objectArray[14]){temp.setREVOCATION_ARN_RECEIVED(String.valueOf(objectArray[14]));}
			if(null != objectArray[15]){temp.setREVOCATION_GSTIN_REVOKED(String.valueOf(objectArray[15]));}
			if(null != objectArray[16]){temp.setREVOCATION_APPLICATION_REJECTED(String.valueOf(objectArray[16]));}
			if(null != objectArray[17]){temp.setREVOCATION_NO_ARN_PENDING(String.valueOf(objectArray[17]));}
			
			
			
	return temp;
	

	
	 }
	 

}
