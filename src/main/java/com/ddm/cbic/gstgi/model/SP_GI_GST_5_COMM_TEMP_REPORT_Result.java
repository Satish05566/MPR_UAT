package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

public class SP_GI_GST_5_COMM_TEMP_REPORT_Result {

	private int AMND;
	private int TOTAL_COMM;
	private int COMPLETE_COMM;
	
	private String SR_NO;
	private String F_NO;

	private String NAME_TAXPAYER;
	private String ADDRESS_TAXPAYER;
	private String GSTIN;
	private String TAX_EVADED;
	private String NAME;
	private String DESGINATION;
	private String AGE;	
	private String PAN;
	private String AADHAR;	
	private String DATE_ARREST;
	private String ROLE_PLAYED;
	private String SANCTION_ORDER_NO;	
	private String SANCTION_ORDER_DATE; 	
	private String NUMBER_PERSONS_PROSECUTED;
	private String DATE_FILING_COURT;
	private String CRIMINAL_COMPLAINT_NUMBER; 	
	private String COURT_ORDER_NO;
	private String COURT_ORDER_DATE;
	private String COURT_DETAIL_ORDER;
	
	
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

	public String getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(String sR_NO) {
		SR_NO = sR_NO;
	}

	public String getF_NO() {
		return F_NO;
	}

	public void setF_NO(String f_NO) {
		F_NO = f_NO;
	}

	public String getNAME_TAXPAYER() {
		return NAME_TAXPAYER;
	}

	public void setNAME_TAXPAYER(String nAME_TAXPAYER) {
		NAME_TAXPAYER = nAME_TAXPAYER;
	}

	public String getADDRESS_TAXPAYER() {
		return ADDRESS_TAXPAYER;
	}

	public void setADDRESS_TAXPAYER(String aDDRESS_TAXPAYER) {
		ADDRESS_TAXPAYER = aDDRESS_TAXPAYER;
	}

