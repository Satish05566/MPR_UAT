package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_LOGIN_GST_DIV_Result {
 String ID ;
 String CODE ;
 String PASS ;
 String NAME ;
 String TYPE ;

public void setID(String ID) {
	this.ID=ID;
}

public String getID() {
	return ID;
}


public void setCODE(String CODE) {
	this.CODE=CODE;
}

public String getCODE() {
	return CODE;
}


public void setPASS(String PASS) {
	this.PASS=PASS;
}

public String getPASS() {
	return PASS;
}


public void setNAME(String NAME) {
	this.NAME=NAME;
}

public String getNAME() {
	return NAME;
}


public void setTYPE(String TYPE) {
	this.TYPE=TYPE;
}

public String getTYPE() {
	return TYPE;
}

public  List<SP_LOGIN_GST_DIV_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_LOGIN_GST_DIV_Result> list =  new ArrayList<SP_LOGIN_GST_DIV_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_LOGIN_GST_DIV_Result temp = new SP_LOGIN_GST_DIV_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_LOGIN_GST_DIV_Result generateResultBean(Object [] objectArray) {
	SP_LOGIN_GST_DIV_Result temp =  new SP_LOGIN_GST_DIV_Result();
	temp.setID((String)( objectArray[0]));
	temp.setCODE((String)( objectArray[1]));
	temp.setPASS((String)( objectArray[2]));
	temp.setNAME((String)( objectArray[3]));
	temp.setTYPE((String)( objectArray[4]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("ID");
	listLabels.add("CODE");
	listLabels.add("PASS");
	listLabels.add("NAME");
	listLabels.add("TYPE");
	return listLabels;
}

}
