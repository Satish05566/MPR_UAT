package com.ddm.cbic.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SP_DDM_CE_4_COMM_TEMP_Result {
 String COMM_CODE ;
 Date MM_YYYY ;
 short ASSESSEE_CODE ;
 String ASSESSEE ;
 BigDecimal REVENUE_PRE_YEAR ;
 BigDecimal PRE_YEAR_FOR ;
 BigDecimal PRE_YEAR_UPTO ;
 BigDecimal CUR_YEAR_FOR ;
 BigDecimal CUR_YEAR_UPTO ;
 String REASONS ;

public void setCOMM_CODE(String COMM_CODE) {
	this.COMM_CODE=COMM_CODE;
}

public String getCOMM_CODE() {
	return COMM_CODE;
}









public Date getMM_YYYY() {
	return MM_YYYY;
}

public void setMM_YYYY(Date mM_YYYY) {
	MM_YYYY = mM_YYYY;
}

public void setASSESSEE(String ASSESSEE) {
	this.ASSESSEE=ASSESSEE;
}

public String getASSESSEE() {
	return ASSESSEE;
}






public short getASSESSEE_CODE() {
	return ASSESSEE_CODE;
}

public void setASSESSEE_CODE(short aSSESSEE_CODE) {
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

public void setREASONS(String REASONS) {
	this.REASONS=REASONS;
}

public String getREASONS() {
	return REASONS;
}

public  List<SP_DDM_CE_4_COMM_TEMP_Result> generateResultList_SP_DDM_CE_4_COMM_TEMP(List<Object []> listObjectArray) {
	List <SP_DDM_CE_4_COMM_TEMP_Result> list =  new ArrayList<SP_DDM_CE_4_COMM_TEMP_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_DDM_CE_4_COMM_TEMP_Result temp = new SP_DDM_CE_4_COMM_TEMP_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_DDM_CE_4_COMM_TEMP_Result generateResultBean(Object [] objectArray) {
	SP_DDM_CE_4_COMM_TEMP_Result temp =  new SP_DDM_CE_4_COMM_TEMP_Result();
	temp.setCOMM_CODE((String)( objectArray[0]));
	temp.setMM_YYYY((Date)( objectArray[1]));
	temp.setASSESSEE_CODE((short)( objectArray[2]));
	temp.setASSESSEE((String)( objectArray[3]));
	temp.setREVENUE_PRE_YEAR((BigDecimal)( objectArray[4]));
	temp.setPRE_YEAR_FOR((BigDecimal)( objectArray[5]));
	temp.setPRE_YEAR_UPTO((BigDecimal)( objectArray[6]));
	temp.setCUR_YEAR_FOR((BigDecimal)( objectArray[7]));
	temp.setCUR_YEAR_UPTO((BigDecimal)( objectArray[8]));
	temp.setREASONS((String)( objectArray[9]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("COMM_CODE");
	listLabels.add("MM_YYYY");
	listLabels.add("ASSESSEE_CODE");
	listLabels.add("ASSESSEE");
	listLabels.add("REVENUE_PRE_YEAR");
	listLabels.add("PRE_YEAR_FOR");
	listLabels.add("PRE_YEAR_UPTO");
	listLabels.add("CUR_YEAR_FOR");
	listLabels.add("CUR_YEAR_UPTO");
	listLabels.add("REASONS");
	return listLabels;
}

}