	public String getGSTIN() {
		return GSTIN;
	}

	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}

	public String getTAX_EVADED() {
		return TAX_EVADED;
	}

	public void setTAX_EVADED(String tAX_EVADED) {
		TAX_EVADED = tAX_EVADED;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getDESGINATION() {
		return DESGINATION;
	}

	public void setDESGINATION(String dESGINATION) {
		DESGINATION = dESGINATION;
	}

	public String getAGE() {
		return AGE;
	}

	public void setAGE(String aGE) {
		AGE = aGE;
	}

	public String getPAN() {
		return PAN;
	}

	public void setPAN(String pAN) {
		PAN = pAN;
	}

	public String getAADHAR() {
		return AADHAR;
	}

	public void setAADHAR(String aADHAR) {
		AADHAR = aADHAR;
	}

	public String getDATE_ARREST() {
		return DATE_ARREST;
	}

	public void setDATE_ARREST(String dATE_ARREST) {
		DATE_ARREST = dATE_ARREST;
	}

	public String getROLE_PLAYED() {
		return ROLE_PLAYED;
	}

	public void setROLE_PLAYED(String rOLE_PLAYED) {
		ROLE_PLAYED = rOLE_PLAYED;
	}

	public String getSANCTION_ORDER_NO() {
		return SANCTION_ORDER_NO;
	}

	public void setSANCTION_ORDER_NO(String sANCTION_ORDER_NO) {
		SANCTION_ORDER_NO = sANCTION_ORDER_NO;
	}

	public String getSANCTION_ORDER_DATE() {
		return SANCTION_ORDER_DATE;
	}

	public void setSANCTION_ORDER_DATE(String sANCTION_ORDER_DATE) {
		SANCTION_ORDER_DATE = sANCTION_ORDER_DATE;
	}

	public String getNUMBER_PERSONS_PROSECUTED() {
		return NUMBER_PERSONS_PROSECUTED;
	}

	public void setNUMBER_PERSONS_PROSECUTED(String nUMBER_PERSONS_PROSECUTED) {
		NUMBER_PERSONS_PROSECUTED = nUMBER_PERSONS_PROSECUTED;
	}

	public String getDATE_FILING_COURT() {
		return DATE_FILING_COURT;
	}

	public void setDATE_FILING_COURT(String dATE_FILING_COURT) {
		DATE_FILING_COURT = dATE_FILING_COURT;
	}

	public String getCRIMINAL_COMPLAINT_NUMBER() {
		return CRIMINAL_COMPLAINT_NUMBER;
	}

	public void setCRIMINAL_COMPLAINT_NUMBER(String cRIMINAL_COMPLAINT_NUMBER) {
		CRIMINAL_COMPLAINT_NUMBER = cRIMINAL_COMPLAINT_NUMBER;
	}

	public String getCOURT_ORDER_NO() {
		return COURT_ORDER_NO;
	}

	public void setCOURT_ORDER_NO(String cOURT_ORDER_NO) {
		COURT_ORDER_NO = cOURT_ORDER_NO;
	}

	public String getCOURT_ORDER_DATE() {
		return COURT_ORDER_DATE;
	}

	public void setCOURT_ORDER_DATE(String cOURT_ORDER_DATE) {
		COURT_ORDER_DATE = cOURT_ORDER_DATE;
	}

	public String getCOURT_DETAIL_ORDER() {
		return COURT_DETAIL_ORDER;
	}

	public void setCOURT_DETAIL_ORDER(String cOURT_DETAIL_ORDER) {
		COURT_DETAIL_ORDER = cOURT_DETAIL_ORDER;
	}

	public List<SP_GI_GST_5_COMM_TEMP_REPORT_Result> generateResultBeanList(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_GI_GST_5_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_GI_GST_5_COMM_TEMP_REPORT_Result>();
			for (Object[] objectArray : resultList) {
				SP_GI_GST_5_COMM_TEMP_REPORT_Result temp = new SP_GI_GST_5_COMM_TEMP_REPORT_Result();

				temp = generateResultBean(objectArray);
				list.add(temp);
			}
			return list;
		}
	}

	public SP_GI_GST_5_COMM_TEMP_REPORT_Result generateResultBean(Object[] objectArray) {
		SP_GI_GST_5_COMM_TEMP_REPORT_Result temp = new SP_GI_GST_5_COMM_TEMP_REPORT_Result();

		temp.setTOTAL_COMM(Integer.parseInt((String.valueOf(objectArray[0]))));
		temp.setCOMPLETE_COMM(Integer.parseInt((String.valueOf(objectArray[1]))));
		temp.setAMND(Integer.parseInt((String.valueOf(objectArray[2]))));		
		temp.setSR_NO(String.valueOf(objectArray[3]));
		temp.setF_NO(String.valueOf(objectArray[4]));
		temp.setNAME_TAXPAYER(String.valueOf(objectArray[5]));
		temp.setADDRESS_TAXPAYER(String.valueOf(objectArray[6]));
		temp.setGSTIN(String.valueOf(objectArray[7]));
		temp.setTAX_EVADED(String.valueOf(objectArray[8]));
		temp.setNAME(String.valueOf(objectArray[9]));		
		temp.setDESGINATION(String.valueOf(objectArray[10]));
		temp.setAGE(String.valueOf(objectArray[11]));
		temp.setPAN(String.valueOf(objectArray[12]));
		temp.setAADHAR(String.valueOf(objectArray[13]));
		temp.setDATE_ARREST(String.valueOf(objectArray[14]));
		temp.setROLE_PLAYED(String.valueOf(objectArray[15]));
		temp.setSANCTION_ORDER_NO(String.valueOf(objectArray[16]));		
		temp.setSANCTION_ORDER_DATE(String.valueOf(objectArray[17]));
		temp.setNUMBER_PERSONS_PROSECUTED(String.valueOf(objectArray[18]));
		temp.setDATE_FILING_COURT(String.valueOf(objectArray[19]));
		temp.setCRIMINAL_COMPLAINT_NUMBER(String.valueOf(objectArray[20]));		
		temp.setCOURT_ORDER_NO(String.valueOf(objectArray[21]));
		temp.setCOURT_ORDER_DATE(String.valueOf(objectArray[22]));
		temp.setCOURT_DETAIL_ORDER(String.valueOf(objectArray[23]));
		
		return temp;
	}

}
