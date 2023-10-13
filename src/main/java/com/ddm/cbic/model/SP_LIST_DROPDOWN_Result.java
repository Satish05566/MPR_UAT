package com.ddm.cbic.model;
import java.util.ArrayList;
import java.util.List;

public class SP_LIST_DROPDOWN_Result {
 String Text ;
 String Value ;
 String Selected;
 


public String getText() {
	return Text;
}

public void setText(String text) {
	Text = text;
}

public String getValue() {
	return Value;
}

public void setValue(String value) {
	Value = value;
}

public String getSelected() {
	return Selected;
}

public void setSelected(String selected) {
	Selected = selected;
}

public  List<SP_LIST_DROPDOWN_Result> generateResultBeanList(List<Object []> listObjectArray) {
	List <SP_LIST_DROPDOWN_Result> list =  new ArrayList<SP_LIST_DROPDOWN_Result>();
	for(Object [] objArray : listObjectArray) { 
	SP_LIST_DROPDOWN_Result temp = new SP_LIST_DROPDOWN_Result ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

public  SP_LIST_DROPDOWN_Result generateResultBean(Object [] objectArray) {
	SP_LIST_DROPDOWN_Result temp =  new SP_LIST_DROPDOWN_Result();
	temp.setText((String)( objectArray[1]));
	temp.setValue((String)( objectArray[0]));
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("ZONE_NAME");
	listLabels.add("ZONE_CODE");
	return listLabels;
}

}
