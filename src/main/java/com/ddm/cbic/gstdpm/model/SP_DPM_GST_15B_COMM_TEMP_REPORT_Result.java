package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DPM_GST_15B_COMM_TEMP_REPORT_Result {

	private String TOTAL_COMM;
	private String COMPLETE_COMM;
	private String AMND;
	private String COMM_CODE;
	private String PENDENCY_PART_OFFICER_NO_GSTIN ;
	private String REPLY_AWAITED_TAXPAYER_NO_GSTIN;
	private String TAXES_OR_DUES_UNPAID_NO_GSTIN;
	private String TECHNICAL_ISSUES_NO_GSTIN;
	private String OTHERS_REMARKS;
	private String OTHERS_NO_GSTIN;

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

	public String getPENDENCY_PART_OFFICER_NO_GSTIN() {
		return PENDENCY_PART_OFFICER_NO_GSTIN;
	}

	public void setPENDENCY_PART_OFFICER_NO_GSTIN(String pENDENCY_PART_OFFICER_NO_GSTIN) {
		PENDENCY_PART_OFFICER_NO_GSTIN = pENDENCY_PART_OFFICER_NO_GSTIN;
	}

	public String getREPLY_AWAITED_TAXPAYER_NO_GSTIN() {
		return REPLY_AWAITED_TAXPAYER_NO_GSTIN;
	}

	public void setREPLY_AWAITED_TAXPAYER_NO_GSTIN(String rEPLY_AWAITED_TAXPAYER_NO_GSTIN) {
		REPLY_AWAITED_TAXPAYER_NO_GSTIN = rEPLY_AWAITED_TAXPAYER_NO_GSTIN;
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

	public String getOTHERS_REMARKS() {
		return OTHERS_REMARKS;
	}

	public void setOTHERS_REMARKS(String oTHERS_REMARKS) {
		OTHERS_REMARKS = oTHERS_REMARKS;
	}

	public String getOTHERS_NO_GSTIN() {
		return OTHERS_NO_GSTIN;
	}

	public void setOTHERS_NO_GSTIN(String oTHERS_NO_GSTIN) {
		OTHERS_NO_GSTIN = oTHERS_NO_GSTIN;
	}

	public SP_DPM_GST_15B_COMM_TEMP_REPORT_Result generateTempResult(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_DPM_GST_15B_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_DPM_GST_15B_COMM_TEMP_REPORT_Result>();
			for (Object[] objectArray : resultList) {
				SP_DPM_GST_15B_COMM_TEMP_REPORT_Result temp = new SP_DPM_GST_15B_COMM_TEMP_REPORT_Result();

				temp = generateReportBean(objectArray);
				list.add(temp);
			}
			return list.get(0);
		}
	}

	private SP_DPM_GST_15B_COMM_TEMP_REPORT_Result generateReportBean(Object[] objectArray) {

		SP_DPM_GST_15B_COMM_TEMP_REPORT_Result temp = new SP_DPM_GST_15B_COMM_TEMP_REPORT_Result();

		if (null != objectArray[0]) {
			temp.setTOTAL_COMM(String.valueOf(objectArray[0]));
		}
		if (null != objectArray[1]) {
			temp.setCOMPLETE_COMM(String.valueOf(objectArray[1]));
		}
		if (null != objectArray[2]) {
			temp.setAMND(String.valueOf(objectArray[2]));
		}
		if (null != objectArray[3]) {
			temp.setCOMM_CODE(String.valueOf(objectArray[3]));
		}
		if(null != objectArray[4]){temp.setPENDENCY_PART_OFFICER_NO_GSTIN(String.valueOf(objectArray[4]));}
		if(null != objectArray[5]){temp.setREPLY_AWAITED_TAXPAYER_NO_GSTIN(String.valueOf(objectArray[5]));}
		if(null != objectArray[6]){temp.setTAXES_OR_DUES_UNPAID_NO_GSTIN(String.valueOf(objectArray[6]));}
		
		if(null != objectArray[7]){temp.setTECHNICAL_ISSUES_NO_GSTIN(String.valueOf(objectArray[7]));}
		if(null != objectArray[8]){temp.setOTHERS_REMARKS(String.valueOf(objectArray[8]));}
		if(null != objectArray[9]){temp.setOTHERS_NO_GSTIN(String.valueOf(objectArray[9]));}

		return temp;

	}

}
