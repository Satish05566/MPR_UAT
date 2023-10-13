package com.ddm.cbic.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SP_CORRECTION_LIST_ZONE_GST_Result {
	public String COMM_NAME ;
    public String FO ;
    public String MPR ;
    public String MM_YYYY ;
    public String MAX_MM_YYYY ;
    public String DEP ;
    public Date SUBMISSION_DT ;
    public String REMARKS ;
    public int STATUS ;
	public String getCOMM_NAME() {
		return COMM_NAME;
	}
	public void setCOMM_NAME(String cOMM_NAME) {
		COMM_NAME = cOMM_NAME;
	}
	public String getFO() {
		return FO;
	}
	public void setFO(String fO) {
		FO = fO;
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
	public void setMM_YYYY(String _MM_YYYY) {
		MM_YYYY = _MM_YYYY;
	}
	public String getMAX_MM_YYYY() {
		return MAX_MM_YYYY;
	}
	public void setMAX_MM_YYYY(String mAX_MM_YYYY) {
		MAX_MM_YYYY = mAX_MM_YYYY;
	}
	public String getDEP() {
		return DEP;
	}
	public void setDEP(String dEP) {
		DEP = dEP;
	}
	public Date getSUBMISSION_DT() {
		return SUBMISSION_DT;
	}
	public void setSUBMISSION_DT(Date sUBMISSION_DT) {
		SUBMISSION_DT = sUBMISSION_DT;
	}
	public String getREMARKS() {
		return REMARKS;
	}
	public void setREMARKS(String rEMARKS) {
		REMARKS = rEMARKS;
	}
	public int getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}
	
	public  List<SP_CORRECTION_LIST_ZONE_GST_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_CORRECTION_LIST_ZONE_GST_Result> list =  new ArrayList<SP_CORRECTION_LIST_ZONE_GST_Result>();
		for(Object [] objArray : listObjectArray) { 
			SP_CORRECTION_LIST_ZONE_GST_Result temp = new SP_CORRECTION_LIST_ZONE_GST_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}

	public  SP_CORRECTION_LIST_ZONE_GST_Result generateResultBean(Object [] objectArray) {
		SP_CORRECTION_LIST_ZONE_GST_Result temp =  new SP_CORRECTION_LIST_ZONE_GST_Result();
		String _MM_YYYY="";
		String obj=objectArray[3].toString();
		System.out.println("obj--"+obj);
		SimpleDateFormat formatter = new SimpleDateFormat("MMMM yyyy");
		
		  try { Date date = formatter.parse(obj); 
		  DateFormat desDtFormat = new  SimpleDateFormat("yyyy-MM-dd"); 
		  _MM_YYYY = desDtFormat.format(date); 
		  DateFormat DtFormat = new SimpleDateFormat("YYYY-MMM"); 
		  _MM_YYYY = DtFormat.format(date); 
		  } catch (ParseException e) {e.printStackTrace();}
		 
		if(null!=objectArray[0] && objectArray[0]!=null) {
		temp.setCOMM_NAME((String)( objectArray[0]));}
		if(null!=objectArray[1] && objectArray[1]!=null) {
		temp.setFO((String)( objectArray[1]));}
		if(null!=objectArray[0] && objectArray[0]!=null) {
		temp.setMPR((String)( objectArray[2]));}
		if(null!=objectArray[3] && objectArray[3]!=null) {
		temp.setMM_YYYY((String)(_MM_YYYY));}
		if(null!=objectArray[4] && objectArray[4]!=null) {
		temp.setMAX_MM_YYYY((String)( objectArray[4]));}
		if(null!=objectArray[5] && objectArray[5]!=null) {
		temp.setDEP((String)( objectArray[5]));}
		if(null!=objectArray[6] && objectArray[6]!=null) {
		temp.setSUBMISSION_DT((Date)( objectArray[6]));}
		if(null!=objectArray[7] && objectArray[7]!=null) {
		temp.setREMARKS((String)( objectArray[7]));}
		if(null!=objectArray[8] && objectArray[8]!=null) {
		temp.setSTATUS((int)( objectArray[8]));}
		
		return temp;
	}

}
