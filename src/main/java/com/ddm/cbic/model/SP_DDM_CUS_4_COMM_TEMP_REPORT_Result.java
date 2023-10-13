package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;


public  class SP_DDM_CUS_4_COMM_TEMP_REPORT_Result
{

	private String 	TOTAL_COMM	;
	private String 	COMPLETE_COMM	;
	private String 	AMND	;
	private String 	ASSESSEE_CODE	;
	private String 	ASSESSEE	;
	private String 	REVENUE_PRE_YEAR	;
	private String 	PRE_YEAR_FOR	;
	private String 	PRE_YEAR_UPTO	;
	private String 	CUR_YEAR_FOR	;
	private String 	CUR_YEAR_UPTO	;
	private String 	ACTUAL_UPTO	;
	private String 	PERCENT_UPTO	;
	private String 	REASONS	;

    



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


	public String getASSESSEE_CODE() {
		return ASSESSEE_CODE;
	}


	public void setASSESSEE_CODE(String aSSESSEE_CODE) {
		ASSESSEE_CODE = aSSESSEE_CODE;
	}


	public String getASSESSEE() {
		return ASSESSEE;
	}


	public void setASSESSEE(String aSSESSEE) {
		ASSESSEE = aSSESSEE;
	}


	public String getREVENUE_PRE_YEAR() {
		return REVENUE_PRE_YEAR;
	}


	public void setREVENUE_PRE_YEAR(String rEVENUE_PRE_YEAR) {
		REVENUE_PRE_YEAR = rEVENUE_PRE_YEAR;
	}


	public String getPRE_YEAR_FOR() {
		return PRE_YEAR_FOR;
	}


	public void setPRE_YEAR_FOR(String pRE_YEAR_FOR) {
		PRE_YEAR_FOR = pRE_YEAR_FOR;
	}


	public String getPRE_YEAR_UPTO() {
		return PRE_YEAR_UPTO;
	}


	public void setPRE_YEAR_UPTO(String pRE_YEAR_UPTO) {
		PRE_YEAR_UPTO = pRE_YEAR_UPTO;
	}


	public String getCUR_YEAR_FOR() {
		return CUR_YEAR_FOR;
	}


	public void setCUR_YEAR_FOR(String cUR_YEAR_FOR) {
		CUR_YEAR_FOR = cUR_YEAR_FOR;
	}


	public String getCUR_YEAR_UPTO() {
		return CUR_YEAR_UPTO;
	}


	public void setCUR_YEAR_UPTO(String cUR_YEAR_UPTO) {
		CUR_YEAR_UPTO = cUR_YEAR_UPTO;
	}


	public String getACTUAL_UPTO() {
		return ACTUAL_UPTO;
	}


	public void setACTUAL_UPTO(String aCTUAL_UPTO) {
		ACTUAL_UPTO = aCTUAL_UPTO;
	}


	public String getPERCENT_UPTO() {
		return PERCENT_UPTO;
	}


	public void setPERCENT_UPTO(String pERCENT_UPTO) {
		PERCENT_UPTO = pERCENT_UPTO;
	}


	public String getREASONS() {
		return REASONS;
	}


	public void setREASONS(String rEASONS) {
		REASONS = rEASONS;
	}


public List<SP_DDM_CUS_4_COMM_TEMP_REPORT_Result> generateResultList_SP_DDM_CUS_4_COMM_TEMP_REPORT(List<Object[]> listObjectArray){
List <SP_DDM_CUS_4_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_DDM_CUS_4_COMM_TEMP_REPORT_Result>();
for(Object[] objArray : listObjectArray) {
SP_DDM_CUS_4_COMM_TEMP_REPORT_Result temp = new SP_DDM_CUS_4_COMM_TEMP_REPORT_Result();
temp = generateResultBean_SP_DDM_CUS_4_COMM_TEMP_REPORT(objArray);
list.add(temp);
}
return list;
}


public SP_DDM_CUS_4_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CUS_4_COMM_TEMP_REPORT(Object[] objectArray)
{
SP_DDM_CUS_4_COMM_TEMP_REPORT_Result temp = new SP_DDM_CUS_4_COMM_TEMP_REPORT_Result();

if(null != objectArray[0]){temp.setTOTAL_COMM(objectArray[0].toString());}else{temp.setTOTAL_COMM("0");}
if(null != objectArray[1]){temp.setCOMPLETE_COMM(objectArray[1].toString());}else{temp.setCOMPLETE_COMM("0");}
if(null != objectArray[2]){temp.setAMND(objectArray[2].toString());}else{temp.setAMND("0");}
if(null != objectArray[3]){temp.setASSESSEE_CODE(objectArray[3].toString());}else{temp.setASSESSEE_CODE("0");}
if(null != objectArray[4]){temp.setASSESSEE(objectArray[4].toString());}else{temp.setASSESSEE("0");}
if(null != objectArray[5]){temp.setREVENUE_PRE_YEAR(objectArray[5].toString());}else{temp.setREVENUE_PRE_YEAR("0");}
if(null != objectArray[6]){temp.setPRE_YEAR_FOR(objectArray[6].toString());}else{temp.setPRE_YEAR_FOR("0");}
if(null != objectArray[7]){temp.setPRE_YEAR_UPTO(objectArray[7].toString());}else{temp.setPRE_YEAR_UPTO("0");}
if(null != objectArray[8]){temp.setCUR_YEAR_FOR(objectArray[8].toString());}else{temp.setCUR_YEAR_FOR("0");}
if(null != objectArray[9]){temp.setCUR_YEAR_UPTO(objectArray[9].toString());}else{temp.setCUR_YEAR_UPTO("0");}
if(null != objectArray[10]){temp.setACTUAL_UPTO(objectArray[10].toString());}else{temp.setACTUAL_UPTO("0");}
if(null != objectArray[11]){temp.setPERCENT_UPTO(objectArray[11].toString());}else{temp.setPERCENT_UPTO("0");}
if(null != objectArray[12]){temp.setREASONS(objectArray[12].toString());}else{temp.setREASONS("0");}

return temp;
}


@Override
public String toString() {
	return "SP_DDM_CUS_4_COMM_TEMP_REPORT_Result [TOTAL_COMM=" + TOTAL_COMM + ", COMPLETE_COMM=" + COMPLETE_COMM
			+ ", AMND=" + AMND + ", ASSESSEE_CODE=" + ASSESSEE_CODE + ", ASSESSEE=" + ASSESSEE + ", REVENUE_PRE_YEAR="
			+ REVENUE_PRE_YEAR + ", PRE_YEAR_FOR=" + PRE_YEAR_FOR + ", PRE_YEAR_UPTO=" + PRE_YEAR_UPTO
			+ ", CUR_YEAR_FOR=" + CUR_YEAR_FOR + ", CUR_YEAR_UPTO=" + CUR_YEAR_UPTO + ", ACTUAL_UPTO=" + ACTUAL_UPTO
			+ ", PERCENT_UPTO=" + PERCENT_UPTO + ", REASONS=" + REASONS + "]";
}



}
