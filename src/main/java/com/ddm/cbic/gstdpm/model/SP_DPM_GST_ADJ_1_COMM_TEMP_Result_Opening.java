package com.ddm.cbic.gstdpm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening {

	private String COMM_CODE;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_COMMISSIONERATE_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_COMMISSIONERATE_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_AUDIT_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_AUDIT_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_INVESTIGATION_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_INVESTIGATION_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ADC_CALLBOOK_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String ADC_CALLBOOK_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_COMMISSIONERATE_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_COMMISSIONERATE_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_AUDIT_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_AUDIT_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_INVESTIGATION_OPENING_NO ;
	private String DC_INVESTIGATION_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DC_CALLBOOK_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String DC_CALLBOOK_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_COMMISSIONERATE_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_AUDIT_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_AUDIT_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_INVESTIGATION_OPENING_NO ;
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_INVESTIGATION_OPENING_AMT ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String SUPERINTENDENT_CALLBOOK_OPENING_NO ;
	
	@NotEmpty(message = "*")
	@Pattern(regexp = "[0-9]+(\\.[0-9][0-9]?)?", message = "Must be numeric")
	private String SUPERINTENDENT_CALLBOOK_OPENING_AMT ;


	public String getCOMM_CODE() {
		return COMM_CODE;
	}


	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}

	public String getADC_COMMISSIONERATE_OPENING_NO() {
		return ADC_COMMISSIONERATE_OPENING_NO;
	}


	public void setADC_COMMISSIONERATE_OPENING_NO(String aDC_COMMISSIONERATE_OPENING_NO) {
		ADC_COMMISSIONERATE_OPENING_NO = aDC_COMMISSIONERATE_OPENING_NO;
	}


	public String getADC_COMMISSIONERATE_OPENING_AMT() {
		return ADC_COMMISSIONERATE_OPENING_AMT;
	}


	public void setADC_COMMISSIONERATE_OPENING_AMT(String aDC_COMMISSIONERATE_OPENING_AMT) {
		ADC_COMMISSIONERATE_OPENING_AMT = aDC_COMMISSIONERATE_OPENING_AMT;
	}


	public String getADC_AUDIT_OPENING_NO() {
		return ADC_AUDIT_OPENING_NO;
	}


	public void setADC_AUDIT_OPENING_NO(String aDC_AUDIT_OPENING_NO) {
		ADC_AUDIT_OPENING_NO = aDC_AUDIT_OPENING_NO;
	}


	public String getADC_AUDIT_OPENING_AMT() {
		return ADC_AUDIT_OPENING_AMT;
	}


	public void setADC_AUDIT_OPENING_AMT(String aDC_AUDIT_OPENING_AMT) {
		ADC_AUDIT_OPENING_AMT = aDC_AUDIT_OPENING_AMT;
	}


	public String getADC_INVESTIGATION_OPENING_NO() {
		return ADC_INVESTIGATION_OPENING_NO;
	}


	public void setADC_INVESTIGATION_OPENING_NO(String aDC_INVESTIGATION_OPENING_NO) {
		ADC_INVESTIGATION_OPENING_NO = aDC_INVESTIGATION_OPENING_NO;
	}


	public String getADC_INVESTIGATION_OPENING_AMT() {
		return ADC_INVESTIGATION_OPENING_AMT;
	}


	public void setADC_INVESTIGATION_OPENING_AMT(String aDC_INVESTIGATION_OPENING_AMT) {
		ADC_INVESTIGATION_OPENING_AMT = aDC_INVESTIGATION_OPENING_AMT;
	}


	public String getADC_CALLBOOK_OPENING_NO() {
		return ADC_CALLBOOK_OPENING_NO;
	}


	public void setADC_CALLBOOK_OPENING_NO(String aDC_CALLBOOK_OPENING_NO) {
		ADC_CALLBOOK_OPENING_NO = aDC_CALLBOOK_OPENING_NO;
	}


	public String getADC_CALLBOOK_OPENING_AMT() {
		return ADC_CALLBOOK_OPENING_AMT;
	}


	public void setADC_CALLBOOK_OPENING_AMT(String aDC_CALLBOOK_OPENING_AMT) {
		ADC_CALLBOOK_OPENING_AMT = aDC_CALLBOOK_OPENING_AMT;
	}


	public String getDC_COMMISSIONERATE_OPENING_NO() {
		return DC_COMMISSIONERATE_OPENING_NO;
	}


	public void setDC_COMMISSIONERATE_OPENING_NO(String dC_COMMISSIONERATE_OPENING_NO) {
		DC_COMMISSIONERATE_OPENING_NO = dC_COMMISSIONERATE_OPENING_NO;
	}


	public String getDC_COMMISSIONERATE_OPENING_AMT() {
		return DC_COMMISSIONERATE_OPENING_AMT;
	}


	public void setDC_COMMISSIONERATE_OPENING_AMT(String dC_COMMISSIONERATE_OPENING_AMT) {
		DC_COMMISSIONERATE_OPENING_AMT = dC_COMMISSIONERATE_OPENING_AMT;
	}


	public String getDC_AUDIT_OPENING_NO() {
		return DC_AUDIT_OPENING_NO;
	}


	public void setDC_AUDIT_OPENING_NO(String dC_AUDIT_OPENING_NO) {
		DC_AUDIT_OPENING_NO = dC_AUDIT_OPENING_NO;
	}


	public String getDC_AUDIT_OPENING_AMT() {
		return DC_AUDIT_OPENING_AMT;
	}


	public void setDC_AUDIT_OPENING_AMT(String dC_AUDIT_OPENING_AMT) {
		DC_AUDIT_OPENING_AMT = dC_AUDIT_OPENING_AMT;
	}


	public String getDC_INVESTIGATION_OPENING_NO() {
		return DC_INVESTIGATION_OPENING_NO;
	}


	public void setDC_INVESTIGATION_OPENING_NO(String dC_INVESTIGATION_OPENING_NO) {
		DC_INVESTIGATION_OPENING_NO = dC_INVESTIGATION_OPENING_NO;
	}


	public String getDC_INVESTIGATION_OPENING_AMT() {
		return DC_INVESTIGATION_OPENING_AMT;
	}


	public void setDC_INVESTIGATION_OPENING_AMT(String dC_INVESTIGATION_OPENING_AMT) {
		DC_INVESTIGATION_OPENING_AMT = dC_INVESTIGATION_OPENING_AMT;
	}


	public String getDC_CALLBOOK_OPENING_NO() {
		return DC_CALLBOOK_OPENING_NO;
	}


	public void setDC_CALLBOOK_OPENING_NO(String dC_CALLBOOK_OPENING_NO) {
		DC_CALLBOOK_OPENING_NO = dC_CALLBOOK_OPENING_NO;
	}


	public String getDC_CALLBOOK_OPENING_AMT() {
		return DC_CALLBOOK_OPENING_AMT;
	}


	public void setDC_CALLBOOK_OPENING_AMT(String dC_CALLBOOK_OPENING_AMT) {
		DC_CALLBOOK_OPENING_AMT = dC_CALLBOOK_OPENING_AMT;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_OPENING_NO() {
		return SUPERINTENDENT_COMMISSIONERATE_OPENING_NO;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_OPENING_NO(String sUPERINTENDENT_COMMISSIONERATE_OPENING_NO) {
		SUPERINTENDENT_COMMISSIONERATE_OPENING_NO = sUPERINTENDENT_COMMISSIONERATE_OPENING_NO;
	}


	public String getSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT() {
		return SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT;
	}


	public void setSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT(String sUPERINTENDENT_COMMISSIONERATE_OPENING_AMT) {
		SUPERINTENDENT_COMMISSIONERATE_OPENING_AMT = sUPERINTENDENT_COMMISSIONERATE_OPENING_AMT;
	}


	public String getSUPERINTENDENT_AUDIT_OPENING_NO() {
		return SUPERINTENDENT_AUDIT_OPENING_NO;
	}


	public void setSUPERINTENDENT_AUDIT_OPENING_NO(String sUPERINTENDENT_AUDIT_OPENING_NO) {
		SUPERINTENDENT_AUDIT_OPENING_NO = sUPERINTENDENT_AUDIT_OPENING_NO;
	}


	public String getSUPERINTENDENT_AUDIT_OPENING_AMT() {
		return SUPERINTENDENT_AUDIT_OPENING_AMT;
	}


	public void setSUPERINTENDENT_AUDIT_OPENING_AMT(String sUPERINTENDENT_AUDIT_OPENING_AMT) {
		SUPERINTENDENT_AUDIT_OPENING_AMT = sUPERINTENDENT_AUDIT_OPENING_AMT;
	}


	public String getSUPERINTENDENT_INVESTIGATION_OPENING_NO() {
		return SUPERINTENDENT_INVESTIGATION_OPENING_NO;
	}


	public void setSUPERINTENDENT_INVESTIGATION_OPENING_NO(String sUPERINTENDENT_INVESTIGATION_OPENING_NO) {
		SUPERINTENDENT_INVESTIGATION_OPENING_NO = sUPERINTENDENT_INVESTIGATION_OPENING_NO;
	}


	public String getSUPERINTENDENT_INVESTIGATION_OPENING_AMT() {
		return SUPERINTENDENT_INVESTIGATION_OPENING_AMT;
	}


	public void setSUPERINTENDENT_INVESTIGATION_OPENING_AMT(String sUPERINTENDENT_INVESTIGATION_OPENING_AMT) {
		SUPERINTENDENT_INVESTIGATION_OPENING_AMT = sUPERINTENDENT_INVESTIGATION_OPENING_AMT;
	}


	public String getSUPERINTENDENT_CALLBOOK_OPENING_NO() {
		return SUPERINTENDENT_CALLBOOK_OPENING_NO;
	}


	public void setSUPERINTENDENT_CALLBOOK_OPENING_NO(String sUPERINTENDENT_CALLBOOK_OPENING_NO) {
		SUPERINTENDENT_CALLBOOK_OPENING_NO = sUPERINTENDENT_CALLBOOK_OPENING_NO;
	}


	public String getSUPERINTENDENT_CALLBOOK_OPENING_AMT() {
		return SUPERINTENDENT_CALLBOOK_OPENING_AMT;
	}


	public void setSUPERINTENDENT_CALLBOOK_OPENING_AMT(String sUPERINTENDENT_CALLBOOK_OPENING_AMT) {
		SUPERINTENDENT_CALLBOOK_OPENING_AMT = sUPERINTENDENT_CALLBOOK_OPENING_AMT;
	}


	public SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening  generateAllResult(List <Object []> resultList) {
		if(resultList.size()==0)
			  return null;
		else {
		List <SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening> list =  new ArrayList<SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening>();
		//for(Object [] objectArray : resultList) { 
			SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening temp = new SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening ();
			
		temp = generateReportBean(resultList.get(0));
		list.add(temp);
		//}
		return list.get(0);
		}
	}
	
	
	 private SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening generateReportBean(Object[] objectArray) {

			SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening temp =  new SP_DPM_GST_ADJ_1_COMM_TEMP_Result_Opening();
			
			if (null != objectArray[0]){ temp.setADC_COMMISSIONERATE_OPENING_NO (String.valueOf(objectArray[0]));}
			if (null != objectArray[1]){ temp.setADC_COMMISSIONERATE_OPENING_AMT (String.valueOf(objectArray[1]));}
     		if (null != objectArray[2]){ temp.setADC_AUDIT_OPENING_NO (String.valueOf(objectArray[2]));}
			if (null != objectArray[3]){ temp.setADC_AUDIT_OPENING_AMT (String.valueOf(objectArray[3]));}
			if (null != objectArray[4]){ temp.setADC_INVESTIGATION_OPENING_NO (String.valueOf(objectArray[4]));}
			if (null != objectArray[5]){ temp.setADC_INVESTIGATION_OPENING_AMT (String.valueOf(objectArray[5]));}
			if (null != objectArray[6]){ temp.setADC_CALLBOOK_OPENING_NO (String.valueOf(objectArray[6]));}
			if (null != objectArray[7]){ temp.setADC_CALLBOOK_OPENING_AMT (String.valueOf(objectArray[7]));}
			if (null != objectArray[8]){ temp.setDC_COMMISSIONERATE_OPENING_NO (String.valueOf(objectArray[8]));}
			if (null != objectArray[9]){ temp.setDC_COMMISSIONERATE_OPENING_AMT (String.valueOf(objectArray[9]));}
			if (null != objectArray[10]){ temp.setDC_AUDIT_OPENING_NO (String.valueOf(objectArray[10]));}
			if (null != objectArray[11]){ temp.setDC_AUDIT_OPENING_AMT (String.valueOf(objectArray[11]));}
			if (null != objectArray[12]){ temp.setDC_INVESTIGATION_OPENING_NO (String.valueOf(objectArray[12]));}
			if (null != objectArray[13]){ temp.setDC_INVESTIGATION_OPENING_AMT (String.valueOf(objectArray[13]));}
			if (null != objectArray[14]){ temp.setDC_CALLBOOK_OPENING_NO (String.valueOf(objectArray[14]));}
			if (null != objectArray[15]){ temp.setDC_CALLBOOK_OPENING_AMT (String.valueOf(objectArray[15]));}
			if (null != objectArray[16]){ temp.setSUPERINTENDENT_COMMISSIONERATE_OPENING_NO (String.valueOf(objectArray[16]));}
			if (null != objectArray[17]){ temp.setSUPERINTENDENT_COMMISSIONERATE_OPENING_AMT (String.valueOf(objectArray[17]));}
			if (null != objectArray[18]){ temp.setSUPERINTENDENT_AUDIT_OPENING_NO (String.valueOf(objectArray[18]));}
			if (null != objectArray[19]){ temp.setSUPERINTENDENT_AUDIT_OPENING_AMT (String.valueOf(objectArray[19]));}
			if (null != objectArray[20]){ temp.setSUPERINTENDENT_INVESTIGATION_OPENING_NO (String.valueOf(objectArray[20]));}
			if (null != objectArray[21]){ temp.setSUPERINTENDENT_INVESTIGATION_OPENING_AMT (String.valueOf(objectArray[21]));}
			if (null != objectArray[22]){ temp.setSUPERINTENDENT_CALLBOOK_OPENING_NO (String.valueOf(objectArray[22]));}
			if (null != objectArray[23]){ temp.setSUPERINTENDENT_CALLBOOK_OPENING_AMT (String.valueOf(objectArray[23]));}
			if (null != objectArray[24]){ temp.setCOMM_CODE(String.valueOf(objectArray[24]));}

   return temp;
	
	 }
	
	
	
	
	
	
	

}
