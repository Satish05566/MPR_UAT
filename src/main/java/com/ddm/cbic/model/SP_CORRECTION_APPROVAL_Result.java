package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class SP_CORRECTION_APPROVAL_Result {
	
	String COMM_CODE ;
	 String MPR ;
	 String MM_YYYY ;
	 String DEP ;
	 String SUBMISSION_DT ;

	 public String getCOMM_CODE() {
		return COMM_CODE;
	}
	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}
	public String getMPR() {
		return MPR;
	}
	public void setMPR(String mPR) {
		MPR = mPR;
	}
	public String getMM_YYYY() {
		return MM_YYYY;
	}
	public void setMM_YYYY(String mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}
	public String getDEP() {
		return DEP;
	}
	public void setDEP(String dEP) {
		DEP = dEP;
	}
	public String getSUBMISSION_DT() {
		return SUBMISSION_DT;
	}
	public void setSUBMISSION_DT(String sUBMISSION_DT) {
		SUBMISSION_DT = sUBMISSION_DT;
	}
		 
	 
	 
	 public  List<SP_CORRECTION_APPROVAL_Result> generateResultBeanList(List<Object []> listObjectArray) {
			List <SP_CORRECTION_APPROVAL_Result> list =  new ArrayList<SP_CORRECTION_APPROVAL_Result>();
			for(Object [] objArray : listObjectArray) { 
				SP_CORRECTION_APPROVAL_Result temp = new SP_CORRECTION_APPROVAL_Result ();

			temp = generateResultBean(objArray);
			list.add(temp);
			}
			return list;
		}

		public  SP_CORRECTION_APPROVAL_Result generateResultBean(Object [] objectArray) {
			SP_CORRECTION_APPROVAL_Result temp =  new SP_CORRECTION_APPROVAL_Result();
			temp.setCOMM_CODE((String)( objectArray[0]));
			temp.setMPR((String)( objectArray[1]));
			temp.setMM_YYYY((String)( objectArray[2])); 
			temp.setDEP((String)( objectArray[3]));
			temp.setSUBMISSION_DT((String.valueOf(objectArray[4])));
			return temp;
		}

}
