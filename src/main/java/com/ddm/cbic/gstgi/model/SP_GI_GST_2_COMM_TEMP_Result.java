package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_GI_GST_2_COMM_TEMP_Result {

	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String OPENING_BALANCE_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String OPENING_BALANCE_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String RECEIPT_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String RECEIPT_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SCN_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SCN_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String VOLUNTARY_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String VOLUNTARY_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String MERIT_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String MERIT_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String TRANSFER_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String TRANSFER_TAX;
	private String CLOSING_BALANCE_NO;
	private String CLOSING_BALANCE_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String LESS_THAN_2_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String LESS_THAN_2_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String MORE_THAN_2_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String MORE_THAN_2_TAX;

	public String getOPENING_BALANCE_NO() {
		return OPENING_BALANCE_NO;
	}

	public void setOPENING_BALANCE_NO(String oPENING_BALANCE_NO) {
		OPENING_BALANCE_NO = oPENING_BALANCE_NO;
	}

	public String getOPENING_BALANCE_TAX() {
		return OPENING_BALANCE_TAX;
	}

	public void setOPENING_BALANCE_TAX(String oPENING_BALANCE_TAX) {
		OPENING_BALANCE_TAX = oPENING_BALANCE_TAX;
	}

	public String getRECEIPT_NO() {
		return RECEIPT_NO;
	}

	public void setRECEIPT_NO(String rECEIPT_NO) {
		RECEIPT_NO = rECEIPT_NO;
	}

	public String getRECEIPT_TAX() {
		return RECEIPT_TAX;
	}

	public void setRECEIPT_TAX(String rECEIPT_TAX) {
		RECEIPT_TAX = rECEIPT_TAX;
	}

	public String getSCN_NO() {
		return SCN_NO;
	}

	public void setSCN_NO(String sCN_NO) {
		SCN_NO = sCN_NO;
	}

	public String getSCN_TAX() {
		return SCN_TAX;
	}

	public void setSCN_TAX(String sCN_TAX) {
		SCN_TAX = sCN_TAX;
	}

	public String getVOLUNTARY_NO() {
		return VOLUNTARY_NO;
	}

	public void setVOLUNTARY_NO(String vOLUNTARY_NO) {
		VOLUNTARY_NO = vOLUNTARY_NO;
	}

	public String getVOLUNTARY_TAX() {
		return VOLUNTARY_TAX;
	}

	public void setVOLUNTARY_TAX(String vOLUNTARY_TAX) {
		VOLUNTARY_TAX = vOLUNTARY_TAX;
	}

	public String getMERIT_NO() {
		return MERIT_NO;
	}

	public void setMERIT_NO(String mERIT_NO) {
		MERIT_NO = mERIT_NO;
	}

	public String getMERIT_TAX() {
		return MERIT_TAX;
	}

	public void setMERIT_TAX(String mERIT_TAX) {
		MERIT_TAX = mERIT_TAX;
	}

	public String getTRANSFER_NO() {
		return TRANSFER_NO;
	}

	public void setTRANSFER_NO(String tRANSFER_NO) {
		TRANSFER_NO = tRANSFER_NO;
	}

	public String getTRANSFER_TAX() {
		return TRANSFER_TAX;
	}

	public void setTRANSFER_TAX(String tRANSFER_TAX) {
		TRANSFER_TAX = tRANSFER_TAX;
	}

	public String getCLOSING_BALANCE_NO() {
		return CLOSING_BALANCE_NO;
	}

	public void setCLOSING_BALANCE_NO(String cLOSING_BALANCE_NO) {
		CLOSING_BALANCE_NO = cLOSING_BALANCE_NO;
	}

	public String getCLOSING_BALANCE_TAX() {
		return CLOSING_BALANCE_TAX;
	}

	public void setCLOSING_BALANCE_TAX(String cLOSING_BALANCE_TAX) {
		CLOSING_BALANCE_TAX = cLOSING_BALANCE_TAX;
	}

	public String getLESS_THAN_2_NO() {
		return LESS_THAN_2_NO;
	}

	public void setLESS_THAN_2_NO(String lESS_THAN_2_NO) {
		LESS_THAN_2_NO = lESS_THAN_2_NO;
	}

	public String getLESS_THAN_2_TAX() {
		return LESS_THAN_2_TAX;
	}

	public void setLESS_THAN_2_TAX(String lESS_THAN_2_TAX) {
		LESS_THAN_2_TAX = lESS_THAN_2_TAX;
	}

	public String getMORE_THAN_2_NO() {
		return MORE_THAN_2_NO;
	}

	public void setMORE_THAN_2_NO(String mORE_THAN_2_NO) {
		MORE_THAN_2_NO = mORE_THAN_2_NO;
	}

	public String getMORE_THAN_2_TAX() {
		return MORE_THAN_2_TAX;
	}

	public void setMORE_THAN_2_TAX(String mORE_THAN_2_TAX) {
		MORE_THAN_2_TAX = mORE_THAN_2_TAX;
	}

	public SP_GI_GST_2_COMM_TEMP_Result generateCommTempResult(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_GI_GST_2_COMM_TEMP_Result> list = new ArrayList<SP_GI_GST_2_COMM_TEMP_Result>();
			for (Object[] objectArray : resultList) {
				SP_GI_GST_2_COMM_TEMP_Result temp = new SP_GI_GST_2_COMM_TEMP_Result();

				temp = generateReportBean(objectArray);
				list.add(temp);
			}
			return list.get(0);
		}
	}

	private SP_GI_GST_2_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

		SP_GI_GST_2_COMM_TEMP_Result temp = new SP_GI_GST_2_COMM_TEMP_Result();

		if (null != objectArray[0]) {
			temp.setOPENING_BALANCE_NO(String.valueOf(objectArray[0]));
		}
		if (null != objectArray[1]) {
			temp.setOPENING_BALANCE_TAX(String.valueOf(objectArray[1]));
		}
		if (null != objectArray[2]) {
			temp.setRECEIPT_NO(String.valueOf(objectArray[2]));
		}
		if (null != objectArray[3]) {
			temp.setRECEIPT_TAX(String.valueOf(objectArray[3]));
		}
		if (null != objectArray[4]) {
			temp.setSCN_NO(String.valueOf(objectArray[4]));
		}
		if (null != objectArray[5]) {
			temp.setSCN_TAX(String.valueOf(objectArray[5]));
		}
		if (null != objectArray[6]) {
			temp.setVOLUNTARY_NO(String.valueOf(objectArray[6]));
		}
		if (null != objectArray[7]) {
			temp.setVOLUNTARY_TAX(String.valueOf(objectArray[7]));
		}
		if (null != objectArray[8]) {
			temp.setMERIT_NO(String.valueOf(objectArray[8]));
		}
		if (null != objectArray[9]) {
			temp.setMERIT_TAX(String.valueOf(objectArray[9]));
		}
		if (null != objectArray[10]) {
			temp.setTRANSFER_NO(String.valueOf(objectArray[10]));
		}
		if (null != objectArray[11]) {
			temp.setTRANSFER_TAX(String.valueOf(objectArray[11]));
		}
		if (null != objectArray[12]) {
			temp.setCLOSING_BALANCE_NO(String.valueOf(objectArray[12]));
		}
		if (null != objectArray[13]) {
			temp.setCLOSING_BALANCE_TAX(String.valueOf(objectArray[13]));
		}
		if (null != objectArray[14]) {
			temp.setLESS_THAN_2_NO(String.valueOf(objectArray[14]));
		}
		if (null != objectArray[15]) {
			temp.setLESS_THAN_2_TAX(String.valueOf(objectArray[15]));
		}
		if (null != objectArray[16]) {
			temp.setMORE_THAN_2_NO(String.valueOf(objectArray[16]));
		}
		if (null != objectArray[17]) {
			temp.setMORE_THAN_2_TAX(String.valueOf(objectArray[17]));
		}

		return temp;

	}

}
