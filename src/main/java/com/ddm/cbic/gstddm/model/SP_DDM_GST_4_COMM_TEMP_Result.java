package com.ddm.cbic.gstddm.model;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
public class SP_DDM_GST_4_COMM_TEMP_Result {

	private String COMM_CODE;
	private String MM_YYYY;
	private String SNO;
	private String HSN_CODE;
	private String DESC_OF_GOODS;
	private String CUR_YEAR_FOR;
	private String CUR_YEAR_UPTO;
	private String PRE_YEAR_FOR;
	private String PRE_YEAR_UPTO;
	private String INC_DEC_PRV_YR;
	private String INC_DEC_PRV_YR_PERC;
	@NotEmpty(message = "*")
	@Pattern(regexp = "^[a-zA-Z0-9. ()/,'-]+$", message = "Only ()./,'- special characters are allowed.!")
	private String REASONS;

	public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}

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

	public String getHSN_CODE() {
		return HSN_CODE;
	}

	public void setHSN_CODE(String hSN_CODE) {
		HSN_CODE = hSN_CODE;
	}

	public String getDESC_OF_GOODS() {
		return DESC_OF_GOODS;
	}

	public void setDESC_OF_GOODS(String dESC_OF_GOODS) {
		DESC_OF_GOODS = dESC_OF_GOODS;
	}

	public String getCUR_YEAR_FOR() {
		return CUR_YEAR_FOR;
	}

	public void setCUR_YEAR_FOR(String cUR_YEAR_FOR) {
		CUR_YEAR_FOR = cUR_YEAR_FOR;
	}

	public String getCUR_YEAR_UPTO() {
		return CUR_YEAR_UPTO;
	}

	public void setCUR_YEAR_UPTO(String cUR_YEAR_UPTO) {
		CUR_YEAR_UPTO = cUR_YEAR_UPTO;
	}

	public String getPRE_YEAR_FOR() {
		return PRE_YEAR_FOR;
	}

	public void setPRE_YEAR_FOR(String pRE_YEAR_FOR) {
		PRE_YEAR_FOR = pRE_YEAR_FOR;
	}

	public String getPRE_YEAR_UPTO() {
		return PRE_YEAR_UPTO;
	}

	public void setPRE_YEAR_UPTO(String pRE_YEAR_UPTO) {
		PRE_YEAR_UPTO = pRE_YEAR_UPTO;
	}

	public String getINC_DEC_PRV_YR() {
		return INC_DEC_PRV_YR;
	}

	public void setINC_DEC_PRV_YR(String iNC_DEC_PRV_YR) {
		INC_DEC_PRV_YR = iNC_DEC_PRV_YR;
	}

	public String getINC_DEC_PRV_YR_PERC() {
		return INC_DEC_PRV_YR_PERC;
	}

	public void setINC_DEC_PRV_YR_PERC(String iNC_DEC_PRV_YR_PERC) {
		INC_DEC_PRV_YR_PERC = iNC_DEC_PRV_YR_PERC;
	}

	public String getREASONS() {
		return REASONS;
	}

	public void setREASONS(String rEASONS) {
		REASONS = rEASONS;
	}

	public List<SP_DDM_GST_4_COMM_TEMP_Result> generateResultBeanList(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_DDM_GST_4_COMM_TEMP_Result> list = new ArrayList<SP_DDM_GST_4_COMM_TEMP_Result>();
			for (Object[] objectArray : resultList) {
				SP_DDM_GST_4_COMM_TEMP_Result temp = new SP_DDM_GST_4_COMM_TEMP_Result();

				temp = generateResultBean(objectArray);
				list.add(temp);
			}
			return list;
		}
	}

	public SP_DDM_GST_4_COMM_TEMP_Result generateResultBean(Object[] objectArray) {
		SP_DDM_GST_4_COMM_TEMP_Result temp = new SP_DDM_GST_4_COMM_TEMP_Result();

		temp.setCOMM_CODE(String.valueOf(objectArray[0]));
		temp.setMM_YYYY(String.valueOf(objectArray[1]));
		temp.setSNO(String.valueOf(objectArray[2]));
		temp.setHSN_CODE(String.valueOf(objectArray[3]));
		temp.setDESC_OF_GOODS(String.valueOf(objectArray[4]));
		temp.setCUR_YEAR_FOR(String.valueOf(objectArray[5]));
		temp.setCUR_YEAR_UPTO(String.valueOf(objectArray[6]));
		temp.setPRE_YEAR_FOR(String.valueOf(objectArray[7]));
		temp.setPRE_YEAR_UPTO(String.valueOf(objectArray[8]));
		temp.setREASONS(
				(String.valueOf(objectArray[9]) != null) && (!String.valueOf(objectArray[9]).equalsIgnoreCase("null"))
						? String.valueOf(objectArray[9])
						: "");

		return temp;
	}

}
