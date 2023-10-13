package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.Date;

public class SP_DDM_CUS_1A_COMM_TEMP_ProcResult {
	
	String COMM_CODE;
	Date MM_YYYY;
	BigDecimal MOVING_TARGET;
	BigDecimal CUSTOM_DUTY_NONGST_POL;
	BigDecimal CUSTOM_DUTY_NONGST_NON_POL;
	BigDecimal CESS_CESS;
	BigDecimal CESS_COMP_IMPORT;
	BigDecimal SEZ;
	BigDecimal OTHER_RECEIPTS_EXPORT_DUTY;
	BigDecimal OTHER_RECEIPTS_MISCLLANEOUS;
	BigDecimal OTHER_RECEIPTS_IGST_IMPORT;	
	BigDecimal CUSTOM_DUTY_NONGST_REFUND;
    BigDecimal CESS_REFUND;
	BigDecimal COMP_CESS_IMPORT_REFUND;	
	BigDecimal EXPORT_DUTY_REFUND;
    BigDecimal IGST_IMPORT_REFUND;
	BigDecimal IGST_EXPORT_REFUND;
	BigDecimal DRAWBACK;
	 
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
	public BigDecimal getCUSTOM_DUTY_NONGST_POL() {
		return CUSTOM_DUTY_NONGST_POL;
	}
	public void setCUSTOM_DUTY_NONGST_POL(BigDecimal cUSTOM_DUTY_NONGST_POL) {
		CUSTOM_DUTY_NONGST_POL = cUSTOM_DUTY_NONGST_POL;
	}
	public BigDecimal getCUSTOM_DUTY_NONGST_NON_POL() {
		return CUSTOM_DUTY_NONGST_NON_POL;
	}
	public void setCUSTOM_DUTY_NONGST_NON_POL(BigDecimal cUSTOM_DUTY_NONGST_NON_POL) {
		CUSTOM_DUTY_NONGST_NON_POL = cUSTOM_DUTY_NONGST_NON_POL;
	}
	public BigDecimal getCESS_CESS() {
		return CESS_CESS;
	}
	public void setCESS_CESS(BigDecimal cESS_CESS) {
		CESS_CESS = cESS_CESS;
	}
	public BigDecimal getCESS_COMP_IMPORT() {
		return CESS_COMP_IMPORT;
	}
	public void setCESS_COMP_IMPORT(BigDecimal cESS_COMP_IMPORT) {
		CESS_COMP_IMPORT = cESS_COMP_IMPORT;
	}
	public BigDecimal getSEZ() {
		return SEZ;
	}
	public void setSEZ(BigDecimal sEZ) {
		SEZ = sEZ;
	}
	public BigDecimal getOTHER_RECEIPTS_EXPORT_DUTY() {
		return OTHER_RECEIPTS_EXPORT_DUTY;
	}
	public void setOTHER_RECEIPTS_EXPORT_DUTY(BigDecimal oTHER_RECEIPTS_EXPORT_DUTY) {
		OTHER_RECEIPTS_EXPORT_DUTY = oTHER_RECEIPTS_EXPORT_DUTY;
	}
	public BigDecimal getOTHER_RECEIPTS_MISCLLANEOUS() {
		return OTHER_RECEIPTS_MISCLLANEOUS;
	}
	public void setOTHER_RECEIPTS_MISCLLANEOUS(BigDecimal oTHER_RECEIPTS_MISCLLANEOUS) {
		OTHER_RECEIPTS_MISCLLANEOUS = oTHER_RECEIPTS_MISCLLANEOUS;
	}
	public BigDecimal getOTHER_RECEIPTS_IGST_IMPORT() {
		return OTHER_RECEIPTS_IGST_IMPORT;
	}
	public void setOTHER_RECEIPTS_IGST_IMPORT(BigDecimal oTHER_RECEIPTS_IGST_IMPORT) {
		OTHER_RECEIPTS_IGST_IMPORT = oTHER_RECEIPTS_IGST_IMPORT;
	}
	public BigDecimal getCUSTOM_DUTY_NONGST_REFUND() {
		return CUSTOM_DUTY_NONGST_REFUND;
	}
	public void setCUSTOM_DUTY_NONGST_REFUND(BigDecimal cUSTOM_DUTY_NONGST_REFUND) {
		CUSTOM_DUTY_NONGST_REFUND = cUSTOM_DUTY_NONGST_REFUND;
	}
	public BigDecimal getCESS_REFUND() {
		return CESS_REFUND;
	}
	public void setCESS_REFUND(BigDecimal cESS_REFUND) {
		CESS_REFUND = cESS_REFUND;
	}
	public BigDecimal getCOMP_CESS_IMPORT_REFUND() {
		return COMP_CESS_IMPORT_REFUND;
	}
	public void setCOMP_CESS_IMPORT_REFUND(BigDecimal cOMP_CESS_IMPORT_REFUND) {
		COMP_CESS_IMPORT_REFUND = cOMP_CESS_IMPORT_REFUND;
	}
	public BigDecimal getEXPORT_DUTY_REFUND() {
		return EXPORT_DUTY_REFUND;
	}
	public void setEXPORT_DUTY_REFUND(BigDecimal eXPORT_DUTY_REFUND) {
		EXPORT_DUTY_REFUND = eXPORT_DUTY_REFUND;
	}
	public BigDecimal getIGST_IMPORT_REFUND() {
		return IGST_IMPORT_REFUND;
	}
	public void setIGST_IMPORT_REFUND(BigDecimal iGST_IMPORT_REFUND) {
		IGST_IMPORT_REFUND = iGST_IMPORT_REFUND;
	}
	public BigDecimal getIGST_EXPORT_REFUND() {
		return IGST_EXPORT_REFUND;
	}
	public void setIGST_EXPORT_REFUND(BigDecimal iGST_EXPORT_REFUND) {
		IGST_EXPORT_REFUND = iGST_EXPORT_REFUND;
	}
	public BigDecimal getDRAWBACK() {
		return DRAWBACK;
	}
	public void setDRAWBACK(BigDecimal dRAWBACK) {
		DRAWBACK = dRAWBACK;
	}
	
