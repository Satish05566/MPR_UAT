package com.ddm.cbic.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.math.*;

public class SP_DDM_GST_4_COMM_TEMP_Result {

	public String COMM_CODE;
	public String MM_YYYY;
	public String GST_ASSESSEE_CODE;
	public String  GST_ASSESSEE;
	public String CENTRAL_GST_FOR;
	public String STATEUT_GST_FOR;
	public String  INTEGRATED_GST_FOR;
	public String  CESS_GST_FOR;
	public String  CENTRAL_GST_UPTO;
	public String  STATEUT_GST_UPTO;
	public String  INTEGRATED_GST_UPTO;
	public String  CESS_GST_UPTO;
	

	
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

	public String getCENTRAL_GST_FOR() {
		return CENTRAL_GST_FOR;
	}

	public void setCENTRAL_GST_FOR(String cENTRAL_GST_FOR) {
		CENTRAL_GST_FOR = cENTRAL_GST_FOR;
	}

	public String getSTATEUT_GST_FOR() {
		return STATEUT_GST_FOR;
	}

	public void setSTATEUT_GST_FOR(String sTATEUT_GST_FOR) {
		STATEUT_GST_FOR = sTATEUT_GST_FOR;
	}

	public String getINTEGRATED_GST_FOR() {
		return INTEGRATED_GST_FOR;
	}

	public void setINTEGRATED_GST_FOR(String iNTEGRATED_GST_FOR) {
		INTEGRATED_GST_FOR = iNTEGRATED_GST_FOR;
	}

	public String getCESS_GST_FOR() {
		return CESS_GST_FOR;
	}

	public void setCESS_GST_FOR(String cESS_GST_FOR) {
		CESS_GST_FOR = cESS_GST_FOR;
	}

	public String getCENTRAL_GST_UPTO() {
		return CENTRAL_GST_UPTO;
	}

	public void setCENTRAL_GST_UPTO(String cENTRAL_GST_UPTO) {
		CENTRAL_GST_UPTO = cENTRAL_GST_UPTO;
	}

	public String getSTATEUT_GST_UPTO() {
		return STATEUT_GST_UPTO;
	}

	public void setSTATEUT_GST_UPTO(String sTATEUT_GST_UPTO) {
		STATEUT_GST_UPTO = sTATEUT_GST_UPTO;
	}

	public String getINTEGRATED_GST_UPTO() {
		return INTEGRATED_GST_UPTO;
	}

	public void setINTEGRATED_GST_UPTO(String iNTEGRATED_GST_UPTO) {
		INTEGRATED_GST_UPTO = iNTEGRATED_GST_UPTO;
	}

	public String getCESS_GST_UPTO() {
		return CESS_GST_UPTO;
	}

	public void setCESS_GST_UPTO(String cESS_GST_UPTO) {
		CESS_GST_UPTO = cESS_GST_UPTO;
	}

	public List<SP_DDM_GST_4_COMM_TEMP_Result> generateResultBeanList(List<Object[]> listObjectArray){
		List <SP_DDM_GST_4_COMM_TEMP_Result> list = new ArrayList<SP_DDM_GST_4_COMM_TEMP_Result>();
		for(Object[] objArray : listObjectArray) {
			SP_DDM_GST_4_COMM_TEMP_Result temp = new SP_DDM_GST_4_COMM_TEMP_Result();
		temp = generateResultBean_SP_DDM_GST_4_COMM_TEMP(objArray);
		list.add(temp);
		}
		return list;
		}

		public SP_DDM_GST_4_COMM_TEMP_Result generateResultBean_SP_DDM_GST_4_COMM_TEMP(Object[] objectArray)
		{
			SP_DDM_GST_4_COMM_TEMP_Result temp = new SP_DDM_GST_4_COMM_TEMP_Result();
			if(null!=objectArray[0] && objectArray[0]!=null) {
				temp.setCOMM_CODE(( objectArray[0].toString()));}
				if(null!=objectArray[1] && objectArray[1]!=null) {
				temp.setMM_YYYY(( objectArray[1].toString()));}
				if(null!=objectArray[2] && objectArray[2]!=null) {
				temp.setGST_ASSESSEE_CODE( objectArray[2].toString());}
				if(null!=objectArray[3] && objectArray[3]!=null) {
				temp.setGST_ASSESSEE(( objectArray[3].toString()));}
				if(null!=objectArray[4] && objectArray[4]!=null) {
				temp.setCENTRAL_GST_FOR(( objectArray[4].toString()));}
				if(null!=objectArray[5] && objectArray[5]!=null) {
				temp.setSTATEUT_GST_FOR(( objectArray[5].toString()));}
				if(null!=objectArray[6] && objectArray[6]!=null) {
				temp.setINTEGRATED_GST_FOR(( objectArray[6].toString()));}
				if(null!=objectArray[7] && objectArray[7]!=null) {
				temp.setCESS_GST_FOR(( objectArray[7].toString()));}
				if(null!=objectArray[8] && objectArray[8]!=null) {
				temp.setCENTRAL_GST_UPTO(( objectArray[8].toString()));}
				if(null!=objectArray[9] && objectArray[9]!=null) {
				temp.setSTATEUT_GST_UPTO(( objectArray[9].toString()));}
				if(null!=objectArray[10] && objectArray[10]!=null) {
				temp.setINTEGRATED_GST_UPTO(( objectArray[10].toString()));}
				if(null!=objectArray[11] && objectArray[11]!=null) {
				temp.setCESS_GST_UPTO(( objectArray[11].toString()));}
		return temp;

		}
	
}
