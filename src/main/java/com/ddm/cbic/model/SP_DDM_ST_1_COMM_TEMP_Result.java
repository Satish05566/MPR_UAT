package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;

public class SP_DDM_ST_1_COMM_TEMP_Result {
	 public String COMM_CODE;
	 public Date MM_YYYY;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public BigDecimal MOVING_TARGET;
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public BigDecimal GROSS; 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public BigDecimal REFUND; 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public BigDecimal REBATE;
	 
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
	public BigDecimal getMOVING_TARGET() {
		return MOVING_TARGET;
	}
	public void setMOVING_TARGET(BigDecimal mOVING_TARGET) {
		MOVING_TARGET = mOVING_TARGET;
	}
	public BigDecimal getGROSS() {
		return GROSS;
	}
	public void setGROSS(BigDecimal gROSS) {
		GROSS = gROSS;
	}
	public BigDecimal getREFUND() {
		return REFUND;
	}
	public void setREFUND(BigDecimal rEFUND) {
		REFUND = rEFUND;
	}
	public BigDecimal getREBATE() {
		return REBATE;
	}
	public void setREBATE(BigDecimal rEBATE) {
		REBATE = rEBATE;
	} 
	
	public List<SP_DDM_ST_1_COMM_TEMP_Result> sp_DDM_CE_1_REGION_Result(List<Object[]> listObjectArray){
		List <SP_DDM_ST_1_COMM_TEMP_Result> list = new ArrayList<SP_DDM_ST_1_COMM_TEMP_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_ST_1_COMM_TEMP_Result temp = new SP_DDM_ST_1_COMM_TEMP_Result();
		temp = generateResultBean_SP_DDM_ST_1_COMM_TEMP(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_ST_1_COMM_TEMP_Result generateResultBean_SP_DDM_ST_1_COMM_TEMP(Object[] objectArray)
		{
			SP_DDM_ST_1_COMM_TEMP_Result temp = new SP_DDM_ST_1_COMM_TEMP_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
			temp.setCOMM_CODE((String)( objectArray[0]));}
			if(null!=objectArray[1] && objectArray[1]!=null) {
			temp.setMM_YYYY((Date)( objectArray[1]));}
			if(null!=objectArray[2] && objectArray[2]!=null) {
			temp.setMOVING_TARGET((BigDecimal)( objectArray[2]));}
			if(null!=objectArray[3] && objectArray[3]!=null) {
			temp.setGROSS((BigDecimal)( objectArray[3]));}
			if(null!=objectArray[4] && objectArray[4]!=null) {
			temp.setREFUND((BigDecimal)( objectArray[4]));}
			if(null!=objectArray[5] && objectArray[5]!=null) {
			temp.setREBATE((BigDecimal)( objectArray[5]));}
			
			return temp;
					
			
		}

}
