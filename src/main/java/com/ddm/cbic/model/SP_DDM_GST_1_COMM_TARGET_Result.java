package com.ddm.cbic.model;


import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;

public class SP_DDM_GST_1_COMM_TARGET_Result {

	
	public String COMM_CODE;
	public String MM_YYYY;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	public String TARGET_CGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	public String TARGET_SGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	public String TARGET_IGST;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	public String TARGET_CESS;	
		

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

	public String getTARGET_CGST() {
		return TARGET_CGST;
	}

	public void setTARGET_CGST(String tARGET_CGST) {
		TARGET_CGST = tARGET_CGST;
	}

	public String getTARGET_SGST() {
		return TARGET_SGST;
	}

	public void setTARGET_SGST(String tARGET_SGST) {
		TARGET_SGST = tARGET_SGST;
	}

	public String getTARGET_IGST() {
		return TARGET_IGST;
	}
	public void setTARGET_IGST(String tARGET_IGST) {
		TARGET_IGST = tARGET_IGST;
	}
	public String getTARGET_CESS() {
		return TARGET_CESS;
	}

	public void setTARGET_CESS(String tARGET_CESS) {
		TARGET_CESS = tARGET_CESS;
	}


	public  SP_DDM_GST_1_COMM_TARGET_Result generateResultBean(Object [] objectArray) {
		SP_DDM_GST_1_COMM_TARGET_Result temp =  new SP_DDM_GST_1_COMM_TARGET_Result();
		temp.setCOMM_CODE(String.valueOf(objectArray[0]));
		temp.setTARGET_CGST(String.valueOf(objectArray[1]));
		temp.setTARGET_SGST(String.valueOf(objectArray[2]));
		temp.setTARGET_IGST(String.valueOf(objectArray[3]));
		temp.setTARGET_CESS(String.valueOf(objectArray[4]));
		
		return temp;
	}
	
	
}
