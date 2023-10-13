package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;

import java.math.BigDecimal;

public class SP_DDM_GST_4_ALL_Result {

	public int AMND;
	public int TOTAL_COMM;
	public int COMPLETE_COMM;	
	public String GST_ASSESSEE_CODE;
	public String  GST_ASSESSEE;
	public BigDecimal CENTRAL_GST_FOR;
	public BigDecimal STATEUT_GST_FOR;
	public BigDecimal  INTEGRATED_GST_FOR;
	public BigDecimal  CESS_GST_FOR;
	public BigDecimal  CENTRAL_GST_UPTO;
	public BigDecimal  STATEUT_GST_UPTO;
	public BigDecimal  INTEGRATED_GST_UPTO;
	public BigDecimal  CESS_GST_UPTO;
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
	public String getGST_ASSESSEE_CODE() {
		return GST_ASSESSEE_CODE;
	}
	public void setGST_ASSESSEE_CODE(String gST_ASSESSEE_CODE) {
		GST_ASSESSEE_CODE = gST_ASSESSEE_CODE;
	}
	public String getGST_ASSESSEE() {
		return GST_ASSESSEE;
	}
	public void setGST_ASSESSEE(String gST_ASSESSEE) {
		GST_ASSESSEE = gST_ASSESSEE;
	}
	public BigDecimal getCENTRAL_GST_FOR() {
		return CENTRAL_GST_FOR;
	}
	public void setCENTRAL_GST_FOR(BigDecimal cENTRAL_GST_FOR) {
		CENTRAL_GST_FOR = cENTRAL_GST_FOR;
	}
	public BigDecimal getSTATEUT_GST_FOR() {
		return STATEUT_GST_FOR;
	}
	public void setSTATEUT_GST_FOR(BigDecimal sTATEUT_GST_FOR) {
		STATEUT_GST_FOR = sTATEUT_GST_FOR;
	}
	public BigDecimal getINTEGRATED_GST_FOR() {
		return INTEGRATED_GST_FOR;
	}
	public void setINTEGRATED_GST_FOR(BigDecimal iNTEGRATED_GST_FOR) {
		INTEGRATED_GST_FOR = iNTEGRATED_GST_FOR;
	}
	public BigDecimal getCESS_GST_FOR() {
		return CESS_GST_FOR;
	}
	public void setCESS_GST_FOR(BigDecimal cESS_GST_FOR) {
		CESS_GST_FOR = cESS_GST_FOR;
	}
	public BigDecimal getCENTRAL_GST_UPTO() {
		return CENTRAL_GST_UPTO;
	}
	public void setCENTRAL_GST_UPTO(BigDecimal cENTRAL_GST_UPTO) {
		CENTRAL_GST_UPTO = cENTRAL_GST_UPTO;
	}
	public BigDecimal getSTATEUT_GST_UPTO() {
		return STATEUT_GST_UPTO;
	}
	public void setSTATEUT_GST_UPTO(BigDecimal sTATEUT_GST_UPTO) {
		STATEUT_GST_UPTO = sTATEUT_GST_UPTO;
	}
	public BigDecimal getINTEGRATED_GST_UPTO() {
		return INTEGRATED_GST_UPTO;
	}
	public void setINTEGRATED_GST_UPTO(BigDecimal iNTEGRATED_GST_UPTO) {
		INTEGRATED_GST_UPTO = iNTEGRATED_GST_UPTO;
	}
	public BigDecimal getCESS_GST_UPTO() {
		return CESS_GST_UPTO;
	}
	public void setCESS_GST_UPTO(BigDecimal cESS_GST_UPTO) {
		CESS_GST_UPTO = cESS_GST_UPTO;
	}
	
	public List<SP_DDM_GST_4_ALL_Result> SP_DDM_GST_4_ALL_Result(List<Object[]> listObjectArray){
		List <SP_DDM_GST_4_ALL_Result> list = new ArrayList<SP_DDM_GST_4_ALL_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_GST_4_ALL_Result temp = new SP_DDM_GST_4_ALL_Result();
		temp = generateResultBean_SP_DDM_GST_4_ALL(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_GST_4_ALL_Result generateResultBean_SP_DDM_GST_4_ALL(Object[] objectArray)
		{
			SP_DDM_GST_4_ALL_Result temp = new SP_DDM_GST_4_ALL_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
				temp.setAMND((int)( objectArray[0]));}
				if(null!=objectArray[1] && objectArray[1]!=null) {
				temp.setTOTAL_COMM((int)( objectArray[1]));}
				if(null!=objectArray[2] && objectArray[2]!=null) {
				temp.setCOMPLETE_COMM((int)( objectArray[2]));}
				if(null!=objectArray[3] && objectArray[3]!=null) {
				temp.setGST_ASSESSEE_CODE((String)( objectArray[3]));}
				if(null!=objectArray[4] && objectArray[4]!=null) {
				temp.setGST_ASSESSEE((String)( objectArray[4]));}
				if(null!=objectArray[5] && objectArray[5]!=null) {
				temp.setCENTRAL_GST_FOR((BigDecimal)( objectArray[5]));}
				if(null!=objectArray[6] && objectArray[6]!=null) {
				temp.setSTATEUT_GST_FOR((BigDecimal)( objectArray[6]));}
				if(null!=objectArray[7] && objectArray[7]!=null) {
				temp.setINTEGRATED_GST_FOR((BigDecimal)( objectArray[7]));}
				if(null!=objectArray[8] && objectArray[8]!=null) {
				temp.setCESS_GST_FOR((BigDecimal)( objectArray[8]));}
				if(null!=objectArray[9] && objectArray[9]!=null) {
				temp.setCENTRAL_GST_UPTO((BigDecimal)( objectArray[9]));}
				if(null!=objectArray[10] && objectArray[10]!=null) {
				temp.setSTATEUT_GST_UPTO((BigDecimal)( objectArray[10]));}
				if(null!=objectArray[11] && objectArray[11]!=null) {
				temp.setINTEGRATED_GST_UPTO((BigDecimal)( objectArray[11]));}
				if(null!=objectArray[12] && objectArray[12]!=null) {
				temp.setCESS_GST_UPTO((BigDecimal)( objectArray[12]));}
						  
		
		return temp;

		}
		@Override
		public String toString() {
			return "SP_DDM_GST_4_ALL_Result [AMND=" + AMND + ", TOTAL_COMM=" + TOTAL_COMM + ", COMPLETE_COMM="
					+ COMPLETE_COMM + ", GST_ASSESSEE_CODE=" + GST_ASSESSEE_CODE + ", GST_ASSESSEE=" + GST_ASSESSEE
					+ ", CENTRAL_GST_FOR=" + CENTRAL_GST_FOR + ", STATEUT_GST_FOR=" + STATEUT_GST_FOR
					+ ", INTEGRATED_GST_FOR=" + INTEGRATED_GST_FOR + ", CESS_GST_FOR=" + CESS_GST_FOR
					+ ", CENTRAL_GST_UPTO=" + CENTRAL_GST_UPTO + ", STATEUT_GST_UPTO=" + STATEUT_GST_UPTO
					+ ", INTEGRATED_GST_UPTO=" + INTEGRATED_GST_UPTO + ", CESS_GST_UPTO=" + CESS_GST_UPTO + "]";
		}
		
		
		
		
}
