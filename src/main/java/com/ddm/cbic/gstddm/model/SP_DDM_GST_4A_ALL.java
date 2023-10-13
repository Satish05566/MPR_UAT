package com.ddm.cbic.gstddm.model;

import java.util.ArrayList;
import java.util.List;

public class SP_DDM_GST_4A_ALL {
	
	private int AMND;
	private int TOTAL_COMM;
	private int COMPLETE_COMM;
	/*
	 * private String COMM_CODE; private String MM_YYYY;
	 */
	private String SERVICE_CODE;
	private String SERVICE_NAME;
	private String CUR_YEAR_FOR;
	private String CUR_YEAR_UPTO;
	private String PRE_YEAR_FOR;
	private String PRE_YEAR_UPTO;
	
	private String INC_DEC_PRV_YR_FOR_MON;
	private String INC_DEC_PRV_YR_UPTO_MON;	
	
	
	private String INC_DEC_PRV_YR_PERC_FOR_MON; 	
	private String INC_DEC_PRV_YR_PERC_UPTO_MON;
	
	
	
	
	private String REASONS;



	/*
	 * public String getCOMM_CODE() { return COMM_CODE; }
	 * 
	 * public void setCOMM_CODE(String cOMM_CODE) { COMM_CODE = cOMM_CODE; }
	 * 
	 * public String getMM_YYYY() { return MM_YYYY; }
	 * 
	 * public void setMM_YYYY(String mM_YYYY) { MM_YYYY = mM_YYYY; }
	 */

	public String getSERVICE_CODE() {
		return SERVICE_CODE;
	}

	public int getAMND() {
		return AMND;
	}

	public void setAMND(int aMND) {
		AMND = aMND;
	}

	public int getTOTAL_COMM() {
		return TOTAL_COMM;
	}

	public void setTOTAL_COMM(int tOTAL_COMM) {
		TOTAL_COMM = tOTAL_COMM;
	}

	public int getCOMPLETE_COMM() {
		return COMPLETE_COMM;
	}

	public void setCOMPLETE_COMM(int cOMPLETE_COMM) {
		COMPLETE_COMM = cOMPLETE_COMM;
	}

	public void setSERVICE_CODE(String sERVICE_CODE) {
		SERVICE_CODE = sERVICE_CODE;
	}

	public String getSERVICE_NAME() {
		return SERVICE_NAME;
	}

	public void setSERVICE_NAME(String sERVICE_NAME) {
		SERVICE_NAME = sERVICE_NAME;
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

	public String getREASONS() {
		return REASONS;
	}

	public void setREASONS(String rEASONS) {
		REASONS = rEASONS;
	}
	
	public String getINC_DEC_PRV_YR_FOR_MON() {
		return INC_DEC_PRV_YR_FOR_MON;
	}

	public void setINC_DEC_PRV_YR_FOR_MON(String iNC_DEC_PRV_YR_FOR_MON) {
		INC_DEC_PRV_YR_FOR_MON = iNC_DEC_PRV_YR_FOR_MON;
	}

	public String getINC_DEC_PRV_YR_UPTO_MON() {
		return INC_DEC_PRV_YR_UPTO_MON;
	}

	public void setINC_DEC_PRV_YR_UPTO_MON(String iNC_DEC_PRV_YR_UPTO_MON) {
		INC_DEC_PRV_YR_UPTO_MON = iNC_DEC_PRV_YR_UPTO_MON;
	}

	public String getINC_DEC_PRV_YR_PERC_FOR_MON() {
		return INC_DEC_PRV_YR_PERC_FOR_MON;
	}

	public void setINC_DEC_PRV_YR_PERC_FOR_MON(String iNC_DEC_PRV_YR_PERC_FOR_MON) {
		INC_DEC_PRV_YR_PERC_FOR_MON = iNC_DEC_PRV_YR_PERC_FOR_MON;
	}

	public String getINC_DEC_PRV_YR_PERC_UPTO_MON() {
		return INC_DEC_PRV_YR_PERC_UPTO_MON;
	}

	public void setINC_DEC_PRV_YR_PERC_UPTO_MON(String iNC_DEC_PRV_YR_PERC_UPTO_MON) {
		INC_DEC_PRV_YR_PERC_UPTO_MON = iNC_DEC_PRV_YR_PERC_UPTO_MON;
	}

	public List<SP_DDM_GST_4A_ALL> generateResultBeanList(List<Object[]> resultList) {
		if (resultList.size() == 0)
			return null;
		else {
			List<SP_DDM_GST_4A_ALL> list = new ArrayList<SP_DDM_GST_4A_ALL>();
			for (Object[] objectArray : resultList) {
				SP_DDM_GST_4A_ALL temp = new SP_DDM_GST_4A_ALL();

				temp = generateResultBean(objectArray);
				list.add(temp);
			}
			return list;
		}
	}

	public SP_DDM_GST_4A_ALL generateResultBean(Object[] objectArray) {
		SP_DDM_GST_4A_ALL temp = new SP_DDM_GST_4A_ALL();

		temp.setAMND(Integer.parseInt((String.valueOf(objectArray[0]))));
		temp.setTOTAL_COMM(Integer.parseInt((String.valueOf(objectArray[1]))));
		temp.setCOMPLETE_COMM(Integer.parseInt((String.valueOf(objectArray[2]))));
		/*
		 * temp.setCOMM_CODE(String.valueOf(objectArray[3]));
		 * temp.setMM_YYYY(String.valueOf(objectArray[4]));
		 */
		/*
		 * temp.setSERVICE_CODE(String.valueOf(objectArray[5]));
		 * temp.setSERVICE_NAME(String.valueOf(objectArray[6]));
		 * temp.setCUR_YEAR_FOR(String.valueOf(objectArray[7]));
		 * temp.setCUR_YEAR_UPTO(String.valueOf(objectArray[8]));
		 * temp.setPRE_YEAR_FOR(String.valueOf(objectArray[9]));
		 * temp.setPRE_YEAR_UPTO(String.valueOf(objectArray[10]));
		 * 
		 * temp.setINC_DEC_PRV_YR_FOR_MON(String.valueOf(objectArray[11]));
		 * temp.setINC_DEC_PRV_YR_PERC_UPTO_MON(String.valueOf(objectArray[12]));
		 * temp.setINC_DEC_PRV_YR_PERC_FOR_MON(String.valueOf(objectArray[13]));
		 * temp.setINC_DEC_PRV_YR_UPTO_MON(String.valueOf(objectArray[14]));
		 * 
		 * temp.setREASONS(String.valueOf(objectArray[15]));
		 */
		temp.setSERVICE_CODE(String.valueOf(objectArray[3]));
		temp.setSERVICE_NAME(String.valueOf(objectArray[4]));
		temp.setCUR_YEAR_FOR(String.valueOf(objectArray[5]));
		temp.setCUR_YEAR_UPTO(String.valueOf(objectArray[6]));
		temp.setPRE_YEAR_FOR(String.valueOf(objectArray[7]));
		temp.setPRE_YEAR_UPTO(String.valueOf(objectArray[8]));
		
		temp.setINC_DEC_PRV_YR_FOR_MON(String.valueOf(objectArray[9]));
		temp.setINC_DEC_PRV_YR_UPTO_MON(String.valueOf(objectArray[10]));
		

		temp.setINC_DEC_PRV_YR_PERC_FOR_MON(String.valueOf(objectArray[11]));
		temp.setINC_DEC_PRV_YR_PERC_UPTO_MON(String.valueOf(objectArray[12]));
		
		
		temp.setREASONS(String.valueOf(objectArray[13]));
		return temp;
	}

}
