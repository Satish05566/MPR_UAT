package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_ADJ_2_ZONE_Result {
	 
	private String AMND;
	private String TOTAL_COMM;
	private String COMPLETE_COMM;	
	private String OPENING_NO;
	private String OPENING_AMT;
	private String RECEIPT_NO;
	private String RECEIPT_AMT;	
	private String RECEIPT_UPTO_NO;
	private String RECEIPT_UPTO_AMT;	
	private String DISPOSAL_REVENUE_NO;
	private String DISPOSAL_REVENUE_AMT;	
	private String DISPOSAL_TAXPAYER_NO;
	private String DISPOSAL_TAXPAYER_AMT;
	private String TOTAL_DISPOSAL_NO;
	private String TOTAL_DISPOSAL_AMOUNT;
	private String CLOSING_BALANCE_NO;
	private String CLOSING_BALANCE_AMOUNT;	
	private String AGE_UPTO_6_NO;	
	private String AGE_6_TO_12_NO;
	private String AGE_MORE_THAN_1_NO;
	
	
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


	public List<SP_DPM_GST_ADJ_2_ZONE_Result>  generateAllResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_DPM_GST_ADJ_2_ZONE_Result> list =  new ArrayList<SP_DPM_GST_ADJ_2_ZONE_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DPM_GST_ADJ_2_ZONE_Result temp = new SP_DPM_GST_ADJ_2_ZONE_Result ();
			
		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list;
		}
	}
	
	
	 private SP_DPM_GST_ADJ_2_ZONE_Result generateReportBean(Object[] objectArray) {

			SP_DPM_GST_ADJ_2_ZONE_Result temp =  new SP_DPM_GST_ADJ_2_ZONE_Result();
			
			if(null != objectArray[0]) {temp.setAMND(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setTOTAL_COMM(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]) {temp.setCOMPLETE_COMM(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]) {temp.setOPENING_NO(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]) {temp.setOPENING_AMT(String.valueOf(objectArray[4]));}			
			if(null != objectArray[5]) {temp.setRECEIPT_NO(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]) {temp.setRECEIPT_AMT(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]) {temp.setRECEIPT_UPTO_NO(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]) {temp.setRECEIPT_UPTO_AMT(String.valueOf(objectArray[8]));}			
			if(null != objectArray[9]) {temp.setDISPOSAL_REVENUE_NO(String.valueOf(objectArray[9]));}			
			if(null != objectArray[10]) {temp.setDISPOSAL_REVENUE_AMT(String.valueOf(objectArray[10]));}			
			if(null != objectArray[11]) {temp.setDISPOSAL_TAXPAYER_NO(String.valueOf(objectArray[11]));}
			if(null != objectArray[12]) {temp.setDISPOSAL_TAXPAYER_AMT(String.valueOf(objectArray[12]));}			
			if(null != objectArray[11]) {temp.setTOTAL_DISPOSAL_NO(String.valueOf(objectArray[13]));}
			if(null != objectArray[12]) {temp.setTOTAL_DISPOSAL_AMOUNT(String.valueOf(objectArray[14]));}
			if(null != objectArray[11]) {temp.setCLOSING_BALANCE_NO(String.valueOf(objectArray[15]));}
			if(null != objectArray[12]) {temp.setCLOSING_BALANCE_AMOUNT(String.valueOf(objectArray[16]));}			
			if(null != objectArray[12]) {temp.setAGE_UPTO_6_NO(String.valueOf(objectArray[17]));}
			if(null != objectArray[11]) {temp.setAGE_6_TO_12_NO(String.valueOf(objectArray[18]));}
			if(null != objectArray[12]) {temp.setAGE_MORE_THAN_1_NO(String.valueOf(objectArray[19]));}
			
   return temp;
	
	 }
	
	
	
	
	
	
	

}
