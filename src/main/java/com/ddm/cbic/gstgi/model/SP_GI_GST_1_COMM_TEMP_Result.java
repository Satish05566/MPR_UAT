package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;


public class SP_GI_GST_1_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String REALISATION_CGST_NO;
	
	private String REALISATION_SGST_NO;
	
	private String REALISATION_IGST_NO;
	
	private String REALISATION_CESS_NO;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_CGST_AMT;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_SGST_AMT;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_IGST_AMT;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_CESS_AMT;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String REALISATION_CGST_NO_PRE;
	
	private String REALISATION_SGST_NO_PRE;
	
	private String REALISATION_IGST_NO_PRE;
	
	private String REALISATION_CESS_NO_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_CGST_AMT_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_SGST_AMT_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_IGST_AMT_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String REALISATION_CESS_AMT_PRE;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
   	private String DETECTION_CGST_NO;
	
	private String DETECTION_SGST_NO;
	
	private String DETECTION_IGST_NO;
	
	private String DETECTION_CESS_NO;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_CGST_AMT;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_SGST_AMT;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_IGST_AMT;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_CESS_AMT;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String DETECTION_CGST_NO_PRE;
	
	private String DETECTION_SGST_NO_PRE;
	
	private String DETECTION_IGST_NO_PRE;
	
	private String DETECTION_CESS_NO_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_CGST_AMT_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_SGST_AMT_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_IGST_AMT_PRE;
	
	@NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String DETECTION_CESS_AMT_PRE;

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
	
	
	public String getREALISATION_CGST_NO() {
		return REALISATION_CGST_NO;
	}


	public void setREALISATION_CGST_NO(String rEALISATION_CGST_NO) {
		REALISATION_CGST_NO = rEALISATION_CGST_NO;
	}


	public String getREALISATION_SGST_NO() {
		return REALISATION_SGST_NO;
	}


	public void setREALISATION_SGST_NO(String rEALISATION_SGST_NO) {
		REALISATION_SGST_NO = rEALISATION_SGST_NO;
	}


	public String getREALISATION_IGST_NO() {
		return REALISATION_IGST_NO;
	}


	public void setREALISATION_IGST_NO(String rEALISATION_IGST_NO) {
		REALISATION_IGST_NO = rEALISATION_IGST_NO;
	}


	public String getREALISATION_CESS_NO() {
		return REALISATION_CESS_NO;
	}


	public void setREALISATION_CESS_NO(String rEALISATION_CESS_NO) {
		REALISATION_CESS_NO = rEALISATION_CESS_NO;
	}


	public String getREALISATION_CGST_AMT() {
		return REALISATION_CGST_AMT;
	}


	public void setREALISATION_CGST_AMT(String rEALISATION_CGST_AMT) {
		REALISATION_CGST_AMT = rEALISATION_CGST_AMT;
	}


	public String getREALISATION_SGST_AMT() {
		return REALISATION_SGST_AMT;
	}


	public void setREALISATION_SGST_AMT(String rEALISATION_SGST_AMT) {
		REALISATION_SGST_AMT = rEALISATION_SGST_AMT;
	}


	public String getREALISATION_IGST_AMT() {
		return REALISATION_IGST_AMT;
	}


	public void setREALISATION_IGST_AMT(String rEALISATION_IGST_AMT) {
		REALISATION_IGST_AMT = rEALISATION_IGST_AMT;
	}


	public String getREALISATION_CESS_AMT() {
		return REALISATION_CESS_AMT;
	}


	public void setREALISATION_CESS_AMT(String rEALISATION_CESS_AMT) {
		REALISATION_CESS_AMT = rEALISATION_CESS_AMT;
	}


	public String getREALISATION_CGST_NO_PRE() {
		return REALISATION_CGST_NO_PRE;
	}


	public void setREALISATION_CGST_NO_PRE(String rEALISATION_CGST_NO_PRE) {
		REALISATION_CGST_NO_PRE = rEALISATION_CGST_NO_PRE;
	}


	public String getREALISATION_SGST_NO_PRE() {
		return REALISATION_SGST_NO_PRE;
	}


	public void setREALISATION_SGST_NO_PRE(String rEALISATION_SGST_NO_PRE) {
		REALISATION_SGST_NO_PRE = rEALISATION_SGST_NO_PRE;
	}


	public String getREALISATION_IGST_NO_PRE() {
		return REALISATION_IGST_NO_PRE;
	}


	public void setREALISATION_IGST_NO_PRE(String rEALISATION_IGST_NO_PRE) {
		REALISATION_IGST_NO_PRE = rEALISATION_IGST_NO_PRE;
	}


	public String getREALISATION_CESS_NO_PRE() {
		return REALISATION_CESS_NO_PRE;
	}


	public void setREALISATION_CESS_NO_PRE(String rEALISATION_CESS_NO_PRE) {
		REALISATION_CESS_NO_PRE = rEALISATION_CESS_NO_PRE;
	}


	public String getREALISATION_CGST_AMT_PRE() {
		return REALISATION_CGST_AMT_PRE;
	}


	public void setREALISATION_CGST_AMT_PRE(String rEALISATION_CGST_AMT_PRE) {
		REALISATION_CGST_AMT_PRE = rEALISATION_CGST_AMT_PRE;
	}


	public String getREALISATION_SGST_AMT_PRE() {
		return REALISATION_SGST_AMT_PRE;
	}


	public void setREALISATION_SGST_AMT_PRE(String rEALISATION_SGST_AMT_PRE) {
		REALISATION_SGST_AMT_PRE = rEALISATION_SGST_AMT_PRE;
	}


	public String getREALISATION_IGST_AMT_PRE() {
		return REALISATION_IGST_AMT_PRE;
	}


	public void setREALISATION_IGST_AMT_PRE(String rEALISATION_IGST_AMT_PRE) {
		REALISATION_IGST_AMT_PRE = rEALISATION_IGST_AMT_PRE;
	}


	public String getREALISATION_CESS_AMT_PRE() {
		return REALISATION_CESS_AMT_PRE;
	}


	public void setREALISATION_CESS_AMT_PRE(String rEALISATION_CESS_AMT_PRE) {
		REALISATION_CESS_AMT_PRE = rEALISATION_CESS_AMT_PRE;
	}
	
		
	public String getDETECTION_CGST_NO() {
		return DETECTION_CGST_NO;
	}


	public void setDETECTION_CGST_NO(String dETECTION_CGST_NO) {
		DETECTION_CGST_NO = dETECTION_CGST_NO;
	}


	public String getDETECTION_SGST_NO() {
		return DETECTION_SGST_NO;
	}


	public void setDETECTION_SGST_NO(String dETECTION_SGST_NO) {
		DETECTION_SGST_NO = dETECTION_SGST_NO;
	}


	public String getDETECTION_IGST_NO() {
		return DETECTION_IGST_NO;
	}


	public void setDETECTION_IGST_NO(String dETECTION_IGST_NO) {
		DETECTION_IGST_NO = dETECTION_IGST_NO;
	}


	public String getDETECTION_CESS_NO() {
		return DETECTION_CESS_NO;
	}


	public void setDETECTION_CESS_NO(String dETECTION_CESS_NO) {
		DETECTION_CESS_NO = dETECTION_CESS_NO;
	}


	public String getDETECTION_CGST_AMT() {
		return DETECTION_CGST_AMT;
	}


	public void setDETECTION_CGST_AMT(String dETECTION_CGST_AMT) {
		DETECTION_CGST_AMT = dETECTION_CGST_AMT;
	}


	public String getDETECTION_SGST_AMT() {
		return DETECTION_SGST_AMT;
	}


	public void setDETECTION_SGST_AMT(String dETECTION_SGST_AMT) {
		DETECTION_SGST_AMT = dETECTION_SGST_AMT;
	}


	public String getDETECTION_IGST_AMT() {
		return DETECTION_IGST_AMT;
	}


	public void setDETECTION_IGST_AMT(String dETECTION_IGST_AMT) {
		DETECTION_IGST_AMT = dETECTION_IGST_AMT;
	}


	public String getDETECTION_CESS_AMT() {
		return DETECTION_CESS_AMT;
	}


	public void setDETECTION_CESS_AMT(String dETECTION_CESS_AMT) {
		DETECTION_CESS_AMT = dETECTION_CESS_AMT;
	}


	public String getDETECTION_CGST_NO_PRE() {
		return DETECTION_CGST_NO_PRE;
	}


	public void setDETECTION_CGST_NO_PRE(String dETECTION_CGST_NO_PRE) {
		DETECTION_CGST_NO_PRE = dETECTION_CGST_NO_PRE;
	}


	public String getDETECTION_SGST_NO_PRE() {
		return DETECTION_SGST_NO_PRE;
	}


	public void setDETECTION_SGST_NO_PRE(String dETECTION_SGST_NO_PRE) {
		DETECTION_SGST_NO_PRE = dETECTION_SGST_NO_PRE;
	}


	public String getDETECTION_IGST_NO_PRE() {
		return DETECTION_IGST_NO_PRE;
	}


	public void setDETECTION_IGST_NO_PRE(String dETECTION_IGST_NO_PRE) {
		DETECTION_IGST_NO_PRE = dETECTION_IGST_NO_PRE;
	}


	public String getDETECTION_CESS_NO_PRE() {
		return DETECTION_CESS_NO_PRE;
	}


	public void setDETECTION_CESS_NO_PRE(String dETECTION_CESS_NO_PRE) {
		DETECTION_CESS_NO_PRE = dETECTION_CESS_NO_PRE;
	}


	public String getDETECTION_CGST_AMT_PRE() {
		return DETECTION_CGST_AMT_PRE;
	}


	public void setDETECTION_CGST_AMT_PRE(String dETECTION_CGST_AMT_PRE) {
		DETECTION_CGST_AMT_PRE = dETECTION_CGST_AMT_PRE;
	}


	public String getDETECTION_SGST_AMT_PRE() {
		return DETECTION_SGST_AMT_PRE;
	}


	public void setDETECTION_SGST_AMT_PRE(String dETECTION_SGST_AMT_PRE) {
		DETECTION_SGST_AMT_PRE = dETECTION_SGST_AMT_PRE;
	}


	public String getDETECTION_IGST_AMT_PRE() {
		return DETECTION_IGST_AMT_PRE;
	}


	public void setDETECTION_IGST_AMT_PRE(String dETECTION_IGST_AMT_PRE) {
		DETECTION_IGST_AMT_PRE = dETECTION_IGST_AMT_PRE;
	}


	public String getDETECTION_CESS_AMT_PRE() {
		return DETECTION_CESS_AMT_PRE;
	}


	public void setDETECTION_CESS_AMT_PRE(String dETECTION_CESS_AMT_PRE) {
		DETECTION_CESS_AMT_PRE = dETECTION_CESS_AMT_PRE;
	}


	public SP_GI_GST_1_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_GI_GST_1_COMM_TEMP_Result> list =  new ArrayList<SP_GI_GST_1_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_GI_GST_1_COMM_TEMP_Result temp = new SP_GI_GST_1_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_GI_GST_1_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_GI_GST_1_COMM_TEMP_Result temp =  new SP_GI_GST_1_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			if (null != objectArray[2]) {
				temp.setREALISATION_CGST_NO(String.valueOf( objectArray[2]));
			}
			if (null != objectArray[3]) {
				temp.setREALISATION_SGST_NO(String.valueOf( objectArray[3]));
			}
			if (null != objectArray[4]) {
				temp.setREALISATION_IGST_NO(String.valueOf( objectArray[4]));
			}

			if (null != objectArray[5]) {
				temp.setREALISATION_CESS_NO(String.valueOf( objectArray[5]));
			}
			if (null != objectArray[6]) {
				temp.setREALISATION_CGST_AMT(String.valueOf( objectArray[6]));
			}
			if (null != objectArray[7]) {
				temp.setREALISATION_SGST_AMT(String.valueOf( objectArray[7]));
			}
			if (null != objectArray[8]) {
				temp.setREALISATION_IGST_AMT(String.valueOf( objectArray[8]));
			}
			if (null != objectArray[9]) {
				temp.setREALISATION_CESS_AMT(String.valueOf( objectArray[9]));
			}

			if (null != objectArray[10]) {
				temp.setREALISATION_CGST_NO_PRE(String.valueOf( objectArray[10]));
			}
			if (null != objectArray[11]) {
				temp.setREALISATION_SGST_NO_PRE(String.valueOf( objectArray[11]));
			}
			if (null != objectArray[12]) {
				temp.setREALISATION_IGST_NO_PRE(String.valueOf( objectArray[12]));
			}
			if (null != objectArray[13]) {
				temp.setREALISATION_CESS_NO_PRE(String.valueOf( objectArray[13]));
			}
			if (null != objectArray[14]) {
				temp.setREALISATION_CGST_AMT_PRE(String.valueOf( objectArray[14]));
			}

			if (null != objectArray[15]) {
				temp.setREALISATION_SGST_AMT_PRE(String.valueOf( objectArray[15]));
			}
			if (null != objectArray[16]) {
				temp.setREALISATION_IGST_AMT_PRE(String.valueOf( objectArray[16]));
			}
			if (null != objectArray[17]) {
				temp.setREALISATION_CESS_AMT_PRE(String.valueOf( objectArray[17]));
			}
			if (null != objectArray[18]) {
				temp.setDETECTION_CGST_NO(String.valueOf( objectArray[18]));
			}
			if (null != objectArray[19]) {
				temp.setDETECTION_SGST_NO(String.valueOf( objectArray[19]));
			}
			if (null != objectArray[20]) {
				temp.setDETECTION_IGST_NO(String.valueOf( objectArray[20]));
			}

			if (null != objectArray[21]) {
				temp.setDETECTION_CESS_NO(String.valueOf( objectArray[21]));
			}
			if (null != objectArray[22]) {
				temp.setDETECTION_CGST_AMT(String.valueOf( objectArray[22]));
			}
			if (null != objectArray[23]) {
				temp.setDETECTION_SGST_AMT(String.valueOf( objectArray[23]));
			}
			if (null != objectArray[24]) {
				temp.setDETECTION_IGST_AMT(String.valueOf( objectArray[24]));
			}
			if (null != objectArray[25]) {
				temp.setDETECTION_CESS_AMT(String.valueOf( objectArray[25]));
			}

			if (null != objectArray[26]) {
				temp.setDETECTION_CGST_NO_PRE(String.valueOf( objectArray[26]));
			}
			if (null != objectArray[27]) {
				temp.setDETECTION_SGST_NO_PRE(String.valueOf( objectArray[27]));
			}
			if (null != objectArray[28]) {
				temp.setDETECTION_IGST_NO_PRE(String.valueOf( objectArray[28]));
			}
			if (null != objectArray[29]) {
				temp.setDETECTION_CESS_NO_PRE(String.valueOf( objectArray[29]));
			}
			if (null != objectArray[30]) {
				temp.setDETECTION_CGST_AMT_PRE(String.valueOf( objectArray[30]));
			}

			if (null != objectArray[31]) {
				temp.setDETECTION_SGST_AMT_PRE(String.valueOf( objectArray[31]));
			}
			if (null != objectArray[32]) {
				temp.setDETECTION_IGST_AMT_PRE(String.valueOf( objectArray[32]));
			}
			if (null != objectArray[33]) {
				temp.setDETECTION_CESS_AMT_PRE(String.valueOf( objectArray[33]));
			}
				
	return temp;
	
	 }
	
}
