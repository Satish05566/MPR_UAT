package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_LIST_ZONE_Result {
 String ZONE_NAME ;
 String ZONE_CODE ;

public void setZONE_NAME(String ZONE_NAME) {
	this.ZONE_NAME=ZONE_NAME;
}

public String getZONE_NAME() {
	return ZONE_NAME;
}


public void setZONE_CODE(String ZONE_CODE) {
	this.ZONE_CODE=ZONE_CODE;
}

public String getZONE_CODE() {
	return ZONE_CODE;
}

public  List<SP_LIST_ZONE_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_LIST_ZONE_Result> list =  new ArrayList<SP_LIST_ZONE_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_LIST_ZONE_Result temp = new SP_LIST_ZONE_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_LIST_ZONE_Result generateResultBean(Object [] objectArray) {
	SP_LIST_ZONE_Result temp =  new SP_LIST_ZONE_Result();
	temp.setZONE_NAME((String)( objectArray[1]));
	temp.setZONE_CODE((String)( objectArray[0]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("ZONE_NAME");
	listLabels.add("ZONE_CODE");
	return listLabels;
}

}
