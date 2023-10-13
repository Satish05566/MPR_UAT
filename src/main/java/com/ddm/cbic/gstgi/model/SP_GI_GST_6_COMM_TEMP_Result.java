package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_GI_GST_6_COMM_TEMP_Result {

	private String COMM_CODE;
	private String MM_YYYY;
	
	@NotEmpty(message="*")	
	private String HSN_SAC_CODE;
	
	
	private String HSN_SAC_CODE_DESCRIPTION;
	
	@NotEmpty(message="*")
	private String GOODS_OR_SERVICES_TYPE;
	
	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String NO_OF_CASES;
	
	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String AMOUNT_OF_TAX_EVASION;
	
	@NotEmpty(message="*")
	@Pattern(regexp="^(0|[1-9][0-9]*)$",message="Must be Integer")
	private String NO_OF_CASES_PRE;
	
	@NotEmpty(message="*")
	@Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String AMOUNT_OF_TAX_EVASION_PRE;
	
	

	

	
	public String getCOMM_CODE() {
		return COMM_CODE;
	}

	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}

	public String getMM_YYYY() {
		return MM_YYYY;
	}

	public void setMM_YYYY(String mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}

	public String getHSN_SAC_CODE() {
		return HSN_SAC_CODE;
	}

	public void setHSN_SAC_CODE(String hSN_SAC_CODE) {
		HSN_SAC_CODE = hSN_SAC_CODE;
	}
	
	public String getHSN_SAC_CODE_DESCRIPTION() {
		return HSN_SAC_CODE_DESCRIPTION;
	}

	public void setHSN_SAC_CODE_DESCRIPTION(String hSN_SAC_CODE_DESCRIPTION) {
		HSN_SAC_CODE_DESCRIPTION = hSN_SAC_CODE_DESCRIPTION;
	}

	public String getGOODS_OR_SERVICES_TYPE() {
		return GOODS_OR_SERVICES_TYPE;
	}

	public void setGOODS_OR_SERVICES_TYPE(String gOODS_OR_SERVICES_TYPE) {
		GOODS_OR_SERVICES_TYPE = gOODS_OR_SERVICES_TYPE;
	}

	public String getNO_OF_CASES() {
		return NO_OF_CASES;
	}

	public void setNO_OF_CASES(String nO_OF_CASES) {
		NO_OF_CASES = nO_OF_CASES;
	}

	public String getAMOUNT_OF_TAX_EVASION() {
		return AMOUNT_OF_TAX_EVASION;
	}

	public void setAMOUNT_OF_TAX_EVASION(String aMOUNT_OF_TAX_EVASION) {
		AMOUNT_OF_TAX_EVASION = aMOUNT_OF_TAX_EVASION;
	}

	public String getNO_OF_CASES_PRE() {
		return NO_OF_CASES_PRE;
	}

	public void setNO_OF_CASES_PRE(String nO_OF_CASES_PRE) {
		NO_OF_CASES_PRE = nO_OF_CASES_PRE;
	}

	public String getAMOUNT_OF_TAX_EVASION_PRE() {
		return AMOUNT_OF_TAX_EVASION_PRE;
	}

	public void setAMOUNT_OF_TAX_EVASION_PRE(String aMOUNT_OF_TAX_EVASION_PRE) {
		AMOUNT_OF_TAX_EVASION_PRE = aMOUNT_OF_TAX_EVASION_PRE;
	}

	public List<SP_GI_GST_6_COMM_TEMP_Result> generateCommTempResult(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_GI_GST_6_COMM_TEMP_Result> list = new ArrayList<SP_GI_GST_6_COMM_TEMP_Result>();
			for (Object[] objectArray : resultList) {
				SP_GI_GST_6_COMM_TEMP_Result temp = new SP_GI_GST_6_COMM_TEMP_Result();

				temp = generateReportBean(objectArray);
				list.add(temp);
			}
			return list;
		}
	}

	private SP_GI_GST_6_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

		SP_GI_GST_6_COMM_TEMP_Result temp = new SP_GI_GST_6_COMM_TEMP_Result();

		if (null != objectArray[0]){temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
		if (null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
		if (null != objectArray[2]){temp.setHSN_SAC_CODE(String.valueOf(objectArray[2]));}
		if (null != objectArray[3]){temp.setHSN_SAC_CODE_DESCRIPTION(String.valueOf(objectArray[3]));}
		if (null != objectArray[4]){temp.setGOODS_OR_SERVICES_TYPE(String.valueOf(objectArray[4]));}
		if (null != objectArray[5]){temp.setNO_OF_CASES(String.valueOf(objectArray[5]));}
		if (null != objectArray[6]){temp.setAMOUNT_OF_TAX_EVASION(String.valueOf(objectArray[6]));}
		if (null != objectArray[7]){temp.setNO_OF_CASES_PRE(String.valueOf(objectArray[7]));}
		if (null != objectArray[8]){temp.setAMOUNT_OF_TAX_EVASION_PRE(String.valueOf(objectArray[8]));}
		
		return temp;
	}
}
