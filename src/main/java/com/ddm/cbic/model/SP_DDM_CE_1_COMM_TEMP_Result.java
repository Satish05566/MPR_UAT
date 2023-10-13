package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.Date;

public class SP_DDM_CE_1_COMM_TEMP_Result {

	String COMM_CODE;
    public Date MM_YYYY;
    public BigDecimal MOVING_TARGET;
    public BigDecimal POL_CRUDE;
    public BigDecimal POL_OTHER;
    public BigDecimal NON_POL; 
    public BigDecimal REFUND;
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
	public BigDecimal getPOL_CRUDE() {
		return POL_CRUDE;
	}
	public void setPOL_CRUDE(BigDecimal pOL_CRUDE) {
		POL_CRUDE = pOL_CRUDE;
	}
	public BigDecimal getPOL_OTHER() {
		return POL_OTHER;
	}
	public void setPOL_OTHER(BigDecimal pOL_OTHER) {
		POL_OTHER = pOL_OTHER;
	}
	public BigDecimal getNON_POL() {
		return NON_POL;
	}
	public void setNON_POL(BigDecimal nON_POL) {
		NON_POL = nON_POL;
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
    
	
	
	public  SP_DDM_CE_1_COMM_TEMP_Result generateResultBean(Object [] objectArray) {
		SP_DDM_CE_1_COMM_TEMP_Result temp =  new SP_DDM_CE_1_COMM_TEMP_Result();
		 if(null!=objectArray[0]) {
		temp.setCOMM_CODE((String)( objectArray[0]));}
		 if(null!=objectArray[1]) {
		temp.setMM_YYYY((Date)( objectArray[1]));}
		 if(null!=objectArray[2]) {
		temp.setMOVING_TARGET((BigDecimal)( objectArray[2]));}
		 if(null!=objectArray[3]) {
		temp.setPOL_CRUDE((BigDecimal)( objectArray[3]));}
		 if(null!=objectArray[4]) {
		temp.setPOL_OTHER((BigDecimal)( objectArray[4]));}
		 if(null!=objectArray[5]) {
		temp.setNON_POL((BigDecimal)( objectArray[5]));}
		 if(null!=objectArray[6]) {
		temp.setREFUND((BigDecimal)( objectArray[6]));}
		 if(null!=objectArray[7]) {
		temp.setREBATE((BigDecimal)( objectArray[7]));}
		
		return temp;
	}
	

	
}
