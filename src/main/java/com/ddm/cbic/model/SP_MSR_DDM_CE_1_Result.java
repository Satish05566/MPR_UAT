package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_MSR_DDM_CE_1_Result {
 int AMND ;
 int TOTAL_COMM ;
 int COMPLETE_COMM ;
 long SNO ;
 String ZONE_CODE ;
 String ZONE_NAME ;
 double TOTAL_GROSS_UPTO_C ;
 double REFUND_UPTO_C ;
 double REBATE_UPTO_C ;
 double TOTAL_UPTO_C ;
 double MOVING_TARGET_UPTO_C ;
 double TOTAL_GROSS_UPTO_P ;
 double REFUND_UPTO_P ;
 double REBATE_UPTO_P ;
 double TOTAL_UPTO_P ;
 double ACTUAL_TOTAL ;
 double TOTAL_PERCENT_UPTO ;
 double TOTAL_TARGET_ACTUAL ;
 double TOTAL_TARGET_PERCENT_UPTO ;

public void setAMND(int AMND) {
	this.AMND=AMND;
}

public int getAMND() {
	return AMND;
}


public void setTOTAL_COMM(int TOTAL_COMM) {
	this.TOTAL_COMM=TOTAL_COMM;
}

public int getTOTAL_COMM() {
	return TOTAL_COMM;
}


public void setCOMPLETE_COMM(int COMPLETE_COMM) {
	this.COMPLETE_COMM=COMPLETE_COMM;
}

public int getCOMPLETE_COMM() {
	return COMPLETE_COMM;
}


public void setSNO(long SNO) {
	this.SNO=SNO;
}

public long getSNO() {
	return SNO;
}


public void setZONE_CODE(String ZONE_CODE) {
	this.ZONE_CODE=ZONE_CODE;
}

public String getZONE_CODE() {
	return ZONE_CODE;
}


public void setZONE_NAME(String ZONE_NAME) {
	this.ZONE_NAME=ZONE_NAME;
}

public String getZONE_NAME() {
	return ZONE_NAME;
}


public void setTOTAL_GROSS_UPTO_C(double TOTAL_GROSS_UPTO_C) {
	this.TOTAL_GROSS_UPTO_C=TOTAL_GROSS_UPTO_C;
}

public double getTOTAL_GROSS_UPTO_C() {
	return TOTAL_GROSS_UPTO_C;
}


public void setREFUND_UPTO_C(double REFUND_UPTO_C) {
	this.REFUND_UPTO_C=REFUND_UPTO_C;
}

public double getREFUND_UPTO_C() {
	return REFUND_UPTO_C;
}


public void setREBATE_UPTO_C(double REBATE_UPTO_C) {
	this.REBATE_UPTO_C=REBATE_UPTO_C;
}

public double getREBATE_UPTO_C() {
	return REBATE_UPTO_C;
}


public void setTOTAL_UPTO_C(double TOTAL_UPTO_C) {
	this.TOTAL_UPTO_C=TOTAL_UPTO_C;
}

public double getTOTAL_UPTO_C() {
	return TOTAL_UPTO_C;
}


public void setMOVING_TARGET_UPTO_C(double MOVING_TARGET_UPTO_C) {
	this.MOVING_TARGET_UPTO_C=MOVING_TARGET_UPTO_C;
}

public double getMOVING_TARGET_UPTO_C() {
	return MOVING_TARGET_UPTO_C;
}


public void setTOTAL_GROSS_UPTO_P(double TOTAL_GROSS_UPTO_P) {
	this.TOTAL_GROSS_UPTO_P=TOTAL_GROSS_UPTO_P;
}

public double getTOTAL_GROSS_UPTO_P() {
	return TOTAL_GROSS_UPTO_P;
}


public void setREFUND_UPTO_P(double REFUND_UPTO_P) {
	this.REFUND_UPTO_P=REFUND_UPTO_P;
}

public double getREFUND_UPTO_P() {
	return REFUND_UPTO_P;
}


public void setREBATE_UPTO_P(double REBATE_UPTO_P) {
	this.REBATE_UPTO_P=REBATE_UPTO_P;
}

public double getREBATE_UPTO_P() {
	return REBATE_UPTO_P;
}


public void setTOTAL_UPTO_P(double TOTAL_UPTO_P) {
	this.TOTAL_UPTO_P=TOTAL_UPTO_P;
}

public double getTOTAL_UPTO_P() {
	return TOTAL_UPTO_P;
}


public void setACTUAL_TOTAL(double ACTUAL_TOTAL) {
	this.ACTUAL_TOTAL=ACTUAL_TOTAL;
}

public double getACTUAL_TOTAL() {
	return ACTUAL_TOTAL;
}


public void setTOTAL_PERCENT_UPTO(double TOTAL_PERCENT_UPTO) {
	this.TOTAL_PERCENT_UPTO=TOTAL_PERCENT_UPTO;
}

public double getTOTAL_PERCENT_UPTO() {
	return TOTAL_PERCENT_UPTO;
}


public void setTOTAL_TARGET_ACTUAL(double TOTAL_TARGET_ACTUAL) {
	this.TOTAL_TARGET_ACTUAL=TOTAL_TARGET_ACTUAL;
}

public double getTOTAL_TARGET_ACTUAL() {
	return TOTAL_TARGET_ACTUAL;
}


public void setTOTAL_TARGET_PERCENT_UPTO(double TOTAL_TARGET_PERCENT_UPTO) {
	this.TOTAL_TARGET_PERCENT_UPTO=TOTAL_TARGET_PERCENT_UPTO;
}

public double getTOTAL_TARGET_PERCENT_UPTO() {
	return TOTAL_TARGET_PERCENT_UPTO;
}

public  List<SP_MSR_DDM_CE_1_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_MSR_DDM_CE_1_Result> list =  new ArrayList<SP_MSR_DDM_CE_1_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_MSR_DDM_CE_1_Result temp = new SP_MSR_DDM_CE_1_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_MSR_DDM_CE_1_Result generateResultBean(Object [] objectArray) {
	SP_MSR_DDM_CE_1_Result temp =  new SP_MSR_DDM_CE_1_Result();
	if(null !=  objectArray[0]){
	temp.setAMND((int)(  Integer.parseInt(String.valueOf(objectArray[0]))));
	}
	if(null !=  objectArray[1]){
	temp.setTOTAL_COMM((int)(  Integer.parseInt(String.valueOf(objectArray[1]))));
	}
	if(null !=  objectArray[2]){
	temp.setCOMPLETE_COMM((int)(  Integer.parseInt(String.valueOf(objectArray[2]))));
	}
	if(null !=  objectArray[3]){
	temp.setSNO((long)(  Long.parseLong( String.valueOf(objectArray[3]))));
	}
	if(null !=  objectArray[4]){
	temp.setZONE_CODE((String)( objectArray[4]));
	}
	if(null !=  objectArray[5]){
	temp.setZONE_NAME((String)( objectArray[5]));
	}
	if(null !=  objectArray[6]){
	temp.setTOTAL_GROSS_UPTO_C((double)(  Double.parseDouble( String.valueOf(objectArray[6]))));
	}
	if(null !=  objectArray[7]){
	temp.setREFUND_UPTO_C((double)(  Double.parseDouble( String.valueOf(objectArray[7]))));
	}
	if(null !=  objectArray[8]){
	temp.setREBATE_UPTO_C((double)(  Double.parseDouble( String.valueOf(objectArray[8]))));
	}
	if(null !=  objectArray[9]){
	temp.setTOTAL_UPTO_C((double)(  Double.parseDouble( String.valueOf(objectArray[9]))));
	}
	if(null !=  objectArray[10]){
	temp.setMOVING_TARGET_UPTO_C((double)(  Double.parseDouble( String.valueOf(objectArray[10]))));
	}
	if(null !=  objectArray[11]){
	temp.setTOTAL_GROSS_UPTO_P((double)(  Double.parseDouble( String.valueOf(objectArray[11]))));
	}
	if(null !=  objectArray[12]){
	temp.setREFUND_UPTO_P((double)(  Double.parseDouble( String.valueOf(objectArray[12]))));
	}
	if(null !=  objectArray[13]){
	temp.setREBATE_UPTO_P((double)(  Double.parseDouble( String.valueOf(objectArray[13]))));
	}
	if(null !=  objectArray[14]){
	temp.setTOTAL_UPTO_P((double)(  Double.parseDouble( String.valueOf(objectArray[14]))));
	}
	if(null !=  objectArray[15]){
	temp.setACTUAL_TOTAL((double)(  Double.parseDouble( String.valueOf(objectArray[15]))));
	}
	if(null !=  objectArray[16]){
	temp.setTOTAL_PERCENT_UPTO((double)(  Double.parseDouble( String.valueOf(objectArray[16]))));
	}
	if(null !=  objectArray[17]){
	temp.setTOTAL_TARGET_ACTUAL((double)(  Double.parseDouble( String.valueOf(objectArray[17]))));
	}
	if(null !=  objectArray[18]){
	temp.setTOTAL_TARGET_PERCENT_UPTO((double)(  Double.parseDouble( String.valueOf(objectArray[18]))));
	}
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("AMND");
	listLabels.add("TOTAL_COMM");
	listLabels.add("COMPLETE_COMM");
	listLabels.add("SNO");
	listLabels.add("ZONE_CODE");
	listLabels.add("ZONE_NAME");
	listLabels.add("TOTAL_GROSS_UPTO_C");
	listLabels.add("REFUND_UPTO_C");
	listLabels.add("REBATE_UPTO_C");
	listLabels.add("TOTAL_UPTO_C");
	listLabels.add("MOVING_TARGET_UPTO_C");
	listLabels.add("TOTAL_GROSS_UPTO_P");
	listLabels.add("REFUND_UPTO_P");
	listLabels.add("REBATE_UPTO_P");
	listLabels.add("TOTAL_UPTO_P");
	listLabels.add("ACTUAL_TOTAL");
	listLabels.add("TOTAL_PERCENT_UPTO");
	listLabels.add("TOTAL_TARGET_ACTUAL");
	listLabels.add("TOTAL_TARGET_PERCENT_UPTO");
	return listLabels;
}

}
