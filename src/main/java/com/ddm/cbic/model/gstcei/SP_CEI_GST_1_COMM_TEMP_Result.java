package com.ddm.cbic.model.gstcei;

import java.util.ArrayList;
import java.util.List;

public class SP_CEI_GST_1_COMM_TEMP_Result {
	private String COMM_CODE;
	private String DET_NOC;
	private String DET_AMT_CGST;
	private String DET_AMT_IGST;
	private String DET_AMT_SGGST;
	private String DET_AMT_UTGST;
	private String DET_AMT_CESS;
	private String REAL_NOC;
	private String REAL_AMT_CGST;
	private String REAL_AMT_IGST;
	private String REAL_AMT_SGGST;
	private String REAL_AMT_UTGST;
	private String REAL_AMT_CESS;

	public String getCOMM_CODE() {
		return COMM_CODE;
	}

	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}

	public String getDET_NOC() {
		return DET_NOC;
	}

	public void setDET_NOC(String dET_NOC) {
		DET_NOC = dET_NOC;
	}

	public String getDET_AMT_CGST() {
		return DET_AMT_CGST;
	}

	public void setDET_AMT_CGST(String dET_AMT_CGST) {
		DET_AMT_CGST = dET_AMT_CGST;
	}

	public String getDET_AMT_IGST() {
		return DET_AMT_IGST;
	}

	public void setDET_AMT_IGST(String dET_AMT_IGST) {
		DET_AMT_IGST = dET_AMT_IGST;
	}

	public String getDET_AMT_SGGST() {
		return DET_AMT_SGGST;
	}

	public void setDET_AMT_SGGST(String dET_AMT_SGGST) {
		DET_AMT_SGGST = dET_AMT_SGGST;
	}

	public String getDET_AMT_UTGST() {
		return DET_AMT_UTGST;
	}

	public void setDET_AMT_UTGST(String dET_AMT_UTGST) {
		DET_AMT_UTGST = dET_AMT_UTGST;
	}

	public String getDET_AMT_CESS() {
		return DET_AMT_CESS;
	}

	public void setDET_AMT_CESS(String dET_AMT_CESS) {
		DET_AMT_CESS = dET_AMT_CESS;
	}

	public String getREAL_NOC() {
		return REAL_NOC;
	}

	public void setREAL_NOC(String rEAL_NOC) {
		REAL_NOC = rEAL_NOC;
	}

	public String getREAL_AMT_CGST() {
		return REAL_AMT_CGST;
	}

	public void setREAL_AMT_CGST(String rEAL_AMT_CGST) {
		REAL_AMT_CGST = rEAL_AMT_CGST;
	}

	public String getREAL_AMT_IGST() {
		return REAL_AMT_IGST;
	}

	public void setREAL_AMT_IGST(String rEAL_AMT_IGST) {
		REAL_AMT_IGST = rEAL_AMT_IGST;
	}

	public String getREAL_AMT_SGGST() {
		return REAL_AMT_SGGST;
	}

	public void setREAL_AMT_SGGST(String rEAL_AMT_SGGST) {
		REAL_AMT_SGGST = rEAL_AMT_SGGST;
	}

	public String getREAL_AMT_UTGST() {
		return REAL_AMT_UTGST;
	}

	public void setREAL_AMT_UTGST(String rEAL_AMT_UTGST) {
		REAL_AMT_UTGST = rEAL_AMT_UTGST;
	}

	public String getREAL_AMT_CESS() {
		return REAL_AMT_CESS;
	}

	public void setREAL_AMT_CESS(String rEAL_AMT_CESS) {
		REAL_AMT_CESS = rEAL_AMT_CESS;
	}

	public List<SP_CEI_GST_1_COMM_TEMP_Result> generateResultBeanList(List<Object[]> listObjectArray) {
		List<SP_CEI_GST_1_COMM_TEMP_Result> list = new ArrayList<SP_CEI_GST_1_COMM_TEMP_Result>();
		for (Object[] objArray : listObjectArray) {
			SP_CEI_GST_1_COMM_TEMP_Result temp = new SP_CEI_GST_1_COMM_TEMP_Result();

			temp = generateResultBean(objArray);
			list.add(temp);
		}
		return list;
	}

	public SP_CEI_GST_1_COMM_TEMP_Result generateResultBean(Object[] objectArray) {
		SP_CEI_GST_1_COMM_TEMP_Result temp = new SP_CEI_GST_1_COMM_TEMP_Result();

		temp.setCOMM_CODE(objectArray[0].toString());
		temp.setDET_NOC(objectArray[1].toString());
		temp.setDET_AMT_CGST(objectArray[2].toString());
		temp.setDET_AMT_IGST(objectArray[3].toString());
		temp.setDET_AMT_SGGST(objectArray[4].toString());
		temp.setDET_AMT_UTGST(objectArray[5].toString());
		temp.setDET_AMT_CESS(objectArray[6].toString());
		temp.setREAL_NOC(objectArray[7].toString());
		temp.setREAL_AMT_CGST(objectArray[8].toString());
		temp.setREAL_AMT_IGST(objectArray[9].toString());
		temp.setREAL_AMT_SGGST(objectArray[10].toString());
		temp.setREAL_AMT_UTGST(objectArray[11].toString());
		temp.setREAL_AMT_CESS(objectArray[12].toString());
		return temp;
	}

	public SP_CEI_GST_1_COMM_TEMP_Result generateTempResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_CEI_GST_1_COMM_TEMP_Result> list =  new ArrayList<SP_CEI_GST_1_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_CEI_GST_1_COMM_TEMP_Result temp = new SP_CEI_GST_1_COMM_TEMP_Result ();

		temp = generateResultBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
}
