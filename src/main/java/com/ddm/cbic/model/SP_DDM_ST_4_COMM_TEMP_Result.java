package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;

public class SP_DDM_ST_4_COMM_TEMP_Result {
	 
	private String COMM_CODE ;
    private String MM_YYYY ;
    private String ASSESSEE_CODE ;
    private String ASSESSEE ;
    private String REVENUE_PRE_YEAR ;
    private String PRE_YEAR_FOR ;
    private String PRE_YEAR_UPTO ;
    private String CUR_YEAR_FOR ;
    private String CUR_YEAR_UPTO ;
    private String REASONS ;


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

	public String getREASONS() {
		return REASONS;
	}

	public void setREASONS(String rEASONS) {
		REASONS = rEASONS;
	}

	public List<SP_DDM_ST_4_COMM_TEMP_Result> sp_DDM_ST_4_COMM_TEMP_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_4_COMM_TEMP_Result> list = new ArrayList<SP_DDM_ST_4_COMM_TEMP_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_4_COMM_TEMP_Result temp = new SP_DDM_ST_4_COMM_TEMP_Result();
		temp = generateResultBean_SP_DDM_ST_4_COMM_TEMP(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_ST_4_COMM_TEMP_Result generateResultBean_SP_DDM_ST_4_COMM_TEMP(Object[] objectArray)
		{
			SP_DDM_ST_4_COMM_TEMP_Result temp = new SP_DDM_ST_4_COMM_TEMP_Result();
			

			 temp.setCOMM_CODE (String.valueOf(objectArray[0]));
			        temp.setMM_YYYY (String.valueOf(objectArray[1]));
			        temp.setASSESSEE_CODE (String.valueOf(objectArray[2]));
			        temp.setASSESSEE (String.valueOf(objectArray[3]));
			        temp.setREVENUE_PRE_YEAR (String.valueOf(objectArray[4]));
			        temp.setPRE_YEAR_FOR (String.valueOf(objectArray[5]));
			        temp.setPRE_YEAR_UPTO (String.valueOf(objectArray[6]));
			        temp.setCUR_YEAR_FOR (String.valueOf(objectArray[7]));
			        temp.setCUR_YEAR_UPTO (String.valueOf(objectArray[8]));
			        temp.setREASONS (String.valueOf(objectArray[9]));

			return temp;
					
			
		}

}
