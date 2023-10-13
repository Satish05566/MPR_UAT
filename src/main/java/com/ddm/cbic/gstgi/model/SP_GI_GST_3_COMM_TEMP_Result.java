package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_GI_GST_3_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	
	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String REWARD_DEPARTMENTAL_NO;

	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REWARD_DEPARTMENTAL_AMT;

	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String REWARD_INFORMER_NO;

	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REWARD_INFORMER_AMT;

	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String DISBURSED_DEPARTMENTAL_NO;

	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DISBURSED_DEPARTMENTAL_AMT;

	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String DISBURSED_INFORMER_NO;

	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DISBURSED_INFORMER_AMT;

	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String PENDING_DEPARTMENTAL_NO;

	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String PENDING_DEPARTMENTAL_AMT;

	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String PENDING_INFORMER_NO;

	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String PENDING_INFORMER_AMT;
	
    
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


	public String getREWARD_DEPARTMENTAL_NO() {
		return REWARD_DEPARTMENTAL_NO;
	}


	public void setREWARD_DEPARTMENTAL_NO(String rEWARD_DEPARTMENTAL_NO) {
		REWARD_DEPARTMENTAL_NO = rEWARD_DEPARTMENTAL_NO;
	}


	public String getREWARD_DEPARTMENTAL_AMT() {
		return REWARD_DEPARTMENTAL_AMT;
	}


	public void setREWARD_DEPARTMENTAL_AMT(String rEWARD_DEPARTMENTAL_AMT) {
		REWARD_DEPARTMENTAL_AMT = rEWARD_DEPARTMENTAL_AMT;
	}


	public String getREWARD_INFORMER_NO() {
		return REWARD_INFORMER_NO;
	}


	public void setREWARD_INFORMER_NO(String rEWARD_INFORMER_NO) {
		REWARD_INFORMER_NO = rEWARD_INFORMER_NO;
	}


	public String getREWARD_INFORMER_AMT() {
		return REWARD_INFORMER_AMT;
	}


	public void setREWARD_INFORMER_AMT(String rEWARD_INFORMER_AMT) {
		REWARD_INFORMER_AMT = rEWARD_INFORMER_AMT;
	}


	public String getDISBURSED_DEPARTMENTAL_NO() {
		return DISBURSED_DEPARTMENTAL_NO;
	}


	public void setDISBURSED_DEPARTMENTAL_NO(String dISBURSED_DEPARTMENTAL_NO) {
		DISBURSED_DEPARTMENTAL_NO = dISBURSED_DEPARTMENTAL_NO;
	}


	public String getDISBURSED_DEPARTMENTAL_AMT() {
		return DISBURSED_DEPARTMENTAL_AMT;
	}


	public void setDISBURSED_DEPARTMENTAL_AMT(String dISBURSED_DEPARTMENTAL_AMT) {
		DISBURSED_DEPARTMENTAL_AMT = dISBURSED_DEPARTMENTAL_AMT;
	}


	public String getDISBURSED_INFORMER_NO() {
		return DISBURSED_INFORMER_NO;
	}


	public void setDISBURSED_INFORMER_NO(String dISBURSED_INFORMER_NO) {
		DISBURSED_INFORMER_NO = dISBURSED_INFORMER_NO;
	}


	public String getDISBURSED_INFORMER_AMT() {
		return DISBURSED_INFORMER_AMT;
	}


	public void setDISBURSED_INFORMER_AMT(String dISBURSED_INFORMER_AMT) {
		DISBURSED_INFORMER_AMT = dISBURSED_INFORMER_AMT;
	}


	public String getPENDING_DEPARTMENTAL_NO() {
		return PENDING_DEPARTMENTAL_NO;
	}


	public void setPENDING_DEPARTMENTAL_NO(String pENDING_DEPARTMENTAL_NO) {
		PENDING_DEPARTMENTAL_NO = pENDING_DEPARTMENTAL_NO;
	}


	public String getPENDING_DEPARTMENTAL_AMT() {
		return PENDING_DEPARTMENTAL_AMT;
	}


	public void setPENDING_DEPARTMENTAL_AMT(String pENDING_DEPARTMENTAL_AMT) {
		PENDING_DEPARTMENTAL_AMT = pENDING_DEPARTMENTAL_AMT;
	}


	public String getPENDING_INFORMER_NO() {
		return PENDING_INFORMER_NO;
	}


	public void setPENDING_INFORMER_NO(String pENDING_INFORMER_NO) {
		PENDING_INFORMER_NO = pENDING_INFORMER_NO;
	}


	public String getPENDING_INFORMER_AMT() {
		return PENDING_INFORMER_AMT;
	}


	public void setPENDING_INFORMER_AMT(String pENDING_INFORMER_AMT) {
		PENDING_INFORMER_AMT = pENDING_INFORMER_AMT;
	}


	public SP_GI_GST_3_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_GI_GST_3_COMM_TEMP_Result> list =  new ArrayList<SP_GI_GST_3_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_GI_GST_3_COMM_TEMP_Result temp = new SP_GI_GST_3_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_GI_GST_3_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_GI_GST_3_COMM_TEMP_Result temp =  new SP_GI_GST_3_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			
			if(null != objectArray[2]){temp.setREWARD_DEPARTMENTAL_NO(String.valueOf(objectArray[2]));}	
			if(null != objectArray[3]){temp.setREWARD_DEPARTMENTAL_AMT (String.valueOf(objectArray[3]));}	
			if(null != objectArray[4]){temp.setREWARD_INFORMER_NO(String.valueOf(objectArray[4]));}	
			if(null != objectArray[5]){temp.setREWARD_INFORMER_AMT(String.valueOf(objectArray[5]));}	
			if(null != objectArray[6]){temp.setDISBURSED_DEPARTMENTAL_NO (String.valueOf(objectArray[6]));}	
			if(null != objectArray[7]){temp.setDISBURSED_DEPARTMENTAL_AMT(String.valueOf(objectArray[7]));}	
			if(null != objectArray[8]){temp.setDISBURSED_INFORMER_NO(String.valueOf(objectArray[8]));}	
			if(null != objectArray[9]){temp.setDISBURSED_INFORMER_AMT(String.valueOf(objectArray[9]));}	
			if(null != objectArray[10]){temp.setPENDING_DEPARTMENTAL_NO(String.valueOf(objectArray[10]));}	
			if(null != objectArray[11]){temp.setPENDING_DEPARTMENTAL_AMT(String.valueOf(objectArray[11]));}	
			if(null != objectArray[12]){temp.setPENDING_INFORMER_NO(String.valueOf(objectArray[12]));}	
			if(null != objectArray[13]){temp.setPENDING_INFORMER_AMT(String.valueOf(objectArray[13]));}	

			return temp;
	 }
}
