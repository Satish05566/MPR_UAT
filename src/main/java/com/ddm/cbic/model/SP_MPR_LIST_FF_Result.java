package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_MPR_LIST_FF_Result {
 long SNO ;
 String CODE ;
 String DEP ;
 String FO ;
 String GROUP_NAME ;
 String REPORT_PAGE ;
 String INSERT_PAGE ;

@Override
public String toString() {
	return "SP_MPR_GST_LIST_USER_Result [SNO=" + SNO + ", CODE=" + CODE + ", DEP=" + DEP + ", FO=" + FO
			+ ", GROUP_NAME=" + GROUP_NAME + ", REPORT_PAGE=" + REPORT_PAGE + ", INSERT_PAGE=" + INSERT_PAGE + "]";
}

public void setSNO(long SNO) {
	this.SNO=SNO;
}

public long getSNO() {
	return SNO;
}


public void setCODE(String CODE) {
	this.CODE=CODE;
}

public String getCODE() {
	return CODE;
}


public void setDEP(String DEP) {
	this.DEP=DEP;
}

public String getDEP() {
	return DEP;
}


public void setFO(String FO) {
	this.FO=FO;
}

public String getFO() {
	return FO;
}


public void setGROUP_NAME(String GROUP_NAME) {
	this.GROUP_NAME=GROUP_NAME;
}

public String getGROUP_NAME() {
	return GROUP_NAME;
}


public void setREPORT_PAGE(String REPORT_PAGE) {
	this.REPORT_PAGE=REPORT_PAGE;
}

public String getREPORT_PAGE() {
	return REPORT_PAGE;
}


public void setINSERT_PAGE(String INSERT_PAGE) {
	this.INSERT_PAGE=INSERT_PAGE;
}

public String getINSERT_PAGE() {
	return INSERT_PAGE;
}

public  List<SP_MPR_LIST_FF_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_MPR_LIST_FF_Result> list =  new ArrayList<SP_MPR_LIST_FF_Result>();
	for(Object [] objArray : listObjectArray) { 
		SP_MPR_LIST_FF_Result temp = new SP_MPR_LIST_FF_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_MPR_LIST_FF_Result generateResultBean(Object [] objectArray) {
	SP_MPR_LIST_FF_Result temp =  new SP_MPR_LIST_FF_Result();
	temp.setSNO((long)( Long.parseLong(objectArray[0].toString())));
	temp.setCODE((String)( objectArray[1]));
	temp.setDEP((String)( objectArray[2]));
	temp.setFO((String)( objectArray[3]));
	temp.setGROUP_NAME((String)( objectArray[4]));
	temp.setREPORT_PAGE((String)( objectArray[5]));
	temp.setINSERT_PAGE((String)( objectArray[6]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("SNO");
	listLabels.add("CODE");
	listLabels.add("DEP");
	listLabels.add("FO");
	listLabels.add("GROUP_NAME");
	listLabels.add("REPORT_PAGE");
	listLabels.add("INSERT_PAGE");
	return listLabels;
}

}
