package com.ddm.cbic.gstgi.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotEmpty;


public class SP_GI_GST_1A_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String PROSECUTION_SANCTIONED;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String COMPOUNDING_OF_OFFENCES;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String PROSECUTION_LAUNCHED;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String PROSECUTION_SANCTIONED_PRE;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String COMPOUNDING_OF_OFFENCES_PRE;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String PROSECUTION_LAUNCHED_PRE;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ARRESTS_MADE;
	
	@NotEmpty(message="*")
	@Pattern(regexp = "[0-9]+", message = "Must be integer")
	private String ARRESTS_MADE_PRE;

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
	
	
	public String getPROSECUTION_SANCTIONED() {
		return PROSECUTION_SANCTIONED;
	}


	public void setPROSECUTION_SANCTIONED(String pROSECUTION_SANCTIONED) {
		PROSECUTION_SANCTIONED = pROSECUTION_SANCTIONED;
	}


	public String getCOMPOUNDING_OF_OFFENCES() {
		return COMPOUNDING_OF_OFFENCES;
	}


	public void setCOMPOUNDING_OF_OFFENCES(String cOMPOUNDING_OF_OFFENCES) {
		COMPOUNDING_OF_OFFENCES = cOMPOUNDING_OF_OFFENCES;
	}


	public String getPROSECUTION_LAUNCHED() {
		return PROSECUTION_LAUNCHED;
	}


	public void setPROSECUTION_LAUNCHED(String pROSECUTION_LAUNCHED) {
		PROSECUTION_LAUNCHED = pROSECUTION_LAUNCHED;
	}


	public String getPROSECUTION_SANCTIONED_PRE() {
		return PROSECUTION_SANCTIONED_PRE;
	}


	public void setPROSECUTION_SANCTIONED_PRE(String pROSECUTION_SANCTIONED_PRE) {
		PROSECUTION_SANCTIONED_PRE = pROSECUTION_SANCTIONED_PRE;
	}


	public String getCOMPOUNDING_OF_OFFENCES_PRE() {
		return COMPOUNDING_OF_OFFENCES_PRE;
	}


	public void setCOMPOUNDING_OF_OFFENCES_PRE(String cOMPOUNDING_OF_OFFENCES_PRE) {
		COMPOUNDING_OF_OFFENCES_PRE = cOMPOUNDING_OF_OFFENCES_PRE;
	}


	public String getPROSECUTION_LAUNCHED_PRE() {
		return PROSECUTION_LAUNCHED_PRE;
	}


	public void setPROSECUTION_LAUNCHED_PRE(String pROSECUTION_LAUNCHED_PRE) {
		PROSECUTION_LAUNCHED_PRE = pROSECUTION_LAUNCHED_PRE;
	}


	public String getARRESTS_MADE() {
		return ARRESTS_MADE;
	}


	public void setARRESTS_MADE(String aRRESTS_MADE) {
		ARRESTS_MADE = aRRESTS_MADE;
	}


	public String getARRESTS_MADE_PRE() {
		return ARRESTS_MADE_PRE;
	}


	public void setARRESTS_MADE_PRE(String aRRESTS_MADE_PRE) {
		ARRESTS_MADE_PRE = aRRESTS_MADE_PRE;
	}


	public SP_GI_GST_1A_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_GI_GST_1A_COMM_TEMP_Result> list =  new ArrayList<SP_GI_GST_1A_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_GI_GST_1A_COMM_TEMP_Result temp = new SP_GI_GST_1A_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_GI_GST_1A_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_GI_GST_1A_COMM_TEMP_Result temp =  new SP_GI_GST_1A_COMM_TEMP_Result();	
			
			if (null != objectArray[0]) {
				temp.setCOMM_CODE(String.valueOf(objectArray[0]));
			}
			if (null != objectArray[1]) {
				temp.setMM_YYYY(String.valueOf(objectArray[1]));
			}
			if (null != objectArray[2]) {
				temp.setPROSECUTION_SANCTIONED(String.valueOf(objectArray[2]));
			}
			if (null != objectArray[3]) {
				temp.setCOMPOUNDING_OF_OFFENCES(String.valueOf(objectArray[3]));
			}
			if (null != objectArray[4]) {
				temp.setPROSECUTION_LAUNCHED(String.valueOf(objectArray[4]));
			}

			if (null != objectArray[5]) {
				temp.setPROSECUTION_SANCTIONED_PRE(String.valueOf(objectArray[5]));
			}
			if (null != objectArray[6]) {
				temp.setCOMPOUNDING_OF_OFFENCES_PRE(String.valueOf(objectArray[6]));
			}
			if (null != objectArray[7]) {
				temp.setPROSECUTION_LAUNCHED_PRE(String.valueOf(objectArray[7]));
			}
			if (null != objectArray[8]) {
				temp.setARRESTS_MADE(String.valueOf(objectArray[8]));
			}
			if (null != objectArray[9]) {
				temp.setARRESTS_MADE_PRE(String.valueOf(objectArray[9]));
			}
			
				
	return temp;
	
	 }



	
	
	

	
	
}
