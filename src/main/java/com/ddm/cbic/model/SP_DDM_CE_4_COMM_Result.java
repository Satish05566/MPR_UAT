package com.ddm.cbic.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_CE_4_COMM_Result {
 String TOTAL_COMM ;
 int AMND ;
 String COMPLETE_COMM ;
 String ASSESSEE_CODE ;
 String ASSESSEE ;
 BigDecimal REVENUE_PRE_YEAR ;
 BigDecimal PRE_YEAR_FOR ;
 BigDecimal PRE_YEAR_UPTO ;
 BigDecimal CUR_YEAR_FOR ;
 BigDecimal CUR_YEAR_UPTO ;
 BigDecimal ACTUAL_UPTO ;
 BigDecimal PERCENT_UPTO ;
 String REASONS ;

public void setTOTAL_COMM(String TOTAL_COMM) {
	this.TOTAL_COMM=TOTAL_COMM;
}

public String getTOTAL_COMM() {
	return TOTAL_COMM;
}


public void setAMND(int AMND) {
	this.AMND=AMND;
}

public int getAMND() {
	return AMND;
}


public void setCOMPLETE_COMM(String COMPLETE_COMM) {
	this.COMPLETE_COMM=COMPLETE_COMM;
}

public String getCOMPLETE_COMM() {
	return COMPLETE_COMM;
}




public void setASSESSEE(String ASSESSEE) {
	this.ASSESSEE=ASSESSEE;
}

public String getASSESSEE() {
	return ASSESSEE;
}




public void setREASONS(String REASONS) {
	this.REASONS=REASONS;
}

public String getREASONS() {
	return REASONS;
}




public String getASSESSEE_CODE() {
	return ASSESSEE_CODE;
}

public void setASSESSEE_CODE(String aSSESSEE_CODE) {
	ASSESSEE_CODE = aSSESSEE_CODE;
}

public BigDecimal getREVENUE_PRE_YEAR() {
	return REVENUE_PRE_YEAR;
}

public void setREVENUE_PRE_YEAR(BigDecimal rEVENUE_PRE_YEAR) {
	REVENUE_PRE_YEAR = rEVENUE_PRE_YEAR;
}

public BigDecimal getPRE_YEAR_FOR() {
	return PRE_YEAR_FOR;
}

public void setPRE_YEAR_FOR(BigDecimal pRE_YEAR_FOR) {
	PRE_YEAR_FOR = pRE_YEAR_FOR;
}

public BigDecimal getPRE_YEAR_UPTO() {
	return PRE_YEAR_UPTO;
}

public void setPRE_YEAR_UPTO(BigDecimal pRE_YEAR_UPTO) {
	PRE_YEAR_UPTO = pRE_YEAR_UPTO;
}

public BigDecimal getCUR_YEAR_FOR() {
	return CUR_YEAR_FOR;
}

public void setCUR_YEAR_FOR(BigDecimal cUR_YEAR_FOR) {
	CUR_YEAR_FOR = cUR_YEAR_FOR;
}

public BigDecimal getCUR_YEAR_UPTO() {
	return CUR_YEAR_UPTO;
}

public void setCUR_YEAR_UPTO(BigDecimal cUR_YEAR_UPTO) {
	CUR_YEAR_UPTO = cUR_YEAR_UPTO;
}

public BigDecimal getACTUAL_UPTO() {
	return ACTUAL_UPTO;
}

public void setACTUAL_UPTO(BigDecimal aCTUAL_UPTO) {
	ACTUAL_UPTO = aCTUAL_UPTO;
}

public BigDecimal getPERCENT_UPTO() {
	return PERCENT_UPTO;
}

public void setPERCENT_UPTO(BigDecimal pERCENT_UPTO) {
	PERCENT_UPTO = pERCENT_UPTO;
}

public  List<SP_DDM_CE_4_COMM_Result> generateResultList_SP_DDM_CE_4_COMM(List<Object []> listObjectArray) {
	List <SP_DDM_CE_4_COMM_Result> list =  new ArrayList<SP_DDM_CE_4_COMM_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_DDM_CE_4_COMM_Result temp = new SP_DDM_CE_4_COMM_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_DDM_CE_4_COMM_Result generateResultBean(Object [] objectArray) {
	SP_DDM_CE_4_COMM_Result temp =  new SP_DDM_CE_4_COMM_Result();
	temp.setTOTAL_COMM((String)( objectArray[0]));
	temp.setAMND((int)( objectArray[1]));
	temp.setCOMPLETE_COMM((String)( objectArray[2]));
	temp.setASSESSEE_CODE((String)( objectArray[3]));
	temp.setASSESSEE((String)( objectArray[4]));
	temp.setREVENUE_PRE_YEAR((BigDecimal)( objectArray[5]));
	temp.setPRE_YEAR_FOR((BigDecimal)( objectArray[6]));
	temp.setPRE_YEAR_UPTO((BigDecimal)( objectArray[7]));
	temp.setCUR_YEAR_FOR((BigDecimal)( objectArray[8]));
	temp.setCUR_YEAR_UPTO((BigDecimal)( objectArray[9]));
	temp.setACTUAL_UPTO((BigDecimal)( objectArray[10]));
	temp.setPERCENT_UPTO((BigDecimal)( objectArray[11]));
	temp.setREASONS((String)( objectArray[12]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("TOTAL_COMM");
	listLabels.add("AMND");
	listLabels.add("COMPLETE_COMM");
	listLabels.add("ASSESSEE_CODE");
	listLabels.add("ASSESSEE");
	listLabels.add("REVENUE_PRE_YEAR");
	listLabels.add("PRE_YEAR_FOR");
	listLabels.add("PRE_YEAR_UPTO");
	listLabels.add("CUR_YEAR_FOR");
	listLabels.add("CUR_YEAR_UPTO");
	listLabels.add("ACTUAL_UPTO");
	listLabels.add("PERCENT_UPTO");
	listLabels.add("REASONS");
	return listLabels;
}

}
