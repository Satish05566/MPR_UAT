package com.ddm.cbic.model;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SP_DDM_GST_5_COMM_TEMP_Result {
	 String COMM_CODE ;
	 String MM_YYYY ;
	 
	 BigDecimal AUDIT ;
	 BigDecimal AER ;
	 BigDecimal RCD ;
	 BigDecimal PRE_DEPOSITS ;
	 BigDecimal SCRUT_RETURNS ;
	 BigDecimal DETAIL_SCRUT ;
	 BigDecimal RFD ;
	 BigDecimal FPA ;
	 BigDecimal ITR_TDS ;
	 BigDecimal OTHERS ;

public void setCOMM_CODE(String COMM_CODE) {
	this.COMM_CODE=COMM_CODE;
}

public String getCOMM_CODE() {
	return COMM_CODE;
}


public void setMM_YYYY(String MM_YYYY) {
	this.MM_YYYY=MM_YYYY;
}

public String getMM_YYYY() {
	return MM_YYYY;
}




public BigDecimal getAUDIT() {
	return AUDIT;
}

public void setAUDIT(BigDecimal aUDIT) {
	AUDIT = aUDIT;
}

public BigDecimal getAER() {
	return AER;
}

public void setAER(BigDecimal aER) {
	AER = aER;
}

public BigDecimal getRCD() {
	return RCD;
}

public void setRCD(BigDecimal rCD) {
	RCD = rCD;
}

public BigDecimal getPRE_DEPOSITS() {
	return PRE_DEPOSITS;
}

public void setPRE_DEPOSITS(BigDecimal pRE_DEPOSITS) {
	PRE_DEPOSITS = pRE_DEPOSITS;
}

public BigDecimal getSCRUT_RETURNS() {
	return SCRUT_RETURNS;
}

public void setSCRUT_RETURNS(BigDecimal sCRUT_RETURNS) {
	SCRUT_RETURNS = sCRUT_RETURNS;
}

public BigDecimal getDETAIL_SCRUT() {
	return DETAIL_SCRUT;
}

public void setDETAIL_SCRUT(BigDecimal dETAIL_SCRUT) {
	DETAIL_SCRUT = dETAIL_SCRUT;
}

public BigDecimal getRFD() {
	return RFD;
}

public void setRFD(BigDecimal rFD) {
	RFD = rFD;
}

public BigDecimal getFPA() {
	return FPA;
}

public void setFPA(BigDecimal fPA) {
	FPA = fPA;
}

public BigDecimal getITR_TDS() {
	return ITR_TDS;
}

public void setITR_TDS(BigDecimal iTR_TDS) {
	ITR_TDS = iTR_TDS;
}

public BigDecimal getOTHERS() {
	return OTHERS;
}

public void setOTHERS(BigDecimal oTHERS) {
	OTHERS = oTHERS;
}

public  List<SP_DDM_GST_5_COMM_TEMP_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_DDM_GST_5_COMM_TEMP_Result> list =  new ArrayList<SP_DDM_GST_5_COMM_TEMP_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_DDM_GST_5_COMM_TEMP_Result temp = new SP_DDM_GST_5_COMM_TEMP_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_DDM_GST_5_COMM_TEMP_Result generateResultBean(Object [] objectArray) {
	SP_DDM_GST_5_COMM_TEMP_Result temp =  new SP_DDM_GST_5_COMM_TEMP_Result();
	
	if(null!=objectArray[0] && objectArray[0]!=null) {
	temp.setCOMM_CODE((String)( objectArray[0]));}
	if(null!=objectArray[1] && objectArray[1]!=null) {
	temp.setMM_YYYY(String.valueOf(objectArray[1]));}
	if(null!=objectArray[2] && objectArray[2]!=null) {
	temp.setAUDIT((BigDecimal)(objectArray[2]));}
	if(null!=objectArray[3] && objectArray[3]!=null) {
	temp.setAER((BigDecimal)( objectArray[3]));}
	if(null!=objectArray[4] && objectArray[4]!=null) {
	temp.setRCD((BigDecimal)( objectArray[4]));}
	if(null!=objectArray[5] && objectArray[5]!=null) {
	temp.setPRE_DEPOSITS((BigDecimal)( objectArray[5]));}
	if(null!=objectArray[6] && objectArray[6]!=null) {
	temp.setSCRUT_RETURNS((BigDecimal)( objectArray[6]));}
	if(null!=objectArray[7] && objectArray[7]!=null) {
	temp.setDETAIL_SCRUT((BigDecimal)( objectArray[7]));}
	if(null!=objectArray[8] && objectArray[8]!=null) {
	temp.setRFD((BigDecimal)( objectArray[8]));}
	if(null!=objectArray[9] && objectArray[9]!=null) {
	temp.setFPA((BigDecimal)( objectArray[9]));}
	if(null!=objectArray[10] && objectArray[10]!=null) {
	temp.setITR_TDS((BigDecimal)( objectArray[10]));}
	if(null!=objectArray[11] && objectArray[11]!=null) {
	temp.setOTHERS((BigDecimal)( objectArray[11]));}
	
	
	
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("COMM_CODE");
	listLabels.add("MM_YYYY");
	listLabels.add("AUDIT");
	listLabels.add("AER");
	listLabels.add("RCD");
	listLabels.add("PRE_DEPOSITS");
	listLabels.add("SCRUT_RETURNS");
	listLabels.add("DETAIL_SCRUT");
	listLabels.add("RFD");
	listLabels.add("FPA");
	listLabels.add("ITR_TDS");
	listLabels.add("OTHERS");
	return listLabels;
}

}