	public  SP_DDM_CUS_1A_COMM_TEMP_ProcResult generateResultBean(Object [] objectArray) {
		SP_DDM_CUS_1A_COMM_TEMP_ProcResult temp =  new SP_DDM_CUS_1A_COMM_TEMP_ProcResult();
		temp.setCOMM_CODE((String)( objectArray[0]));
		temp.setMM_YYYY((Date)( objectArray[1]));
		temp.setMOVING_TARGET((BigDecimal)( objectArray[2]));
		temp.setCUSTOM_DUTY_NONGST_POL((BigDecimal)( objectArray[3]));
		temp.setCUSTOM_DUTY_NONGST_NON_POL((BigDecimal)( objectArray[4]));
		temp.setCESS_CESS((BigDecimal)( objectArray[5]));
		temp.setCESS_COMP_IMPORT((BigDecimal)( objectArray[6]));
		temp.setSEZ((BigDecimal)( objectArray[7]));
		temp.setOTHER_RECEIPTS_EXPORT_DUTY((BigDecimal)( objectArray[8]));
		temp.setOTHER_RECEIPTS_MISCLLANEOUS((BigDecimal)( objectArray[9]));
		temp.setOTHER_RECEIPTS_IGST_IMPORT((BigDecimal)( objectArray[10]));
		temp.setCUSTOM_DUTY_NONGST_REFUND((BigDecimal)( objectArray[11]));
		temp.setCESS_REFUND((BigDecimal)( objectArray[12]));
		temp.setCOMP_CESS_IMPORT_REFUND((BigDecimal)( objectArray[13]));
		temp.setEXPORT_DUTY_REFUND((BigDecimal)( objectArray[14]));
		temp.setIGST_IMPORT_REFUND((BigDecimal)( objectArray[15]));
		temp.setIGST_EXPORT_REFUND((BigDecimal)( objectArray[16]));
		temp.setDRAWBACK((BigDecimal)( objectArray[17]));
		return temp;
	}

	

}
