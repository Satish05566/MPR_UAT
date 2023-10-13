package com.ddm.cbic.gstddm.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class SP_DDM_GST_2_COMM_TEMP_Result {
	
	private String COMM_CODE;
	private String MM_YYYY;
	
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String AUDIT_RECOVERY;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String RECOVERY_OF_CONFIRMED_DEMANDS;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String PRE_DEPOSITS;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String SCRUTINY_OF_GST_RETURNS;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String RECOVERY_FROM_DEFAULTERS;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String FINALISATION_OF_PROVISIONAL_ASSESSMENTS;
    
    @NotEmpty(message="*")
	@Pattern(regexp = "^[a-zA-Z0-9. ()/,'-.]+$", message = "Only ()/,'-. special characters are allowed.!")
	private String OTHERS_NAME;
    
    @NotEmpty(message="*")
    @Pattern(regexp="[0-9]+(\\.[0-9][0-9]?)?",message="Must be numeric")
	private String OTHERS_VALUE;
	
	
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
	public String getAUDIT_RECOVERY() {
		return AUDIT_RECOVERY;
	}
	public void setAUDIT_RECOVERY(String aUDIT_RECOVERY) {
		AUDIT_RECOVERY = aUDIT_RECOVERY;
	}
	public String getANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS() {
		return ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS;
	}
	public void setANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS(String aNTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS) {
		ANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS = aNTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS;
	}
	public String getRECOVERY_OF_CONFIRMED_DEMANDS() {
		return RECOVERY_OF_CONFIRMED_DEMANDS;
	}
	public void setRECOVERY_OF_CONFIRMED_DEMANDS(String rECOVERY_OF_CONFIRMED_DEMANDS) {
		RECOVERY_OF_CONFIRMED_DEMANDS = rECOVERY_OF_CONFIRMED_DEMANDS;
	}
	public String getPRE_DEPOSITS() {
		return PRE_DEPOSITS;
	}
	public void setPRE_DEPOSITS(String pRE_DEPOSITS) {
		PRE_DEPOSITS = pRE_DEPOSITS;
	}
	public String getSCRUTINY_OF_GST_RETURNS() {
		return SCRUTINY_OF_GST_RETURNS;
	}
	public void setSCRUTINY_OF_GST_RETURNS(String sCRUTINY_OF_GST_RETURNS) {
		SCRUTINY_OF_GST_RETURNS = sCRUTINY_OF_GST_RETURNS;
	}
	public String getRECOVERY_FROM_DEFAULTERS() {
		return RECOVERY_FROM_DEFAULTERS;
	}
	public void setRECOVERY_FROM_DEFAULTERS(String rECOVERY_FROM_DEFAULTERS) {
		RECOVERY_FROM_DEFAULTERS = rECOVERY_FROM_DEFAULTERS;
	}
	public String getFINALISATION_OF_PROVISIONAL_ASSESSMENTS() {
		return FINALISATION_OF_PROVISIONAL_ASSESSMENTS;
	}
	public void setFINALISATION_OF_PROVISIONAL_ASSESSMENTS(String fINALISATION_OF_PROVISIONAL_ASSESSMENTS) {
		FINALISATION_OF_PROVISIONAL_ASSESSMENTS = fINALISATION_OF_PROVISIONAL_ASSESSMENTS;
	}
	
	
	
	public String getOTHERS_NAME() {
		return OTHERS_NAME;
	}
	public void setOTHERS_NAME(String oTHERS_NAME) {
		OTHERS_NAME = oTHERS_NAME;
	}
	public String getOTHERS_VALUE() {
		return OTHERS_VALUE;
	}
	public void setOTHERS_VALUE(String oTHERS_VALUE) {
		OTHERS_VALUE = oTHERS_VALUE;
	}
	public SP_DDM_GST_2_COMM_TEMP_Result generateCommTempResult(List <Object []> resultList) {
		if(resultList.size()==0 )
			  return null;
		else {
		List <SP_DDM_GST_2_COMM_TEMP_Result> list =  new ArrayList<SP_DDM_GST_2_COMM_TEMP_Result>();
		for(Object [] objectArray : resultList) { 
			SP_DDM_GST_2_COMM_TEMP_Result temp = new SP_DDM_GST_2_COMM_TEMP_Result ();

		temp = generateReportBean(objectArray);
		list.add(temp);
		}
		return list.get(0);
		}
	}
	
	
	 private SP_DDM_GST_2_COMM_TEMP_Result generateReportBean(Object[] objectArray) {

			SP_DDM_GST_2_COMM_TEMP_Result temp =  new SP_DDM_GST_2_COMM_TEMP_Result();	
			
			if(null != objectArray[0]){temp.setCOMM_CODE(String.valueOf(objectArray[0]));}
			if(null != objectArray[1]){temp.setMM_YYYY(String.valueOf(objectArray[1]));}
			if(null != objectArray[2]){temp.setAUDIT_RECOVERY(String.valueOf(objectArray[2]));}
			if(null != objectArray[3]){temp.setANTI_EVASION_RECOVERY_INCLUDING_TRANSIT_CHECKS(String.valueOf(objectArray[3]));}
			if(null != objectArray[4]){temp.setRECOVERY_OF_CONFIRMED_DEMANDS(String.valueOf(objectArray[4]));}
			if(null != objectArray[5]){temp.setPRE_DEPOSITS(String.valueOf(objectArray[5]));}
			if(null != objectArray[6]){temp.setSCRUTINY_OF_GST_RETURNS(String.valueOf(objectArray[6]));}
			if(null != objectArray[7]){temp.setRECOVERY_FROM_DEFAULTERS(String.valueOf(objectArray[7]));}
			if(null != objectArray[8]){temp.setFINALISATION_OF_PROVISIONAL_ASSESSMENTS(String.valueOf(objectArray[8]));}
			if(null != objectArray[9]){temp.setOTHERS_NAME(String.valueOf(objectArray[9]));}
			if(null != objectArray[9]){temp.setOTHERS_VALUE(String.valueOf(objectArray[10]));}
			
	return temp;
	
	 }
	

}
