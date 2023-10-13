package com.ddm.cbic.gstddm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/**
 * @author 002KK7744
 *
 */
public class SP_DDM_GST_3A_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	private String SR_NO;
	private String GSTIN;
	private String NAME_OF_TAXPAYER;
	private String CASH_FOR_CURRENT;
	private String ITC_FOR_CURRENT;
	private String CASH_UPTO_CURRENT;
	private String ITC_UPTO_CURRENT;
	private String CASH_FOR_PREV;
	private String ITC_FOR_PREV;
	private String CASH_UPTO_PREV;
	private String ITC_UPTO_PREV;
	
	@NotEmpty(message="*")
	
	@Pattern(regexp = "^[a-zA-Z0-9. ()/,'-]+$", message = "Only ()./,'- special characters are allowed !")
	private String REASON_FOR_INCREASE_REVENUE;
	
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

	public String getSR_NO() {
		return SR_NO;
	}

	public void setSR_NO(String sR_NO) {
		SR_NO = sR_NO;
	}

	public String getGSTIN() {
		return GSTIN;
	}

	public void setGSTIN(String gSTIN) {
		GSTIN = gSTIN;
	}

	public String getNAME_OF_TAXPAYER() {
		return NAME_OF_TAXPAYER;
	}

	public void setNAME_OF_TAXPAYER(String nAME_OF_TAXPAYER) {
		NAME_OF_TAXPAYER = nAME_OF_TAXPAYER;
	}

	public String getCASH_FOR_CURRENT() {
		return CASH_FOR_CURRENT;
	}

	public void setCASH_FOR_CURRENT(String cASH_FOR_CURRENT) {
		CASH_FOR_CURRENT = cASH_FOR_CURRENT;
	}

	public String getITC_FOR_CURRENT() {
		return ITC_FOR_CURRENT;
	}

	public void setITC_FOR_CURRENT(String iTC_FOR_CURRENT) {
		ITC_FOR_CURRENT = iTC_FOR_CURRENT;
	}

	public String getCASH_UPTO_CURRENT() {
		return CASH_UPTO_CURRENT;
	}

	public void setCASH_UPTO_CURRENT(String cASH_UPTO_CURRENT) {
		CASH_UPTO_CURRENT = cASH_UPTO_CURRENT;
	}

	public String getITC_UPTO_CURRENT() {
		return ITC_UPTO_CURRENT;
	}

	public void setITC_UPTO_CURRENT(String iTC_UPTO_CURRENT) {
		ITC_UPTO_CURRENT = iTC_UPTO_CURRENT;
	}

	public String getCASH_FOR_PREV() {
		return CASH_FOR_PREV;
	}

	public void setCASH_FOR_PREV(String cASH_FOR_PREV) {
		CASH_FOR_PREV = cASH_FOR_PREV;
	}

	public String getITC_FOR_PREV() {
		return ITC_FOR_PREV;
	}

	public void setITC_FOR_PREV(String iTC_FOR_PREV) {
		ITC_FOR_PREV = iTC_FOR_PREV;
	}

	public String getCASH_UPTO_PREV() {
		return CASH_UPTO_PREV;
	}

	public void setCASH_UPTO_PREV(String cASH_UPTO_PREV) {
		CASH_UPTO_PREV = cASH_UPTO_PREV;
	}

	public String getITC_UPTO_PREV() {
		return ITC_UPTO_PREV;
	}

	public void setITC_UPTO_PREV(String iTC_UPTO_PREV) {
		ITC_UPTO_PREV = iTC_UPTO_PREV;
	}

	public String getREASON_FOR_INCREASE_REVENUE() {
		return REASON_FOR_INCREASE_REVENUE;
	}

	public void setREASON_FOR_INCREASE_REVENUE(String rEASON_FOR_INCREASE_REVENUE) {
		REASON_FOR_INCREASE_REVENUE = rEASON_FOR_INCREASE_REVENUE;
	}

	public List<SP_DDM_GST_3A_COMM_TEMP_Result> generateResultBeanList(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_DDM_GST_3A_COMM_TEMP_Result> list = new ArrayList<SP_DDM_GST_3A_COMM_TEMP_Result>();
			for (Object[] objectArray : resultList) {
				SP_DDM_GST_3A_COMM_TEMP_Result temp = new SP_DDM_GST_3A_COMM_TEMP_Result();

				temp = generateResultBean(objectArray);
				list.add(temp);
			}
			return list;
		}
	}

	public SP_DDM_GST_3A_COMM_TEMP_Result generateResultBean(Object[] objectArray) {
		SP_DDM_GST_3A_COMM_TEMP_Result temp = new SP_DDM_GST_3A_COMM_TEMP_Result();
		
		temp.setCOMM_CODE(String.valueOf(objectArray[0]));
		temp.setMM_YYYY(String.valueOf(objectArray[1]));
		temp.setSR_NO(String.valueOf(objectArray[2]));
		temp.setGSTIN(String.valueOf(objectArray[3]));
		temp.setNAME_OF_TAXPAYER(String.valueOf(objectArray[4]));
		temp.setCASH_FOR_CURRENT(String.valueOf(objectArray[5]));
		temp.setITC_FOR_CURRENT(String.valueOf(objectArray[6]));
		temp.setCASH_UPTO_CURRENT(String.valueOf(objectArray[7]));
		temp.setITC_UPTO_CURRENT(String.valueOf(objectArray[8]));
		temp.setCASH_FOR_PREV(String.valueOf(objectArray[9]));
		temp.setITC_FOR_PREV(String.valueOf(objectArray[10]));
		temp.setCASH_UPTO_PREV(String.valueOf(objectArray[11]));
		temp.setITC_UPTO_PREV(String.valueOf(objectArray[12]));
		temp.setREASON_FOR_INCREASE_REVENUE(String.valueOf(objectArray[13]));
		
		return temp;
	}

}
