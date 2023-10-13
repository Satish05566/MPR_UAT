package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_GST_DDM_STATUS_Result {
	String SNO;
	String NAME;
	String CODE;
	String ZONE_CODE;
	String APR;
	String MAY;
	String JUN;
	String JUL;
	String AUG;
	String SEP;
	String OCT;
	String NOV;
	String DEC;
	String JAN;
	String FEB;
	String MAR;
	
public String getSNO() {
		return SNO;
	}

	public void setSNO(String sNO) {
		SNO = sNO;
	}

	public String getNAME() {
		return NAME;
	}

	public void setNAME(String nAME) {
		NAME = nAME;
	}

	public String getCODE() {
		return CODE;
	}

	public void setCODE(String cODE) {
		CODE = cODE;
	}

	public String getZONE_CODE() {
		return ZONE_CODE;
	}

	public void setZONE_CODE(String zONE_CODE) {
		ZONE_CODE = zONE_CODE;
	}

	public String getAPR() {
		return APR;
	}

	public void setAPR(String aPR) {
		APR = aPR;
	}

	public String getMAY() {
		return MAY;
	}

	public void setMAY(String mAY) {
		MAY = mAY;
	}

	public String getJUN() {
		return JUN;
	}

	public void setJUN(String jUN) {
		JUN = jUN;
	}

	public String getJUL() {
		return JUL;
	}

	public void setJUL(String jUL) {
		JUL = jUL;
	}

	public String getAUG() {
		return AUG;
	}

	public void setAUG(String aUG) {
		AUG = aUG;
	}

	public String getSEP() {
		return SEP;
	}

	public void setSEP(String sEP) {
		SEP = sEP;
	}

	public String getOCT() {
		return OCT;
	}

	public void setOCT(String oCT) {
		OCT = oCT;
	}

	public String getNOV() {
		return NOV;
	}

	public void setNOV(String nOV) {
		NOV = nOV;
	}

	public String getDEC() {
		return DEC;
	}

	public void setDEC(String dEC) {
		DEC = dEC;
	}

	public String getJAN() {
		return JAN;
	}

	public void setJAN(String jAN) {
		JAN = jAN;
	}

	public String getFEB() {
		return FEB;
	}

	public void setFEB(String fEB) {
		FEB = fEB;
	}

	public String getMAR() {
		return MAR;
	}

	public void setMAR(String mAR) {
		MAR = mAR;
	}

public  List<SP_GST_DDM_STATUS_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_GST_DDM_STATUS_Result> list =  new ArrayList<SP_GST_DDM_STATUS_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_GST_DDM_STATUS_Result temp = new SP_GST_DDM_STATUS_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_GST_DDM_STATUS_Result generateResultBean(Object [] objectArray) {
	SP_GST_DDM_STATUS_Result temp =  new SP_GST_DDM_STATUS_Result();
	temp.setSNO((String)(objectArray[0]));
	temp.setNAME((String)(objectArray[1]));
	temp.setCODE((String)(objectArray[2]));
	temp.setZONE_CODE((String)(objectArray[3]));
	temp.setAPR((String)(objectArray[4]));
	temp.setMAY((String)(objectArray[5]));
	temp.setJUN((String)(objectArray[6]));
	temp.setJUL((String)(objectArray[7]));
	temp.setAUG((String)(objectArray[8]));
	temp.setSEP((String)(objectArray[9]));
	temp.setOCT((String)(objectArray[10]));
	temp.setNOV((String)(objectArray[11]));
	temp.setDEC((String)(objectArray[12]));
	temp.setJAN((String)(objectArray[13]));
	temp.setFEB((String)(objectArray[14]));
	temp.setMAR((String)(objectArray[15]));	
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("COMM_CODE");
	listLabels.add("COMM_NAME");
	return listLabels;
}

}
