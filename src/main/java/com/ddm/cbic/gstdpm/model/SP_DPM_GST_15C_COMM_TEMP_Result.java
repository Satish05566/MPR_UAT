package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_DPM_GST_15C_COMM_TEMP_Result {
	
	@Pattern(regexp="[0-9]+",message="Must be integer")
    @NotEmpty(message="*")
	private String PERSONAL_HEARING_GRANTED_NO_GSTIN;
	@Pattern(regexp="[0-9]+",message="Must be integer")
    @NotEmpty(message="*")
	private String NOTIME_LEFT_FOR_REJECTION_NO_GSTIN;
	@Pattern(regexp="[0-9]+",message="Must be integer")
    @NotEmpty(message="*")
	private String TAXES_OR_DUES_UNPAID_NO_GSTIN;
	@Pattern(regexp="[0-9]+",message="Must be integer")
    @NotEmpty(message="*")
	private String TECHNICAL_ISSUES_NO_GSTIN;
	@NotEmpty(message = "*")
	@Pattern(regexp = "^[a-zA-Z0-9. ()/,-]+$", message = "Only ()./,'- special characters are allowed.!")
	private String OTHERS_SPECIFY;
	@Pattern(regexp="[0-9]+",message="Must be integer")
    @NotEmpty(message="*")
	private String OTHERS_NO_GSTIN;

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


	public SP_DPM_GST_15C_COMM_TEMP_Result generateCommTempResult(List<Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_15C_COMM_TEMP_Result> list =  new ArrayList<SP_DPM_GST_15C_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_15C_COMM_TEMP_Result temp = new SP_DPM_GST_15C_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_15C_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

		 SP_DPM_GST_15C_COMM_TEMP_Result temp =  new SP_DPM_GST_15C_COMM_TEMP_Result();
			
			if(null != objectArray[0]){temp.setPERSONAL_HEARING_GRANTED_NO_GSTIN(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setNOTIME_LEFT_FOR_REJECTION_NO_GSTIN(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setTAXES_OR_DUES_UNPAID_NO_GSTIN(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setTECHNICAL_ISSUES_NO_GSTIN(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setOTHERS_SPECIFY(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setOTHERS_NO_GSTIN(String.valueOf(objectArray[5]));}
			
			
			
	return temp;
	
	 }
	 

}
