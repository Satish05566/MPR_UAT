package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_LOGIN_FO_Result {
 String ID ;
 String NAME ;

public void setID(String ID) {
	this.ID=ID;
}

public String getID() {
	return ID;
}


public void setNAME(String NAME) {
	this.NAME=NAME;
}

public String getNAME() {
	return NAME;
}

public  List<SP_LOGIN_FO_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_LOGIN_FO_Result> list =  new ArrayList<SP_LOGIN_FO_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_LOGIN_FO_Result temp = new SP_LOGIN_FO_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_LOGIN_FO_Result generateResultBean(Object [] objectArray) {
	SP_LOGIN_FO_Result temp =  new SP_LOGIN_FO_Result();
	temp.setID((String)( objectArray[0]));
	temp.setNAME((String)( objectArray[1]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("ID");
	listLabels.add("NAME");
	return listLabels;
}

}
