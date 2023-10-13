package com.ddm.cbic.model;

import java.util.ArrayList;
import java.util.List;

public class DINSearch {
 String DRN_NO;
 String DATE_GENERATE_DRN;
 String OFFICE_NAME;
public String getDRN_NO() {
	return DRN_NO;
}
public void setDRN_NO(String dRN_NO) {
	DRN_NO = dRN_NO;
}
public String getDATE_GENERATE_DRN() {
	return DATE_GENERATE_DRN;
}
public void setDATE_GENERATE_DRN(String dATE_GENERATE_DRN) {
	DATE_GENERATE_DRN = dATE_GENERATE_DRN;
}
public String getOFFICE_NAME() {
	return OFFICE_NAME;
}
public void setOFFICE_NAME(String oFFICE_NAME) {
	OFFICE_NAME = oFFICE_NAME;
}


public  List<DINSearch> generateResultBeanList(List<Object []> listObjectArray) {
	List <DINSearch> list =  new ArrayList<DINSearch>();
	for(Object [] objArray : listObjectArray) { 
		DINSearch temp = new DINSearch ();

	temp = generateResultBean(objArray);
	list.add(temp);
	}
	return list;
}

 
public  DINSearch generateResultBean(Object [] objectArray) {
	DINSearch temp =  new DINSearch();
	temp.setDRN_NO((String)( objectArray[0]));
	temp.setDATE_GENERATE_DRN((String)(String.valueOf(objectArray[1])));
	temp.setOFFICE_NAME((String)( objectArray[2]));
	
	return temp;
}

public  List<String>  generateResultBeanLabels() {
	List <String> listLabels =  new ArrayList<String>();
	listLabels.add("DRN_NO");
	listLabels.add("DATE_GENERATE_DRN");
	listLabels.add("OFFICE_NAME");
	
	return listLabels;
}
}
