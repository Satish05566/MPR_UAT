package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_CE_2_COMM_TEMP_REPORT_Result {
	public String TOTAL_COMM ;
	public String COMPLETE_COMM ;
    public BigInteger AMND ;
    public String COMM_CODE;
    public BigDecimal CU_FOR_P ;
    public BigDecimal CU_UPTO_P ;
    public BigDecimal CU_FOR_C ;
    public BigDecimal CU_UPTO_C ;
    public BigDecimal ACTUAL ;
    public BigDecimal PERC ;
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
	public BigInteger getAMND() {
		return AMND;
	}
	public void setAMND(BigInteger aMND) {
		AMND = aMND;
	}
	public String getCOMM_CODE() {
		return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}
	public BigDecimal getCU_FOR_P() {
		return CU_FOR_P;
	}
	public void setCU_FOR_P(BigDecimal cU_FOR_P) {
		CU_FOR_P = cU_FOR_P;
	}
	public BigDecimal getCU_UPTO_P() {
		return CU_UPTO_P;
	}
	public void setCU_UPTO_P(BigDecimal cU_UPTO_P) {
		CU_UPTO_P = cU_UPTO_P;
	}
	public BigDecimal getCU_FOR_C() {
		return CU_FOR_C;
	}
	public void setCU_FOR_C(BigDecimal cU_FOR_C) {
		CU_FOR_C = cU_FOR_C;
	}
	public BigDecimal getCU_UPTO_C() {
		return CU_UPTO_C;
	}
	public void setCU_UPTO_C(BigDecimal cU_UPTO_C) {
		CU_UPTO_C = cU_UPTO_C;
	}
	public BigDecimal getACTUAL() {
		return ACTUAL;
	}
	public void setACTUAL(BigDecimal aCTUAL) {
		ACTUAL = aCTUAL;
	}
	public BigDecimal getPERC() {
		return PERC;
	}
	public void setPERC(BigDecimal pERC) {
		PERC = pERC;
	}
    
    
	public List<SP_DDM_CE_2_COMM_TEMP_REPORT_Result> sp_DDM_CE_1_REGION_Result(List<Object[]> listObjectArray){
		List <SP_DDM_CE_2_COMM_TEMP_REPORT_Result> list = new ArrayList<SP_DDM_CE_2_COMM_TEMP_REPORT_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_CE_2_COMM_TEMP_REPORT_Result temp = new SP_DDM_CE_2_COMM_TEMP_REPORT_Result();
		temp = generateResultBean_SP_DDM_CE_2_COMM_TEMP_REPORT(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_CE_2_COMM_TEMP_REPORT_Result generateResultBean_SP_DDM_CE_2_COMM_TEMP_REPORT(Object[] objectArray)
		{
			SP_DDM_CE_2_COMM_TEMP_REPORT_Result temp = new SP_DDM_CE_2_COMM_TEMP_REPORT_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
			temp.setTOTAL_COMM((String)( objectArray[0]));}
			if(null!=objectArray[1] && objectArray[1]!=null) {
			temp.setCOMPLETE_COMM((String)( objectArray[1]));}
			if(null!=objectArray[2] && objectArray[2]!=null) {
			temp.setAMND((BigInteger)( objectArray[2]));}
			if(null!=objectArray[3] && objectArray[3]!=null) {
			temp.setCOMM_CODE((String)( objectArray[3]));}
			if(null!=objectArray[4] && objectArray[4]!=null) {
			temp.setCU_FOR_P((BigDecimal)( objectArray[4]));}
			if(null!=objectArray[5] && objectArray[5]!=null) {
			temp.setCU_UPTO_P((BigDecimal)( objectArray[5]));}
			if(null!=objectArray[6] && objectArray[6]!=null) {
			temp.setCU_FOR_C((BigDecimal)( objectArray[6]));}
			if(null!=objectArray[7] && objectArray[7]!=null) {
			temp.setCU_UPTO_C((BigDecimal)( objectArray[7]));}
			if(null!=objectArray[8] && objectArray[8]!=null) {
			temp.setACTUAL((BigDecimal)( objectArray[8]));}
			if(null!=objectArray[9] && objectArray[9]!=null) {
			temp.setPERC((BigDecimal)( objectArray[9]));}
			return temp;
				

		}

    
}
