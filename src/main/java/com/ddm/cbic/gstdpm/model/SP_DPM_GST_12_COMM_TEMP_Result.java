package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_12_COMM_TEMP_Result {
	 
	private String COMM_CODE;
	private String MM_YYYY;
	private String SR_NO;
	private String NO_TAXPAYER_FOR_MONTH;
	private String NEW_TAXPAYER_FOR_MONTH;
	private String MIGRATION_TAXPAYER_FROM;
	private String MIGRATION_TAXPAYER_TO;
	private String SUO_MOTO;
	private String ON_REQUEST;
	private String REVOCATION;
	
	
	
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


	public String getSR_NO() {
		return SR_NO;
	}


	public void setSR_NO(String sR_NO) {
		SR_NO = sR_NO;
	}


	public String getNO_TAXPAYER_FOR_MONTH() {
		return NO_TAXPAYER_FOR_MONTH;
	}


	public void setNO_TAXPAYER_FOR_MONTH(String nO_TAXPAYER_FOR_MONTH) {
		NO_TAXPAYER_FOR_MONTH = nO_TAXPAYER_FOR_MONTH;
	}


	public String getNEW_TAXPAYER_FOR_MONTH() {
		return NEW_TAXPAYER_FOR_MONTH;
	}


	public void setNEW_TAXPAYER_FOR_MONTH(String nEW_TAXPAYER_FOR_MONTH) {
		NEW_TAXPAYER_FOR_MONTH = nEW_TAXPAYER_FOR_MONTH;
	}


	public String getMIGRATION_TAXPAYER_FROM() {
		return MIGRATION_TAXPAYER_FROM;
	}


	public void setMIGRATION_TAXPAYER_FROM(String mIGRATION_TAXPAYER_FROM) {
		MIGRATION_TAXPAYER_FROM = mIGRATION_TAXPAYER_FROM;
	}


	public String getMIGRATION_TAXPAYER_TO() {
		return MIGRATION_TAXPAYER_TO;
	}


	public void setMIGRATION_TAXPAYER_TO(String mIGRATION_TAXPAYER_TO) {
		MIGRATION_TAXPAYER_TO = mIGRATION_TAXPAYER_TO;
	}


	public String getSUO_MOTO() {
		return SUO_MOTO;
	}


	public void setSUO_MOTO(String sUO_MOTO) {
		SUO_MOTO = sUO_MOTO;
	}


	public String getON_REQUEST() {
		return ON_REQUEST;
	}


	public void setON_REQUEST(String oN_REQUEST) {
		ON_REQUEST = oN_REQUEST;
	}


	public String getREVOCATION() {
		return REVOCATION;
	}


	public void setREVOCATION(String rEVOCATION) {
		REVOCATION = rEVOCATION;
	}




	public List<SP_DPM_GST_12_COMM_TEMP_Result>  generateAllResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_DPM_GST_12_COMM_TEMP_Result> list =  new ArrayList<SP_DPM_GST_12_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_12_COMM_TEMP_Result temp = new SP_DPM_GST_12_COMM_TEMP_Result ();
			
		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list;
		}
	}
	
	
	 private SP_DPM_GST_12_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_12_COMM_TEMP_Result temp =  new SP_DPM_GST_12_COMM_TEMP_Result();
			
			if(null != objectArray[0]) {temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]) {temp.setSR_NO(String.valueOf(objectArray[2]));}
			
			if(null != objectArray[3]) {temp.setNO_TAXPAYER_FOR_MONTH(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]) {temp.setNEW_TAXPAYER_FOR_MONTH(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]) {temp.setMIGRATION_TAXPAYER_FROM(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]) {temp.setMIGRATION_TAXPAYER_TO(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]) {temp.setSUO_MOTO(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]) {temp.setON_REQUEST(String.valueOf(objectArray[8]));}
			if(null != objectArray[9]) {temp.setREVOCATION(String.valueOf(objectArray[9]));}
			
				
   return temp;
	
	 }
	
	
	
	
	
	
	

}
