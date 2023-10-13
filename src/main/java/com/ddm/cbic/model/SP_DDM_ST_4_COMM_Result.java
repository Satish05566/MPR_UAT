package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_4_COMM_Result {
	
	
	private String TOTAL_COMM ;
    private String AMND ;
    private String COMPLETE_COMM ;
    private String ASSESSEE_CODE ;
    private String ASSESSEE ;
    private String REVENUE_PRE_YEAR ;
    private String PRE_YEAR_FOR ;
    private String PRE_YEAR_UPTO ;
    private String CUR_YEAR_FOR ;
    private String CUR_YEAR_UPTO ;
    private String ACTUAL_UPTO ;
    private String PERCENT_UPTO ;
    private String REASONS ;


	public String getTOTAL_COMM() {
		return TOTAL_COMM;
	}

	public void setTOTAL_COMM(String tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}

	public String getAMND() {
		return AMND;
	}

	public void setAMND(String aMND) {
		AMND = aMND;
	}

	public String getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}

	public void setCOMPLETE_COMM(String cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
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

	public List<SP_DDM_ST_4_COMM_Result> SP_DDM_ST_4_COMM_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_4_COMM_Result> list = new ArrayList<SP_DDM_ST_4_COMM_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_4_COMM_Result temp = new SP_DDM_ST_4_COMM_Result();
		temp = generateResultBean_SP_DDM_ST_4_COMM(objArray);
		list.add(temp);
		}
		return list;
		}

	public SP_DDM_ST_4_COMM_Result generateResultBean_SP_DDM_ST_4_COMM(Object[] objectArray)
	{
		SP_DDM_ST_4_COMM_Result temp = new SP_DDM_ST_4_COMM_Result();

temp.setTOTAL_COMM (String.valueOf(objectArray[0]));
        temp.setAMND (String.valueOf(objectArray[1]));
        temp.setCOMPLETE_COMM (String.valueOf(objectArray[2]));
        temp.setASSESSEE_CODE (String.valueOf(objectArray[3]));
        temp.setASSESSEE (String.valueOf(objectArray[4]));
        temp.setREVENUE_PRE_YEAR (String.valueOf(objectArray[5]));
        temp.setPRE_YEAR_FOR (String.valueOf(objectArray[6]));
        temp.setPRE_YEAR_UPTO (String.valueOf(objectArray[7]));
        temp.setCUR_YEAR_FOR (String.valueOf(objectArray[8]));
        temp.setCUR_YEAR_UPTO (String.valueOf(objectArray[9]));
        temp.setACTUAL_UPTO (String.valueOf(objectArray[10]));
        temp.setPERCENT_UPTO (String.valueOf(objectArray[11]));
        temp.setREASONS (String.valueOf(objectArray[12]));

		
	return temp;

	}


	
	
}
