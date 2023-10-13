package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_ST_2_COMM_TEMP_REPORT_Result {
    
	private String TOTAL_COMM ;
    private String COMPLETE_COMM ;
    private String AMND ;
    private String COMM_CODE ;
    private String CU_FOR_P ;
    private String CU_UPTO_P ;
    private String CU_FOR_C ;
    private String CU_UPTO_C ;
    private String ACTUAL ;
    private String PERC ;



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



	public String getCU_FOR_P() {
		return CU_FOR_P;
	}



	public void setCU_FOR_P(String cU_FOR_P) {
		CU_FOR_P = cU_FOR_P;
	}



	public String getCU_UPTO_P() {
		return CU_UPTO_P;
	}



	public void setCU_UPTO_P(String cU_UPTO_P) {
		CU_UPTO_P = cU_UPTO_P;
	}



	public String getCU_FOR_C() {
		return CU_FOR_C;
	}



	public void setCU_FOR_C(String cU_FOR_C) {
		CU_FOR_C = cU_FOR_C;
	}



	public String getCU_UPTO_C() {
		return CU_UPTO_C;
	}



	public void setCU_UPTO_C(String cU_UPTO_C) {
		CU_UPTO_C = cU_UPTO_C;
	}



	public String getACTUAL() {
		return ACTUAL;
	}



	public void setACTUAL(String aCTUAL) {
		ACTUAL = aCTUAL;
	}



	public String getPERC() {
		return PERC;
	}



	public void setPERC(String pERC) {
		PERC = pERC;
	}



	public List<SP_DDM_ST_2_COMM_TEMP_REPORT_Result> SP_DDM_ST_2_COMM_TEMP_Report_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_2_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_DDM_ST_2_COMM_TEMP_REPORT_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_2_COMM_TEMP_REPORT_Result temp = new SP_DDM_ST_2_COMM_TEMP_REPORT_Result();
		temp = generateResultBean_SP_DDM_ST_2_COMM_TEMP_REPORT(objArray);
		list.add(temp);
		}
		return list;
		}
	
	

	public SP_DDM_ST_2_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_ST_2_COMM_TEMP_REPORT(Object[] objectArray)
	{
		SP_DDM_ST_2_COMM_TEMP_REPORT_Result temp = new SP_DDM_ST_2_COMM_TEMP_REPORT_Result();
		

temp.setTOTAL_COMM (String.valueOf(objectArray[0]));
        temp.setCOMPLETE_COMM (String.valueOf(objectArray[1]));
        temp.setAMND (String.valueOf(objectArray[2]));
        temp.setCOMM_CODE (String.valueOf(objectArray[3]));
        temp.setCU_FOR_P (String.valueOf(objectArray[4]));
        temp.setCU_UPTO_P (String.valueOf(objectArray[5]));
        temp.setCU_FOR_C (String.valueOf(objectArray[6]));
        temp.setCU_UPTO_C (String.valueOf(objectArray[7]));
        temp.setACTUAL (String.valueOf(objectArray[8]));
        temp.setPERC (String.valueOf(objectArray[9]));

	return temp;

	}

    
    
    
	
}
