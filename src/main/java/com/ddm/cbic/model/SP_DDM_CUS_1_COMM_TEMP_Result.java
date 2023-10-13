package com.ddm.cbic.model;
import javax.validation.constraints.Digits;

public class SP_DDM_CUS_1_COMM_TEMP_Result {
	
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public String COMM_CODE;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public String MOVING_TARGET;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String REVENUE_POL;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String REVENUE_NON_POL;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String CESS_IRON;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String CESS_OTHER;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String RECIEPTS_EXPORT;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String RECIEPTS_OTHER;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String REBATE_CUS;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String REBATE_CEX;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String REBATE_STX;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
     public String IGST_REFUND;
	 
	public String getCOMM_CODE() {
		return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}
	public String getMOVING_TARGET() {
		return MOVING_TARGET;
	}
	public void setMOVING_TARGET(String mOVING_TARGET) {
		MOVING_TARGET = mOVING_TARGET;
	}
	public String getREVENUE_POL() {
		return REVENUE_POL;
	}
	public void setREVENUE_POL(String rEVENUE_POL) {
		REVENUE_POL = rEVENUE_POL;
	}
	public String getREVENUE_NON_POL() {
		return REVENUE_NON_POL;
	}
	public void setREVENUE_NON_POL(String rEVENUE_NON_POL) {
		REVENUE_NON_POL = rEVENUE_NON_POL;
	}
	public String getCESS_IRON() {
		return CESS_IRON;
	}
	public void setCESS_IRON(String cESS_IRON) {
		CESS_IRON = cESS_IRON;
	}
	public String getCESS_OTHER() {
		return CESS_OTHER;
	}
	public void setCESS_OTHER(String cESS_OTHER) {
		CESS_OTHER = cESS_OTHER;
	}
	public String getRECIEPTS_EXPORT() {
		return RECIEPTS_EXPORT;
	}
	public void setRECIEPTS_EXPORT(String rECIEPTS_EXPORT) {
		RECIEPTS_EXPORT = rECIEPTS_EXPORT;
	}
	public String getRECIEPTS_OTHER() {
		return RECIEPTS_OTHER;
	}
	public void setRECIEPTS_OTHER(String rECIEPTS_OTHER) {
		RECIEPTS_OTHER = rECIEPTS_OTHER;
	}
	public String getREFUND() {
		return REFUND;
	}
	public void setREFUND(String rEFUND) {
		REFUND = rEFUND;
	}
	public String getREBATE_CUS() {
		return REBATE_CUS;
	}
	public void setREBATE_CUS(String rEBATE_CUS) {
		REBATE_CUS = rEBATE_CUS;
	}
	public String getREBATE_CEX() {
		return REBATE_CEX;
	}
	public void setREBATE_CEX(String rEBATE_CEX) {
		REBATE_CEX = rEBATE_CEX;
	}
	public String getREBATE_STX() {
		return REBATE_STX;
	}
	public void setREBATE_STX(String rEBATE_STX) {
		REBATE_STX = rEBATE_STX;
	}
	public String getIGST_REFUND() {
		return IGST_REFUND;
	}
	public void setIGST_REFUND(String iGST_REFUND) {
		IGST_REFUND = iGST_REFUND;
	}
     
     
     
}
