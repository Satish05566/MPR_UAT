package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.Date;

public class SP_DDM_CUS_1_COMM_TEMP_ProcResult {
String COMM_CODE;
	Date MM_YYYY;
	BigDecimal MOVING_TARGET;
	BigDecimal REVENUE_POL;
	BigDecimal REVENUE_NON_POL;
	BigDecimal CESS_IRON;
	BigDecimal CESS_OTHER;
	BigDecimal RECIEPTS_EXPORT;
	BigDecimal RECIEPTS_OTHER;
	BigDecimal REFUND;
	BigDecimal REBATE_CUS;
	
	BigDecimal REBATE_CEX;
    BigDecimal REBATE_STX;
	BigDecimal IGST_REFUND;
	 
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
	public BigDecimal getREVENUE_POL() {
		return REVENUE_POL;
	}
	public void setREVENUE_POL(BigDecimal rEVENUE_POL) {
		REVENUE_POL = rEVENUE_POL;
	}
	public BigDecimal getREVENUE_NON_POL() {
		return REVENUE_NON_POL;
	}
	public void setREVENUE_NON_POL(BigDecimal rEVENUE_NON_POL) {
		REVENUE_NON_POL = rEVENUE_NON_POL;
	}
	public BigDecimal getCESS_IRON() {
		return CESS_IRON;
	}
	public void setCESS_IRON(BigDecimal cESS_IRON) {
		CESS_IRON = cESS_IRON;
	}
	public BigDecimal getCESS_OTHER() {
		return CESS_OTHER;
	}
	public void setCESS_OTHER(BigDecimal cESS_OTHER) {
		CESS_OTHER = cESS_OTHER;
	}
	public BigDecimal getRECIEPTS_EXPORT() {
		return RECIEPTS_EXPORT;
	}
	public void setRECIEPTS_EXPORT(BigDecimal rECIEPTS_EXPORT) {
		RECIEPTS_EXPORT = rECIEPTS_EXPORT;
	}
	public BigDecimal getRECIEPTS_OTHER() {
		return RECIEPTS_OTHER;
	}
	public void setRECIEPTS_OTHER(BigDecimal rECIEPTS_OTHER) {
		RECIEPTS_OTHER = rECIEPTS_OTHER;
	}
	public BigDecimal getREFUND() {
		return REFUND;
	}
	public void setREFUND(BigDecimal rEFUND) {
		REFUND = rEFUND;
	}
	public BigDecimal getREBATE_CUS() {
		return REBATE_CUS;
	}
	public void setREBATE_CUS(BigDecimal rEBATE_CUS) {
		REBATE_CUS = rEBATE_CUS;
	}
	public BigDecimal getREBATE_CEX() {
		return REBATE_CEX;
	}
	public void setREBATE_CEX(BigDecimal rEBATE_CEX) {
		REBATE_CEX = rEBATE_CEX;
	}
	public BigDecimal getREBATE_STX() {
		return REBATE_STX;
	}
	public void setREBATE_STX(BigDecimal rEBATE_STX) {
		REBATE_STX = rEBATE_STX;
	}
	public BigDecimal getIGST_REFUND() {
		return IGST_REFUND;
	}
	public void setIGST_REFUND(BigDecimal iGST_REFUND) {
		IGST_REFUND = iGST_REFUND;
	}
	
	public  SP_DDM_CUS_1_COMM_TEMP_ProcResult generateResultBean(Object [] objectArray) {
		SP_DDM_CUS_1_COMM_TEMP_ProcResult temp =  new SP_DDM_CUS_1_COMM_TEMP_ProcResult();
		temp.setCOMM_CODE((String)( objectArray[0]));
		temp.setMM_YYYY((Date)( objectArray[1]));
		temp.setMOVING_TARGET((BigDecimal)( objectArray[2]));
		temp.setREVENUE_POL((BigDecimal)( objectArray[3]));
		temp.setREVENUE_NON_POL((BigDecimal)( objectArray[4]));
		temp.setCESS_IRON((BigDecimal)( objectArray[5]));
		temp.setCESS_OTHER((BigDecimal)( objectArray[6]));
		temp.setRECIEPTS_EXPORT((BigDecimal)( objectArray[7]));
		temp.setRECIEPTS_OTHER((BigDecimal)( objectArray[8]));
		temp.setREFUND((BigDecimal)( objectArray[9]));
		temp.setREBATE_CUS((BigDecimal)( objectArray[10]));
		temp.setREBATE_CEX((BigDecimal)( objectArray[11]));
		temp.setREBATE_STX((BigDecimal)( objectArray[12]));
		temp.setIGST_REFUND((BigDecimal)( objectArray[13]));
		return temp;
	}

	
}
