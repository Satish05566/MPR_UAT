package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;

public class SP_DDM_CE_2_COMM_TEMP_Result {

	public String COMM_CODE;
	public Date MM_YYYY;
	
	@Digits(message="Must be numeric", fraction = 2, integer = 15)
	public BigDecimal CENVAT_UTILISED;
	
	
	
	public String getCOMM_CODE() {
		return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}
	public Date getMM_YYYY() {
		return MM_YYYY;
	}
	public void setMM_YYYY(Date mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}
	public BigDecimal getCENVAT_UTILISED() {
		return CENVAT_UTILISED;
	}
	public void setCENVAT_UTILISED(BigDecimal cENVAT_UTILISED) {
		CENVAT_UTILISED = cENVAT_UTILISED;
	}
	
	
	
	public  SP_DDM_CE_2_COMM_TEMP_Result generateResultBean(Object [] objectArray) {
		SP_DDM_CE_2_COMM_TEMP_Result temp =  new SP_DDM_CE_2_COMM_TEMP_Result();
		 if(null!=objectArray[0]) {
		temp.setCOMM_CODE((String)( objectArray[0]));}
		 if(null!=objectArray[1]) {
		temp.setMM_YYYY((Date)( objectArray[1]));}
		 if(null!=objectArray[2]) {
		temp.setCENVAT_UTILISED((BigDecimal)( objectArray[2]));}
				
		return temp;
	}

	
	
}
