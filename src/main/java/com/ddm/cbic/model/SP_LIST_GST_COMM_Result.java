package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_LIST_GST_COMM_Result {
 String COMM_CODE ;
 String COMM_NAME ;

public void setCOMM_CODE(String COMM_CODE) {
	this.COMM_CODE=COMM_CODE;
}

public String getCOMM_CODE() {
	return COMM_CODE;
}


public void setCOMM_NAME(String COMM_NAME) {
	this.COMM_NAME=COMM_NAME;
}

public String getCOMM_NAME() {
	return COMM_NAME;
}

public  List<SP_LIST_GST_COMM_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_LIST_GST_COMM_Result> list =  new ArrayList<SP_LIST_GST_COMM_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_LIST_GST_COMM_Result temp = new SP_LIST_GST_COMM_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_LIST_GST_COMM_Result generateResultBean(Object [] objectArray) {
	SP_LIST_GST_COMM_Result temp =  new SP_LIST_GST_COMM_Result();
	temp.setCOMM_CODE((String)( objectArray[0]));
	temp.setCOMM_NAME((String)( objectArray[1]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("COMM_CODE");
	listLabels.add("COMM_NAME");
	return listLabels;
}

}
