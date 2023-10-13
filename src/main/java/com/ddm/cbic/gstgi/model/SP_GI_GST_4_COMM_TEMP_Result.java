package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_GI_GST_4_COMM_TEMP_Result {

	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String AE_1_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String AE_2_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String INSPECTION_PERMISES_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SEARCHES_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String INSPECTION_GOODS_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SUMMONS_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SEIZUR67_GOODS_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SEIZUR67_GOODS_VALUE;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SEIZUR67_GOODS_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SEIZUR67_VEHICLES_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SEIZUR67_VEHICLES_VALUE;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SEIZUR67_VEHICLES_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SEIZUR67_CURRENCY_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric and only 2 digits allowed after decimal")
	private String SEIZUR67_CURRENCY_VALUE;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric and only 2 digits allowed after decimal")
	private String SEIZUR67_CURRENCY_TAX;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SEIZUR129_GOODS_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SEIZUR129_GOODS_VALUE;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String SEIZUR129_VEHICLES_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SEIZUR129_VEHICLES_VALUE;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String ATTACHMENT_GOODS_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ATTACHMENT_GOODS_VALUE;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String ATTACHMENT_PROPERTY_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ATTACHMENT_PROPERTY_VALUE;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String ATTACHMENT_ACCOUNT_NO;
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	private String INCIDENT_NO;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String INCIDENT_AMOUNT;

	public String getAE_1_NO() {
		return AE_1_NO;
	}

	public void setAE_1_NO(String aE_1_NO) {
		AE_1_NO = aE_1_NO;
	}

	public String getAE_2_NO() {
		return AE_2_NO;
	}

	public void setAE_2_NO(String aE_2_NO) {
		AE_2_NO = aE_2_NO;
	}

	public String getINSPECTION_PERMISES_NO() {
		return INSPECTION_PERMISES_NO;
	}

	public void setINSPECTION_PERMISES_NO(String iNSPECTION_PERMISES_NO) {
		INSPECTION_PERMISES_NO = iNSPECTION_PERMISES_NO;
	}

	public String getSEARCHES_NO() {
		return SEARCHES_NO;
	}

	public void setSEARCHES_NO(String sEARCHES_NO) {
		SEARCHES_NO = sEARCHES_NO;
	}

	public String getINSPECTION_GOODS_NO() {
		return INSPECTION_GOODS_NO;
	}

	public void setINSPECTION_GOODS_NO(String iNSPECTION_GOODS_NO) {
		INSPECTION_GOODS_NO = iNSPECTION_GOODS_NO;
	}

	public String getSUMMONS_NO() {
		return SUMMONS_NO;
	}

	public void setSUMMONS_NO(String sUMMONS_NO) {
		SUMMONS_NO = sUMMONS_NO;
	}

	public String getSEIZUR67_GOODS_NO() {
		return SEIZUR67_GOODS_NO;
	}

	public void setSEIZUR67_GOODS_NO(String sEIZUR67_GOODS_NO) {
		SEIZUR67_GOODS_NO = sEIZUR67_GOODS_NO;
	}

	public String getSEIZUR67_GOODS_VALUE() {
		return SEIZUR67_GOODS_VALUE;
	}

	public void setSEIZUR67_GOODS_VALUE(String sEIZUR67_GOODS_VALUE) {
		SEIZUR67_GOODS_VALUE = sEIZUR67_GOODS_VALUE;
	}

	public String getSEIZUR67_GOODS_TAX() {
		return SEIZUR67_GOODS_TAX;
	}

	public void setSEIZUR67_GOODS_TAX(String sEIZUR67_GOODS_TAX) {
		SEIZUR67_GOODS_TAX = sEIZUR67_GOODS_TAX;
	}

	public String getSEIZUR67_VEHICLES_NO() {
		return SEIZUR67_VEHICLES_NO;
	}

	public void setSEIZUR67_VEHICLES_NO(String sEIZUR67_VEHICLES_NO) {
		SEIZUR67_VEHICLES_NO = sEIZUR67_VEHICLES_NO;
	}

	public String getSEIZUR67_VEHICLES_VALUE() {
		return SEIZUR67_VEHICLES_VALUE;
	}

	public void setSEIZUR67_VEHICLES_VALUE(String sEIZUR67_VEHICLES_VALUE) {
		SEIZUR67_VEHICLES_VALUE = sEIZUR67_VEHICLES_VALUE;
	}

	public String getSEIZUR67_VEHICLES_TAX() {
		return SEIZUR67_VEHICLES_TAX;
	}

	public void setSEIZUR67_VEHICLES_TAX(String sEIZUR67_VEHICLES_TAX) {
		SEIZUR67_VEHICLES_TAX = sEIZUR67_VEHICLES_TAX;
	}

	public String getSEIZUR67_CURRENCY_NO() {
		return SEIZUR67_CURRENCY_NO;
	}

	public void setSEIZUR67_CURRENCY_NO(String sEIZUR67_CURRENCY_NO) {
		SEIZUR67_CURRENCY_NO = sEIZUR67_CURRENCY_NO;
	}

	public String getSEIZUR67_CURRENCY_VALUE() {
		return SEIZUR67_CURRENCY_VALUE;
	}

	public void setSEIZUR67_CURRENCY_VALUE(String sEIZUR67_CURRENCY_VALUE) {
		SEIZUR67_CURRENCY_VALUE = sEIZUR67_CURRENCY_VALUE;
	}

	public String getSEIZUR67_CURRENCY_TAX() {
		return SEIZUR67_CURRENCY_TAX;
	}

	public void setSEIZUR67_CURRENCY_TAX(String sEIZUR67_CURRENCY_TAX) {
		SEIZUR67_CURRENCY_TAX = sEIZUR67_CURRENCY_TAX;
	}

	public String getSEIZUR129_GOODS_NO() {
		return SEIZUR129_GOODS_NO;
	}

	public void setSEIZUR129_GOODS_NO(String sEIZUR129_GOODS_NO) {
		SEIZUR129_GOODS_NO = sEIZUR129_GOODS_NO;
	}

	public String getSEIZUR129_GOODS_VALUE() {
		return SEIZUR129_GOODS_VALUE;
	}

	public void setSEIZUR129_GOODS_VALUE(String sEIZUR129_GOODS_VALUE) {
		SEIZUR129_GOODS_VALUE = sEIZUR129_GOODS_VALUE;
	}

	public String getSEIZUR129_VEHICLES_NO() {
		return SEIZUR129_VEHICLES_NO;
	}

	public void setSEIZUR129_VEHICLES_NO(String sEIZUR129_VEHICLES_NO) {
		SEIZUR129_VEHICLES_NO = sEIZUR129_VEHICLES_NO;
	}

	public String getSEIZUR129_VEHICLES_VALUE() {
		return SEIZUR129_VEHICLES_VALUE;
	}

	public void setSEIZUR129_VEHICLES_VALUE(String sEIZUR129_VEHICLES_VALUE) {
		SEIZUR129_VEHICLES_VALUE = sEIZUR129_VEHICLES_VALUE;
	}

	public String getATTACHMENT_GOODS_NO() {
		return ATTACHMENT_GOODS_NO;
	}

	public void setATTACHMENT_GOODS_NO(String aTTACHMENT_GOODS_NO) {
		ATTACHMENT_GOODS_NO = aTTACHMENT_GOODS_NO;
	}

	public String getATTACHMENT_GOODS_VALUE() {
		return ATTACHMENT_GOODS_VALUE;
	}

	public void setATTACHMENT_GOODS_VALUE(String aTTACHMENT_GOODS_VALUE) {
		ATTACHMENT_GOODS_VALUE = aTTACHMENT_GOODS_VALUE;
	}

	public String getATTACHMENT_PROPERTY_NO() {
		return ATTACHMENT_PROPERTY_NO;
	}

	public void setATTACHMENT_PROPERTY_NO(String aTTACHMENT_PROPERTY_NO) {
		ATTACHMENT_PROPERTY_NO = aTTACHMENT_PROPERTY_NO;
	}

	public String getATTACHMENT_PROPERTY_VALUE() {
		return ATTACHMENT_PROPERTY_VALUE;
	}

	public void setATTACHMENT_PROPERTY_VALUE(String aTTACHMENT_PROPERTY_VALUE) {
		ATTACHMENT_PROPERTY_VALUE = aTTACHMENT_PROPERTY_VALUE;
	}

	public String getATTACHMENT_ACCOUNT_NO() {
		return ATTACHMENT_ACCOUNT_NO;
	}

	public void setATTACHMENT_ACCOUNT_NO(String aTTACHMENT_ACCOUNT_NO) {
		ATTACHMENT_ACCOUNT_NO = aTTACHMENT_ACCOUNT_NO;
	}

	public String getINCIDENT_NO() {
		return INCIDENT_NO;
	}

	public void setINCIDENT_NO(String iNCIDENT_NO) {
		INCIDENT_NO = iNCIDENT_NO;
	}

	public String getINCIDENT_AMOUNT() {
		return INCIDENT_AMOUNT;
	}

	public void setINCIDENT_AMOUNT(String iNCIDENT_AMOUNT) {
		INCIDENT_AMOUNT = iNCIDENT_AMOUNT;
	}

	public SP_GI_GST_4_COMM_TEMP_Result generateCommTempResult(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_GI_GST_4_COMM_TEMP_Result> list = new ArrayList<SP_GI_GST_4_COMM_TEMP_Result>();
			for (Object[] objectArray : resultList) {
				SP_GI_GST_4_COMM_TEMP_Result temp = new SP_GI_GST_4_COMM_TEMP_Result();

				temp = generateReportBean(objectArray);
				list.add(temp);
			}
			return list.get(0);
		}
	}

	private SP_GI_GST_4_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

		SP_GI_GST_4_COMM_TEMP_Result temp = new SP_GI_GST_4_COMM_TEMP_Result();

		if (null != objectArray[0]) {
			temp.setAE_1_NO((String.valueOf(objectArray[0])));
		}
		if (null != objectArray[1]) {
			temp.setAE_2_NO((String.valueOf(objectArray[1])));
		}
		if (null != objectArray[2]) {
			temp.setINSPECTION_PERMISES_NO((String.valueOf(objectArray[2])));
		}
		if (null != objectArray[3]) {
			temp.setSEARCHES_NO((String.valueOf(objectArray[3])));
		}
		if (null != objectArray[4]) {
			temp.setINSPECTION_GOODS_NO((String.valueOf(objectArray[4])));
		}
		if (null != objectArray[5]) {
			temp.setSUMMONS_NO((String.valueOf(objectArray[5])));
		}
		if (null != objectArray[6]) {
			temp.setSEIZUR67_GOODS_NO((String.valueOf(objectArray[6])));
		}
		if (null != objectArray[7]) {
			temp.setSEIZUR67_GOODS_VALUE((String.valueOf(objectArray[7])));
		}
		if (null != objectArray[8]) {
			temp.setSEIZUR67_GOODS_TAX((String.valueOf(objectArray[8])));
		}
		if (null != objectArray[9]) {
			temp.setSEIZUR67_VEHICLES_NO((String.valueOf(objectArray[9])));
		}
		if (null != objectArray[10]) {
			temp.setSEIZUR67_VEHICLES_VALUE((String.valueOf(objectArray[10])));
		}
		if (null != objectArray[11]) {
			temp.setSEIZUR67_VEHICLES_TAX((String.valueOf(objectArray[11])));
		}
		if (null != objectArray[12]) {
			temp.setSEIZUR67_CURRENCY_NO((String.valueOf(objectArray[12])));
		}
		if (null != objectArray[13]) {
			temp.setSEIZUR67_CURRENCY_VALUE((String.valueOf(objectArray[13])));
		}
		if (null != objectArray[14]) {
			temp.setSEIZUR67_CURRENCY_TAX((String.valueOf(objectArray[14])));
		}
		if (null != objectArray[15]) {
			temp.setSEIZUR129_GOODS_NO((String.valueOf(objectArray[15])));
		}
		if (null != objectArray[16]) {
			temp.setSEIZUR129_GOODS_VALUE((String.valueOf(objectArray[16])));
		}
		if (null != objectArray[17]) {
			temp.setSEIZUR129_VEHICLES_NO((String.valueOf(objectArray[17])));
		}
		if (null != objectArray[18]) {
			temp.setSEIZUR129_VEHICLES_VALUE((String.valueOf(objectArray[18])));
		}
		if (null != objectArray[19]) {
			temp.setATTACHMENT_GOODS_NO((String.valueOf(objectArray[19])));
		}
		if (null != objectArray[20]) {
			temp.setATTACHMENT_GOODS_VALUE((String.valueOf(objectArray[20])));
		}
		if (null != objectArray[21]) {
			temp.setATTACHMENT_PROPERTY_NO((String.valueOf(objectArray[21])));
		}
		if (null != objectArray[22]) {
			temp.setATTACHMENT_PROPERTY_VALUE((String.valueOf(objectArray[22])));
		}
		if (null != objectArray[23]) {
			temp.setATTACHMENT_ACCOUNT_NO((String.valueOf(objectArray[23])));
		}
		if (null != objectArray[24]) {
			temp.setINCIDENT_NO((String.valueOf(objectArray[24])));
		}
		if (null != objectArray[25]) {
			temp.setINCIDENT_AMOUNT((String.valueOf(objectArray[25])));
		}

		return temp;

	}

}
