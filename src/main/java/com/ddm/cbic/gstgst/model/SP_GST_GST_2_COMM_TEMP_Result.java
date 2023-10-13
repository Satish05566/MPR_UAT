package com.ddm.cbic.gstgst.model;

import java.util.ArrayList;
import java.util.List;

public class SP_GST_GST_2_COMM_TEMP_Result {
	
	 private String GSTR_1M_F;
	 private String GSTR_3BM_F;
	 private String GSTR_1Q_F;
	 private String GSTR_3BQ_F;
	 private String GST_CMP_08_F;
	 private String GSTR_4_F;
	 private String GSTR_9_F;
	 private String GSTR_9A_F;
	 private String GSTR_9C_F;
	 private String GSTR_1M_D;
	 private String GSTR_3BM_D;
	 private String GSTR_1Q_D;
	 private String GSTR_3BQ_D;
	 private String GST_CMP_08_D;
	 private String GSTR_4_D;
	 private String GSTR_9_D;
	 private String GSTR_9A_D;
	 private String GSTR_9C_D;
	 private String GSTR_3A_I;
	 private String GSTR_3A_NI;
	 
	 

	public String getGSTR_1M_F() {
		return GSTR_1M_F;
	}



	public void setGSTR_1M_F(String gSTR_1M_F) {
		GSTR_1M_F = gSTR_1M_F;
	}



	public String getGSTR_3BM_F() {
		return GSTR_3BM_F;
	}



	public void setGSTR_3BM_F(String gSTR_3BM_F) {
		GSTR_3BM_F = gSTR_3BM_F;
	}



	public String getGSTR_1Q_F() {
		return GSTR_1Q_F;
	}



	public void setGSTR_1Q_F(String gSTR_1Q_F) {
		GSTR_1Q_F = gSTR_1Q_F;
	}



	public String getGSTR_3BQ_F() {
		return GSTR_3BQ_F;
	}



	public void setGSTR_3BQ_F(String gSTR_3BQ_F) {
		GSTR_3BQ_F = gSTR_3BQ_F;
	}



	public String getGST_CMP_08_F() {
		return GST_CMP_08_F;
	}



	public void setGST_CMP_08_F(String gST_CMP_08_F) {
		GST_CMP_08_F = gST_CMP_08_F;
	}



	public String getGSTR_4_F() {
		return GSTR_4_F;
	}



	public void setGSTR_4_F(String gSTR_4_F) {
		GSTR_4_F = gSTR_4_F;
	}



	public String getGSTR_9_F() {
		return GSTR_9_F;
	}



	public void setGSTR_9_F(String gSTR_9_F) {
		GSTR_9_F = gSTR_9_F;
	}



	public String getGSTR_9A_F() {
		return GSTR_9A_F;
	}



	public void setGSTR_9A_F(String gSTR_9A_F) {
		GSTR_9A_F = gSTR_9A_F;
	}



	public String getGSTR_9C_F() {
		return GSTR_9C_F;
	}



	public void setGSTR_9C_F(String gSTR_9C_F) {
		GSTR_9C_F = gSTR_9C_F;
	}



	public String getGSTR_1M_D() {
		return GSTR_1M_D;
	}



	public void setGSTR_1M_D(String gSTR_1M_D) {
		GSTR_1M_D = gSTR_1M_D;
	}



	public String getGSTR_3BM_D() {
		return GSTR_3BM_D;
	}



	public void setGSTR_3BM_D(String gSTR_3BM_D) {
		GSTR_3BM_D = gSTR_3BM_D;
	}



	public String getGSTR_1Q_D() {
		return GSTR_1Q_D;
	}



	public void setGSTR_1Q_D(String gSTR_1Q_D) {
		GSTR_1Q_D = gSTR_1Q_D;
	}



	public String getGSTR_3BQ_D() {
		return GSTR_3BQ_D;
	}



	public void setGSTR_3BQ_D(String gSTR_3BQ_D) {
		GSTR_3BQ_D = gSTR_3BQ_D;
	}



	public String getGST_CMP_08_D() {
		return GST_CMP_08_D;
	}



	public void setGST_CMP_08_D(String gST_CMP_08_D) {
		GST_CMP_08_D = gST_CMP_08_D;
	}



	public String getGSTR_4_D() {
		return GSTR_4_D;
	}



	public void setGSTR_4_D(String gSTR_4_D) {
		GSTR_4_D = gSTR_4_D;
	}



	public String getGSTR_9_D() {
		return GSTR_9_D;
	}



	public void setGSTR_9_D(String gSTR_9_D) {
		GSTR_9_D = gSTR_9_D;
	}



	public String getGSTR_9A_D() {
		return GSTR_9A_D;
	}



	public void setGSTR_9A_D(String gSTR_9A_D) {
		GSTR_9A_D = gSTR_9A_D;
	}



	public String getGSTR_9C_D() {
		return GSTR_9C_D;
	}



	public void setGSTR_9C_D(String gSTR_9C_D) {
		GSTR_9C_D = gSTR_9C_D;
	}



	public String getGSTR_3A_I() {
		return GSTR_3A_I;
	}



	public void setGSTR_3A_I(String gSTR_3A_I) {
		GSTR_3A_I = gSTR_3A_I;
	}



	public String getGSTR_3A_NI() {
		return GSTR_3A_NI;
	}



	public void setGSTR_3A_NI(String gSTR_3A_NI) {
		GSTR_3A_NI = gSTR_3A_NI;
	}



	public SP_GST_GST_2_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_GST_GST_2_COMM_TEMP_Result> list =  new ArrayList<SP_GST_GST_2_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_GST_GST_2_COMM_TEMP_Result temp = new SP_GST_GST_2_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_GST_GST_2_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_GST_GST_2_COMM_TEMP_Result temp =  new SP_GST_GST_2_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setGSTR_1M_F(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setGSTR_3BM_F(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setGSTR_1Q_F(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setGSTR_3BQ_F(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setGST_CMP_08_F(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setGSTR_4_F(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setGSTR_9_F(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]){temp.setGSTR_9A_F(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setGSTR_9C_F(String.valueOf(objectArray[8]));}
			if(null != objectArray[9]){temp.setGSTR_1M_D(String.valueOf(objectArray[9]));}
			if(null != objectArray[10]){temp.setGSTR_3BM_D(String.valueOf(objectArray[10]));}
			if(null != objectArray[11]){temp.setGSTR_1Q_D(String.valueOf(objectArray[11]));}
			if(null != objectArray[12]){temp.setGSTR_3BQ_D(String.valueOf(objectArray[12]));}
			if(null != objectArray[13]){temp.setGST_CMP_08_D(String.valueOf(objectArray[13]));}
			if(null != objectArray[14]){temp.setGSTR_4_D(String.valueOf(objectArray[14]));}
			if(null != objectArray[15]){temp.setGSTR_9_D(String.valueOf(objectArray[15]));}
			if(null != objectArray[16]){temp.setGSTR_9A_D(String.valueOf(objectArray[16]));}
			if(null != objectArray[17]){temp.setGSTR_9C_D(String.valueOf(objectArray[17]));}
			if(null != objectArray[18]){temp.setGSTR_3A_I(String.valueOf(objectArray[18]));}
			if(null != objectArray[19]){temp.setGSTR_3A_NI(String.valueOf(objectArray[19]));}
			
	return temp;
	
	 }
	 

}
