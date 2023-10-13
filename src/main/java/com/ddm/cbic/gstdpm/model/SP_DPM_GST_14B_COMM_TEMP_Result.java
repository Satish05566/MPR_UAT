package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_DPM_GST_14B_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+",message="Must be integer")
	private String RECEIVED_FROM_OTHER_CPC;
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+",message="Must be integer")
	private String PV_REPORT_NOT_RECEIVED;
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+",message="Must be integer")
	private String OFFICER_FAILED_TO_PROCESS_ARN;
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+",message="Must be integer")
	private String OTHERS;
	
	
	

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




	public SP_DPM_GST_14B_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_14B_COMM_TEMP_Result> list =  new ArrayList<SP_DPM_GST_14B_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_14B_COMM_TEMP_Result temp = new SP_DPM_GST_14B_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_14B_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_14B_COMM_TEMP_Result temp =  new SP_DPM_GST_14B_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setRECEIVED_FROM_OTHER_CPC(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setPV_REPORT_NOT_RECEIVED(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setOFFICER_FAILED_TO_PROCESS_ARN(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setOTHERS(String.valueOf(objectArray[5]));}
			
	return temp;
	
	 }
	 
}
