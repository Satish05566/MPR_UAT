package com.ddm.cbic.gstgi.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_GI_GST_2_OPENING_Result {
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	@NotEmpty(message = "*")
	String OPENING_BALANCE_NO ;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	String OPENING_BALANCE_AMOUNT ;
	
	public String getOPENING_BALANCE_NO() {
		return OPENING_BALANCE_NO;
	}

	public void setOPENING_BALANCE_NO(String oPENING_BALANCE_NO) {
		OPENING_BALANCE_NO = oPENING_BALANCE_NO;
	}

	public String getOPENING_BALANCE_AMOUNT() {
		return OPENING_BALANCE_AMOUNT;
	}

	public void setOPENING_BALANCE_AMOUNT(String oPENING_BALANCE_AMOUNT) {
		OPENING_BALANCE_AMOUNT = oPENING_BALANCE_AMOUNT;
	}

	public  List<SP_GI_GST_2_OPENING_Result> generateResultBeanList(List<Object []> listObjectArray) {
		List <SP_GI_GST_2_OPENING_Result> list =  new ArrayList<SP_GI_GST_2_OPENING_Result>();
		for(Object [] objArray : listObjectArray) { 
			SP_GI_GST_2_OPENING_Result temp = new SP_GI_GST_2_OPENING_Result ();

		temp = generateResultBean(objArray);
		list.add(temp);
		}
		return list;
	}
	
	public  SP_GI_GST_2_OPENING_Result generateResultBean(Object [] objectArray) {
		SP_GI_GST_2_OPENING_Result temp =  new SP_GI_GST_2_OPENING_Result();
		if(null!=objectArray[0] && objectArray[0]!=null) {
		temp.setOPENING_BALANCE_NO((String)( objectArray[0]));}
		if(null!=objectArray[1] && objectArray[1]!=null) {
		temp.setOPENING_BALANCE_AMOUNT((String)( objectArray[1]));}
		return temp;
	}
	
	

}
