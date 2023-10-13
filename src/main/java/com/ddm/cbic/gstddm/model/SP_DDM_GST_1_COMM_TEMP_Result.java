package com.ddm.cbic.gstddm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;


public class SP_DDM_GST_1_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String MOVING_TARGET_CGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String MOVING_TARGET_SGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String MOVING_TARGET_IGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String MOVING_TARGET_CESS;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String GROSS_TAX_CGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String GROSS_TAX_SGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String GROSS_TAX_IGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String GROSS_TAX_CESS;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REFUND_SANCTIONED_CGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REFUND_SANCTIONED_SGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REFUND_SANCTIONED_IGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REFUND_SANCTIONED_CESS;

	public String getCOMM_CODE() {
		return COMM_CODE;
	}


	public void setCOMM_CODE(String cOMM_CODE) {
		COMM_CODE = cOMM_CODE;
	}


	public String getMM_YYYY() {
		return MM_YYYY;
	}


	public void setMM_YYYY(String mM_YYYY) {
		MM_YYYY = mM_YYYY;
	}


	public String getMOVING_TARGET_CGST() {
		return MOVING_TARGET_CGST;
	}


	public void setMOVING_TARGET_CGST(String mOVING_TARGET_CGST) {
		MOVING_TARGET_CGST = mOVING_TARGET_CGST;
	}


	public String getMOVING_TARGET_SGST() {
		return MOVING_TARGET_SGST;
	}


	public void setMOVING_TARGET_SGST(String mOVING_TARGET_SGST) {
		MOVING_TARGET_SGST = mOVING_TARGET_SGST;
	}


	public String getMOVING_TARGET_IGST() {
		return MOVING_TARGET_IGST;
	}


	public void setMOVING_TARGET_IGST(String mOVING_TARGET_IGST) {
		MOVING_TARGET_IGST = mOVING_TARGET_IGST;
	}


	public String getMOVING_TARGET_CESS() {
		return MOVING_TARGET_CESS;
	}


	public void setMOVING_TARGET_CESS(String mOVING_TARGET_CESS) {
		MOVING_TARGET_CESS = mOVING_TARGET_CESS;
	}


	public String getGROSS_TAX_CGST() {
		return GROSS_TAX_CGST;
	}


	public void setGROSS_TAX_CGST(String gROSS_TAX_CGST) {
		GROSS_TAX_CGST = gROSS_TAX_CGST;
	}


	public String getGROSS_TAX_SGST() {
		return GROSS_TAX_SGST;
	}


	public void setGROSS_TAX_SGST(String gROSS_TAX_SGST) {
		GROSS_TAX_SGST = gROSS_TAX_SGST;
	}


	public String getGROSS_TAX_IGST() {
		return GROSS_TAX_IGST;
	}


	public void setGROSS_TAX_IGST(String gROSS_TAX_IGST) {
		GROSS_TAX_IGST = gROSS_TAX_IGST;
	}


	public String getGROSS_TAX_CESS() {
		return GROSS_TAX_CESS;
	}


	public void setGROSS_TAX_CESS(String gROSS_TAX_CESS) {
		GROSS_TAX_CESS = gROSS_TAX_CESS;
	}


	public String getREFUND_SANCTIONED_CGST() {
		return REFUND_SANCTIONED_CGST;
	}


	public void setREFUND_SANCTIONED_CGST(String rEFUND_SANCTIONED_CGST) {
		REFUND_SANCTIONED_CGST = rEFUND_SANCTIONED_CGST;
	}


	public String getREFUND_SANCTIONED_SGST() {
		return REFUND_SANCTIONED_SGST;
	}


	public void setREFUND_SANCTIONED_SGST(String rEFUND_SANCTIONED_SGST) {
		REFUND_SANCTIONED_SGST = rEFUND_SANCTIONED_SGST;
	}


	public String getREFUND_SANCTIONED_IGST() {
		return REFUND_SANCTIONED_IGST;
	}


	public void setREFUND_SANCTIONED_IGST(String rEFUND_SANCTIONED_IGST) {
		REFUND_SANCTIONED_IGST = rEFUND_SANCTIONED_IGST;
	}


	public String getREFUND_SANCTIONED_CESS() {
		return REFUND_SANCTIONED_CESS;
	}


	public void setREFUND_SANCTIONED_CESS(String rEFUND_SANCTIONED_CESS) {
		REFUND_SANCTIONED_CESS = rEFUND_SANCTIONED_CESS;
	}

	

	public SP_DDM_GST_1_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DDM_GST_1_COMM_TEMP_Result> list =  new ArrayList<SP_DDM_GST_1_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DDM_GST_1_COMM_TEMP_Result temp = new SP_DDM_GST_1_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DDM_GST_1_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DDM_GST_1_COMM_TEMP_Result temp =  new SP_DDM_GST_1_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setMOVING_TARGET_CGST(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setMOVING_TARGET_SGST(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setMOVING_TARGET_IGST(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setMOVING_TARGET_CESS(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setGROSS_TAX_CGST(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]){temp.setGROSS_TAX_SGST(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setGROSS_TAX_IGST(String.valueOf(objectArray[8]));}
			if(null != objectArray[9]){temp.setGROSS_TAX_CESS(String.valueOf(objectArray[9]));}
			if(null != objectArray[10]){temp.setREFUND_SANCTIONED_CGST(String.valueOf(objectArray[10]));}
			if(null != objectArray[11]){temp.setREFUND_SANCTIONED_SGST(String.valueOf(objectArray[11]));}
			if(null != objectArray[12]){temp.setREFUND_SANCTIONED_IGST(String.valueOf(objectArray[12]));}
			if(null != objectArray[13]){temp.setREFUND_SANCTIONED_CESS(String.valueOf(objectArray[13]));}
	
	return temp;
	
	 }

	
	
	

	
	
}
