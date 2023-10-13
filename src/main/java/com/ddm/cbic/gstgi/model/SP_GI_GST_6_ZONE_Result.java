package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

public class SP_GI_GST_6_ZONE_Result {

	private String AMND;
	private String TOTAL_COMM;
	private String COMPLETE_COMM;  
	private String ZONE_CODE; 
	private String HSN_SAC_CODE; 
	private String HSN_SAC_CODE_DESCRIPTION; 
	private String GOODS_OR_SERVICES_TYPE; 
	private String NO_OF_CASES_CUR_FOR; 
	private String TAX_EVASION_AMT_CUR_FOR; 
	private String NO_OF_CASES_CUR_UPTO; 
	private String AMOUNT_OF_TAX_EVASION_CUR_UPTO; 
	private String NO_OF_CASES_PRE_FOR; 
	private String TAX_EVASION_AMT_PRE_FOR; 
	private String NO_OF_CASES_PRE_UPTO; 
	private String AMOUNT_OF_TAX_EVASION_PRE_UPTO;
	
	
	


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


	public String getZONE_CODE() {
		return ZONE_CODE;
	}


	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}


	public String getHSN_SAC_CODE() {
		return HSN_SAC_CODE;
	}


	public void setHSN_SAC_CODE(String hSN_SAC_CODE) {
		HSN_SAC_CODE = hSN_SAC_CODE;
	}


	public String getHSN_SAC_CODE_DESCRIPTION() {
		return HSN_SAC_CODE_DESCRIPTION;
	}


	public void setHSN_SAC_CODE_DESCRIPTION(String hSN_SAC_CODE_DESCRIPTION) {
		HSN_SAC_CODE_DESCRIPTION = hSN_SAC_CODE_DESCRIPTION;
	}


	public String getGOODS_OR_SERVICES_TYPE() {
		return GOODS_OR_SERVICES_TYPE;
	}


	public void setGOODS_OR_SERVICES_TYPE(String gOODS_OR_SERVICES_TYPE) {
		GOODS_OR_SERVICES_TYPE = gOODS_OR_SERVICES_TYPE;
	}


	public String getNO_OF_CASES_CUR_FOR() {
		return NO_OF_CASES_CUR_FOR;
	}


	public void setNO_OF_CASES_CUR_FOR(String nO_OF_CASES_CUR_FOR) {
		NO_OF_CASES_CUR_FOR = nO_OF_CASES_CUR_FOR;
	}


	public String getTAX_EVASION_AMT_CUR_FOR() {
		return TAX_EVASION_AMT_CUR_FOR;
	}


	public void setTAX_EVASION_AMT_CUR_FOR(String tAX_EVASION_AMT_CUR_FOR) {
		TAX_EVASION_AMT_CUR_FOR = tAX_EVASION_AMT_CUR_FOR;
	}


	public String getNO_OF_CASES_CUR_UPTO() {
		return NO_OF_CASES_CUR_UPTO;
	}


	public void setNO_OF_CASES_CUR_UPTO(String nO_OF_CASES_CUR_UPTO) {
		NO_OF_CASES_CUR_UPTO = nO_OF_CASES_CUR_UPTO;
	}


	public String getAMOUNT_OF_TAX_EVASION_CUR_UPTO() {
		return AMOUNT_OF_TAX_EVASION_CUR_UPTO;
	}


	public void setAMOUNT_OF_TAX_EVASION_CUR_UPTO(String aMOUNT_OF_TAX_EVASION_CUR_UPTO) {
		AMOUNT_OF_TAX_EVASION_CUR_UPTO = aMOUNT_OF_TAX_EVASION_CUR_UPTO;
	}


	public String getNO_OF_CASES_PRE_FOR() {
		return NO_OF_CASES_PRE_FOR;
	}


	public void setNO_OF_CASES_PRE_FOR(String nO_OF_CASES_PRE_FOR) {
		NO_OF_CASES_PRE_FOR = nO_OF_CASES_PRE_FOR;
	}


	public String getTAX_EVASION_AMT_PRE_FOR() {
		return TAX_EVASION_AMT_PRE_FOR;
	}


	public void setTAX_EVASION_AMT_PRE_FOR(String tAX_EVASION_AMT_PRE_FOR) {
		TAX_EVASION_AMT_PRE_FOR = tAX_EVASION_AMT_PRE_FOR;
	}


	public String getNO_OF_CASES_PRE_UPTO() {
		return NO_OF_CASES_PRE_UPTO;
	}


	public void setNO_OF_CASES_PRE_UPTO(String nO_OF_CASES_PRE_UPTO) {
		NO_OF_CASES_PRE_UPTO = nO_OF_CASES_PRE_UPTO;
	}


	public String getAMOUNT_OF_TAX_EVASION_PRE_UPTO() {
		return AMOUNT_OF_TAX_EVASION_PRE_UPTO;
	}
	
	public void setAMOUNT_OF_TAX_EVASION_PRE_UPTO(String aMOUNT_OF_TAX_EVASION_PRE_UPTO) {
		AMOUNT_OF_TAX_EVASION_PRE_UPTO = aMOUNT_OF_TAX_EVASION_PRE_UPTO;
	}
	
	public List<SP_GI_GST_6_ZONE_Result> generateZoneResult(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_GI_GST_6_ZONE_Result> list = new ArrayList<SP_GI_GST_6_ZONE_Result>();
			for (Object[] objectArray : resultList) {
				SP_GI_GST_6_ZONE_Result temp = new SP_GI_GST_6_ZONE_Result();

				temp = generateReportBean(objectArray);
				list.add(temp);
			}
			return list;
		}
	}

	private SP_GI_GST_6_ZONE_Result generateReportBean(Object[] objectArray) {

		SP_GI_GST_6_ZONE_Result temp = new SP_GI_GST_6_ZONE_Result();
		if (null != objectArray[0])   {temp.setAMND(String.valueOf(objectArray[0]));}
		if (null != objectArray[1])   {temp.setTOTAL_COMM((String) objectArray[1]);}
		if (null != objectArray[2])   {temp.setCOMPLETE_COMM((String) objectArray[2]);}	
		if (null != objectArray[3]) {temp.setZONE_CODE((String)objectArray[3]);}

		
		if (null != objectArray[4])   {temp.setHSN_SAC_CODE(String.valueOf(objectArray[4]));} 
		if (null != objectArray[5])   {temp.setHSN_SAC_CODE_DESCRIPTION(String.valueOf(objectArray[5]));} 
		if (null != objectArray[6])   {temp.setGOODS_OR_SERVICES_TYPE(String.valueOf(objectArray[6]));} 
		if (null != objectArray[7])   {temp.setNO_OF_CASES_CUR_FOR(String.valueOf(objectArray[7]));} 
		if (null != objectArray[8])   {temp.setTAX_EVASION_AMT_CUR_FOR(String.valueOf(objectArray[8]));} 
		if (null != objectArray[9])   {temp.setNO_OF_CASES_CUR_UPTO(String.valueOf(objectArray[9]));} 
		if (null != objectArray[10])  {temp.setAMOUNT_OF_TAX_EVASION_CUR_UPTO(String.valueOf(objectArray[10]));} 
		if (null != objectArray[11])  {temp.setNO_OF_CASES_PRE_FOR(String.valueOf(objectArray[11]));} 
		if (null != objectArray[12])  {temp.setTAX_EVASION_AMT_PRE_FOR(String.valueOf(objectArray[12]));} 
		if (null != objectArray[13])  {temp.setNO_OF_CASES_PRE_UPTO(String.valueOf(objectArray[13]));} 
		if (null != objectArray[14])  {temp.setAMOUNT_OF_TAX_EVASION_PRE_UPTO(String.valueOf(objectArray[14]));}

	return temp;

	}

}
