package com.ddm.cbic.model;
import java.math.BigInteger;

import javax.validation.constraints.Digits;

public class SP_DDM_CUS_1_COMM_TARGET_Result {
	
	public String COMM_CODE;
	@Digits(message="Must be integer", fraction = 2, integer = 15)
	public BigInteger TARGET;
	
	
	public String getCOMM_CODE() {
		return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}
	public BigInteger getTARGET() {
		return TARGET;
	}
	public void setTARGET(BigInteger tARGET) {
		TARGET = tARGET;
	}
	
	
	public  SP_DDM_CUS_1_COMM_TARGET_Result generateResultBean(Object [] objectArray) {
		SP_DDM_CUS_1_COMM_TARGET_Result temp =  new SP_DDM_CUS_1_COMM_TARGET_Result();
		temp.setCOMM_CODE((String)( objectArray[0]));
		temp.setTARGET((BigInteger)( objectArray[1]));
		return temp;
	}
	
	
	
	
	
	
	
	
	
}
