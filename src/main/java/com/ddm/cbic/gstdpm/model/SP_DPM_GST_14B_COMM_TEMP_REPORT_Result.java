package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_14B_COMM_TEMP_REPORT_Result {
	
	 private String TOTAL_COMM;
	 private String COMPLETE_COMM;
	 private String AMND;
	 private String COMM_CODE;
	 private String MM_YYYY;
	 private String RECEIVED_FROM_OTHER_CPC;
	 private String PV_REPORT_NOT_RECEIVED;
	 private String OFFICER_FAILED_TO_PROCESS_ARN;
	 private String OTHERS;
	 private String TOTAL;
		
	 
	 

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


	public String getAMND() {
		return AMND;
	}


	public void setAMND(String aMND) {
		AMND = aMND;
	}


	public String getCOMM_CODE() {
		return COMM_CODE;
	}


	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}


	public String getMM_YYYY() {
		return MM_YYYY;
	}


	public void setMM_YYYY(String mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}


	public String getRECEIVED_FROM_OTHER_CPC() {
		return RECEIVED_FROM_OTHER_CPC;
	}


	public void setRECEIVED_FROM_OTHER_CPC(String rECEIVED_FROM_OTHER_CPC) {
		RECEIVED_FROM_OTHER_CPC = rECEIVED_FROM_OTHER_CPC;
	}


	public String getPV_REPORT_NOT_RECEIVED() {
		return PV_REPORT_NOT_RECEIVED;
	}


	public void setPV_REPORT_NOT_RECEIVED(String pV_REPORT_NOT_RECEIVED) {
		PV_REPORT_NOT_RECEIVED = pV_REPORT_NOT_RECEIVED;
	}


	public String getOFFICER_FAILED_TO_PROCESS_ARN() {
		return OFFICER_FAILED_TO_PROCESS_ARN;
	}


	public void setOFFICER_FAILED_TO_PROCESS_ARN(String oFFICER_FAILED_TO_PROCESS_ARN) {
		OFFICER_FAILED_TO_PROCESS_ARN = oFFICER_FAILED_TO_PROCESS_ARN;
	}


	public String getOTHERS() {
		return OTHERS;
	}


	public void setOTHERS(String oTHERS) {
		OTHERS = oTHERS;
	}
	
	public String getTOTAL() {
		return TOTAL;
	}


	public void setTOTAL(String tOTAL) {
		TOTAL = tOTAL;
	}


	public SP_DPM_GST_14B_COMM_TEMP_REPORT_Result generateTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_14B_COMM_TEMP_REPORT_Result> list =  new ArrayList<SP_DPM_GST_14B_COMM_TEMP_REPORT_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_14B_COMM_TEMP_REPORT_Result temp = new SP_DPM_GST_14B_COMM_TEMP_REPORT_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_14B_COMM_TEMP_REPORT_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_14B_COMM_TEMP_REPORT_Result temp =  new SP_DPM_GST_14B_COMM_TEMP_REPORT_Result();	
			
			if(null != objectArray[0]){temp.setTOTAL_COMM(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setAMND(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setCOMPLETE_COMM(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setCOMM_CODE(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setRECEIVED_FROM_OTHER_CPC(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setPV_REPORT_NOT_RECEIVED(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setOFFICER_FAILED_TO_PROCESS_ARN(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]){temp.setOTHERS(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setTOTAL(String.valueOf(objectArray[8]));}
			
			
	return temp;
	
	 }
	 

}
