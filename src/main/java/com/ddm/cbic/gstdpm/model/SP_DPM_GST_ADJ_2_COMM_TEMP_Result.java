package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_DPM_GST_ADJ_2_COMM_TEMP_Result {
	 
	private String COMM_CODE;
	private String MM_YYYY;	
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String OPENING_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String OPENING_AMT;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String RECEIPT_NO;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String RECEIPT_AMT;	
	private String RECEIPT_UPTO_NO;
	private String RECEIPT_UPTO_AMT;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String DISPOSAL_REVENUE_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DISPOSAL_REVENUE_AMT;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String DISPOSAL_TAXPAYER_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DISPOSAL_TAXPAYER_AMT;
	private String TOTAL_DISPOSAL_NO;	
	private String TOTAL_DISPOSAL_AMOUNT;
	private String CLOSING_BALANCE_NO;
	private String CLOSING_BALANCE_AMOUNT;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String AGE_UPTO_6_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String AGE_6_TO_12_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String AGE_MORE_THAN_1_NO;
	
	
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


	public String getOPENING_NO() {
		return OPENING_NO;
	}


	public void setOPENING_NO(String oPENING_NO) {
		OPENING_NO = oPENING_NO;
	}


	public String getOPENING_AMT() {
		return OPENING_AMT;
	}


	public void setOPENING_AMT(String oPENING_AMT) {
		OPENING_AMT = oPENING_AMT;
	}


	public String getRECEIPT_NO() {
		return RECEIPT_NO;
	}


	public void setRECEIPT_NO(String rECEIPT_NO) {
		RECEIPT_NO = rECEIPT_NO;
	}


	public String getRECEIPT_AMT() {
		return RECEIPT_AMT;
	}


	public void setRECEIPT_AMT(String rECEIPT_AMT) {
		RECEIPT_AMT = rECEIPT_AMT;
	}


	public String getRECEIPT_UPTO_NO() {
		return RECEIPT_UPTO_NO;
	}


	public void setRECEIPT_UPTO_NO(String rECEIPT_UPTO_NO) {
		RECEIPT_UPTO_NO = rECEIPT_UPTO_NO;
	}


	public String getRECEIPT_UPTO_AMT() {
		return RECEIPT_UPTO_AMT;
	}


	public void setRECEIPT_UPTO_AMT(String rECEIPT_UPTO_AMT) {
		RECEIPT_UPTO_AMT = rECEIPT_UPTO_AMT;
	}


	public String getDISPOSAL_REVENUE_NO() {
		return DISPOSAL_REVENUE_NO;
	}


	public void setDISPOSAL_REVENUE_NO(String dISPOSAL_REVENUE_NO) {
		DISPOSAL_REVENUE_NO = dISPOSAL_REVENUE_NO;
	}


	public String getDISPOSAL_REVENUE_AMT() {
		return DISPOSAL_REVENUE_AMT;
	}


	public void setDISPOSAL_REVENUE_AMT(String dISPOSAL_REVENUE_AMT) {
		DISPOSAL_REVENUE_AMT = dISPOSAL_REVENUE_AMT;
	}


	public String getDISPOSAL_TAXPAYER_NO() {
		return DISPOSAL_TAXPAYER_NO;
	}


	public void setDISPOSAL_TAXPAYER_NO(String dISPOSAL_TAXPAYER_NO) {
		DISPOSAL_TAXPAYER_NO = dISPOSAL_TAXPAYER_NO;
	}


	public String getDISPOSAL_TAXPAYER_AMT() {
		return DISPOSAL_TAXPAYER_AMT;
	}


	public void setDISPOSAL_TAXPAYER_AMT(String dISPOSAL_TAXPAYER_AMT) {
		DISPOSAL_TAXPAYER_AMT = dISPOSAL_TAXPAYER_AMT;
	}


	public String getTOTAL_DISPOSAL_NO() {
		return TOTAL_DISPOSAL_NO;
	}


	public void setTOTAL_DISPOSAL_NO(String tOTAL_DISPOSAL_NO) {
		TOTAL_DISPOSAL_NO = tOTAL_DISPOSAL_NO;
	}


	public String getTOTAL_DISPOSAL_AMOUNT() {
		return TOTAL_DISPOSAL_AMOUNT;
	}


	public void setTOTAL_DISPOSAL_AMOUNT(String tOTAL_DISPOSAL_AMOUNT) {
		TOTAL_DISPOSAL_AMOUNT = tOTAL_DISPOSAL_AMOUNT;
	}


	public String getCLOSING_BALANCE_NO() {
		return CLOSING_BALANCE_NO;
	}


	public void setCLOSING_BALANCE_NO(String cLOSING_BALANCE_NO) {
		CLOSING_BALANCE_NO = cLOSING_BALANCE_NO;
	}


	public String getCLOSING_BALANCE_AMOUNT() {
		return CLOSING_BALANCE_AMOUNT;
	}


	public void setCLOSING_BALANCE_AMOUNT(String cLOSING_BALANCE_AMOUNT) {
		CLOSING_BALANCE_AMOUNT = cLOSING_BALANCE_AMOUNT;
	}


	public String getAGE_UPTO_6_NO() {
		return AGE_UPTO_6_NO;
	}


	public void setAGE_UPTO_6_NO(String aGE_UPTO_6_NO) {
		AGE_UPTO_6_NO = aGE_UPTO_6_NO;
	}


	public String getAGE_6_TO_12_NO() {
		return AGE_6_TO_12_NO;
	}


	public void setAGE_6_TO_12_NO(String aGE_6_TO_12_NO) {
		AGE_6_TO_12_NO = aGE_6_TO_12_NO;
	}


	public String getAGE_MORE_THAN_1_NO() {
		return AGE_MORE_THAN_1_NO;
	}


	public void setAGE_MORE_THAN_1_NO(String aGE_MORE_THAN_1_NO) {
		AGE_MORE_THAN_1_NO = aGE_MORE_THAN_1_NO;
	}


	public List<SP_DPM_GST_ADJ_2_COMM_TEMP_Result>  generateAllResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_DPM_GST_ADJ_2_COMM_TEMP_Result> list =  new ArrayList<SP_DPM_GST_ADJ_2_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_ADJ_2_COMM_TEMP_Result temp = new SP_DPM_GST_ADJ_2_COMM_TEMP_Result ();
			
		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list;
		}
	}
		
	
	 private SP_DPM_GST_ADJ_2_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_ADJ_2_COMM_TEMP_Result temp =  new SP_DPM_GST_ADJ_2_COMM_TEMP_Result();
			
			if(null != objectArray[0]) {temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}			
			if(null != objectArray[2]) {temp.setOPENING_NO(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]) {temp.setOPENING_AMT(String.valueOf(objectArray[3]));}			
			if(null != objectArray[4]) {temp.setRECEIPT_NO(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]) {temp.setRECEIPT_AMT(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]) {temp.setRECEIPT_UPTO_NO(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]) {temp.setRECEIPT_UPTO_AMT(String.valueOf(objectArray[7]));}			
			if(null != objectArray[8]) {temp.setDISPOSAL_REVENUE_NO(String.valueOf(objectArray[8]));}			
			if(null != objectArray[9]) {temp.setDISPOSAL_REVENUE_AMT(String.valueOf(objectArray[9]));}			
			if(null != objectArray[10]) {temp.setDISPOSAL_TAXPAYER_NO(String.valueOf(objectArray[10]));}
			if(null != objectArray[11]) {temp.setDISPOSAL_TAXPAYER_AMT(String.valueOf(objectArray[11]));}			
			if(null != objectArray[12]) {temp.setTOTAL_DISPOSAL_NO(String.valueOf(objectArray[12]));}
			if(null != objectArray[13]) {temp.setTOTAL_DISPOSAL_AMOUNT(String.valueOf(objectArray[13]));}
			if(null != objectArray[14]) {temp.setCLOSING_BALANCE_NO(String.valueOf(objectArray[14]));}
			if(null != objectArray[15]) {temp.setCLOSING_BALANCE_AMOUNT(String.valueOf(objectArray[15]));}			
			if(null != objectArray[16]) {temp.setAGE_UPTO_6_NO(String.valueOf(objectArray[16]));}
			if(null != objectArray[17]) {temp.setAGE_6_TO_12_NO(String.valueOf(objectArray[17]));}
			if(null != objectArray[18]) {temp.setAGE_MORE_THAN_1_NO(String.valueOf(objectArray[18]));}
			
				
   return temp;
	
	 }
	
	
	
	
	
	
	

}
