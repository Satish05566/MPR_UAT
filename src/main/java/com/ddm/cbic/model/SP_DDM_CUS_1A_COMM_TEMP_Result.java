package com.ddm.cbic.model;
import javax.validation.constraints.Digits;

public class SP_DDM_CUS_1A_COMM_TEMP_Result {
	
	@Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public String COMM_CODE;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	 public String MOVING_TARGET;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String CUSTOM_DUTY_NONGST_POL;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String CUSTOM_DUTY_NONGST_NON_POL;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String CESS_CESS;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String CESS_COMP_IMPORT;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String SEZ;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String OTHER_RECEIPTS_EXPORT_DUTY;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String OTHER_RECEIPTS_MISCLLANEOUS;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String OTHER_RECEIPTS_IGST_IMPORT;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String CUSTOM_DUTY_NONGST_REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String CESS_REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
    public String COMP_CESS_IMPORT_REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	    public String EXPORT_DUTY_REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	    public String IGST_IMPORT_REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	    public String IGST_EXPORT_REFUND;
	 
	 @Digits(message="Must be numeric", fraction = 2, integer = 15)
	    public String DRAWBACK;
	 
	 public String getCOMM_CODE() {
			return COMM_CODE;
		}
		public void setCOMM_CODE(String cOMM_CODE) {
			COMM_CODE = cOMM_CODE;
		}
		
		public String  getMOVING_TARGET() {
			return MOVING_TARGET;
		}
		public void setMOVING_TARGET(String  mOVING_TARGET) {
			MOVING_TARGET = mOVING_TARGET;
		}
		public String  getCUSTOM_DUTY_NONGST_POL() {
			return CUSTOM_DUTY_NONGST_POL;
		}
		public void setCUSTOM_DUTY_NONGST_POL(String  cUSTOM_DUTY_NONGST_POL) {
			CUSTOM_DUTY_NONGST_POL = cUSTOM_DUTY_NONGST_POL;
		}
		public String  getCUSTOM_DUTY_NONGST_NON_POL() {
			return CUSTOM_DUTY_NONGST_NON_POL;
		}
		public void setCUSTOM_DUTY_NONGST_NON_POL(String  cUSTOM_DUTY_NONGST_NON_POL) {
			CUSTOM_DUTY_NONGST_NON_POL = cUSTOM_DUTY_NONGST_NON_POL;
		}
		public String  getCESS_CESS() {
			return CESS_CESS;
		}
		public void setCESS_CESS(String  cESS_CESS) {
			CESS_CESS = cESS_CESS;
		}
		public String  getCESS_COMP_IMPORT() {
			return CESS_COMP_IMPORT;
		}
		public void setCESS_COMP_IMPORT(String  cESS_COMP_IMPORT) {
			CESS_COMP_IMPORT = cESS_COMP_IMPORT;
		}
		public String  getSEZ() {
			return SEZ;
		}
		public void setSEZ(String  sEZ) {
			SEZ = sEZ;
		}
		public String  getOTHER_RECEIPTS_EXPORT_DUTY() {
			return OTHER_RECEIPTS_EXPORT_DUTY;
		}
		public void setOTHER_RECEIPTS_EXPORT_DUTY(String  oTHER_RECEIPTS_EXPORT_DUTY) {
			OTHER_RECEIPTS_EXPORT_DUTY = oTHER_RECEIPTS_EXPORT_DUTY;
		}
		public String  getOTHER_RECEIPTS_MISCLLANEOUS() {
			return OTHER_RECEIPTS_MISCLLANEOUS;
		}
		public void setOTHER_RECEIPTS_MISCLLANEOUS(String  oTHER_RECEIPTS_MISCLLANEOUS) {
			OTHER_RECEIPTS_MISCLLANEOUS = oTHER_RECEIPTS_MISCLLANEOUS;
		}
		public String  getOTHER_RECEIPTS_IGST_IMPORT() {
			return OTHER_RECEIPTS_IGST_IMPORT;
		}
		public void setOTHER_RECEIPTS_IGST_IMPORT(String  oTHER_RECEIPTS_IGST_IMPORT) {
			OTHER_RECEIPTS_IGST_IMPORT = oTHER_RECEIPTS_IGST_IMPORT;
		}
		public String  getCUSTOM_DUTY_NONGST_REFUND() {
			return CUSTOM_DUTY_NONGST_REFUND;
		}
		public void setCUSTOM_DUTY_NONGST_REFUND(String  cUSTOM_DUTY_NONGST_REFUND) {
			CUSTOM_DUTY_NONGST_REFUND = cUSTOM_DUTY_NONGST_REFUND;
		}
		public String  getCESS_REFUND() {
			return CESS_REFUND;
		}
		public void setCESS_REFUND(String  cESS_REFUND) {
			CESS_REFUND = cESS_REFUND;
		}
		public String  getCOMP_CESS_IMPORT_REFUND() {
			return COMP_CESS_IMPORT_REFUND;
		}
		public void setCOMP_CESS_IMPORT_REFUND(String  cOMP_CESS_IMPORT_REFUND) {
			COMP_CESS_IMPORT_REFUND = cOMP_CESS_IMPORT_REFUND;
		}
		public String  getEXPORT_DUTY_REFUND() {
			return EXPORT_DUTY_REFUND;
		}
		public void setEXPORT_DUTY_REFUND(String  eXPORT_DUTY_REFUND) {
			EXPORT_DUTY_REFUND = eXPORT_DUTY_REFUND;
		}
		public String  getIGST_IMPORT_REFUND() {
			return IGST_IMPORT_REFUND;
		}
		public void setIGST_IMPORT_REFUND(String  iGST_IMPORT_REFUND) {
			IGST_IMPORT_REFUND = iGST_IMPORT_REFUND;
		}
		public String  getIGST_EXPORT_REFUND() {
			return IGST_EXPORT_REFUND;
		}
		public void setIGST_EXPORT_REFUND(String  iGST_EXPORT_REFUND) {
			IGST_EXPORT_REFUND = iGST_EXPORT_REFUND;
		}
		public String  getDRAWBACK() {
			return DRAWBACK;
		}
		public void setDRAWBACK(String  dRAWBACK) {
			DRAWBACK = dRAWBACK;
		}

}
