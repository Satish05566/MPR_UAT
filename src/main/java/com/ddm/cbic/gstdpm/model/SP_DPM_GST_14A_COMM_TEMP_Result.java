package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_14A_COMM_TEMP_Result {
	
	private String S_NO;
	private String COMM_CODE;
	private String MM_YYYY;
	private String OPENING_BALANCE;
	private String NO_OF_ARN_RECEIVED_GSTN;
	private String NO_OF_ARN_RECEIVED_CPC;
	private String DISPOSAL_OF_ARN_WITHIN_7;
	private String DISPOSAL_OF_ARN_PV_RECOMMENDED;
	private String DISPOSAL_OF_ARN_PV_APPROVED;
	private String DISPOSAL_OF_ARN_PV_REJECTED;
	private String DISPOSAL_OF_ARN_PV_NOT_RECEIVED;
	private String DISPOSAL_OF_ARN_TRANSFERED_CPC;
	private String DISPOSAL_OF_ARN_DEEMED_REG;
	private String CLOSING_BALANCE;
	
	

	public String getS_NO() {
		return S_NO;
	}



	public void setS_NO(String s_NO) {
		S_NO = s_NO;
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
	
	public String getOPENING_BALANCE() {
		return OPENING_BALANCE;
	}

	public void setOPENING_BALANCE(String oPENING_BALANCE) {
		OPENING_BALANCE = oPENING_BALANCE;
	}



	

	public String getNO_OF_ARN_RECEIVED_GSTN() {
		return NO_OF_ARN_RECEIVED_GSTN;
	}



	public void setNO_OF_ARN_RECEIVED_GSTN(String nO_OF_ARN_RECEIVED_GSTN) {
		NO_OF_ARN_RECEIVED_GSTN = nO_OF_ARN_RECEIVED_GSTN;
	}



	public String getNO_OF_ARN_RECEIVED_CPC() {
		return NO_OF_ARN_RECEIVED_CPC;
	}



	public void setNO_OF_ARN_RECEIVED_CPC(String nO_OF_ARN_RECEIVED_CPC) {
		NO_OF_ARN_RECEIVED_CPC = nO_OF_ARN_RECEIVED_CPC;
	}



	public String getDISPOSAL_OF_ARN_WITHIN_7() {
		return DISPOSAL_OF_ARN_WITHIN_7;
	}



	public void setDISPOSAL_OF_ARN_WITHIN_7(String dISPOSAL_OF_ARN_WITHIN_7) {
		DISPOSAL_OF_ARN_WITHIN_7 = dISPOSAL_OF_ARN_WITHIN_7;
	}



	public String getDISPOSAL_OF_ARN_PV_RECOMMENDED() {
		return DISPOSAL_OF_ARN_PV_RECOMMENDED;
	}



	public void setDISPOSAL_OF_ARN_PV_RECOMMENDED(String dISPOSAL_OF_ARN_PV_RECOMMENDED) {
		DISPOSAL_OF_ARN_PV_RECOMMENDED = dISPOSAL_OF_ARN_PV_RECOMMENDED;
	}



	public String getDISPOSAL_OF_ARN_PV_APPROVED() {
		return DISPOSAL_OF_ARN_PV_APPROVED;
	}



	public void setDISPOSAL_OF_ARN_PV_APPROVED(String dISPOSAL_OF_ARN_PV_APPROVED) {
		DISPOSAL_OF_ARN_PV_APPROVED = dISPOSAL_OF_ARN_PV_APPROVED;
	}



	public String getDISPOSAL_OF_ARN_PV_REJECTED() {
		return DISPOSAL_OF_ARN_PV_REJECTED;
	}



	public void setDISPOSAL_OF_ARN_PV_REJECTED(String dISPOSAL_OF_ARN_PV_REJECTED) {
		DISPOSAL_OF_ARN_PV_REJECTED = dISPOSAL_OF_ARN_PV_REJECTED;
	}



	public String getDISPOSAL_OF_ARN_PV_NOT_RECEIVED() {
		return DISPOSAL_OF_ARN_PV_NOT_RECEIVED;
	}



	public void setDISPOSAL_OF_ARN_PV_NOT_RECEIVED(String dISPOSAL_OF_ARN_PV_NOT_RECEIVED) {
		DISPOSAL_OF_ARN_PV_NOT_RECEIVED = dISPOSAL_OF_ARN_PV_NOT_RECEIVED;
	}



	public String getDISPOSAL_OF_ARN_TRANSFERED_CPC() {
		return DISPOSAL_OF_ARN_TRANSFERED_CPC;
	}



	public void setDISPOSAL_OF_ARN_TRANSFERED_CPC(String dISPOSAL_OF_ARN_TRANSFERED_CPC) {
		DISPOSAL_OF_ARN_TRANSFERED_CPC = dISPOSAL_OF_ARN_TRANSFERED_CPC;
	}



	public String getDISPOSAL_OF_ARN_DEEMED_REG() {
		return DISPOSAL_OF_ARN_DEEMED_REG;
	}



	public void setDISPOSAL_OF_ARN_DEEMED_REG(String dISPOSAL_OF_ARN_DEEMED_REG) {
		DISPOSAL_OF_ARN_DEEMED_REG = dISPOSAL_OF_ARN_DEEMED_REG;
	}
	
	public String getCLOSING_BALANCE() {
		return CLOSING_BALANCE;
	}

	public void setCLOSING_BALANCE(String cLOSING_BALANCE) {
		CLOSING_BALANCE = cLOSING_BALANCE;
	}
	
	



	public SP_DPM_GST_14A_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DPM_GST_14A_COMM_TEMP_Result> list =  new ArrayList<SP_DPM_GST_14A_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_14A_COMM_TEMP_Result temp = new SP_DPM_GST_14A_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_14A_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_14A_COMM_TEMP_Result temp =  new SP_DPM_GST_14A_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setS_NO(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setCOMM_CODE(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setMM_YYYY(String.valueOf(objectArray[2]));}
			if (null != objectArray[3]) {temp.setOPENING_BALANCE(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setNO_OF_ARN_RECEIVED_GSTN(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setNO_OF_ARN_RECEIVED_CPC(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setDISPOSAL_OF_ARN_WITHIN_7(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]){temp.setDISPOSAL_OF_ARN_PV_RECOMMENDED(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setDISPOSAL_OF_ARN_PV_APPROVED(String.valueOf(objectArray[8]));}
			if(null != objectArray[9]){temp.setDISPOSAL_OF_ARN_PV_REJECTED(String.valueOf(objectArray[9]));}
			if(null != objectArray[10]){temp.setDISPOSAL_OF_ARN_PV_NOT_RECEIVED(String.valueOf(objectArray[10]));}
			if(null != objectArray[11]){temp.setDISPOSAL_OF_ARN_TRANSFERED_CPC(String.valueOf(objectArray[11]));}
			if(null != objectArray[12]){temp.setDISPOSAL_OF_ARN_DEEMED_REG(String.valueOf(objectArray[12]));}
			if (null != objectArray[13]) {temp.setCLOSING_BALANCE(String.valueOf(objectArray[13]));}
			
	return temp;
	
	 }
}