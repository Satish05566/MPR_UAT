package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_CHANGE_PASS_ZONE_GST_Result {
 String p_RESULT ;

public void setP_RESULT(String p_RESULT) {
	this.p_RESULT=p_RESULT;
}

public String getP_RESULT() {
	return p_RESULT;
}

public  List<SP_CHANGE_PASS_ZONE_GST_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_CHANGE_PASS_ZONE_GST_Result> list =  new ArrayList<SP_CHANGE_PASS_ZONE_GST_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_CHANGE_PASS_ZONE_GST_Result temp = new SP_CHANGE_PASS_ZONE_GST_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_CHANGE_PASS_ZONE_GST_Result generateResultBean(Object [] objectArray) {
	SP_CHANGE_PASS_ZONE_GST_Result temp =  new SP_CHANGE_PASS_ZONE_GST_Result();
	temp.setP_RESULT((String)( objectArray[0]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("p_RESULT");
	return listLabels;
}

}
